package nom.brunokarpo.todotasks.app.postgres.repository

import nom.brunokarpo.todotasks.app.postgres.JdbcDatabaseIT
import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.UserRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

@SqlGroup(
    Sql(value = ["/sql/load-users.sql"], executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
    Sql(value = ["/sql/clean-database.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
)
class UserRepositoryIT: JdbcDatabaseIT() {

    @Autowired
    private lateinit var sut: UserRepository

    @Test
    fun `should load user by email`() {
        val result = sut.findByEmail("bob@example.com")

        assertNotNull(result)
        result.apply {
            assertEquals("f6863a3a-3da6-4c0f-96b1-2d86d12f47a9", this.id.toString())
            assertEquals("Bob", this.name)
            assertEquals("bob@example.com", this.email)
        }
    }

    @Test
    fun `should return null when does not exist user with the email`() {
        val result = sut.findByEmail("gaspar@email.com")

        assertNull(result)
    }

    @Test
    fun `should insert new user`() {
        val user = User(
            name = "Gaspar",
            email = "gaspar@example.com"
        )

        var result: User? = null
        assertDoesNotThrow {
            result = sut.create(user)
        }

        assertNotNull(result)

        assertEquals(user, result)
    }
}