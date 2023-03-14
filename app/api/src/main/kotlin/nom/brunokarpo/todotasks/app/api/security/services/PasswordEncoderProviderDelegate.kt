package nom.brunokarpo.todotasks.app.api.security.services

import nom.brunokarpo.todotasks.domain.service.PasswordEncoderProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncoderProviderDelegate(
    private val passwordEncoder: PasswordEncoder
): PasswordEncoderProvider {
    override fun encode(rawPassword: String): String {
        return passwordEncoder.encode(rawPassword)
    }
}