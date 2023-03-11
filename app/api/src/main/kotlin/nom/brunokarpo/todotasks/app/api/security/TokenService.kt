package nom.brunokarpo.todotasks.app.api.security

import nom.brunokarpo.todotasks.app.api.dto.UserDetailsDTO
import org.springframework.stereotype.Service

@Service
class TokenService {
    fun generateToken(user: UserDetailsDTO): String {
        TODO("Not yet implemented")
    }

}
