package nom.brunokarpo.todotasks.app.api.endpoints

import nom.brunokarpo.todotasks.app.api.dto.TaskDTO
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.config.Task
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(TasksApi.TASK_PATH)
interface TasksApi {

    companion object {
        const val TASK_PATH = "/tasks"
    }

    @PostMapping
    fun create(@RequestBody dto: TaskDTO): ResponseEntity<TaskDTO>

    @GetMapping
    fun search(
        @RequestParam(required = false) id: UUID?,
        @RequestParam(required = false) title: String?,
        @RequestParam(required = false) description: String?,
        @RequestParam(required = false) status: String?
    ): ResponseEntity<List<TaskDTO>>

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @RequestBody dto: TaskDTO
    ): ResponseEntity<TaskDTO>

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Void>
}