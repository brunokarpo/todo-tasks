package nom.brunokarpo.todotasks.app.postgres

import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.NONE,
    classes = [JdbcDatabaseConfiguration::class]
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
class JdbcDatabaseIT