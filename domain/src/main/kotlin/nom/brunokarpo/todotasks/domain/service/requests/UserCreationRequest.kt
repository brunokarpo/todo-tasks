package nom.brunokarpo.todotasks.domain.service.requests

import nom.brunokarpo.todotasks.domain.model.User

data class UserCreationRequest(
    val name: String,
    val email: String
) {
    fun toUser(): User {
        return User(
            name = this.name,
            email = this.email
        )
    }
}
