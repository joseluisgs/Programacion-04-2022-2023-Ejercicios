package models

import interfaces.IPercusionista
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PercusionistaTest {

    @Test
    fun interpretar() {
        assertEquals(Percusionista("Meg White",IPercusionista.TipoPercusion.Bateria,20).interpretar(),
            "Meg White esta tocando Bateria")
    }
}