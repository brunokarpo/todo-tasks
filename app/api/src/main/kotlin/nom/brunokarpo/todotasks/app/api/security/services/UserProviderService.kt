package nom.brunokarpo.todotasks.app.api.security.services

import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.service.UserProvider
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserProviderService: UserProvider {
    override fun getUserFromSession(): User {
        return SecurityContextHolder
            .getContext()
            .authentication
            .principal as User
    }
}