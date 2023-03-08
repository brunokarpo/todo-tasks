package nom.brunokarpo.todotasks.domain.repository

import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.filter.TaskSearchFilter
import nom.brunokarpo.todotasks.domain.service.requests.TaskEditionRequest
import java.util.UUID

interface TaskRepository {
    fun save(task: Task): Task
    fun filter(filter: TaskSearchFilter): List<Task>
    fun update(taskEditionRequest: TaskEditionRequest, sessionUser: User): Task?
    fun delete(taskId: UUID, sessionUser: User): Boolean
}
