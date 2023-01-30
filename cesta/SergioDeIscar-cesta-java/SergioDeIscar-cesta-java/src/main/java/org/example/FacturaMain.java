package org.example;

import org.example.factories.ProductoFactory;
import org.example.models.Factura;
import org.example.models.ItemFactura;
import org.example.models.Producto;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class FacturaMain {
    static Random rdn = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Producto[] productos = new Producto[rdn.nextInt(5,15)];
        ProductoFactory.getInstance().createProductosRandom(productos);

        String usuario = inputString("Introduce tu nombre de usuario: ");

        System.out.println("Bienvenido " + usuario);

        Factura factura = new Factura(usuario);

        mainLoop:do {
            switch (menu()){
                case 1:
                    mostrarFactura(factura);
                    break;
                case 2:
                    addItemAlCarro(factura, productos);
                    break;
                case 3:
                    mostrarFactura(factura);
                    var resRemove = factura.removeItem(inputNumber( "Introduce la posición del producto:", 1, factura.getLengthItems() + 1) -1);
                    mostrarResult(resRemove, "No se ha podido borrar el producto.", "El producto ha sido borrado con éxito.");
                    break;
                case 4:
                    Producto producto = inputProducto(productos);
                    if (producto == null){
                        System.out.println("Error: No se ha encontrado el producto.");
                        break;
                    }
                    var resUpdate = factura.updateItem(inputNumber("Introduce la posición del producto:", 1, factura.getLengthItems() + 1) -1,
                            new ItemFactura(producto, inputNumber("Introduce la cantidad:", 1, producto.getStock())));
                    mostrarResult(resUpdate, "No se ha podido actualizar el producto.", "El producto ha sido actualizado con éxito.");
                    break;
                case 5:
                    var resFind = factura.findItem(inputString("Introduce el nombre del producto:"));
                    mostrarResult(resFind, "No se ha encontrado el producto.", "El producto ha sido encontrado con éxito -> " + resFind);
                    break;
                case 6:
                    mostrarProductos(productos);
                    break;
                case 7:
                    System.out.println("Gracias por su compra.");
                    break mainLoop;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clear();
        }while (true);
        System.out.println(factura);
    }

    private static void mostrarResult(ItemFactura res, String badMessage, String goodMessage) {
        if (res != null){
            System.out.println(goodMessage);
        }
        else {
            System.out.println(badMessage);
        }
    }

    private static void mostrarFactura(Factura factura) {
        System.out.println(factura);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static int menu(){
        return inputNumber("¿Qué quieres hacer?\n" +
                        "1->\tMostrar carrito\n" +
                        "2->\tAñadir producto al carrito\n" +
                        "3->\tBorrar producto del carrito\n" +
                        "4->\tCambiar producto del carrito\n" +
                        "5->\tBuscar producto buscar del carrito\n" +
                        "6->\tMostrar todos los productos disponibles\n" +
                        "7->\tFinalizar compra\n",
                1, 7);
    }

    private static void addItemAlCarro(Factura factura, Producto[] productos){
        Producto producto = inputProducto(productos);

        if (producto == null){
            System.out.println("Error-> No se ha encontrado el producto.");
            return;
        }
        if (producto.getStock() == 0){
            System.out.println("Error-> No hay stock de este producto.");
            return;
        }

        int cantidad = inputNumber("Introduce la cantidad:", 1, producto.getStock());
        int index;
        for (index = 0; index < productos.length; index++) {
            if (Objects.equals(productos[index].getNombre(), producto.getNombre()))
                break;
        }
        ItemFactura itemFactura = new ItemFactura(producto, cantidad);
        factura.addItem(itemFactura);
        productos[index].setStock(productos[index].getStock() - cantidad);
    }

    private static Producto inputProducto(Producto[] productos){
        mostrarProductos(productos);
        int index = inputNumber("Introduce la posición del producto:", 1, productos.length) -1;
        return productos[index];
    }

    private static int inputNumber(String message, int min, int max){
        System.out.println(message);
        int response;
        do {
            try {
                response = sc.nextInt();
                if (response >= min && response <= max) {
                    break;
                } else {
                    System.out.println("Error-> Introduce un número entre " + min + " y " + max);
                }
            } catch (Exception e) {
                System.out.println("Error-> Introduce un número.");
                sc.nextLine();
            }
        }while (true);
        return response;
    }

    private static String inputString(String message) {
        System.out.println(message);
        String response;
        do {
            response = sc.nextLine();
            if (response.isEmpty()) {
                System.out.println("Error-> Introduce algún texto.");
            }
        }while (response.isEmpty());
        return response;
    }

    private static void mostrarProductos(Producto[] productos){
        for (int i = 0; i < productos.length; i++) {
            System.out.println((i+1) + "->\t" + productos[i]);
        }
    }

    private static void clear(){
        clear(20);
    }

    private static void clear(int count){
        for (int i = 0; i < count; i++){
            System.out.println();
        }
    }
}