package nom.brunokarpo.todotasks.domain.repository

import nom.brunokarpo.todotasks.domain.model.User

interface UserRepository {
    fun create(user: User): User
    fun findByEmail(email: String): User?

}
