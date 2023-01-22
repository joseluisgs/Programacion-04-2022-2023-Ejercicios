package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.models.Musico

internal class TrompetistaFactoryTest {
    @Test
    fun createTrompetistaTest() {
        val Trompetista: Musico.Trompetista = TrompetistaFactory.create()
        // Trompetista no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(Trompetista)
    }
}