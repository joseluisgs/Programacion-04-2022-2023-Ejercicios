package ModelsCesta;

import FactoriesCesta.FactoryProducto;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ListaCesta {

    public ListaCesta() {
    }

    private static String RED = "\u001b[31m";
    private static String GREEN = "\u001b[32m";
    private static String YELLOW = "\u001b[33m";
    private static String ROSE = "\u001b[35m";
    private static String CYAN = "\u001b[36m";

    public static Scanner sc = new Scanner(System.in);

    public Producto[] listaProductos = new Producto[20];

    public String[] cantidadPrecioDelProducto = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    /**
     * función que sirve para introducir un nuevo producto a la lista de la cesta
     */
    public void añadirProductosALaListaDeLaCesta(){
        int posicionVacia = buscarPrimerNull();
        if(posicionVacia != -1){
            Producto nuevoProducto = FactoryProducto.getInstance().crearProductoRandom();
            int posicionDelProducto = productoNoExistente(nuevoProducto);
            if(posicionDelProducto == -1){
                System.out.println(CYAN+"Se va a añadir a la cesta el producto: "+añadirProductos(posicionVacia, nuevoProducto).getNombre());
            }else{
                final int cantidadParaAlternarCantidad = 1;
                System.out.println(CYAN+"El producto ha añadir a la cesta: "+ nuevoProducto.getNombre() +", ya existe en la lista, por lo que se le va a sumar la cantidad en "+cantidadParaAlternarCantidad+", por lo que ahora es: "+actualizarCantidadProducto(posicionDelProducto, cantidadParaAlternarCantidad));
            }
        }else{
            System.out.println(YELLOW+"No quedán espacios libres donde puedas introducir más productos");
        }
    }

    /**
     * función que sirve para añadir un producto a la lista de la cesta
     * @param posicionVacia es la primera posición vacia en la que podemos meter productos en la cesta
     * @param nuevoProducto es el nuevo producto que se quiere meter en la lista de la cesta
     */
    public Producto añadirProductos(int posicionVacia, Producto nuevoProducto){
        listaProductos[posicionVacia] = nuevoProducto;
        cantidadPrecioDelProducto[posicionVacia] = "1-"+nuevoProducto.getPrecioUitario();
        return listaProductos[posicionVacia];
    }

    /**
     * función que sirve para eliminar un producto de la lista de la cesta
     */
    public void eliminarProductosALaListaDeLaCesta(){
        defragmentarArray();
        System.out.println(CYAN+"Su lista de la cesta es:");
        mostrarListaDeLaCesta();
        if(estaVaciaLaLista() == false){
            System.out.println(CYAN+"Introduce el nombre del producto que quieras eliminar, o quit si quieres salir:");
            String nombreProducto = introducirNombreProducto();
            int posicionProducto = -1;
            do{
                posicionProducto = buscarProductoPorNombre(nombreProducto);
                if(posicionProducto == -1 && nombreProducto != "quit"){
                    System.out.println(RED+"No Existe ningún producto con ese nombre, vuelve a probar:");
                }
            }while(posicionProducto == -1 && nombreProducto != "quit");
            if(posicionProducto != -1) {
                System.out.println(CYAN + "De acuerdo, se ha eliminado el producto: " + eliminarProducto(posicionProducto).getNombre());
            }
        }else{
            System.out.println(YELLOW+"Como está vacía, no hay productos a eliminar");
        }
    }

    /**
     * función que sirve para eliminar el registro del producto que se encuentré en la posición pasada por parametro
     * @param posicionProducto es la posición en la que se encuentra el producto a eliminar
     * @return el producto que fue eliminado de la lista de la cesta
     */
    public Producto eliminarProducto(int posicionProducto) {
        Producto productoAEliminar = listaProductos[posicionProducto];
        listaProductos[posicionProducto] = null;
        cantidadPrecioDelProducto[posicionProducto] = "";
        return productoAEliminar;
    }

    /**
     * función que sirve para actualizar la cantidad que tenemos de un producto en la lista de la cesta
     */
    public void actualizarProductosALaListaDeLaCesta(){
        defragmentarArray();
        System.out.println(CYAN+"Su lista de la cesta es:");
        mostrarListaDeLaCesta();
        System.out.println();

        if(estaVaciaLaLista() == false){
            System.out.println(CYAN+"Introduce el nombre del producto cuya cantidad quieras actualizar, o quit si quieres salir:");
            String nombreProducto = introducirNombreProducto();
            int posicionProducto = -1;
            do{
                posicionProducto = buscarProductoPorNombre(nombreProducto);
                if(posicionProducto == -1 && !nombreProducto.equals("quit")){
                    System.out.println(RED+"No existe ningún producto con ese nombre, vuelve a probar:");
                }
            }while(posicionProducto == -1 && !nombreProducto.equals("quit"));

            if(posicionProducto != -1) {
                var datosProducto = cantidadPrecioDelProducto[posicionProducto].split("-");
                System.out.println(CYAN + "De acuerdo, se va ha actualizar el producto: " + listaProductos[posicionProducto].getNombre() + ", cuya cantidad actual en cesta es: " + datosProducto[0]);
                if (Integer.parseInt(datosProducto[0]) == 10) {
                    System.out.println(CYAN + "Introduzca la cantidad del producto que quieras quitar de la cesta:");
                    var cantidad = introducirCantidadProducto();
                    System.out.println(CYAN + "La nueva cantidad del producto: " + listaProductos[posicionProducto].getNombre() + ", es " + actualizarCantidadProducto(posicionProducto, -cantidad));
                } else {
                    System.out.println(CYAN + "Introduzca la cantidad del producto que quieras añadir(+) o quitar(-) de la cesta:");
                    var cantidad = introducirCantidadProducto();
                    System.out.println(CYAN + "La nueva cantidad del producto: " + listaProductos[posicionProducto].getNombre() + ", es " + actualizarCantidadProducto(posicionProducto, cantidad));
                }
                eliminarProductoSiCantidad0();
            }
        }else{
            System.out.println(YELLOW+"Como está vacía, no hay productos cuya cantidad podamos actualizar");
        }
    }

    /**
     * función que sirve para eliminar cualquier objeto cuya cantidad sea cero
     */
    public void eliminarProductoSiCantidad0() {
        for(int i = 0;i<listaProductos.length;i++){
            if(listaProductos[i] != null) {
                if (cantidadPrecioDelProducto[i].split("-")[0].equals("0")) {
                    listaProductos[i] = null;
                    cantidadPrecioDelProducto[i] = "";
                }
            }
        }
    }

    /**
     * función que sirve para actualizar la cantidad de cierto producto que tenemos en la cesta
     * @param posicionDelProducto es la posición sobre donde está el producto en la lista de la cesta
     * @param numero es la cantidad en la que se cambiará la cantidad de productos existentes
     */
    public int actualizarCantidadProducto(int posicionDelProducto, int numero) {
        var datos = cantidadPrecioDelProducto[posicionDelProducto].split("-");
        var cantidad = Integer.parseInt(datos[0])+numero;
        if(Integer.parseInt(datos[0])+numero > 10){
            cantidad = 10;
        }
        if(Integer.parseInt(datos[0])+numero < 0){
            cantidad = 0;
        }
        cantidadPrecioDelProducto[posicionDelProducto] = cantidad+"-"+datos[1];
        return cantidad;
    }

    /**
     * función que muestra cuanto cuesta el total de todos los productos en caja
     */
    public void optenerElTotalDeLosProductosEnCaja(){
        if(estaVaciaLaLista() == false) {
            ordenarListaDeLaCestaSegunPrecioTotal();
            for (int i = 0;i<listaProductos.length;i++) {
                if(listaProductos[i] != null ){
                    String[] datos = cantidadPrecioDelProducto[i].split("-");
                    System.out.println(YELLOW+(i+1)+"."+CYAN+"El producto: "+ROSE+listaProductos[i]+CYAN+", en total vale: "+ROSE+String.format(" %.2f",(Double.parseDouble(datos[0])) * (Double.parseDouble(datos[1]))+"€"));
                }
            }
            System.out.println(CYAN+"El total de dinero que cuesta la cesta entera es de: "+String.format(" %.2f",calcularTotalDineroDeCesta())+"€");
        }else{
            System.out.println(YELLOW+"La lista de la cesta está vacía, por lo que no hay nada que mostrar");
        }
    }

    /**
     * función que sirve para calcular el dinero total que cuesta la cesta
     * @return el dinero que cuesta como un double y con decimales
     */
    public double calcularTotalDineroDeCesta() {
        var resultado = 0.0;
        for(int i = 0;i<cantidadPrecioDelProducto.length;i++){
            if(!cantidadPrecioDelProducto[i].isEmpty()) {
                String[] datos = cantidadPrecioDelProducto[i].split("-");
                resultado += (Double.parseDouble(datos[0])) * (Double.parseDouble(datos[1]));
            }
        }
        return resultado;
    }

    /**
     * función que nos muestra la posibles opción que hay para mostrar la lista de la cesta, y la muestra
     */
    public void representarLaListaDeLaCesta(){
        if(estaVaciaLaLista() == false) {
            defragmentarArray();
            switch (menuTipoOrdenacion()) {
                case 1 -> ordenarListaDeLaCestaSegunPrecioTotal();
                case 2 -> ordenarListaDeLaCestaSegunNombreProducto();
            }
            mostrarListaDeLaCesta();
        }else{
            System.out.println(YELLOW+"La lista de la cesta está vacía, por lo que no hay nada que mostrar");
        }
    }

    /**
     * función que sirve para defragmentar el array
     */
    public void defragmentarArray() {
        for(int i = 0;i<listaProductos.length;i++){
            if(listaProductos[i] != null) {
                var j = i;
                if(j - 1 >= 0 && listaProductos[j - 1] == null) {
                    while (j - 1 >= 0 && listaProductos[j - 1] == null) {
                        j--;
                    }
                    listaProductos[j] = listaProductos[i];
                    listaProductos[i] = null;
                    cantidadPrecioDelProducto[j] = cantidadPrecioDelProducto[i];
                    cantidadPrecioDelProducto[i] = "";
                }
            }
        }
    }

    /**
     * función que sirve para controlar si un producto a añadir en la cesta, ya existe, o no
     * @param nuevoProducto es el nuevo producto que se quiere meter en la lista de la cesta
     * @return un -1 si no existe ese producto en la cesta o, la posición del array donde este el producto
     */
    public int productoNoExistente(Producto nuevoProducto) {
        var posicion = -1;
        for(int i = 0;i<listaProductos.length;i++){
            if(listaProductos[i] != null) {
                if (listaProductos[i].equals(nuevoProducto)) {
                    posicion = i;
                    break;
                }
            }
        }
        return posicion;
    }

    /**
     * función que sirve para encontrar en caso de que haya, una posición con null en el array de productos
     * @return un -1 si no hay nulos o, la posición del array con el nulo
     */
    public int buscarPrimerNull() {
        var posicion = -1;
        for(int i = 0;i<listaProductos.length;i++){
            if(listaProductos[i] == null){
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    /**
     * función que sirve para buscar la posición de un producto según su nombre
     * @param nombre es el nombre del producto que usaremos para buscar la posición
     * @return -1 si no se ha encontrado ningún producto con ese nombre, y en caso contrario, la posicion del array de productos correcta
     */
    public int buscarProductoPorNombre(String nombre) {
        var posicion = -1;
        for (int i = 0;i<listaProductos.length;i++) {
            if (listaProductos[i] != null) {
                if(listaProductos[i].getNombre().equals(nombre)){
                    posicion = i;
                    break;
                }
            }
        }
        return posicion;
    }

    /**
     * función que sirve para presentar un menu al usuario y conseguir la opción que seleccione
     * @return la opcion seleccionada por el usuario
     */
    public int menuTipoOrdenacion() {
        System.out.println(GREEN+"**************************************************");
        System.out.println("*                    MENÚ                        *");
        System.out.println("**************************************************");
        System.out.println("* "+YELLOW+"[1] "+CYAN+"Ordenar según el precio total del producto"+GREEN+" *");
        System.out.println("* "+YELLOW+"[2] "+CYAN+"Ordenar según el nombre del producto"+GREEN+"       *");
        System.out.println("**************************************************");
        return introducirOpcion();
    }

    /**
     * función que ordena el array de los productos y el de sus correspondientes cantidades y precio unitario según el precio total del producto en la lista
     */
    public void ordenarListaDeLaCestaSegunPrecioTotal(){
        for(int j = 0;j<listaProductos.length;j++) {
            for (int i = 0;i<listaProductos.length - j;i++) {
                if (listaProductos[i] != null && listaProductos[i + 1] != null) {
                    String[] datos1 = cantidadPrecioDelProducto[i].split("-");
                    String[] datos2 = cantidadPrecioDelProducto[i + 1].split("-");
                    if (((Double.parseDouble(datos1[0])) * (Double.parseDouble(datos1[1]))) < ((Double.parseDouble(datos2[0])) * (Double.parseDouble(datos2[1])))) {
                        Producto auxiliar1 = listaProductos[i];
                        listaProductos[i] = listaProductos[i + 1];
                        listaProductos[i + 1] = auxiliar1;

                        String auxiliar2 = cantidadPrecioDelProducto[i];
                        cantidadPrecioDelProducto[i] = cantidadPrecioDelProducto[i + 1];
                        cantidadPrecioDelProducto[i + 1] = auxiliar2;
                    }
                }
            }
        }
    }

    /**
     * función que ordena el array de los productos y el de sus correspondientes cantidades y precio unitario según el orden alfabetico de los nombres del producto
     */
    public void ordenarListaDeLaCestaSegunNombreProducto(){
        for(int j = 0;j<listaProductos.length;j++) {
            for (int i = 0;i<listaProductos.length - j;i++) {
                if (listaProductos[i] != null && listaProductos[i + 1] != null) {
                    if (listaProductos[i].getNombre().compareTo(listaProductos[i + 1].getNombre()) > 0) {
                        Producto auxiliar1 = listaProductos[i];
                        listaProductos[i] = listaProductos[i + 1];
                        listaProductos[i + 1] = auxiliar1;

                        String auxiliar2 = cantidadPrecioDelProducto[i];
                        cantidadPrecioDelProducto[i] = cantidadPrecioDelProducto[i + 1];
                        cantidadPrecioDelProducto[i + 1] = auxiliar2;
                    }
                }
            }
        }
    }

    /**
     * función que sirve para representar la lista de la cesta, con los productos, cantidad y precio unitario
     */
    public void mostrarListaDeLaCesta() {
        if(estaVaciaLaLista() == false) {
            System.out.println(GREEN+"====================================================================================================================");
            System.out.println("                                          Lista de productos                                                        ");
            System.out.println("====================================================================================================================");
            for (int i = 0;i<listaProductos.length;i++) {
                if (listaProductos[i] != null) {
                    var datos = cantidadPrecioDelProducto[i].split("-");
                    System.out.println(YELLOW+(i+1)+"."+CYAN+listaProductos[i]);
                    System.out.println(CYAN+"Cantidad de producto: "+ROSE+datos[0]+"  "+CYAN+"Precio unitario producto: "+ROSE+datos[1]+"€");
                }
            }
            System.out.println(GREEN+"====================================================================================================================");
        }else{
            System.out.println(YELLOW+"Aun no hay nada en el carrito");
        }
    }

    /**
     * función que sirve para saber si la lista de la cesta está vacia o no
     * @return true si está vacía, false si no lo está
     */
    public boolean estaVaciaLaLista(){
        var estaVacia = true;
        for(int i = 0;i<listaProductos.length;i++){
            if(listaProductos[i] != null){
                estaVacia = false;
                break;
            }
        }
        return estaVacia;
    }

    /**
     * función que sirve para introducir una cantidad de producto válida
     * @return la opcion válida
     */
    public int introducirCantidadProducto() {
        var cantidadProducto = "";
        do {
            try {
                cantidadProducto = sc.nextLine().trim();
                cantidadProductoValida(cantidadProducto);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                cantidadProducto = "";
            }
        } while (cantidadProducto == "");
        return Integer.parseInt(cantidadProducto);
    }

    /**
     * función que sirve para validar la cantidad de producto introducida por teclado
     * @param cantidadProducto lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public boolean cantidadProductoValida(String cantidadProducto){
        if(cantidadProducto == null){
            throw new IllegalArgumentException(RED+"La cantidad de producto introducida no puede ser nula, vuelve a probar:");
        }
        Pattern regex = Pattern.compile("-?[0-9]+");
        if(!regex.matcher(cantidadProducto).matches()){
            throw new IllegalArgumentException(RED+"La cantidad de producto introducida no es válida, porque no has introducido un número, vuelve a probar:");
        }
        if(Integer.parseInt(cantidadProducto) < -10 || Integer.parseInt(cantidadProducto) > 10){
            throw new IllegalArgumentException(RED+"No has elegido una de las cantidades de producto posible, debe estar entre 1 y 10, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir un nombre de producto válido
     * @return el nombre del producto introducido por teclado
     */
    public String introducirNombreProducto() {
        var nombre = "";
        do {
            try {
                nombre = sc.nextLine().trim().toLowerCase();
                nombreValido(nombre);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                nombre = "";
            }
        } while (nombre == "");
        return nombre;
    }

    /**
     * función que sirve para validar el nombre del producto introducido por teclado
     * @param nombre lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public boolean nombreValido(String nombre) {
        if(nombre == null){
            throw new IllegalArgumentException(RED+"El nombre introducido no puede ser nulo, vuelve a probar:");
        }
        if(nombre.isEmpty()){
            throw new IllegalArgumentException(RED+"El nombre introducido no puede estar vacio, vuelve a probar:");
        }
        return true;
    }

    /**
     * función que sirve para introducir una opción válida
     * @return la opcion válida
     */
    public int introducirOpcion() {
        var opcion = "";
        do {
            try {
                opcion = sc.nextLine().trim();
                opcionValida(opcion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                opcion = "";
            }
        } while (opcion == "");
        return Integer.parseInt(opcion);
    }

    /**
     * función que sirve para validar la opción introducida por teclado
     * @param opcion lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    public boolean opcionValida(String opcion) {
        if(opcion == null){
            throw new IllegalArgumentException(RED+"La opción no puede ser nula, vuelve a probar:");
        }
        Pattern regex = Pattern.compile("[0-9]+");
        if(!regex.matcher(opcion).matches()){
            throw new IllegalArgumentException(RED+"La opción introducida no es válida, vuelve a probar:");
        }
        if(Integer.parseInt(opcion) < 1 || Integer.parseInt(opcion) > 2){
            throw new IllegalArgumentException(RED+"No has elegido una de las opciones posibles, vuelve a probar:");
        }
        return true;
    }
}
