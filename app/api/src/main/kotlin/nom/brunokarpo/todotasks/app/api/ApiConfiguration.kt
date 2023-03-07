package nom.brunokarpo.todotasks.app.api

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan
@ConfigurationPropertiesScan("nom.brunokarpo.todotasks.app.api")
class ApiConfiguration