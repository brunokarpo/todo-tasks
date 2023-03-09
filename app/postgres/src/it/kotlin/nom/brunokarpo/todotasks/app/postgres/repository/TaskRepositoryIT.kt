package nom.brunokarpo.todotasks.app.postgres.repository

import nom.brunokarpo.todotasks.app.postgres.JdbcDatabaseIT
import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.model.TaskStatus
import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.TaskRepository
import nom.brunokarpo.todotasks.domain.repository.filter.TaskSearchFilter
import nom.brunokarpo.todotasks.domain.service.requests.TaskEditionRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import java.time.LocalDateTime
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@SqlGroup(
    Sql(value = ["/sql/load-tasks.sql"], executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
    Sql(value = ["/sql/clean-database.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
)
class TaskRepositoryIT : JdbcDatabaseIT() {

    @Autowired
    private lateinit var sut: TaskRepository

    @Test
    fun `should save new task`() {
        val task = Task(
            title = "Simple task",
            description = "Simple task",
            dueDate = LocalDateTime.now().plusDays(5),
            status = TaskStatus.BACKLOG,
            user = User(
                id = UUID.fromString("d2b66bc6-56c6-4ef6-b166-3f4aa9651dfc"),
                name = "Dummy user",
                email = "dummy@email"
            )
        )

        val result = sut.save(task)

        assertEquals(task, result)
    }

    @Test
    fun `should filter all tasks from user`() {
        val filter = TaskSearchFilter(
            user = User(id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"), name = "dummy", email = "dummy@email.com")
        )
        val result = sut.filter(filter)
        assertEquals(3, result.size)
    }

    @Test
    fun `should filter tasks by title ignoring letter case`() {
        val filter = TaskSearchFilter(
            user = User(id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"), name = "dummy", email = "dummy@email.com"),
            title = "comprar"
        )
        val result = sut.filter(filter)
        assertEquals(1, result.size)
    }

    @Test
    fun `should filter tasks by description ignoring letter case`() {
        val filter = TaskSearchFilter(
            user = User(id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"), name = "dummy", email = "dummy@email.com"),
            description = "ler"
        )
        val result = sut.filter(filter)
        assertEquals(2, result.size)
    }

    @Test
    fun `should filter task by status`() {
        val filter = TaskSearchFilter(
            user = User(id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"), name = "dummy", email = "dummy@email.com"),
            taskStatus = TaskStatus.TODO
        )
        val result = sut.filter(filter)
        assertEquals(2, result.size)
    }

    @Test
    fun `should filter task by id`() {
        val filter = TaskSearchFilter(
            user = User(id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"), name = "dummy", email = "dummy@email.com"),
            id = UUID.fromString("d98d8e7d-b00f-41de-853d-962f76cfa0a9")
        )
        val result = sut.filter(filter)
        assertEquals(1, result.size)
    }

    @Test
    fun `should update one task`() {
        val user = User(id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"), name = "dummy", email = "dummy@email.com")
        val taskEditionRequest = TaskEditionRequest(
            id = UUID.fromString("089cd1cf-6d36-4e5f-9f0e-f5a5b5d5b1c5"),
            title = "Ler a bíblia",
            description = "Ler um capitulo do livro de Mateus",
            status = TaskStatus.DONE,
            dueDate = LocalDateTime.now().minusDays(2)
        )
        val result = sut.update(taskEditionRequest, user)

        assertNotNull(result)
        result.apply {
            assertEquals("Ler a bíblia", this.title)
            assertEquals("Ler um capitulo do livro de Mateus", this.description)
            assertEquals(TaskStatus.DONE, this.status)
        }
    }

    @Test
    fun `should return true when delete an existent task`() {
        val user = User(id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"), name = "dummy", email = "dummy@email.com")

        assertTrue { sut.delete(UUID.fromString("089cd1cf-6d36-4e5f-9f0e-f5a5b5d5b1c5"), user) }
    }

    @Test
    fun `should not delete an existent task from diferent user`() {
        val user = User(id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"), name = "dummy", email = "dummy@email.com")

        assertFalse { sut.delete(UUID.fromString("37a51d7c-35c9-49a1-97de-c9d802a8b45f"), user) }
    }
}