package simulacionBandaMusica.models

import org.junit.jupiter.api.Test
import simulacionBandaMusica.factories.CantanteFactory
import kotlin.test.assertEquals

internal class PersonTest {
    @Test
    fun respirarTest() {
        val cantanteTest: Musico.Cantante = CantanteFactory.create()
        val correctString = "Estoy respirando..."
        assertEquals(correctString, cantanteTest.respirar())
    }
}