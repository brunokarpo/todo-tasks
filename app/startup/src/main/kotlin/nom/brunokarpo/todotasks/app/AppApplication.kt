package nom.brunokarpo.todotasks.app

import nom.brunokarpo.todotasks.app.api.ApiConfiguration
import nom.brunokarpo.todotasks.app.postgres.JdbcDatabaseConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackageClasses = [AppApplication::class, ApiConfiguration::class, JdbcDatabaseConfiguration::class])
class AppApplication

fun main(args: Array<String>) {
    runApplication<AppApplication>(*args)
}
