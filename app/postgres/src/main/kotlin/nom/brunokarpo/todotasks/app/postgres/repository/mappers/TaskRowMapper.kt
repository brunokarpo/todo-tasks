package nom.brunokarpo.todotasks.app.postgres.repository.mappers

import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.model.TaskStatus
import nom.brunokarpo.todotasks.domain.model.User
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.util.UUID

class TaskRowMapper(
    private val user: User
): RowMapper<Task> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Task {
        return Task(
            id = UUID.fromString(rs.getString("id")),
            title = rs.getString("title"),
            description = rs.getString("description"),
            dueDate = rs.getTimestamp("due_date").toLocalDateTime(),
            status = TaskStatus.valueOf(rs.getString("status")),
            user = user
        )
    }
}