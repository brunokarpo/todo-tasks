package nom.brunokarpo.todotasks.app.api.endpoints

import nom.brunokarpo.todotasks.app.api.dto.UserDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
interface UsersApi {

    @PostMapping
    fun create(@RequestBody userDto: UserDTO): ResponseEntity<UserDTO>
}