package nom.brunokarpo.todotasks.domain.repository

import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.filter.TaskSearchFilter
import nom.brunokarpo.todotasks.domain.service.requests.TaskEditionRequest

interface TaskRepository {
    fun save(task: Task): Task
    fun filter(filter: TaskSearchFilter): List<Task>
    fun update(taskEditionRequest: TaskEditionRequest, sessionUser: User): Task?
}
