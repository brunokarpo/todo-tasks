package nom.brunokarpo.todotasks.model

import java.time.LocalDateTime
import java.util.UUID

data class Task(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val dueDate: LocalDateTime,
    val status: TaskStatus,
    val user: User
)