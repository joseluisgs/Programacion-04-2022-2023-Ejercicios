package simulacionBandaMusica.models

import org.junit.jupiter.api.Test
import simulacionBandaMusica.factories.TrompetistaFactory
import kotlin.test.assertEquals

internal class TrompetistaTest {
    @Test
    fun respirarTrompetista() {
        val trompetistaTest: Musico.Trompetista = TrompetistaFactory.create()
        val correctoString =
            "Estoy respirando como trompetista con una capacidad pulmonar de " + trompetistaTest.capacidadPulomar
        assertEquals(correctoString, trompetistaTest.respirarTrompetista())
    }
}