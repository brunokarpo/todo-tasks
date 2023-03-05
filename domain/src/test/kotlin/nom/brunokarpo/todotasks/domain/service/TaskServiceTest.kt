package nom.brunokarpo.todotasks.domain.service

import io.mockk.*
import nom.brunokarpo.todotasks.domain.fixture.TaskCreationRequestFixture
import nom.brunokarpo.todotasks.domain.fixture.UserFixture
import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.repository.TaskRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TaskServiceTest {

    private val userProviderMock = mockk<UserProvider> {
        every {
            getUserFromSession()
        } returns UserFixture.createSimpleUser()
    }

    private val taskRepositoryMock = mockk<TaskRepository>() {
        every {
            save(any())
        } just Runs
    }

    private lateinit var sut: TaskService

    @BeforeEach
    fun setUp() {
        sut = TaskService(taskRepositoryMock, userProviderMock)
    }

    @Test
    fun `should create a new task`() {
        val taskCreationRequest = TaskCreationRequestFixture.createBasicTask()
        sut.create(taskCreationRequest)

        verify { taskRepositoryMock.save(any()) }
    }

    @Test
    fun `should create the task with user of session`() {
        val taskSlot = slot<Task>()
        every {
            taskRepositoryMock.save(capture(taskSlot))
        } just Runs

        val user = UserFixture.createSimpleUser()
        every {
            userProviderMock.getUserFromSession()
        } returns user

        val taskCreateRequest = TaskCreationRequestFixture.createBasicTask()

        sut.create(taskCreateRequest)

        val savedTask = taskSlot.captured

        assertEquals(user, savedTask.user)
    }
}