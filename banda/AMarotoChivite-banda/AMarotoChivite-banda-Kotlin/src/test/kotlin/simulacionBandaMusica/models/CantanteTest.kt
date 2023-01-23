package simulacionBandaMusica.models

import org.junit.jupiter.api.Test
import simulacionBandaMusica.factories.CantanteFactory
import kotlin.test.assertEquals

internal class CantanteTest {
    @Test
    fun respirarCantanteTest() {
        val cantanteTest: Musico.Cantante = CantanteFactory.create()
        val correctMessage =
            "Estoy respirando como cantante con una capacidad pulmonar de " + cantanteTest.capacidadPulomar
        assertEquals(correctMessage, cantanteTest.respirarCantante())
    }
}