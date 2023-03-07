package nom.brunokarpo.todotasks.app.api.dto

import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.service.requests.TaskCreationRequest
import java.time.LocalDateTime
import java.util.UUID

data class TaskDTO(
    val id: UUID? = null,
    val title: String? = null,
    val description: String? = null,
    val dueDate: LocalDateTime? = null,
    val status: TaskStatusDTO? = null
) {
    constructor(task: Task) : this(
        id = task.id,
        title = task.title,
        description = task.description,
        dueDate = task.dueDate,
        status = TaskStatusDTO.fromStatus(task.status)
    )

    fun toTaskCreationRequest(): TaskCreationRequest {
        return TaskCreationRequest(
            title = this.title!!,
            description = this.description!!,
            dueDate = this.dueDate!!,
            status = this.status!!.toTaskStatus()
        )
    }
}
