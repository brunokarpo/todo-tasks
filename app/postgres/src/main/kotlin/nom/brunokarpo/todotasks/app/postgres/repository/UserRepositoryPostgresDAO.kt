package nom.brunokarpo.todotasks.app.postgres.repository

import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.UserRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepositoryPostgresDAO(
    private val jdbcTemplate: NamedParameterJdbcTemplate
): UserRepository {
    override fun create(user: User): User {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: String): User? {
        val sql = """
            select id, name, email
            from users_data
            where email = :email
        """.trimIndent()
        val params = mapOf(
            "email" to email
        )
        return jdbcTemplate.query(sql, params) {rs, _ ->
            User(
                id = UUID.fromString(rs.getString("id")),
                name = rs.getString("name"),
                email = rs.getString("email")
            )
        }.firstOrNull()
    }
}