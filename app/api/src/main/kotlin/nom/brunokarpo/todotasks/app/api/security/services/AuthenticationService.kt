package nom.brunokarpo.todotasks.app.api.security.services

import nom.brunokarpo.todotasks.app.api.dto.UserDetailsDTO
import nom.brunokarpo.todotasks.domain.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userService: UserService
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return userService.findByEmail(username)?.let {
            UserDetailsDTO(it)
        } ?: throw UsernameNotFoundException("Not found user with username '$username'")
    }
}