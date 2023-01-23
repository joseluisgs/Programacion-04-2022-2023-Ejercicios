package simulacionBandaMusica.models

import org.junit.jupiter.api.Test
import simulacionBandaMusica.factories.CantanteFactory
import kotlin.test.assertEquals

internal class MusicoTest {
    @Test
    fun interpretarTest() {
        val cantante: Musico.Cantante = CantanteFactory.create()
        val correctString = "Estoy interpretando con mi " + cantante.instrumento
        assertEquals(correctString, cantante.interpretar())
    }
}