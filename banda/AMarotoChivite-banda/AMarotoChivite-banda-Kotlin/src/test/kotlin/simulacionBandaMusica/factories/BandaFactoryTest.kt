package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BandaFactoryTest {
    @Test
    fun createBandaTest() {
        val banda = BandaFactory.create()
        // Banda no nulo, para ver si se han asignado correctamente los datos
        for (i in 0 until banda.vectorMusicos.size) {
            Assertions.assertNotNull(banda.vectorMusicos[i])
        }
    }
}