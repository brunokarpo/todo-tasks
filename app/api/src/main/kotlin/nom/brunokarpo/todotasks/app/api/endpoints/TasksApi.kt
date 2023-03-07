package nom.brunokarpo.todotasks.app.api.endpoints

import nom.brunokarpo.todotasks.app.api.dto.TaskDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
interface TasksApi {

    @PostMapping
    fun create(dto: TaskDTO): TaskDTO
}