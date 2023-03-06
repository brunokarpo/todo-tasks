package nom.brunokarpo.todotasks.app.postgres.repository

import nom.brunokarpo.todotasks.app.postgres.repository.mappers.TaskRowMapper
import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.TaskRepository
import nom.brunokarpo.todotasks.domain.repository.filter.TaskSearchFilter
import nom.brunokarpo.todotasks.domain.service.requests.TaskEditionRequest
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class TaskRepositoryPostgresDAO(
    private val jdbcTemplate: NamedParameterJdbcTemplate
): TaskRepository {
    override fun save(task: Task): Task {
        val sql = """
            insert into tasks (id, title, description, due_date, status, user_id)
            values (:id, :title, :description, :dueDate, :status, :userId)
        """.trimIndent()
        val params = mapOf(
            "id" to task.id,
            "title" to task.title,
            "description" to task.description,
            "dueDate" to task.dueDate,
            "status" to task.status.name,
            "userId" to task.user.id
        )
        jdbcTemplate.update(sql, params)
        return task
    }

    override fun filter(filter: TaskSearchFilter): List<Task> {
        var sql = """
            select id, title, description, due_date, status, user_id
            from tasks
            where user_id = :userId
        """.trimIndent()
        val params = mutableMapOf<String, Any>(
            "userId" to filter.user.id
        )

        filter.id?.let {
            sql += " and id = :id "
            params["id"] = it
        }
        filter.title?.let {
            sql += " and lower(title) ~ :title "
            params["title"] = it.lowercase()
        }
        filter.description?.let {
            sql += " and lower(description) ~ :description"
            params["description"] = it.lowercase()
        }
        filter.taskStatus?.let {
            sql += " and status = :status "
            params["status"] = it.name
        }

        return jdbcTemplate.query(sql, params, TaskRowMapper(filter.user))
    }

    override fun update(taskEditionRequest: TaskEditionRequest, sessionUser: User): Task? {
        if (!taskEditionRequest.hasUpdate()) {
            return null
        }

        val params = mutableMapOf<String, Any>()

        val setClause = mutableListOf<String>()
        taskEditionRequest.title?.let {
            setClause.add(" title = :title ")
            params["title"] = it
        }
        taskEditionRequest.description?.let {
            setClause.add(" description = :description ")
            params["description"] = it
        }
        taskEditionRequest.status?.let {
            setClause.add(" status = :status ")
            params["status"] = it.name
        }
        taskEditionRequest.dueDate?.let {
            setClause.add(" due_date = :dueDate ")
            params["dueDate"] = it
        }

        val sql = """
            update tasks set ${setClause.joinToString(",")}
            where id = :id and user_id = :userId
            returning id, title, description, due_date, status, user_id
        """.trimIndent()
        params["id"] = taskEditionRequest.id
        params["userId"] = sessionUser.id

        return jdbcTemplate.query(sql, params, TaskRowMapper(sessionUser)).firstOrNull()

    }
}