import javafx.util.Pair;
import org.example.models.Film;
import org.example.models.Sala;
import org.junit.Test;
import org.example.enums.*;

import static org.example.SalaCineEditor.stringToAlphabetNumber;
import static org.junit.jupiter.api.Assertions.*;

public class SalaCineTest {
    // region Others
    @Test
    public void charStringToNumber_Test(){
         assertEquals(0, stringToAlphabetNumber("A"));
         assertEquals(13, stringToAlphabetNumber("N"));
         assertEquals(14, stringToAlphabetNumber("Ñ"));
         assertEquals(26, stringToAlphabetNumber("Z"));
         assertEquals(27, stringToAlphabetNumber("AA"));
         assertEquals(41, stringToAlphabetNumber("AÑ"));
         assertEquals(54, stringToAlphabetNumber("BA"));
    }

    @Test
    public void alphabetNumberToString_Test(){
        Sala sala = new Sala("pepe", new Film("pepe", 2020, "pepe", FilmGenero.ACTION), new Pair<>(60,60), 40);

        assertEquals("A", sala.alphabetNumberToString(0));
        assertEquals("N", sala.alphabetNumberToString(13));
        assertEquals("Ñ", sala.alphabetNumberToString(14));
        assertEquals("Z", sala.alphabetNumberToString(26));
        assertEquals("AA", sala.alphabetNumberToString(27));
        assertEquals("AÑ", sala.alphabetNumberToString(41));
        assertEquals("BA", sala.alphabetNumberToString(54));
    }
    //endregion

    Film filmExample = new Film("Titulo", 2022, "Pedro", FilmGenero.AVENTURAS);

    @Test
    public void getSize_Test(){
        Sala smallSala = new Sala("Small", filmExample, new Pair<>(2,5));
        Sala largeSala = new Sala("Small", filmExample, new Pair<>(6,24));

        assertEquals(new Pair<>(2,5), smallSala.getSize());
        assertEquals(new Pair<>(6,24), largeSala.getSize());
    }

    @Test
    public void reservaButaca_Test(){
        Sala sala = new Sala("ToEdit", filmExample, new Pair<>(4,6));
        sala.reservaButaca(new Pair<>(0,3));

        assertFalse(sala.reservaButaca(new Pair<>(5,0)));
        assertFalse(sala.reservaButaca(new Pair<>(0,7)));
        assertFalse(sala.reservaButaca(new Pair<>(0,3)));
        assertTrue(sala.reservaButaca(new Pair<>(0,0)));
    }

    @Test
    public void formalizarReserva_Test(){
        Sala sala = new Sala("ToEdit", filmExample, new Pair<>(4,6));
        sala.reservaButaca(new Pair<>(0,0));

        assertFalse(sala.formalizarReserva(new Pair<>(5,0)));
        assertFalse(sala.formalizarReserva(new Pair<>(0,7)));
        assertFalse(sala.formalizarReserva(new Pair<>(0,1)));
        assertTrue(sala.formalizarReserva(new Pair<>(0,0)));
    }

    @Test
    public void anularReserva_Test(){
        Sala sala = new Sala("ToEdit", filmExample, new Pair<>(4,6));
        sala.reservaButaca(new Pair<>(0,0));

        sala.reservaButaca(new Pair<>(0,1));
        sala.formalizarReserva(new Pair<>(0,1));

        assertFalse(sala.anularReserva(new Pair<>(5,0)));
        assertFalse(sala.anularReserva(new Pair<>(0,7)));

        assertFalse(sala.anularReserva(new Pair<>(0,2)));

        assertTrue(sala.anularReserva(new Pair<>(0,0)));
        assertTrue(sala.anularReserva(new Pair<>(0,1)));
    }

    @Test
    public void balanceSala_Test(){
        // No tengo pongo VIP porque al ser random no puedo predecir el resultado del balance
        Sala sala = new Sala("Example", filmExample, new Pair<>(4,6));
        sala.reservaButaca(new Pair<>(0,0));
        sala.reservaButaca(new Pair<>(1,0));
        sala.reservaButaca(new Pair<>(2,0));

        sala.formalizarReserva(new Pair<>(0,0));
        sala.formalizarReserva(new Pair<>(1,0));

        assertEquals(4f, sala.getBalance(2f,24f));
        assertEquals((5.35f * 2), sala.getBalance());
    }

    @Test
    public void countEstados_Test(){
        Sala freeSala = new Sala("Free", filmExample, new Pair<>(2,5));
        Sala editedSala = new Sala("Free", filmExample, new Pair<>(2,5));

        // region Edit
        editedSala.reservaButaca(new Pair<>(0,0));
        editedSala.reservaButaca(new Pair<>(1,0));
        editedSala.reservaButaca(new Pair<>(0,1));
        editedSala.formalizarReserva(new Pair<>(0,0));
        // endregion

        /*int[] tests = {10,0,0};
        assertContentEquals(tests, freeSala.countEstados());
        assertContentEquals(intArrayOf(7,2,1), editedSala.countEstados());*/
    }
}