package models

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TrompetistaTest {

    @Test
    fun respirar() {
        assertEquals(Trompetista("Arturo Sandoval",130,30).respirar(),
        "Arturo Sandoval respira fuerte.")
    }

    @Test
    fun interpretar() {
        assertEquals(Trompetista("Arturo Sandoval",130,30).interpretar(),
            "Arturo Sandoval esta tocando su trompeta")
    }
}