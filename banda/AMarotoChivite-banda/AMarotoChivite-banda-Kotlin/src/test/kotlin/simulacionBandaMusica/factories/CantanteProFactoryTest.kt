package simulacionBandaMusica.factories

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import simulacionBandaMusica.models.Musico

internal class CantanteProFactoryTest {
    @Test
    fun createCantanteProTest() {
        val CantantePro: Musico.CantantePro = CantanteProFactory.create()
        // CantantePro no nulo, para ver si se han asignado correctamente los datos
        Assertions.assertNotNull(CantantePro)
    }
}