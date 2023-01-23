package simulacionTaller.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MultiFactoryTest {
    @Test
    fun createTest() {
        val multi = MultiFactory.create()
        // No nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(multi)
    }
}