package nom.brunokarpo.todotasks.domain.service.requests

import nom.brunokarpo.todotasks.domain.model.Task
import nom.brunokarpo.todotasks.domain.model.TaskStatus
import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.service.UserProvider
import java.time.LocalDateTime

data class TaskCreationRequest(
    val title: String,
    val description: String,
    val dueDate: LocalDateTime,
    val status: TaskStatus? = null
) {

    fun convertToTask(user: User): Task {
        return Task(
            title = this.title,
            description = this.description,
            dueDate = this.dueDate,
            status = this.status ?: TaskStatus.BACKLOG,
            user = user
        )
    }

}
