package nom.brunokarpo.todotasks.domain.model

import java.util.*

data class User(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val email: String
)
