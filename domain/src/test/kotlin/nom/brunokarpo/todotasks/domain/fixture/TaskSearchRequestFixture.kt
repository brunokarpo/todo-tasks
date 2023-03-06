package nom.brunokarpo.todotasks.domain.fixture

import nom.brunokarpo.todotasks.domain.service.requests.TaskSearchRequest
import java.util.UUID

object TaskSearchRequestFixture {

    fun createTaskSearchRequestById(id: UUID) = TaskSearchRequest(id = id)
}