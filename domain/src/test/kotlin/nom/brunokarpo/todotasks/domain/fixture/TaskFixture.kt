package nom.brunokarpo.todotasks.domain.fixture

import nom.brunokarpo.todotasks.domain.model.Task
import java.time.LocalDateTime

object TaskFixture {

    fun createSimpleTask() = Task(
        title = "Simple task",
        description = "Simple description",
        dueDate = LocalDateTime.now().plusDays(5),
        user = UserFixture.createSimpleUser()
    )
}