package nom.brunokarpo.todotasks.domain.model

import java.util.UUID

data class User(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val email: String,
    val password: String? = null
)
