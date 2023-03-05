package nom.brunokarpo.todotasks.domain.fixture

import nom.brunokarpo.todotasks.domain.service.requests.TaskCreationRequest
import java.time.LocalDateTime

object TaskCreationRequestFixture {

    fun createBasicTask() = TaskCreationRequest(
        title = "Simple task",
        description = "Simple description",
        dueDate = LocalDateTime.now().plusDays(5)
    )
}