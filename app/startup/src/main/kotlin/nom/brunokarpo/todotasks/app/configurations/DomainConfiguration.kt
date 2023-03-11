package nom.brunokarpo.todotasks.app.configurations

import nom.brunokarpo.todotasks.domain.repository.TaskRepository
import nom.brunokarpo.todotasks.domain.repository.UserRepository
import nom.brunokarpo.todotasks.domain.service.TaskService
import nom.brunokarpo.todotasks.domain.service.UserProvider
import nom.brunokarpo.todotasks.domain.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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
}