package models

import interfaces.ICantante
import interfaces.IGuitarrista
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CantanteGuitarristaTest {

    @Test
    fun respirar() {
        assertEquals(CantanteGuitarrista("Chuck Berry",ICantante.TonosCantante.Alto
            ,IGuitarrista.Tipoguitarra.Electrica,30).respirar(),
            "Chuck Berry respira fuerte.")
    }

    @Test
    fun interpretar() {
        assertEquals(CantanteGuitarrista("Chuck Berry",ICantante.TonosCantante.Alto
            ,IGuitarrista.Tipoguitarra.Electrica,30).interpretar(),
            "Chuck Berry esta cantando y tocando la guitarra Electrica")
    }
}