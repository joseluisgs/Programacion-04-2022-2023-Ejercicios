package CestaTests;

import FactoriesCesta.FactoryCesta;
import FactoriesCesta.FactoryProducto;
import ModelsCesta.Cesta;
import ModelsCesta.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ModelsCesta.simulacionCesta.opcionValida;
import static org.junit.jupiter.api.Assertions.*;

public class cestaTests {

    private static String RED = "\u001b[31m";

    Cesta cesta = FactoryCesta.getInstance().crearCestaRandom();

    @BeforeEach
    public void setUp(){
        //Con el objetivo de poder testear las funciones de eliminar, actualizar, defragmentar, ..., coloco un producto en la posición 20 del array
        Producto nuevoProducto = FactoryProducto.getInstance().crearProductoRandom();
        cesta.getListaCesta().añadirProductos(19, nuevoProducto);
    }

    @Test
    public void opcionValidaTest(){
        String opcion1 = "0";
        String opcion2 = "5";
        assertTrue(opcionValida(opcion1));
        assertTrue(opcionValida(opcion2));
    }

    @Test
    public void opcionNoValidaTest(){
        String opcion1 = null;
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{opcionValida(opcion1);});
        String opcion2 = "-1";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{opcionValida(opcion2);});
        String opcion3 = "6";
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{opcionValida(opcion3);});
        String opcion4 = "hola";
        Exception exception4 = assertThrows(IllegalArgumentException.class, ()->{opcionValida(opcion4);});
        assertEquals(RED+"La opción no puede ser nula, vuelve a probar:", exception1.getMessage());
        assertEquals(RED+"La opción introducida no es válida, vuelve a probar:", exception2.getMessage());
        assertEquals(RED+"No has elegido una de las opciones posibles, vuelve a probar:", exception3.getMessage());
        assertEquals(RED+"La opción introducida no es válida, vuelve a probar:", exception4.getMessage());
    }

    @Test
    public void añadirProductosTest(){
        Producto nuevoProducto = FactoryProducto.getInstance().crearProductoRandom();
        String cantidadYPrecioUnitario = "1-"+nuevoProducto.getPrecioUitario();
        cesta.getListaCesta().añadirProductos(0, nuevoProducto);
        assertEquals(nuevoProducto, cesta.getListaCesta().listaProductos[0]);
        assertEquals(cantidadYPrecioUnitario, cesta.getListaCesta().cantidadPrecioDelProducto[0]);
    }

    @Test
    public void eliminarProductosTest(){
        String cantidadYPrecioUnitario = "";
        cesta.getListaCesta().eliminarProducto(19);
        assertEquals(null, cesta.getListaCesta().listaProductos[19]);
        assertEquals(cantidadYPrecioUnitario, cesta.getListaCesta().cantidadPrecioDelProducto[19]);
    }

    @Test
    public void actualizarCantidadProductoTest(){
        int cantidadAAñadir = 4;
        assertEquals(5, cesta.getListaCesta().actualizarCantidadProducto(19, cantidadAAñadir));
        int cantidadARestar = -2;
        assertEquals(3, cesta.getListaCesta().actualizarCantidadProducto(19, cantidadARestar));
    }

    @Test
    public void eliminarProductoSiCantidad0Test(){
        String cantidadYPrecioUnitario = "";
        int cantidadARestar = -10;
        cesta.getListaCesta().actualizarCantidadProducto(19, cantidadARestar);
        cesta.getListaCesta().eliminarProductoSiCantidad0();
        assertEquals(null, cesta.getListaCesta().listaProductos[19]);
        assertEquals(cantidadYPrecioUnitario, cesta.getListaCesta().cantidadPrecioDelProducto[19]);
    }

    @Test
    public void calcularTotalDineroDeCestaTest(){
        cesta.getListaCesta().eliminarProducto(19);
        Producto nuevoProducto1 = FactoryProducto.getInstance().crearProductoRandom();
        nuevoProducto1.setPrecioUitario(5.0);
        cesta.getListaCesta().añadirProductos(0, nuevoProducto1);
        Producto nuevoProducto2 = FactoryProducto.getInstance().crearProductoRandom();
        nuevoProducto2.setPrecioUitario(10.0);
        cesta.getListaCesta().añadirProductos(1, nuevoProducto2);
        assertEquals(15.0, cesta.getListaCesta().calcularTotalDineroDeCesta());
    }

    @Test
    public void defragmentarArrayTest(){
        Producto producto = cesta.getListaCesta().listaProductos[19];
        assertEquals(null, cesta.getListaCesta().listaProductos[0]);
        cesta.getListaCesta().defragmentarArray();
        assertEquals(producto, cesta.getListaCesta().listaProductos[0]);
    }

    @Test
    public void productoNoExistenteTest(){
        Producto productoABuscar1 = cesta.getListaCesta().listaProductos[19];
        Producto productoABuscar2 = FactoryProducto.getInstance().crearProductoRandom();
        assertEquals(19, cesta.getListaCesta().productoNoExistente(productoABuscar1));
        assertEquals(-1, cesta.getListaCesta().productoNoExistente(productoABuscar2));
    }

    @Test
    public void buscarPrimerNullTest(){
        assertEquals(0, cesta.getListaCesta().buscarPrimerNull());
    }

    @Test
    public void buscarProductoPorNombreTest(){
        String nombre1 = cesta.getListaCesta().listaProductos[19].getNombre();
        String nombre2 = "agua";
        assertEquals(19, cesta.getListaCesta().buscarProductoPorNombre(nombre1));
        assertEquals(-1, cesta.getListaCesta().buscarProductoPorNombre(nombre2));
    }

    @Test
    public void ordenarListaDeLaCestaSegunPrecioTotalTest(){
        cesta.getListaCesta().eliminarProducto(19);
        Producto producto1 = FactoryProducto.getInstance().crearProductoRandom();
        producto1.setPrecioUitario(5.0);
        cesta.getListaCesta().añadirProductos(0, producto1);
        Producto producto2 = FactoryProducto.getInstance().crearProductoRandom();
        producto2.setPrecioUitario(15.0);
        cesta.getListaCesta().añadirProductos(1, producto2);

        cesta.getListaCesta().ordenarListaDeLaCestaSegunPrecioTotal();
        assertEquals(producto1, cesta.getListaCesta().listaProductos[1]);
        assertEquals(producto2, cesta.getListaCesta().listaProductos[0]);
    }

    @Test
    public void ordenarListaDeLaCestaSegunNombreProductoTest(){
        cesta.getListaCesta().eliminarProducto(19);
        Producto producto1 = FactoryProducto.getInstance().crearProductoRandom();
        producto1.setNombre("zebra");
        cesta.getListaCesta().añadirProductos(0, producto1);
        Producto producto2 = FactoryProducto.getInstance().crearProductoRandom();
        producto2.setNombre("agua");
        cesta.getListaCesta().añadirProductos(1, producto2);

        cesta.getListaCesta().ordenarListaDeLaCestaSegunNombreProducto();
        assertEquals(producto1, cesta.getListaCesta().listaProductos[1]);
        assertEquals(producto2, cesta.getListaCesta().listaProductos[0]);
    }

    @Test
    public void estaVaciaLaVistaTest(){
        assertFalse(cesta.getListaCesta().estaVaciaLaLista());
        cesta.getListaCesta().eliminarProducto(19);
        assertTrue(cesta.getListaCesta().estaVaciaLaLista());
    }

    @Test
    public void cantidadProductoValidaTest(){
        String cantidad1 = "-10";
        String cantidad2 = "10";
        assertTrue(cesta.getListaCesta().cantidadProductoValida(cantidad1));
        assertTrue(cesta.getListaCesta().cantidadProductoValida(cantidad2));
    }

    @Test
    public void cantidadProductoNoValidaTest(){
        String cantidad1 = null;
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{cesta.getListaCesta().cantidadProductoValida(cantidad1);});
        String cantidad2 = "-11";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{cesta.getListaCesta().cantidadProductoValida(cantidad2);});
        String cantidad3 = "11";
        Exception exception3 = assertThrows(IllegalArgumentException.class, ()->{cesta.getListaCesta().cantidadProductoValida(cantidad3);});
        String cantidad4 = "hola";
        Exception exception4 = assertThrows(IllegalArgumentException.class, ()->{cesta.getListaCesta().cantidadProductoValida(cantidad4);});
        assertEquals(RED+"La cantidad de producto introducida no puede ser nula, vuelve a probar:", exception1.getMessage());
        assertEquals(RED+"No has elegido una de las cantidades de producto posible, debe estar entre 1 y 10, vuelve a probar:", exception2.getMessage());
        assertEquals(RED+"No has elegido una de las cantidades de producto posible, debe estar entre 1 y 10, vuelve a probar:", exception3.getMessage());
        assertEquals(RED+"La cantidad de producto introducida no es válida, porque no has introducido un número, vuelve a probar:", exception4.getMessage());
    }

    @Test
    public void nombreValidoTest(){
        String nombre = "agua";
        assertTrue(cesta.getListaCesta().nombreValido(nombre));
    }

    @Test
    public void nombreNoValidoTest(){
        String nombre1 = null;
        Exception exception1 = assertThrows(IllegalArgumentException.class, ()->{cesta.getListaCesta().nombreValido(nombre1);});
        String nombre2 = "";
        Exception exception2 = assertThrows(IllegalArgumentException.class, ()->{cesta.getListaCesta().nombreValido(nombre2);});
        assertEquals(RED+"El nombre introducido no puede ser nulo, vuelve a probar:", exception1.getMessage());
        assertEquals(RED+"El nombre introducido no puede estar vacio, vuelve a probar:", exception2.getMessage());
    }
}
