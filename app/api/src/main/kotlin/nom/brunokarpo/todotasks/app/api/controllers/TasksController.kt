package nom.brunokarpo.todotasks.app.api.controllers

import nom.brunokarpo.todotasks.app.api.dto.TaskDTO
import nom.brunokarpo.todotasks.app.api.endpoints.TasksApi
import nom.brunokarpo.todotasks.domain.model.TaskStatus
import nom.brunokarpo.todotasks.domain.service.TaskService
import nom.brunokarpo.todotasks.domain.service.requests.TaskEditionRequest
import nom.brunokarpo.todotasks.domain.service.requests.TaskSearchRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.net.URI
import java.util.UUID

@Component
class TasksController(
    private val taskService: TaskService
): TasksApi {

    override fun create(dto: TaskDTO): ResponseEntity<TaskDTO> {
        val taskDTO = TaskDTO(taskService.create(dto.toTaskCreationRequest()))
        return ResponseEntity.created(URI.create("${TasksApi.TASK_PATH}?id=${taskDTO.id}")).body(taskDTO)
    }

    override fun search(
        id: UUID?,
        title: String?,
        description: String?,
        status: String?
    ): ResponseEntity<List<TaskDTO>> {
        val result = taskService.search(TaskSearchRequest(
            id = id,
            title = title,
            description = description,
            status = status?.let { TaskStatus.valueOf(it) }
        ))
        return ResponseEntity.ok(
            result.map {
                TaskDTO(it)
            }
        )
    }

    override fun update(id: UUID, dto: TaskDTO): ResponseEntity<TaskDTO> {
        val result = taskService.edit(TaskEditionRequest(
            id = id,
            title = dto.title,
            description = dto.description,
            status = dto.status?.toTaskStatus(),
            dueDate = dto.dueDate
        ))
        return result?.let {
            ResponseEntity.ok(TaskDTO(it))
        } ?: ResponseEntity.notFound().build()
    }
}