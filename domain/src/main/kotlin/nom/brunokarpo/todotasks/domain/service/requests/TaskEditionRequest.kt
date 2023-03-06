package nom.brunokarpo.todotasks.domain.service.requests

import nom.brunokarpo.todotasks.domain.model.TaskStatus
import java.time.LocalDateTime
import java.util.UUID

data class TaskEditionRequest(
    val id: UUID,
    val title: String? = null,
    val description: String? = null,
    val dueDate: LocalDateTime? = null,
    val status: TaskStatus? = null
) {

    fun hasUpdate(): Boolean {
        return title?.isNotBlank() ?: false || description?.isNotBlank() ?: false || dueDate != null || status != null
    }
}
