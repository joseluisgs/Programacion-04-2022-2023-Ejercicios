package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.models.Musico

internal class CantanteFactoryTest {
    @Test
    fun createCantanteTest() {
        val Cantante: Musico.Cantante = CantanteFactory.create()
        // Cantante no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(Cantante)
    }
}