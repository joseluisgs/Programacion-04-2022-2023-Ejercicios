package BandaMusicosTests;

import modelsBandaMusicos.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class bandaMusicosTests {

    static Banda b = new Banda(8);

    @BeforeAll
    public static void setUp(){
        b.inicializarArray();
        b.arrayMusicos[0] = new Trompetista("Iván", 24, 10);
        b.arrayMusicos[1] = new Cantante("Iván", 24, "suave");
        b.arrayMusicos[2] = new Guitarrista("Iván", 24, tipoGuitarra.ACUSTICA);
        b.arrayMusicos[3] = new Bajista("Iván", 24, 10);
        b.arrayMusicos[4] = new Teclista("Iván", 24, 10);
        b.arrayMusicos[5] = new Percusionista("Iván", 24, tipoPercusion.TAMBOR);
        b.arrayMusicos[6] = new CantanteGuitarrista("Iván", 24, "suave", tipoGuitarra.ACUSTICA);
        b.arrayMusicos[7] = new Multinstrumental("Iván", 24, 10, 12, tipoPercusion.TAMBOR);
    }

    @Test
    public void cuantosTrompetistasHayTest(){
        assertEquals(1, b.contarTrompetistas());
    }

    @Test
    public void cuantosCantantesHayTest(){
        assertEquals(1, b.contarCantantes());
    }

    @Test
    public void cuantosGuitarristasHayTest(){
        assertEquals(1, b.contarGuitarristas());
    }

    @Test
    public void cuantosBajistasHayTest(){
        assertEquals(1, b.contarBajistas());
    }

    @Test
    public void cuantosTeclistasHayTest(){
        assertEquals(1, b.contarTeclistas());
    }

    @Test
    public void cuantosPercusionistasHayTest(){
        assertEquals(1, b.contarPercusionistas());
    }

    @Test
    public void cuantosCantantesGuitarristasHayTest(){
        assertEquals(1, b.contarCantantesGuitarristas());
    }

    @Test
    public void cuantosMultinstrumentalesHayTest(){
        assertEquals(1, b.contarMultinstrumentales());
    }

    @Test
    public void hallarSalarioTotalTest(){
        assertEquals(16650.0, b.hallarSalarioTotal());
    }

    @Test
    public void recalcularSalariosTest(){

        Double r1 = null;
        if(b.arrayMusicos[0] instanceof Trompetista){
            r1 = ((Trompetista) b.arrayMusicos[0]).recalcularSalario(1500.0);
        }

        Double r2 = null;
        if(b.arrayMusicos[1] instanceof Cantante){
            r2 = ((Cantante) b.arrayMusicos[1]).recalcularSalario(1500.0);
        }

        Double r3 = null;
        if(b.arrayMusicos[2] instanceof Guitarrista){
            r3 = ((Guitarrista) b.arrayMusicos[2]).recalcularSalario(1500.0);
        }

        Double r4 = null;
        if(b.arrayMusicos[3] instanceof Bajista){
            r4 = ((Bajista) b.arrayMusicos[3]).recalcularSalario(1500.0);
        }

        Double r5 = null;
        if(b.arrayMusicos[4] instanceof Teclista){
            r5 = ((Teclista) b.arrayMusicos[4]).recalcularSalario(1500.0);
        }

        Double r6 = null;
        if(b.arrayMusicos[5] instanceof Percusionista){
            r6 = ((Percusionista) b.arrayMusicos[5]).recalcularSalario(1500.0);
        }

        Double r7 = null;
        if(b.arrayMusicos[6] instanceof CantanteGuitarrista){
            r7 = ((CantanteGuitarrista) b.arrayMusicos[6]).recalcularSalario(1500.0);
        }

        Double r8 = null;
        if(b.arrayMusicos[7] instanceof Multinstrumental){
            r8 = ((Multinstrumental) b.arrayMusicos[7]).recalcularSalario(1500.0);
        }

        assertEquals(1800.0, r1);
        assertEquals(2100.0, r2);
        assertEquals(2025.0000000000002, r3);
        assertEquals(2250.0, r4);
        assertEquals(1950.0, r5);
        assertEquals(2025.0000000000002, r6);
        assertEquals(2250.0, r7);
        assertEquals(2250.0, r8);
    }
}
