package models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static models.Butaca.*;
import static org.junit.jupiter.api.Assertions.*;


class SalaTest {
    private final int row = 15;
    private final int column = 15;

    Butaca[][] testMatrix = new Butaca[row][column];

    @BeforeEach
    void setUp() {
        for (int i = 0; i <= testMatrix.length - 1; i++) {
            for (int j = 0; j <= testMatrix[i].length - 1; j++) {
                testMatrix[i][j] = FREE_SEAT;
            }
        }
    }

    @Test
    void changeSeatStatusToOccupiedTest() {

        testMatrix[1][0] = FREE_SEAT;
        assertEquals(SOLD_SEAT, Sala.changeSeatStatusToOccupied(testMatrix, "1", 1));
    }

    @Test
    void changeSeatStatusToFreeTest() {
        testMatrix[1][0] = SOLD_SEAT;
        assertEquals(FREE_SEAT, Sala.changeSeatStatusToFree(testMatrix, "1", 1));
    }
    @Test
    void isSeatReservedTest() {

        // Pongo el asiento B:1 como reservado y testeo la función.
        testMatrix[1][0] = RESERVED_SEAT;
        assertTrue(Sala.isSeatReserved("B:1", testMatrix));
        assertFalse(Sala.isSeatReserved("B:2", testMatrix));
    }

    @Test
    void changeSeatStatusToReservedTest() {
        testMatrix[1][0] = FREE_SEAT;
        assertEquals(RESERVED_SEAT, Sala.changeSeatStatusToReserved(testMatrix, "1", 1));
    }

    @Test
    void rowLetterToNumberTest() {
        String entradaValida1 = "A";
        String entradaValida2 = "B";
        String entradaValida3 = "C";
        String entradaValida4 = "D";
        String entradaValida5 = "E";
        String entradaValida6 = "F";
        String entradaValida7 = "G";
        String entradaValida8 = "H";
        String entradaValida9 = "I";
        String entradaValida10 = "J";
        String entradaValida11 = "K";
        String entradaValida12 = "L";
        String entradaValida13 = "M";
        String entradaValida14 = "N";
        String entradaValida15 = "O";
        String entradaValida16 = "P";
        String entradaValida17 = "Q";
        String entradaValida18 = "R";
        String entradaValida19 = "S";
        String entradaValida20 = "T";
        String entradaValida21 = "U";
        String entradaValida22 = "V";
        String entradaValida23 = "W";
        String entradaValida24 = "X";
        String entradaValida25 = "Y";
        String entradaValida26 = "Z";


        assertEquals(0, Sala.rowLetterToNumber(entradaValida1));
        assertEquals(1, Sala.rowLetterToNumber(entradaValida2));
        assertEquals(2, Sala.rowLetterToNumber(entradaValida3));
        assertEquals(3, Sala.rowLetterToNumber(entradaValida4));
        assertEquals(4, Sala.rowLetterToNumber(entradaValida5));
        assertEquals(5, Sala.rowLetterToNumber(entradaValida6));
        assertEquals(6, Sala.rowLetterToNumber(entradaValida7));
        assertEquals(7, Sala.rowLetterToNumber(entradaValida8));
        assertEquals(8, Sala.rowLetterToNumber(entradaValida9));
        assertEquals(9, Sala.rowLetterToNumber(entradaValida10));
        assertEquals(10, Sala.rowLetterToNumber(entradaValida11));
        assertEquals(11, Sala.rowLetterToNumber(entradaValida12));
        assertEquals(12, Sala.rowLetterToNumber(entradaValida13));
        assertEquals(13, Sala.rowLetterToNumber(entradaValida14));
        assertEquals(14, Sala.rowLetterToNumber(entradaValida15));
        assertEquals(15, Sala.rowLetterToNumber(entradaValida16));
        assertEquals(16, Sala.rowLetterToNumber(entradaValida17));
        assertEquals(17, Sala.rowLetterToNumber(entradaValida18));
        assertEquals(18, Sala.rowLetterToNumber(entradaValida19));
        assertEquals(19, Sala.rowLetterToNumber(entradaValida20));
        assertEquals(20, Sala.rowLetterToNumber(entradaValida21));
        assertEquals(21, Sala.rowLetterToNumber(entradaValida22));
        assertEquals(22, Sala.rowLetterToNumber(entradaValida23));
        assertEquals(23, Sala.rowLetterToNumber(entradaValida24));
        assertEquals(24, Sala.rowLetterToNumber(entradaValida25));
        assertEquals(25, Sala.rowLetterToNumber(entradaValida26));

    }


    @Test
    void doesRowExistTest() {
        assertTrue(Sala.doesRowExist("A:1", row));
        assertFalse(Sala.doesRowExist("Z:26", row));
        assertTrue(Sala.doesRowExist("O:15", row));
        assertFalse(Sala.doesRowExist("V:16", row));
        assertTrue(Sala.doesRowExist("a:1", row));

    }

    @Test
    void doesColumnExistTest() {
        assertTrue(Sala.doesColumnExist("A:1", column));
        assertFalse(Sala.doesColumnExist("A:26", column));
        assertTrue(Sala.doesColumnExist("A:15", column));
        assertFalse(Sala.doesColumnExist("A:16", column));
        assertTrue(Sala.doesColumnExist("a:1", column));
        
        
    }
}