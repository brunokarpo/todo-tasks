package nom.brunokarpo.todotasks.app.api.dto

import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.service.requests.UserCreationRequest
import java.util.UUID

data class UserDTO(
    val id: UUID? = null,
    val name: String,
    val email: String,
) {
    constructor(user: User) : this(
        id = user.id,
        name = user.name,
        email = user.email
    )

    fun toUserCreationRequest(): UserCreationRequest {
        return UserCreationRequest(
            name = this.name,
            email = this.email
        )
    }
}
