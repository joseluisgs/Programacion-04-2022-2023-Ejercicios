package AparcamientoTests;

import FactoriesAparcamiento.FactoryConductor;
import FactoriesAparcamiento.FactoryVehiculo;
import ModelsAparcamiento.Aparcamiento;
import ModelsAparcamiento.Conductor;
import ModelsAparcamiento.Vehiculo;
import ModelsAparcamiento.tipoVehiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class aparcamientoTests {

    private static String RED = "\u001b[31m";
    Aparcamiento aparcamiento = new Aparcamiento();
    Vehiculo vehiculo = FactoryVehiculo.getInstance().create("7493-AAA", 2020, tipoVehiculo.coche, new Conductor("Iván", "53907345M"));

    @BeforeEach
    public void setup(){
        for(int i=0;i<aparcamiento.aparcamientos.length;i++){
            for(int j=0;j<aparcamiento.aparcamientos[i].length;j++){
                aparcamiento.aparcamientos[i][j] = null;
            }
        }
        aparcamiento.aparcamientos[0][0] = vehiculo;
    }

    @Test
    public void opcionValidaAparcamientoTest(){
        String opcion = "1";
        assertTrue(aparcamiento.opcionValida(opcion));
    }

    @Test
    public void opcionNoValidaAparcamientoTest(){
        String opcion1 = "-1";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.opcionValida(opcion1);});
        String actualMessage1 = exception1.getMessage();
        String opcion2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.opcionValida(opcion2);});
        String actualMessage2 = exception2.getMessage();
        String opcion3 = null;
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.opcionValida(opcion3);});
        String actualMessage3 = exception3.getMessage();
        assertEquals(RED+"La opción seleccionada es inválida, vuelva a probar:", actualMessage1);
        assertEquals(RED+"La opción seleccionada no puede estar vacia, vuelva a probar:", actualMessage2);
        assertEquals(RED+"La opción seleccionada no puede ser nula, vuelva a probar:", actualMessage3);

    }

    @Test
    public void dniValidoTest(){
        String dni = "53907934M";
        assertTrue(aparcamiento.dniValido(dni));
    }

    @Test
    public void dniNoValidoTest(){
        String dni1 = "899989898";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.dniValido(dni1);});
        String actualMessage1 = exception1.getMessage();
        String dni2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.dniValido(dni2);});
        String actualMessage2 = exception2.getMessage();
        String dni3 = null;
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.dniValido(dni3);});
        String actualMessage3 = exception3.getMessage();
        assertEquals(RED+"El dni introducido no es válido, vuelve a probar:", actualMessage1);
        assertEquals(RED+"El dni introducido no puede estar vacio, vuelva a probar:", actualMessage2);
        assertEquals(RED+"El dni introducido no puede ser nulo, vuelva a probar:", actualMessage3);

    }

    @Test
    public void nombreValidoTest(){
        String nombre = "Iván";
        assertTrue(aparcamiento.nombreValido(nombre));
    }

    @Test
    public void nombreNoValidoTest(){
        String nombre1 = "899989898";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.nombreValido(nombre1);});
        String actualMessage1 = exception1.getMessage();
        String nombre2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.nombreValido(nombre2);});
        String actualMessage2 = exception2.getMessage();
        String nombre3 = null;
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.nombreValido(nombre3);});
        String actualMessage3 = exception3.getMessage();
        assertEquals(RED+"El nombre introducido no es válido, vuelve a probar:", actualMessage1);
        assertEquals(RED+"El nombre introducido no puede estar vacio, vuelva a probar:", actualMessage2);
        assertEquals(RED+"El nombre introducido no puede ser nulo, vuelva a probar:", actualMessage3);
    }

    @Test
    public void matriculaValidaTest(){
        String matricula = "4657-BFS";
        assertTrue(aparcamiento.matriculaValida(matricula));
    }

    @Test
    public void matriculaNOValidaTest(){
        String matricula1 = "899989898";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.matriculaValida(matricula1);});
        String actualMessage1 = exception1.getMessage();
        String matricula2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.matriculaValida(matricula2);});
        String actualMessage2 = exception2.getMessage();
        String matricula3 = null;
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.matriculaValida(matricula3);});
        String actualMessage3 = exception3.getMessage();
        assertEquals(RED+"La matrícula introducida no es válida, vuelve a probar:", actualMessage1);
        assertEquals(RED+"La matricula introducida no puede estar vacia, vuelva a probar:", actualMessage2);
        assertEquals(RED+"La matricula introducida no puede ser nula, vuelva a probar:", actualMessage3);
    }

    @Test
    public void añoFabricacionValidoTest(){
        String añoFabricacion = "1955";
        assertTrue(aparcamiento.añoFabricacionValido(añoFabricacion));
    }

    @Test
    public void añoFabricacionNOValidoTest(){
        String añoFabricacion1 = "1949";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.añoFabricacionValido(añoFabricacion1);});
        String actualMessage1 = exception1.getMessage();
        String añoFabricacion2 = "2023";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.añoFabricacionValido(añoFabricacion2);});
        String actualMessage2 = exception2.getMessage();
        String añoFabricacion3 = "";
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.añoFabricacionValido(añoFabricacion3);});
        String actualMessage3 = exception3.getMessage();
        String añoFabricacion4 = null;
        Exception exception4 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.añoFabricacionValido(añoFabricacion4);});
        String actualMessage4 = exception4.getMessage();
        assertEquals(RED+"El año de fabricacion no puede ser menor que 1950, ni mayor que 2022, vuelve a probar:", actualMessage1);
        assertEquals(RED+"El año de fabricacion no puede ser menor que 1950, ni mayor que 2022, vuelve a probar:", actualMessage2);
        assertEquals(RED+"El año de fabricacion introducido no puede estar vacio, vuelva a probar:", actualMessage3);
        assertEquals(RED+"El año de fabricacion introducido no puede ser nulo, vuelva a probar:", actualMessage4);
    }

    @Test
    public void tipoValidoTest(){
        String tipo = "coche";
        assertTrue(aparcamiento.tipoValido(tipo));
    }

    @Test
    public void tipoNOValidoTest(){
        String tipo1 = "899989898";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.tipoValido(tipo1);});
        String actualMessage1 = exception1.getMessage();
        String tipo2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.tipoValido(tipo2);});
        String actualMessage2 = exception2.getMessage();
        String tipo3 = null;
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{aparcamiento.tipoValido(tipo3);});
        String actualMessage3 = exception3.getMessage();
        assertEquals(RED+"El tipo introducido no es ni un coche, ni una moto, ni un patinete, por lo que no está permitido en el aparcamiento, vuelve a probar:", actualMessage1);
        assertEquals(RED+"El tipo introducido no puede estar vacio, vuelva a probar:", actualMessage2);
        assertEquals(RED+"El tipo introducido no puede ser nulo, vuelva a probar:", actualMessage3);
    }

    @Test
    public void createConductorTest(){
        Conductor conductor = new Conductor("Iván", "53907934M");
        assertEquals(conductor, FactoryConductor.getInstance().create("Iván", "53907934M"));
    }

    @Test
    public void createVehiculoTest(){
        Conductor conductor = new Conductor("Iván", "53907934M");
        Vehiculo vehiculo = new Vehiculo("5463-TRE", 1970, tipoVehiculo.coche, conductor);
        assertEquals(vehiculo, FactoryVehiculo.getInstance().create("5463-TRE", 1970, tipoVehiculo.coche, FactoryConductor.getInstance().create("Iván", "53907934M")));
    }

    @Test
    public void aparcarVehiculoTest(){
        Vehiculo vehiculo = FactoryVehiculo.getInstance().createRandom();
        aparcamiento.aparcar(vehiculo, "0-1");
        assertEquals(vehiculo, aparcamiento.aparcamientos[0][1]);
    }

    @Test
    public void eliminarVehiculoTest(){
        aparcamiento.eliminarCocheDeAparcamiento("0-0");
        assertEquals(null, aparcamiento.aparcamientos[0][0]);
    }

    @Test
    public void dondeAparcarTest(){
        assertEquals("0-1", aparcamiento.buscarPrimeraPosicionLibre());
    }

    @Test
    public void cuantosVehiculosHayAparcadosTest(){
        assertEquals(1, aparcamiento.cuantosVehiculosHayAparcados());
    }

    @Test
    public void buscarVehiculoPorMatriculaTest(){
        assertEquals("0-0", aparcamiento.buscarVehiculoSegunMatricula("7493-AAA"));
    }

    @Test
    public void cuantosVehiculosTieneUnConductroAparcadosTest(){
        assertEquals(1, aparcamiento.contarVehiculosAparcadosDeConductor("53907345M"));
    }

    @Test
    public void calcularRecaudacionTest(){
        aparcamiento.contadorVehiculosAparcados = 1;
        assertEquals(3.75, aparcamiento.calcularRecaudacion());
    }

    @Test
    public void matrizNoVaciaTest(){
        assertTrue(aparcamiento.matrizNoEstaVacia());
        aparcamiento.aparcamientos[0][0] = null;
        assertFalse(aparcamiento.matrizNoEstaVacia());
    }

    @Test
    public void pasarMatrizAVectorTest(){
        Vehiculo[] vector = {aparcamiento.aparcamientos[0][0]};
        assertArrayEquals(vector, aparcamiento.pasarMatrizAVector(1));
    }

    @Test
    public void ordenarMetodoBurbujaDescendenteTest(){
        Vehiculo vehiculo = FactoryVehiculo.getInstance().create("7493-AAA", 2022, tipoVehiculo.coche, new Conductor("Iván", "53907345M"));
        Vehiculo[] vector = {aparcamiento.aparcamientos[0][0],vehiculo};
        aparcamiento.ordenarMetodoBurbujaDescendente(vector);
        assertEquals(aparcamiento.aparcamientos[0][0], vector[1]);
        assertEquals(vehiculo, vector[0]);
    }
}