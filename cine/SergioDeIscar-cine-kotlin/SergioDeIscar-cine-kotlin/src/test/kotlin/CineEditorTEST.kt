import salacine.enums.FilmGenero
import salacine.models.*
import salacine.stringToAlphabetNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.*

private class CineEditorTEST {
    // region Others
    @Test
    fun charStringToNumber_Test(){
        assertAll(
            { assertEquals(0, stringToAlphabetNumber("A")) },
            { assertEquals(13, stringToAlphabetNumber("N")) },
            { assertEquals(14, stringToAlphabetNumber("Ñ")) },
            { assertEquals(26, stringToAlphabetNumber("Z")) },
            { assertEquals(27, stringToAlphabetNumber("AA")) },
            { assertEquals(41, stringToAlphabetNumber("AÑ")) },
            { assertEquals(54, stringToAlphabetNumber("BA")) },
        )
    }

    @Test
    fun alphabetNumberToString_Test(){
        val sala = Sala("pepe", Film("pepe",2020u, "pepe", FilmGenero.ACTION), Pair(60,60), 40)
        assertAll(
            { assertEquals("A", sala.alphabetNumberToString(0)) },
            { assertEquals("N", sala.alphabetNumberToString(13)) },
            { assertEquals("Ñ", sala.alphabetNumberToString(14)) },
            { assertEquals("Z", sala.alphabetNumberToString(26)) },
            { assertEquals("AA", sala.alphabetNumberToString(27)) },
            { assertEquals("AÑ", sala.alphabetNumberToString(41)) },
            { assertEquals("BA", sala.alphabetNumberToString(54)) },
        )
    }
    //endregion

    val filmExample = Film("Titulo", 2022u, "Pedro", FilmGenero.AVENTURAS)

    @Test
    fun getSize_Test(){
        val smallSala = Sala("Small", filmExample, Pair(2,5))
        val largeSala = Sala("Small", filmExample, Pair(6,24))

        assertAll(
            { assertEquals(Pair(2,5), smallSala.getSize()) },
            { assertEquals(Pair(6,24), largeSala.getSize()) },
        )
    }

    @Test
    fun reservaButaca_Test(){
        val sala = Sala("ToEdit", filmExample, Pair(4,6))
        sala.reservaButaca(Pair(0,3))

        assertAll(
            { assertFalse(sala.reservaButaca(Pair(5,0))) },
            { assertFalse(sala.reservaButaca(Pair(0,7))) },

            { assertFalse(sala.reservaButaca(Pair(0,3))) },

            { assertTrue(sala.reservaButaca(Pair(0,0))) }
        )
    }

    @Test
    fun formalizarReserva_Test(){
        val sala = Sala("ToEdit", filmExample, Pair(4,6))
        sala.reservaButaca(Pair(0,0))

        assertAll(
            { assertFalse(sala.formalizarReserva(Pair(5,0))) },
            { assertFalse(sala.formalizarReserva(Pair(0,7))) },

            { assertFalse(sala.formalizarReserva(Pair(0,1))) },

            { assertTrue(sala.formalizarReserva(Pair(0,0))) }
        )
    }

    @Test
    fun anularReserva_Test(){
        val sala = Sala("ToEdit", filmExample, Pair(4,6))
        sala.reservaButaca(Pair(0,0))

        sala.reservaButaca(Pair(0,1))
        sala.formalizarReserva(Pair(0,1))

        assertAll(
            { assertFalse(sala.anularReserva(Pair(5,0))) },
            { assertFalse(sala.anularReserva(Pair(0,7))) },

            { assertFalse(sala.anularReserva(Pair(0,2))) },

            { assertTrue(sala.anularReserva(Pair(0,0))) },
            { assertTrue(sala.anularReserva(Pair(0,1))) }
        )
    }

    @Test
    fun balanceSala_Test(){
        // No tengo puesto VIP porque al ser random no puedo predecir el resultado del balance
        val sala = Sala("Example", filmExample, Pair(4,6))
        sala.reservaButaca(Pair(0,0))
        sala.reservaButaca(Pair(1,0))
        sala.reservaButaca(Pair(2,0))

        sala.formalizarReserva(Pair(0,0))
        sala.formalizarReserva(Pair(1,0))

        assertEquals(4f, sala.balanceSala(2f,24f))
        assertEquals((5.35f * 2), sala.balanceSala())
    }

    @Test
    fun countEstados_Test(){
        val freeSala = Sala("Free", filmExample, Pair(2,5))
        val editedSala = Sala("Free", filmExample, Pair(2,5))
        // region Edit
        editedSala.reservaButaca(Pair(0,0))
        editedSala.reservaButaca(Pair(1,0))
        editedSala.reservaButaca(Pair(0,1))
        editedSala.formalizarReserva(Pair(0,0))
        // endregion

        assertAll(
            { assertContentEquals(intArrayOf(10,0,0), freeSala.countEstados()) },
            { assertContentEquals(intArrayOf(7,2,1), editedSala.countEstados()) },
        )

    }
}