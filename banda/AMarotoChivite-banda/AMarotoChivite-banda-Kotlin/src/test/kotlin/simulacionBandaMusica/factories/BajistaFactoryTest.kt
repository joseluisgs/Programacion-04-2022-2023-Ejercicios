package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.models.Musico.Bajista

internal class BajistaFactoryTest {
    @Test
    fun createBajistaTest() {
        val Bajista: Bajista = BajistaFactory.create()
        // Bajista no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(Bajista)
    }
}