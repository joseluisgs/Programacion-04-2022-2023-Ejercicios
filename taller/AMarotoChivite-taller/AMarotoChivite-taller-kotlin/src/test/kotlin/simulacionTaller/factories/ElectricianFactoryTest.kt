package simulacionTaller.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ElectricianFactoryTest {
    @Test
    fun createTest() {
        val electrician = ElectricianFactory.create()
        // No nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(electrician)
    }
}