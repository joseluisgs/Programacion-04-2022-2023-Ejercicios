package simulacionTaller.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PlaterFactoryTest {
    @Test
    fun createTest() {
        val plater = PlaterFactory.create()
        // No nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(plater)
    }
}