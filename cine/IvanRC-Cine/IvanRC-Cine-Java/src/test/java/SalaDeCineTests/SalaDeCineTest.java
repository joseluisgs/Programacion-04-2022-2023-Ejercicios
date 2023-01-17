package SalaDeCineTests;

import FactorySalaDeCine.FactoryButaca;
import FactorySalaDeCine.FactoryPelicula;
import FactorySalaDeCine.FactorySala;
import ModelsSalaDeCine.butaca;
import ModelsSalaDeCine.pelicula;
import ModelsSalaDeCine.salaDeCine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ModelsSalaDeCine.simuladorSalaDeCine.*;
import static org.junit.jupiter.api.Assertions.*;

public class SalaDeCineTest {

    private static String RED = "\u001b[31m";

    ModelsSalaDeCine.salaDeCine salaDeCine = new salaDeCine("s",5,5, FactoryPelicula.getInstance().create("s", 1960, "s", "s"));

    @BeforeEach
    public void setup(){
        salaDeCine.inicializadorSalaDeCine();
        for(int i=0;i<salaDeCine.butacas.length;i++){
            for(int j=0;j<salaDeCine.butacas[i].length;j++){
                salaDeCine.butacas[i][j].estado = "libre";
            }
        }
    }

    @Test
    public void crearPeliculaTest(){
        pelicula nuevaPelicula = FactoryPelicula.getInstance().create("s", 1960, "s", "s");
        assertEquals(new pelicula("s",1960,"s","s"), nuevaPelicula);
    }

    @Test
    public void tituloValidoTest(){
        String titulo = "Los tres Mosqueteros";
        assertTrue(tituloValido(titulo));
    }

    @Test
    public void tituloNoValidoTest(){
        String titulo1 = null;
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{tituloValido(titulo1);});
        String mensaje1 = exception1.getMessage();
        String titulo2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{tituloValido(titulo2);});
        String mensaje2 = exception2.getMessage();
        assertEquals(RED+"El título no puede ser nulo, vuelve a probar:", mensaje1);
        assertEquals(RED+"El título de la peli no puede estar vacio, vuelve a probar:", mensaje2);

    }

    @Test
    public void añoPublicacionValidoTest(){
        String añoPublicacion = "2022";
        assertTrue(añoPublicacionValido(añoPublicacion));
    }

    @Test
    public void añoPublicacionNoValidoTest(){
        String añoPublicacion1 = "-1";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{añoPublicacionValido(añoPublicacion1);});
        String mensaje1 = exception1.getMessage();
        String añoPublicacion2 = "1949";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{añoPublicacionValido(añoPublicacion2);});
        String mensaje2 = exception2.getMessage();
        String añoPublicacion3 = "2023";
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{añoPublicacionValido(añoPublicacion3);});
        String mensaje3 = exception3.getMessage();
        assertEquals(RED+"El año de publicación no puede ser negativo, vuelve a probar:" , mensaje1);
        assertEquals(RED+"El año de publicación de la peli debe ser entre 1950 y 2022, vuelve a probar:", mensaje2);
        assertEquals(RED+"El año de publicación de la peli debe ser entre 1950 y 2022, vuelve a probar:", mensaje3);

    }

    @Test
    public void directorValidoTest(){
        String director = "Jorge";
        assertTrue(directorValido(director));
    }

    @Test
    public void directorNoValidoTest(){
        String director1 = null;
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{directorValido(director1);});
        String mensaje1 = exception1.getMessage();
        String director2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{directorValido(director2);});
        String mensaje2 = exception2.getMessage();
        assertEquals(RED+"El director no puede ser nulo, vuelve a probar:", mensaje1);
        assertEquals(RED+"El director de la peli no puede estar vacio, vuelve a probar:", mensaje2);
    }

    @Test
    public void generoValidoTest(){
        String genero = "Ciencia Ficción";
        assertTrue(generoValido(genero));
    }

    @Test
    public void generoNoValidoTest(){
        String genero1 = null;
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{generoValido(genero1);});
        String mensaje1 = exception1.getMessage();
        String genero2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{generoValido(genero2);});
        String mensaje2 = exception2.getMessage();
        assertEquals(RED+"El género no puede ser nulo, vuelve a probar:", mensaje1);
        assertEquals(RED+"El género de la peli no puede estar vacio, vuelve a probar:", mensaje2);
    }

    @Test
    public void crearButacaTest(){
        butaca nuevaButacaConMetodoCreate = FactoryButaca.getInstance().create("A1","libre");
        nuevaButacaConMetodoCreate.esVip = true;
        butaca nuevaButaca = new butaca("A1","libre");
        nuevaButaca.esVip = true;
        assertEquals(nuevaButaca, nuevaButacaConMetodoCreate);
    }

    @Test
    public void crearSalaDeCineTest(){
        salaDeCine nuevaSalaDeCine = FactorySala.getInstance().create("s", 5, 5, FactoryPelicula.getInstance().create("s", 1960, "s", "s"));
        assertEquals(new salaDeCine("s",5,5, FactoryPelicula.getInstance().create("s", 1960, "s", "s")), nuevaSalaDeCine);
    }

    @Test
    public void filaColumnaValidaTest(){
        String filaColumna = "8";
        assertTrue(filaColumnaValida(filaColumna));
    }

    @Test
    public void filaColumnaNoValidaTest(){
        String filaColumna1 = "0";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{filaColumnaValida(filaColumna1);});
        String mensaje1 = exception1.getMessage();
        String filaColumna2 = "27";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{filaColumnaValida(filaColumna2);});
        String mensaje2 = exception2.getMessage();
        assertEquals(RED+"La fila/columna no puede ser menor que 1, vuelve a probar:" , mensaje1);
        assertEquals(RED+"La fila/columna sobrepasar el tamaño 26, vuelve a probar:", mensaje2);
    }

    @Test
    public void nombreValidoTest(){
        String nombre = "Ciencia Ficción";
        assertTrue(nombreValido(nombre));
    }

    @Test
    public void nombreNoValidoTest(){
        String nombre1 = null;
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{nombreValido(nombre1);});
        String mensaje1 = exception1.getMessage();
        String nombre2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{nombreValido(nombre2);});
        String mensaje2 = exception2.getMessage();
        assertEquals(RED+"El nombre no puede ser nulo, vuelve a probar:", mensaje1);
        assertEquals(RED+"El nombre no puede estar vacio, vuelve a probar:", mensaje2);
    }

    @Test
    public void butacaValidaTest(){
        String butaca1 = "A1";
        String butaca2 = "stop";
        assertTrue(salaDeCine.butacaValida(butaca1));
        assertTrue(salaDeCine.butacaValida(butaca2));
    }

    @Test
    public void butacaNoValidaTest(){
        String butaca1 = null;
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{salaDeCine.butacaValida(butaca1);});
        String mensaje1 = exception1.getMessage();
        String butaca2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{salaDeCine.butacaValida(butaca2);});
        String mensaje2 = exception2.getMessage();
        String butaca3 = "5B";
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{salaDeCine.butacaValida(butaca3);});
        String mensaje3 = exception3.getMessage();
        assertEquals(RED+"El mensaje no puede ser nulo, vuelve a probar:", mensaje1);
        assertEquals(RED+"El mensaje no puede estar vacio, vuelve a probar:", mensaje2);
        assertEquals(RED+"El mensaje introducido no es válido, vuelve a probar:", mensaje3);
    }

    @Test
    public void opcionValidaTest(){
        String opcion = "4";
        assertTrue(opcionValida(opcion));
    }

    @Test
    public void opcionNoValidaTest(){
        String opcion1 = "-1";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{opcionValida(opcion1);});
        String mensaje1 = exception1.getMessage();
        String opcion2 = "7";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{opcionValida(opcion2);});
        String mensaje2 = exception2.getMessage();
        assertEquals(RED+"La opción introducida no es válida, vuelve a probar:" , mensaje1);
        assertEquals(RED+"No has elegido una de las opciones posibles, vuelve a probar:", mensaje2);
    }

    @Test
    public void opcionIntroducirDatosValidaTest(){
        String opcion = "2";
        assertTrue(opcionDeIntroducirDatosValida(opcion));
    }

    @Test
    public void opcionIntroducirDatosNoValidaTest(){
        String opcion1 = "0";
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{opcionDeIntroducirDatosValida(opcion1);});
        String mensaje1 = exception1.getMessage();
        String opcion2 = "3";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{opcionDeIntroducirDatosValida(opcion2);});
        String mensaje2 = exception2.getMessage();
        String opcion3 = "";
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{opcionDeIntroducirDatosValida(opcion3);});
        String mensaje3 = exception3.getMessage();
        String opcion4 = null;
        Exception exception4 = assertThrows(IllegalArgumentException.class, ()->{opcionDeIntroducirDatosValida(opcion4);});
        String mensaje4 = exception4.getMessage();
        String opcion5 = "hola";
        Exception exception5 = assertThrows(IllegalArgumentException.class, ()->{opcionDeIntroducirDatosValida(opcion5);});
        String mensaje5 = exception5.getMessage();
        assertEquals(RED+"No has elegido una de las opciones posibles, vuelve a probar:" , mensaje1);
        assertEquals(RED+"No has elegido una de las opciones posibles, vuelve a probar:", mensaje2);
        assertEquals(RED+"La opción introducida no puede estar vacía, vuelve a probar:" , mensaje3);
        assertEquals(RED+"La opción introducida no puede ser nula, vuelve a probar:", mensaje4);
        assertEquals(RED+"La opción introducida no es válida, vuelve a probar:", mensaje5);
    }

    @Test
    public void hallarIdentificadorButacaTest(){
        int fila = 1;
        int columna = 1;
        String identificadorButaca = "B2";
        assertEquals(identificadorButaca, salaDeCine.hallarIdentificadorButaca(fila, columna));
    }

    @Test
    public void comprarEntradaTest(){
        String posicion = "0-0";
        assertEquals("comprado", salaDeCine.comprar(posicion).estado);
    }

    @Test
    public void reservarEntradaTest(){
        String posicion = "0-0";
        assertEquals("reservado", salaDeCine.reservar(posicion).estado);
    }

    @Test
    public void anularEntradaTest(){
        String posicion = "0-0";
        assertEquals("libre", salaDeCine.anular(posicion).estado);
    }

    @Test
    public void informeDeLaSalaDeCineTest(){
        String mensaje = salaDeCine.informeDeLaSalaDeCine();
        assertEquals(mensaje, salaDeCine.informeDeLaSalaDeCine());
    }

    @Test
    public void calcularDineroEnCajaTest(){
        salaDeCine.butacas[0][0].estado = "comprado";
        salaDeCine.butacas[0][0].esVip = false;
        salaDeCine.butacas[0][1].estado = "comprado";
        salaDeCine.butacas[0][1].esVip = true;
        double dinero = 13.75;
        assertEquals(dinero, salaDeCine.calcularDineroEnCaja());
    }

    @Test
    public void contarNumeroDeButacasPorTipoTest(){
        salaDeCine.butacas[0][0].estado = "comprado";
        salaDeCine.butacas[0][1].estado = "comprado";
        salaDeCine.butacas[0][2].estado = "comprado";
        salaDeCine.butacas[0][3].estado = "comprado";
        salaDeCine.butacas[0][4].estado = "comprado";
        salaDeCine.butacas[1][0].estado = "reservado";
        salaDeCine.butacas[1][1].estado = "reservado";
        salaDeCine.butacas[1][2].estado = "reservado";
        salaDeCine.butacas[1][3].estado = "reservado";
        salaDeCine.butacas[1][4].estado = "reservado";
        String numeroTipoButacas = "15-5-5";
        assertEquals(numeroTipoButacas, salaDeCine.contarNumeroDeButacasPorTipo());
    }

    @Test
    public void representarButacasTest(){
        String mensaje = salaDeCine.representarButacas();
        assertEquals(mensaje, salaDeCine.representarButacas());
    }

    @Test
    public void buscarButacaPorIdentificadorTest(){
        String identificador1 = "A1";
        String posicion1 = "0-0";
        String identificador2 = "Z27";
        String posicion2 = "-1-1";
        assertEquals(posicion1, salaDeCine.buscarButacaPorIndentificador(identificador1));
        assertEquals(posicion2, salaDeCine.buscarButacaPorIndentificador(identificador2));
    }
}
