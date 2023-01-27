package gameCatan.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BoxFactoryTest {
    @Test
    fun create() {
        val boxTest = BoxFactory.create()
        Assertions.assertNotNull(boxTest)
    }
}