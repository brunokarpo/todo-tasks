package nom.brunokarpo.todotasks.app.api.endpoints

import nom.brunokarpo.todotasks.app.api.dto.LoginDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
interface LoginApi {

    @PostMapping
    fun login(login: LoginDTO): String
}