package models

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach


internal class SalaTest {

    private val row = 15
    private val column = 15

    val testMatrix = Array(row) { Array<Butaca?>(column) { null } }

    @BeforeEach
    internal fun setUp() {
        for (i in testMatrix.indices) {
            for (j in testMatrix[i].indices) {
                testMatrix[i][j] = FREE_SEAT
            }
        }
    }


    @Test
    fun changeSeatStatusToOccupiedTest() {
        // Pongo la casilla B:1 en libre y la cambio a ocupada con la función para testear su funcionamiento.
        testMatrix[1][0] = FREE_SEAT
        assertEquals(SOLD_SEAT, Sala("").changeSeatStatusToOccupied(testMatrix, "1", 1))

    }


    @Test
    fun changeSeatStatusToFreeTest() {
//ESTO NO FUNCIONA
        testMatrix[1][0] = SOLD_SEAT
        assertEquals(FREE_SEAT, Sala("").changeSeatStatusToFree(testMatrix, "1", 1))
    }

    @Test
    fun isSeatReservedTest() {

        // Pongo el asiento B:1 como reservado y testeo la función.
        testMatrix[1][0] = RESERVED_SEAT

        assertAll(
            { assertEquals(true, Sala("").isSeatReserved("B:1", testMatrix)) },
            { assertEquals(false, Sala("").isSeatReserved("B:2", testMatrix)) }
        )
    }



    @Test
    fun changeSeatStatusToReservedTest() {

        testMatrix[1][0] = FREE_SEAT
        assertEquals(RESERVED_SEAT, Sala("").changeSeatStatusToReserved(testMatrix, "1", 1))
    }

    @Test
    fun doesRowExistTest() {
        assertAll(
            { assertEquals(true, Sala("").doesRowExist("A:1", row)) },
            { assertEquals(false, Sala("").doesRowExist("Z:26", row)) },
            { assertEquals(true, Sala("").doesRowExist("O:15", row)) },
            { assertEquals(false, Sala("").doesRowExist("V:16", row)) },
            { assertEquals(true, Sala("").doesRowExist("a:1", row)) }
        )
    }

    @Test
    fun doesColumnExistTest() {
        assertAll(
            { assertEquals(true, Sala("").doesColumnExist("A:1", column)) },
            { assertEquals(false, Sala("").doesColumnExist("A:26", column)) },
            { assertEquals(true, Sala("").doesColumnExist("A:15", column)) },
            { assertEquals(false, Sala("").doesColumnExist("A:16", column)) },
            { assertEquals(true, Sala("").doesColumnExist("a:1", column)) }
        )
    }

    @Test
    fun rowLetterToNumberTest() {
        val entradaValida1 = "A"
        val entradaValida2 = "B"
        val entradaValida3 = "C"
        val entradaValida4 = "D"
        val entradaValida5 = "E"
        val entradaValida6 = "F"
        val entradaValida7 = "G"
        val entradaValida8 = "H"
        val entradaValida9 = "I"
        val entradaValida10 = "J"
        val entradaValida11 = "K"
        val entradaValida12 = "L"
        val entradaValida13 = "M"
        val entradaValida14 = "N"
        val entradaValida15 = "O"
        val entradaValida16 = "P"
        val entradaValida17 = "Q"
        val entradaValida18 = "R"
        val entradaValida19 = "S"
        val entradaValida20 = "T"
        val entradaValida21 = "U"
        val entradaValida22 = "V"
        val entradaValida23 = "W"
        val entradaValida24 = "X"
        val entradaValida25 = "Y"
        val entradaValida26 = "Z"

        assertAll(
            { assertEquals(0, Sala("").rowLetterToNumber(entradaValida1)) },
            { assertEquals(1, Sala("").rowLetterToNumber(entradaValida2)) },
            { assertEquals(2, Sala("").rowLetterToNumber(entradaValida3)) },
            { assertEquals(3, Sala("").rowLetterToNumber(entradaValida4)) },
            { assertEquals(4, Sala("").rowLetterToNumber(entradaValida5)) },
            { assertEquals(5, Sala("").rowLetterToNumber(entradaValida6)) },
            { assertEquals(6, Sala("").rowLetterToNumber(entradaValida7)) },
            { assertEquals(7, Sala("").rowLetterToNumber(entradaValida8)) },
            { assertEquals(8, Sala("").rowLetterToNumber(entradaValida9)) },
            { assertEquals(9, Sala("").rowLetterToNumber(entradaValida10)) },
            { assertEquals(10, Sala("").rowLetterToNumber(entradaValida11)) },
            { assertEquals(11, Sala("").rowLetterToNumber(entradaValida12)) },
            { assertEquals(12, Sala("").rowLetterToNumber(entradaValida13)) },
            { assertEquals(13, Sala("").rowLetterToNumber(entradaValida14)) },
            { assertEquals(14, Sala("").rowLetterToNumber(entradaValida15)) },
            { assertEquals(15, Sala("").rowLetterToNumber(entradaValida16)) },
            { assertEquals(16, Sala("").rowLetterToNumber(entradaValida17)) },
            { assertEquals(17, Sala("").rowLetterToNumber(entradaValida18)) },
            { assertEquals(18, Sala("").rowLetterToNumber(entradaValida19)) },
            { assertEquals(19, Sala("").rowLetterToNumber(entradaValida20)) },
            { assertEquals(20, Sala("").rowLetterToNumber(entradaValida21)) },
            { assertEquals(21, Sala("").rowLetterToNumber(entradaValida22)) },
            { assertEquals(22, Sala("").rowLetterToNumber(entradaValida23)) },
            { assertEquals(23, Sala("").rowLetterToNumber(entradaValida24)) },
            { assertEquals(24, Sala("").rowLetterToNumber(entradaValida25)) },
            { assertEquals(25, Sala("").rowLetterToNumber(entradaValida26)) }


        )
    }
}