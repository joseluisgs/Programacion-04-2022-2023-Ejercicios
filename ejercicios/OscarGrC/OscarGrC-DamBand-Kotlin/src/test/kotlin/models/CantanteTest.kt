package models

import interfaces.ICantante
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CantanteTest {

    @Test
    fun respirar() {
        assertEquals(Cantante("Lemmy",ICantante.TonosCantante.Alto,20).respirar(),
            "Lemmy respira fuerte.")
    }

    @Test
    fun interpretar() {
        assertEquals(Cantante("Lemmy",ICantante.TonosCantante.Alto,20).interpretar(),
            "Lemmy esta cantando")
    }
}