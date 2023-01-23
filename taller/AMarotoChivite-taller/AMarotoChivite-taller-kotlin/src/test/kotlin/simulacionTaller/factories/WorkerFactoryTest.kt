package simulacionTaller.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class WorkerFactoryTest {
    @Test
    fun createTest() {
        val worker = WorkerFactory.create()
        // No nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(worker)
    }
}