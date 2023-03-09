package nom.brunokarpo.todotasks.app.configurations

import nom.brunokarpo.todotasks.domain.model.User
import nom.brunokarpo.todotasks.domain.repository.TaskRepository
import nom.brunokarpo.todotasks.domain.repository.UserRepository
import nom.brunokarpo.todotasks.domain.service.TaskService
import nom.brunokarpo.todotasks.domain.service.UserProvider
import nom.brunokarpo.todotasks.domain.service.UserService
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
    fun userService(userRepository: UserRepository): UserService {
        return UserService(userRepository = userRepository)
    }

    @Bean
    fun userProvider(): UserProvider = object: UserProvider {
        override fun getUserFromSession(): User {
            return User(
                id = UUID.fromString("c1f0018e-cc53-49b1-a1b9-9bb8a017d2e2"),
                name = "Dummy User",
                email = "dummy@email"
            )
        }

    }

}