package nom.brunokarpo.todotasks.app.api.dto

import nom.brunokarpo.todotasks.domain.model.TaskStatus

enum class TaskStatusDTO(
    private val taskStatus: TaskStatus
) {
    BACKLOG(TaskStatus.BACKLOG),
    TODO(TaskStatus.TODO),
    IN_PROGRESS(TaskStatus.IN_PROGRESS),
    DONE(TaskStatus.DONE),
    LATE(TaskStatus.LATE);

    fun toTaskStatus(): TaskStatus {
        return taskStatus
    }

    companion object {
        fun fromStatus(status: TaskStatus): TaskStatusDTO {
            return values().first {
                it.name == status.name
            }
        }
    }
}