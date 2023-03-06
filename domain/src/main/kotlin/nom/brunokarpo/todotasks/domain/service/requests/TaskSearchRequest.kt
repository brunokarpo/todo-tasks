package nom.brunokarpo.todotasks.domain.service.requests

import nom.brunokarpo.todotasks.domain.model.TaskStatus
import nom.brunokarpo.todotasks.domain.model.User
import java.util.*

data class TaskSearchRequest(
    val id: UUID? = null,
    val title: String? = null,
    val description: String? = null,
    val user: User? = null,
    val status: TaskStatus? = null
)
