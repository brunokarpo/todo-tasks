package nom.brunokarpo.todotasks.app.postgres.repository

import nom.brunokarpo.todotasks.app.postgres.repository.mappers.UserRowMapper
import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.UserRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryPostgresDAO(
    private val jdbcTemplate: NamedParameterJdbcTemplate
): UserRepository {
    override fun create(user: User): User {
        insertUserIdentifier(user)
        insertUserData(user)
        return user
    }

    private fun insertUserIdentifier(user: User) {
        val sqlIdentifiers = """
                insert into users_identifiers (id)
                values (:id)
            """.trimIndent()
        val paramsIdentifiers = mapOf<String, Any>(
            "id" to user.id
        )
        jdbcTemplate.update(sqlIdentifiers, paramsIdentifiers)
    }

    private fun insertUserData(user: User) {
        val sqlData = """
                insert into users_data (id, name, email, password)
                values (:id, :name, :email, :password)
            """.trimIndent()
        val paramsData = mapOf(
            "id" to user.id,
            "name" to user.name,
            "email" to user.email,
            "password" to user.password,
        )
        jdbcTemplate.update(sqlData, paramsData)
    }

    override fun findByEmail(email: String): User? {
        val sql = """
            select id, name, email, password
            from users_data
            where email = :email
        """.trimIndent()
        val params = mapOf(
            "email" to email
        )
        return jdbcTemplate.query(sql, params, UserRowMapper()).firstOrNull()
    }
}