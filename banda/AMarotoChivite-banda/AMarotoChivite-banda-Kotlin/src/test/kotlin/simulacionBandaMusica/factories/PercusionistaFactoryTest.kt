package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.models.Musico

internal class PercusionistaFactoryTest {
    @Test
    fun createPercusionistaTest() {
        val Percusionista: Musico.Percusionista = PercusionistaFactory.create()
        // Percusionista no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(Percusionista)
    }
}