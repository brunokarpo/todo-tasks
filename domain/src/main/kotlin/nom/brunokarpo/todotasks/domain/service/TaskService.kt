package nom.brunokarpo.todotasks.domain.service

import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.model.TaskStatus
import nom.brunokarpo.todotasks.domain.repository.TaskRepository
import nom.brunokarpo.todotasks.domain.service.requests.TaskCreationRequest

class TaskService(
    private val taskRepository: TaskRepository,
    private val userProvider: UserProvider
) {
    fun create(taskCreationRequest: TaskCreationRequest) {
        val sessionUser = userProvider.getUserFromSession()
        taskRepository.save(taskCreationRequest.convertToTask(sessionUser))
    }

}
