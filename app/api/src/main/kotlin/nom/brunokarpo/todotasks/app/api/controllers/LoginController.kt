package nom.brunokarpo.todotasks.app.api.controllers

import nom.brunokarpo.todotasks.app.api.dto.LoginDTO
import nom.brunokarpo.todotasks.app.api.dto.UserDetailsDTO
import nom.brunokarpo.todotasks.app.api.endpoints.LoginApi
import nom.brunokarpo.todotasks.app.api.security.services.TokenService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component

@Component
class LoginController(
    private val authenticationManager: AuthenticationManager,
    private val tokenService: TokenService
): LoginApi {
    override fun login(login: LoginDTO): ResponseEntity<String> {
        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken.unauthenticated(login.username, login.password)
        val authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken)

        val user = authenticate.principal as UserDetailsDTO

        return ResponseEntity.ok(tokenService.generateToken(user))
    }
}