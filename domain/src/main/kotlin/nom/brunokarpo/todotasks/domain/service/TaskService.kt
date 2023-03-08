package nom.brunokarpo.todotasks.domain.service

import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.repository.TaskRepository
import nom.brunokarpo.todotasks.domain.repository.filter.TaskSearchFilter
import nom.brunokarpo.todotasks.domain.service.requests.TaskCreationRequest
import nom.brunokarpo.todotasks.domain.service.requests.TaskEditionRequest
import nom.brunokarpo.todotasks.domain.service.requests.TaskSearchRequest
import java.util.UUID

class TaskService(
    private val taskRepository: TaskRepository,
    private val userProvider: UserProvider
) {
    fun create(taskCreationRequest: TaskCreationRequest): Task {
        val sessionUser = userProvider.getUserFromSession()
        return taskRepository.save(taskCreationRequest.convertToTask(sessionUser))
    }

    fun search(search: TaskSearchRequest): List<Task> {
        val sessionUser = userProvider.getUserFromSession()
        return taskRepository.filter(TaskSearchFilter(search, sessionUser))
    }

    fun edit(taskEditionRequest: TaskEditionRequest): Task? {
        val sessionUser = userProvider.getUserFromSession()
        return taskRepository.update(taskEditionRequest, sessionUser)
    }

    fun remove(taskId: UUID): Boolean {
        val sessionUser = userProvider.getUserFromSession()
        return taskRepository.delete(taskId, sessionUser)
    }

}
