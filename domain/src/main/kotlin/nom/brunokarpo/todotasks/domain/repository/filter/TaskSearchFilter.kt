package nom.brunokarpo.todotasks.domain.repository.filter

import nom.brunokarpo.todotasks.domain.model.TaskStatus
import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.service.requests.TaskSearchRequest
import java.util.UUID

data class TaskSearchFilter(
    val id: UUID? = null,
    val title: String? = null,
    val description: String? = null,
    val taskStatus: TaskStatus? = null,
    val user: User
) {
    constructor(searchRequest: TaskSearchRequest, user: User) : this(
        id = searchRequest.id,
        title = searchRequest.title,
        description = searchRequest.description,
        taskStatus = searchRequest.status,
        user = user,
    )
}
