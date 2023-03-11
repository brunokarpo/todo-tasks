package nom.brunokarpo.todotasks.app.api.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import nom.brunokarpo.todotasks.app.api.dto.UserDetailsDTO
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenService {
    fun generateToken(user: UserDetailsDTO): String {
        return JWT.create()
            .withIssuer("TODO_TASKS")
            .withSubject(user.username)
            .withClaim("id", user.username)
            .withExpiresAt(
                LocalDateTime.now()
                    .plusMinutes(10)
                    .toInstant(ZoneOffset.UTC)
            ).sign(Algorithm.HMAC512("muito-dificil-de-descobrir"))
    }

    fun getSubject(token: String): String {
        return JWT
            .require(Algorithm.HMAC512("muito-dificil-de-descobrir"))
            .withIssuer("TODO_TASKS")
            .build().verify(token).subject
    }

}
