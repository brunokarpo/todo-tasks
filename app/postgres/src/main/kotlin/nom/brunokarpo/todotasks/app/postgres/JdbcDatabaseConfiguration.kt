package nom.brunokarpo.todotasks.app.postgres

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan
@ConfigurationPropertiesScan("nom.brunokarpo.todotasks.app.postgres")
class JdbcDatabaseConfiguration