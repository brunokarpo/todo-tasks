package nom.brunokarpo.todotasks.app.postgres.repository.mappers

import nom.brunokarpo.todotasks.domain.model.User
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.UUID

class UserRowMapper: RowMapper<User> {
    override fun mapRow(rs: ResultSet, rowNum: Int): User {
        return User(
            id = UUID.fromString(rs.getString("id")),
            name = rs.getString("name"),
            email = rs.getString("email"),
            password = rs.getString("password")
        )
    }
}