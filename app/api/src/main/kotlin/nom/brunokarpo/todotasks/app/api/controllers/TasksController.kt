package nom.brunokarpo.todotasks.app.api.controllers

import nom.brunokarpo.todotasks.app.api.dto.TaskDTO
import nom.brunokarpo.todotasks.app.api.endpoints.TasksApi
import nom.brunokarpo.todotasks.domain.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.net.URI

@Component
class TasksController(
    private val taskService: TaskService
): TasksApi {

    override fun create(dto: TaskDTO): ResponseEntity<TaskDTO> {
        val taskDTO = TaskDTO(taskService.create(dto.toTaskCreationRequest()))
        return ResponseEntity.created(URI.create("/${taskDTO.id}")).body(taskDTO)
    }
}