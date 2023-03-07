package nom.brunokarpo.todotasks.app

import nom.brunokarpo.todotasks.app.api.ApiConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackageClasses = [ApiConfiguration::class,])
class AppApplication

fun main(args: Array<String>) {
    runApplication<AppApplication>(*args)
}
