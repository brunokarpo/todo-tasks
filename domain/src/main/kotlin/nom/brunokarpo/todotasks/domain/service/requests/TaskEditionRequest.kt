package nom.brunokarpo.todotasks.domain.service.requests

import nom.brunokarpo.todotasks.domain.model.TaskStatus
import java.util.*

data class TaskEditionRequest(
    val id: UUID,
    val title: String? = null,
    val description: String? = null,
    val dueDate: String? = null,
    val status: TaskStatus? = null
)
