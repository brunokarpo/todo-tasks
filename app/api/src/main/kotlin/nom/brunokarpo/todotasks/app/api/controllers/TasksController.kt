package nom.brunokarpo.todotasks.app.api.controllers

import nom.brunokarpo.todotasks.app.api.dto.TaskDTO
import nom.brunokarpo.todotasks.app.api.endpoints.TasksApi
import nom.brunokarpo.todotasks.domain.service.TaskService
import org.springframework.stereotype.Component

@Component
class TasksController(
    private val taskService: TaskService
): TasksApi {

    override fun create(dto: TaskDTO): TaskDTO {
        return TaskDTO(taskService.create(dto.toTaskCreationRequest()))
    }
}