package nom.brunokarpo.todotasks.domain.service

import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.UserRepository
import nom.brunokarpo.todotasks.domain.service.requests.UserCreationRequest

class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoderProvider: PasswordEncoderProvider
) {

    fun create(userCreationRequest: UserCreationRequest): User {
        return userRepository.create(userCreationRequest.toUser(passwordEncoderProvider))
    }

    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }
}