package nom.brunokarpo.todotasks.app.api.controllers

import nom.brunokarpo.todotasks.app.api.dto.LoginDTO
import nom.brunokarpo.todotasks.app.api.dto.UserDetailsDTO
import nom.brunokarpo.todotasks.app.api.endpoints.LoginApi
import nom.brunokarpo.todotasks.app.api.security.TokenService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component

@Component
class LoginController(
    private val authenticationManager: AuthenticationManager,
    private val tokenService: TokenService
): LoginApi {
    override fun login(login: LoginDTO): String {
        val authenticate = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(login.username, login.password)
        )

        val user = authenticate.principal as UserDetailsDTO

        return tokenService.generateToken(user)
    }
}