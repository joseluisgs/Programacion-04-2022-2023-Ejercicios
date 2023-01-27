package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.models.Musico

internal class TeclistaFactoryTest {
    @Test
    fun createTeclistaaTest() {
        val Teclista: Musico.Teclista = TeclistaFactory.create()
        // Teclista no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(Teclista)
    }
}