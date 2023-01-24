package gameCatan.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ComputerFactoryTest {
    @Test
    fun create() {
        val computerTest = ComputerFactory.create()
        Assertions.assertNotNull(computerTest)
    }
}