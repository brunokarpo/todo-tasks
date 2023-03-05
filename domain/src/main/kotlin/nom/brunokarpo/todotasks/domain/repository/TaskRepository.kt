package nom.brunokarpo.todotasks.domain.repository

import nom.brunokarpo.todotasks.domain.model.Task

interface TaskRepository {
    fun save(task: Task)
}
