package nom.brunokarpo.todotasks.app.configurations

import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.TaskRepository
import nom.brunokarpo.todotasks.domain.service.TaskService
import nom.brunokarpo.todotasks.domain.service.UserProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.UUID

@Configuration
class DomainConfiguration {

    @Bean
    fun taskService(taskRepository: TaskRepository, userProvider: UserProvider): TaskService {
        return TaskService(taskRepository = taskRepository, userProvider = userProvider)
    }

    @Bean
    fun userProvider(): UserProvider = object: UserProvider {
        override fun getUserFromSession(): User {
            return User(
                id = UUID.fromString("c3607c49-08af-46b4-897b-bb54ecb2c161"),
                name = "Dummy User",
                email = "dummy@email"
            )
        }

    }

}