package simulacionTaller.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BossFactoryTest {
    @Test
    fun createTest() {
        val boss = BossFactory.create()
        // No nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(boss)
    }
}