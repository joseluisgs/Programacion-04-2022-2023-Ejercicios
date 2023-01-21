package models

import interfaces.ITeclista
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TeclistaTest {

    @Test
    fun interpretar() {
        assertEquals(Teclista("Jon Lord",ITeclista.TipoTeclado.Electrico,20).interpretar(),
            "Jon Lord esta tocando el teclado")
    }
}