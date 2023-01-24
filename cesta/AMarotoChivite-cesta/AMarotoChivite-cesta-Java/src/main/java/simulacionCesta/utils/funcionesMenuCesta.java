package simulacionCesta.utils;

import simulacionCesta.factories.FinalCestFactory;
import simulacionCesta.models.FinalCest;
import simulacionCesta.models.Product;

import java.util.Scanner;

import static java.lang.System.exit;

public class funcionesMenuCesta {
    public static void menuCest(FinalCest cest) throws InterruptedException {
        // Presentamos la cesta inicial
        System.out.println("CARGANDO SU CESTA DE LA COMPRA...");
        Thread.sleep(2000);
        falsoBorradoDeConsola();
        cest.printCompleteCest();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("(USUARIO COMPRADOR) -> Selecciona la opción deseada: ");
            System.out.println();
            System.out.println("1: Listar cesta de compra por nombre ascendente");
            System.out.println("2: Listar cesta de compra por precio descendente");
            System.out.println("3: Actualizar un producto");
            System.out.println("4: Sortear una nueva compra (esto eliminará la anterior compra)");
            System.out.println("0: Salir");

            String option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    falsoBorradoDeConsola();
                    listByNameAscendent(cest);
                    falsoBorradoDeConsola();
                    menuCest(cest);
                }
                case "2" -> {
                    falsoBorradoDeConsola();
                    listByPriceDescendent(cest);
                    falsoBorradoDeConsola();
                    menuCest(cest);
                }
                case "3" -> {
                    falsoBorradoDeConsola();
                    updateProduct(cest);
                    while (!returnToMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola();
                }
                case "4" -> {
                    falsoBorradoDeConsola();
                    newCest(cest);
                }
                // Salir
                case "0" -> {
                    falsoBorradoDeConsola();
                    exit(0);
                }
            }
        }
    }

    /**
     * BubbleSort ordenado por nombre en orden ascendente (a-z)
     *
     * @param cest donde se encuentran los productos
     */
    public static void listByNameAscendent(FinalCest cest) {

        for (int i = 0; i < cest.productsStorage.getStorageProducts().length; i++) {
            for (int j = i + 1; j < cest.productsStorage.getStorageProducts().length; j++) {

                // Comparar un String con el siguiente String
                if (cest.productsStorage.getStorageProducts()[i].name.compareTo(cest.productsStorage.getStorageProducts()[j].name) > 0) {
                    // Cambiamos
                    Product aux = cest.productsStorage.getStorageProducts()[i];
                    cest.productsStorage.getStorageProducts()[i] = cest.productsStorage.getStorageProducts()[j];
                    cest.productsStorage.getStorageProducts()[j] = aux;
                }
            }
        }
    }

    /**
     * BubbleSort ordenado por precio de mayor a menor, descendente (9-1)
     *
     * @param cest donde se encuentran los productos
     */
    public static void listByPriceDescendent(FinalCest cest) {
        for (int i = 0; i < cest.productsStorage.getStorageProducts().length; i++) {
            for (int j = 0; j < cest.productsStorage.getStorageProducts().length - 1; j++) {
                if ((cest.productsStorage.getStorageProducts()[j] != null
                        && cest.productsStorage.getStorageProducts()[j + 1] != null)) {
                    if (cest.productsStorage.getStorageProducts()[j].calculateTotalPricePerProduct() < cest.productsStorage.getStorageProducts()[j + 1].calculateTotalPricePerProduct()) {
                        // Cambiamos
                        Product aux = cest.productsStorage.getStorageProducts()[j];
                        cest.productsStorage.getStorageProducts()[j] = cest.productsStorage.getStorageProducts()[j + 1];
                        cest.productsStorage.getStorageProducts()[j + 1] = aux;
                    }
                }
            }
        }
    }

    private static void updateProduct(FinalCest cest) throws InterruptedException {
        boolean exitPrincipalBucle = false;
        while (!exitPrincipalBucle) {
            System.out.println("Esta es tu cesta de la compra actual:");
            cest.printCompleteCest();
            System.out.println();
            String userRespond = userRespond("Introduzca el nombre del producto que desees modificar (ejemplo -> Pan):");
            for (int i = 0; i < cest.productsStorage.getStorageProducts().length; i++) {
                if (cest.productsStorage.getStorageProducts()[i] != null) {
                    if (cest.productsStorage.getStorageProducts()[i].name.equals(userRespond)) {
                        int positionOfProduct = i;
                        decisionToUpdate(cest, positionOfProduct);
                        System.out.println("CESTA ACTUALIZADA");
                        Thread.sleep(1000);
                        falsoBorradoDeConsola();
                    }
                    if (i == cest.productsStorage.getStorageProducts().length - 1) {
                        System.out.println("No existe el producto que has escrito");
                        Thread.sleep(1000);
                        falsoBorradoDeConsola();
                    }
                }
            }
            while (true) {
                String userReTry = userRespond("Quieres buscar nuevamente un producto? (Y/N)");
                if (userReTry.equals("Y") || userReTry.equals("y")) {
                    break;
                } else if (userReTry.equals("N") || userReTry.equals("n")) {
                    exitPrincipalBucle = true;
                } else {
                    System.out.println("Debes introducir (Y/N)!");
                    Thread.sleep(1200);
                    falsoBorradoDeConsola();
                }
            }
        }
    }

    private static void decisionToUpdate(FinalCest cest, int positionOfProduct) throws InterruptedException {
        while (true) {
            String userRespond = userRespond("Puede añadir,restar y eliminar por completo un producto (A/R/E):");
            if (userRespond.equals("A")) {
                addQuantityProduct(cest, positionOfProduct);
            } else if (userRespond.equals("R")) {
                restQuantityProduct(cest, positionOfProduct);
            } else if (userRespond.equals("E")) {
                deleteProduct(cest, positionOfProduct);
                menuCest(cest);
            } else {
                System.out.println("Debes introducir (A/R/E)!");
                Thread.sleep(1200);
                falsoBorradoDeConsola();
            }
        }
    }

    /**
     * Elimina un producto que el usuario desee, asignaremos como nulo donde se encuentre el producto
     * eliminado y lo arrastraremos hasta el final del almacén, por tanto, debemos ahora tener un control
     * de nulos mayor.
     *
     * @param cest              para poder eliminar en la cesta el producto
     * @param positionOfProduct para poder detallar en que posición de la cesta
     * @throws InterruptedException
     */
    public static void deleteProduct(FinalCest cest, int positionOfProduct) throws InterruptedException {
        cest.productsStorage.getStorageProducts()[positionOfProduct] = null;

        for (int i = 0; i < cest.productsStorage.getStorageProducts().length; i++) {
            for (int j = 0; j < cest.productsStorage.getStorageProducts().length - 1; j++) {
                if ((cest.productsStorage.getStorageProducts()[j] == null
                        && cest.productsStorage.getStorageProducts()[j + 1] != null)) {

                    Product aux = cest.productsStorage.getStorageProducts()[j];
                    cest.productsStorage.getStorageProducts()[j] = cest.productsStorage.getStorageProducts()[j + 1];
                    cest.productsStorage.getStorageProducts()[j + 1] = aux;
                }
            }
        }
        System.out.println("Producto eliminado...");
        System.out.println("CARGANDO NUEVA CESTA...");
        Thread.sleep(2000);
    }

    /**
     * Resta la cantidad de un producto que el usuario desee
     *
     * @param cest              para poder restar en la cesta el producto
     * @param positionOfProduct para poder detallar en que posición de la cesta
     * @throws InterruptedException
     */
    public static void restQuantityProduct(FinalCest cest, int positionOfProduct) throws InterruptedException {
        while (true) {
            String userRespond = userRespond("Elige la cantidad que quieras restar a tu producto:");
            if (checkInteger(userRespond)) {
                if (Integer.parseInt(userRespond) > 0
                        && Integer.parseInt(userRespond) <= cest.productsStorage.getStorageProducts()[positionOfProduct].quantity) {
                    if (Integer.parseInt(userRespond) == cest.productsStorage.getStorageProducts()[positionOfProduct].quantity) {
                        deleteProduct(cest, positionOfProduct);
                    } else {
                        cest.productsStorage.getStorageProducts()[positionOfProduct].quantity = cest.productsStorage.getStorageProducts()[positionOfProduct].quantity - Integer.parseInt(userRespond);
                        System.out.println("Producto actualizado...");
                        System.out.println("CARGANDO NUEVA CESTA...");
                        Thread.sleep(2000);
                        menuCest(cest);
                    }
                } else {
                    System.out.println("Por favor, introduzca un número mayor de 1 y menor a su valor máximo " + cest.productsStorage.getStorageProducts()[positionOfProduct].quantity);
                    Thread.sleep(2000);
                    falsoBorradoDeConsola();
                }
            }
        }
    }

    /**
     * Añade la cantidad de un producto que el usuario desee
     *
     * @param cest              para poder aumentar en la cesta el producto
     * @param positionOfProduct para poder detallar en que posición de la cesta
     * @throws InterruptedException
     */
    public static void addQuantityProduct(FinalCest cest, int positionOfProduct) throws InterruptedException {
        while (true) {
            String userRespond = userRespond("Elige la cantidad que quieras añadir a tu producto:");
            if (checkInteger(userRespond)) {
                if (Integer.parseInt(userRespond) > 0) {
                    cest.productsStorage.getStorageProducts()[positionOfProduct].quantity = cest.productsStorage.getStorageProducts()[positionOfProduct].quantity + Integer.parseInt(userRespond);
                    System.out.println("Producto actualizado...");
                    System.out.println("CARGANDO NUEVA CESTA...");
                    Thread.sleep(2000);
                    menuCest(cest);
                } else {
                    System.out.println("Por favor, introduzca un número mayor de 0");
                    Thread.sleep(2000);
                    falsoBorradoDeConsola();
                }
            }
        }
    }


    /**
     * Se le presentará un mensaje al usuario y deberá introducir una respuesta que recogeremos
     *
     * @param message que se le muestra al usuario
     * @return la respuesta del usuario
     */
    private static String userRespond(String message) {
        System.out.println(message);
        Scanner r = new Scanner(System.in);
        return r.nextLine();
    }

    /**
     * Creamos una nueva cesta de compra aleatoria
     *
     * @param cest la cesta que voy a reiniciar
     */
    public static void newCest(FinalCest cest) throws InterruptedException {
        cest = FinalCestFactory.create();
        System.out.println("CARGANDO SU NUEVA CESTA DE LA COMPRA...");
        Thread.sleep(2000);
        falsoBorradoDeConsola();
        cest.printCompleteCest();
    }

    /**
     * Filtra una cadena de caracteres para asegurar que sea números
     *
     * @param entradaUsuario La cadena de caracteres a filtrar.
     * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
     */
    public static Boolean checkInteger(String entradaUsuario) throws InterruptedException {
        String regex = "[0-9]*";
        if (!entradaUsuario.matches(regex)) {
            System.out.println("Debes introducir un número!");
            Thread.sleep(2000);
            System.out.println();
            return false;
        }
        return true;
    }

    /**
     * Permite al usuario volver al menú principal.
     *
     * @return "true" si el usuario ha introducido "menu", "false" en caso contrario.
     */
    private static Boolean returnToMenu() {
        System.out.println();
        System.out.println("Introduzca (menu), para volver al menú principal:");
        Scanner sc = new Scanner(System.in);
        String entradaDireccionMenu = sc.nextLine().toLowerCase();
        return entradaDireccionMenu.equals("menu");
    }

    /**
     * Crea una sensación de borrado de la consola.
     * Mediante una impresión de varias líneas en blanco.
     */
    private static void falsoBorradoDeConsola() {
        // Para crear una sensación de borrado en consola
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}
