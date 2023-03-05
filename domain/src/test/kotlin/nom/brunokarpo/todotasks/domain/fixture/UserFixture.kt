package nom.brunokarpo.todotasks.domain.fixture

import nom.brunokarpo.todotasks.domain.model.User

object UserFixture {

    fun createSimpleUser() = User(name = "Dummy User", email = "dummy@email")
}