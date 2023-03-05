package nom.brunokarpo.todotasks.domain.service

import nom.brunokarpo.todotasks.domain.model.User

interface UserProvider {
    fun getUserFromSession(): User
}