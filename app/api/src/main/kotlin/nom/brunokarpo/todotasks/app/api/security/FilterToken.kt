package nom.brunokarpo.todotasks.app.api.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import nom.brunokarpo.todotasks.domain.service.UserService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class FilterToken(
    private val tokenService: TokenService,
    private val userService: UserService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        request.getHeader("Authorization")
            ?.removePrefix("Bearer ")
            ?.let {
                val subject = tokenService.getSubject(it)
                val user = userService.findByEmail(subject)

                user?.let { u ->
                    SecurityContextHolder
                        .getContext()
                        .authentication = UsernamePasswordAuthenticationToken(u, null, mutableListOf(SimpleGrantedAuthority("ROLE_USER")))
                }
            }

        filterChain.doFilter(request, response)
    }
}
