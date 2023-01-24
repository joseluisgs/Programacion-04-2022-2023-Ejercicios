package gameCatan.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MapFactoryTest {
    @Test
    fun create() {
        val mapTest = MapFactory.create()
        Assertions.assertNotNull(mapTest)
    }
}