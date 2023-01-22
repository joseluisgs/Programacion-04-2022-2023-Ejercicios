package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.models.Musico

internal class MultiFactoryTest {
    @Test
    fun createMultiTest() {
        val multi: Musico.MultiInstrumentista = MultiFactory.create()
        // MultiInstrumentista no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(multi)
    }
}