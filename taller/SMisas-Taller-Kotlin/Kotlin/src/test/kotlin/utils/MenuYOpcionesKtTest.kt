package utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MenuYOpcionesKtTest {


    @Test
    fun validarOpcionTest() {
        val opcion1 = 0
        val opcion2 = 3
        val opcionMal1 = -1
        val opcionMal2 = 5
        assertAll({

            assertEquals(4, validarOpcion(opcionMal1));
            assertEquals(4, validarOpcion(opcionMal2));
            assertEquals(0, validarOpcion(opcion1));
            assertEquals(3, validarOpcion(opcion2))
        }
        )

    }
}