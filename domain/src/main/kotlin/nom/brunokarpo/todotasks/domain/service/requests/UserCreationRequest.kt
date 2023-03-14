package nom.brunokarpo.todotasks.domain.service.requests

import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.service.PasswordEncoderProvider

data class UserCreationRequest(
    val name: String,
    val email: String,
    val password: String
) {
    fun toUser(passwordEncoderProvider: PasswordEncoderProvider): User {
        return User(
            name = this.name,
            email = this.email,
            password = passwordEncoderProvider.encode(password)
        )
    }
}
