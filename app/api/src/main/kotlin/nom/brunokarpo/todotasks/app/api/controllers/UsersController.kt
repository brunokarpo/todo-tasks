package nom.brunokarpo.todotasks.app.api.controllers

import nom.brunokarpo.todotasks.app.api.dto.UserDTO
import nom.brunokarpo.todotasks.app.api.endpoints.UsersApi
import nom.brunokarpo.todotasks.domain.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UsersController(
    private val userService: UserService
): UsersApi {
    override fun create(userDto: UserDTO): ResponseEntity<UserDTO> {
        val createdUser = UserDTO(userService.create(userDto.toUserCreationRequest()))
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createdUser)
    }
}