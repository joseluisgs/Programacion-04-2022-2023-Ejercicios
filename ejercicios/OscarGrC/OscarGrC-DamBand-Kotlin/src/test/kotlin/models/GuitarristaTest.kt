package models

import interfaces.IGuitarrista
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GuitarristaTest {

    @Test
    fun interpretar() {
        assertEquals(Guitarrista("Brian May",IGuitarrista.Tipoguitarra.Electrica,30).interpretar(),
            "Brian May esta tocando la guitarra Electrica")
    }
}