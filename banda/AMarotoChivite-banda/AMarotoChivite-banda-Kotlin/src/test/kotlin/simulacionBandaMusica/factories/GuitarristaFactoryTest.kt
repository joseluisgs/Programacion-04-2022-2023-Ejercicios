package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.models.Musico

internal class GuitarristaFactoryTest {
    @Test
    fun createGuitarristaTest() {
        val Guitarrista: Musico.Guitarrista = GuitarristaFactory.create()
        // Guitarrista no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(Guitarrista)
    }
}