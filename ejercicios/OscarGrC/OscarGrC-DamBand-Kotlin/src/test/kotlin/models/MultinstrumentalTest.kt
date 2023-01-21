package models

import interfaces.IGuitarrista
import interfaces.IPercusionista
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MultinstrumentalTest {

    @Test
    fun interpretar() {
        assertEquals(Multinstrumental("Dick Van Dyke",5,IGuitarrista.Tipoguitarra.Acustica,
        IPercusionista.TipoPercusion.Bateria,30).interpretar(),
            "Dick Van Dyke esta tocando su bajo de 5 cuerdas, o su guitarra Acustica, o " +
                    "tocando su Bateria, vete tu a saber.")
    }
}