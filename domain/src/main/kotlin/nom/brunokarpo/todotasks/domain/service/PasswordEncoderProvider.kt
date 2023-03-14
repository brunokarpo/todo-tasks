package nom.brunokarpo.todotasks.domain.service

interface PasswordEncoderProvider {

    fun encode(rawPassword: String): String
}
