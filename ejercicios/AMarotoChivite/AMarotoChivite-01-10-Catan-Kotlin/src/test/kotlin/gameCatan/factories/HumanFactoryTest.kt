package gameCatan.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class HumanFactoryTest {
    @Test
    fun create() {
        val humanTest = HumanFactory.create()
        Assertions.assertNotNull(humanTest)
    }
}