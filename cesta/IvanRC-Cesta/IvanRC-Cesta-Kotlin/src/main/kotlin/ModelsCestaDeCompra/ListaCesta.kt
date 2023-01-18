package ModelsCestaDeCompra

import FactoriesCestaDeCompra.FactoryProducto

class ListaCesta {

    var listaProductos: Array<Producto?> = Array<Producto?>(20){null}

    var cantidadPrecioDelProducto = Array<String>(20){""}

    /**
     * función que sirve para introducir un nuevo producto a la lista de la cesta
     */
    fun añadirProductosALaListaDeLaCesta(){
        val posicionVacia = buscarPrimerNull()
        if(posicionVacia != -1){
            val nuevoProducto = FactoryProducto.getInstance()!!.crearProductoRandom()
            val posicionDelProducto = productoNoExistente(nuevoProducto)
            if(posicionDelProducto == -1){
                println("${Colores.CYAN.color}Se va a añadir a la cesta el producto: ${añadirProductos(posicionVacia, nuevoProducto)!!.nombre}")
            }else{
                val cantidadParaAlternarCantidad = 1
                println("${Colores.CYAN.color}El producto ha añadir a la cesta: ${nuevoProducto.nombre}, ya existe en la lista, por lo que se le va a sumar la cantidad en ${cantidadParaAlternarCantidad}, por lo que ahora es: ${actualizarCantidadProducto(posicionDelProducto, cantidadParaAlternarCantidad)}")
            }
        }else{
            println("${Colores.YELLOW.color}No quedán espacios libres donde puedas introducir más productos")
        }
    }

    /**
     * función que sirve para añadir un producto a la lista de la cesta
     * @param posicionVacia es la primera posición vacia en la que podemos meter productos en la cesta
     * @param nuevoProducto es el nuevo producto que se quiere meter en la lista de la cesta
     */
    fun añadirProductos(posicionVacia: Int, nuevoProducto: Producto): Producto? {
        listaProductos[posicionVacia] = nuevoProducto
        cantidadPrecioDelProducto[posicionVacia] = "1-${nuevoProducto.precioUnitario}"
        return listaProductos[posicionVacia]
    }

    /**
     * función que sirve para eliminar un producto de la lista de la cesta
     */
    fun eliminarProductosALaListaDeLaCesta(){
        defragmentarArray()
        println("${Colores.CYAN.color}Su lista de la cesta es:")
        mostrarListaDeLaCesta()
        if(estaVaciaLaLista() == false){
            println("""${Colores.CYAN.color}Introduce el nombre del producto que quieras eliminar, o "quit" si quieres salir:""")
            var posicionProducto = -1
            var nombreProducto = ""
            do{
                nombreProducto = introducirNombreProducto()
                posicionProducto = buscarProductoPorNombre(nombreProducto)
                if(posicionProducto == -1 && nombreProducto != "quit"){
                    println("${Colores.RED.color}No Existe ningún producto con ese nombre, vuelve a probar:")
                }
            }while(posicionProducto == -1 && nombreProducto != "quit")
            if(posicionProducto != -1) {
                println(
                    "${Colores.CYAN.color}De acuerdo, se ha eliminado el producto: ${
                        eliminarProducto(
                            posicionProducto
                        )!!.nombre
                    }"
                )
            }
        }else{
            println("${Colores.YELLOW.color}Como está vacía, no hay productos a eliminar")
        }
    }

    /**
     * función que sirve para eliminar el registro del producto que se encuentré en la posición pasada por parametro
     * @param posicionProducto es la posición en la que se encuentra el producto a eliminar
     * @return el producto que fue eliminado de la lista de la cesta
     */
    fun eliminarProducto(posicionProducto: Int): Producto? {
        val productoAEliminar = listaProductos[posicionProducto]
        listaProductos[posicionProducto] = null
        cantidadPrecioDelProducto[posicionProducto] = ""
        return productoAEliminar
    }

    /**
     * función que sirve para actualizar la cantidad que tenemos de un producto en la lista de la cesta
     */
    fun actualizarProductosALaListaDeLaCesta(){
        defragmentarArray()
        println("${Colores.CYAN.color}Su lista de la cesta es:")
        mostrarListaDeLaCesta()
        println()

        if(estaVaciaLaLista() == false){
            println("""${Colores.CYAN.color}Introduce el nombre del producto cuya cantidad quieras actualizar, o "quit" si quieres salir:""")
            var posicionProducto = -1
            var nombreProducto = ""
            do{
                nombreProducto = introducirNombreProducto()
                posicionProducto = buscarProductoPorNombre(nombreProducto)
                if(posicionProducto == -1 && nombreProducto != "quit"){
                    println("${Colores.RED.color}No Existe ningún producto con ese nombre, vuelve a probar:")
                }
            }while(posicionProducto == -1 && nombreProducto != "quit")

            if(posicionProducto != -1) {
                var datosProducto = cantidadPrecioDelProducto[posicionProducto].split("-")
                println("${Colores.CYAN.color}De acuerdo, se va ha actualizar el producto: ${listaProductos[posicionProducto]!!.nombre}, cuya cantidad actual en cesta es: ${datosProducto[0]}")
                if (datosProducto[0].toInt() == 10) {
                    println("${Colores.CYAN.color}Introduzca la cantidad del producto que quieras quitar de la cesta:")
                    var cantidad = introducirCantidadProducto()
                    println(
                        "${Colores.CYAN.color}La nueva cantidad del producto: ${listaProductos[posicionProducto]!!.nombre}, es ${
                            actualizarCantidadProducto(
                                posicionProducto,
                                -cantidad
                            )
                        }"
                    )
                } else {
                    println("${Colores.CYAN.color}Introduzca la cantidad del producto que quieras añadir(+) o quitar(-) de la cesta:")
                    var cantidad = introducirCantidadProducto()
                    println(
                        "${Colores.CYAN.color}La nueva cantidad del producto: ${listaProductos[posicionProducto]!!.nombre}, es ${
                            actualizarCantidadProducto(
                                posicionProducto,
                                cantidad
                            )
                        }"
                    )
                }
                eliminarProductoSiCantidad0()
            }
        }else{
            println("${Colores.YELLOW.color}Como está vacía, no hay productos cuya cantidad podamos actualizar")
        }
    }

    /**
     * función que sirve para eliminar cualquier objeto cuya cantidad sea cero
     */
    fun eliminarProductoSiCantidad0() {
        for(i in listaProductos.indices){
            if(cantidadPrecioDelProducto[i].split("-")[0] == "0"){
                listaProductos[i] = null
                cantidadPrecioDelProducto[i] = ""
            }
        }
    }

    /**
     * función que sirve para actualizar la cantidad de cierto producto que tenemos en la cesta
     * @param posicionDelProducto es la posición sobre donde está el producto en la lista de la cesta
     * @param numero es la cantidad en la que se cambiará la cantidad de productos existentes
     */
    fun actualizarCantidadProducto(posicionDelProducto: Int, numero: Int): Int {
        var datos = cantidadPrecioDelProducto[posicionDelProducto].split("-")
        var cantidad = datos[0].toInt()+numero
        if(datos[0].toInt()+numero > 10){
            cantidad = 10
        }
        if(datos[0].toInt()+numero < 0){
            cantidad = 0
        }
        cantidadPrecioDelProducto[posicionDelProducto] = "$cantidad-${datos[1]}"
        return cantidad
    }

    /**
     * función que muestra cuanto cuesta el total de todos los productos en caja
     */
    fun optenerElTotalDeLosProductosEnCaja(){
        if(estaVaciaLaLista() == false) {
            ordenarListaDeLaCestaSegunPrecioTotal()
            defragmentarArray()
            println("${Colores.CYAN.color}Su lista de la cesta es:")
            mostrarListaDeLaCesta()
            println()
            println("El total de dinero que cuesta la cesta entera es de: ${String.format(" %.2f",calcularTotalDineroDeCesta())}€")
        }else{
            println("${Colores.YELLOW.color}La lista de la cesta está vacía, por lo que no hay nada que mostrar")
        }
    }

    /**
     * función que sirve para calcular el dinero total que cuesta la cesta
     * @return el dinero que cuesta como un double y con decimales
     */
    fun calcularTotalDineroDeCesta(): Double {
        var resultado = 0.0
        for(i in cantidadPrecioDelProducto){
            if(i != "") {
                val datos = i.split("-")
                resultado += (datos[0].toDouble()) * (datos[1].toDouble())
            }
        }
        return resultado
    }

    /**
     * función que nos muestra la posibles opción que hay para mostrar la lista de la cesta, y la muestra
     */
    fun representarLaListaDeLaCesta(){
        if(estaVaciaLaLista() == false) {
            defragmentarArray()
            when (menuTipoOrdenacion()) {
                1 -> ordenarListaDeLaCestaSegunPrecioTotal()
                2 -> ordenarListaDeLaCestaSegunNombreProducto()
            }
            mostrarListaDeLaCesta()
        }else{
            println("${Colores.YELLOW.color}La lista de la cesta está vacía, por lo que no hay nada que mostrar")
        }
    }

    /**
     * función que sirve para defragmentar el array
     */
    fun defragmentarArray() {
        for(i in listaProductos.indices){
            if(listaProductos[i] != null) {
                var j = i
                if(j - 1 >= 0 && listaProductos[j - 1] == null) {
                    while (j - 1 >= 0 && listaProductos[j - 1] == null) {
                        j--
                    }
                    listaProductos[j] = listaProductos[i]
                    listaProductos[i] = null
                    cantidadPrecioDelProducto[j] = cantidadPrecioDelProducto[i]
                    cantidadPrecioDelProducto[i] = ""
                }
            }
        }
    }

    /**
     * función que sirve para controlar si un producto a añadir en la cesta, ya existe, o no
     * @param nuevoProducto es el nuevo producto que se quiere meter en la lista de la cesta
     * @return un -1 si no existe ese producto en la cesta o, la posición del array donde este el producto
     */
    fun productoNoExistente(nuevoProducto: Producto?): Int {
        var posicion = -1
        for(i in listaProductos.indices){
            if(listaProductos[i] != null) {
                if (listaProductos[i] == nuevoProducto) {
                    posicion = i
                    break
                }
            }
        }
        return posicion
    }

    /**
     * función que sirve para encontrar en caso de que haya, una posición con null en el array de productos
     * @return un -1 si no hay nulos o, la posición del array con el nulo
     */
    fun buscarPrimerNull(): Int {
        var posicion = -1
        for(i in listaProductos.indices){
            if(listaProductos[i] == null){
                posicion = i
                break
            }
        }
        return posicion
    }

    /**
     * función que sirve para buscar la posición de un producto según su nombre
     * @param nombre es el nombre del producto que usaremos para buscar la posición
     * @return -1 si no se ha encontrado ningún producto con ese nombre, y en caso contrario, la posicion del array de productos correcta
     */
    fun buscarProductoPorNombre(nombre: String): Int {
        var posicion = -1
        for (i in listaProductos.indices) {
            if (listaProductos[i] != null) {
               if(listaProductos[i]!!.nombre == nombre){
                   posicion = i
                   break
               }
            }
        }
        return posicion
    }

    /**
     * función que sirve para presentar un menu al usuario y conseguir la opción que seleccione
     * @return la opcion seleccionada por el usuario
     */
    fun menuTipoOrdenacion(): Int {
        println("${Colores.GREEN.color}**************************************************")
        println("*                    MENÚ                        *")
        println("**************************************************")
        println("* ${Colores.YELLOW.color}[1] ${Colores.CYAN.color}Ordenar según el precio total del producto${Colores.GREEN.color} *")
        println("* ${Colores.YELLOW.color}[2] ${Colores.CYAN.color}Ordenar según el nombre del producto${Colores.GREEN.color}       *")
        println("**************************************************")
        return introducirOpcion()
    }

    /**
     * función que ordena el array de los productos y el de sus correspondientes cantidades y precio unitario según el precio total del producto en la lista
     */
    fun ordenarListaDeLaCestaSegunPrecioTotal(){
        for(j in listaProductos.indices) {
            for (i in listaProductos.indices - j) {
                if (listaProductos[i] != null && listaProductos[i + 1] != null) {
                    val datos1 = cantidadPrecioDelProducto[i].split("-")
                    val datos2 = cantidadPrecioDelProducto[i + 1].split("-")
                    if (((datos1[0].toDouble()) * (datos1[1].toDouble())) < ((datos2[0].toDouble()) * (datos2[1].toDouble()))) {
                        val auxiliar1 = listaProductos[i]
                        listaProductos[i] = listaProductos[i + 1]
                        listaProductos[i + 1] = auxiliar1

                        val auxiliar2 = cantidadPrecioDelProducto[i]
                        cantidadPrecioDelProducto[i] = cantidadPrecioDelProducto[i + 1]
                        cantidadPrecioDelProducto[i + 1] = auxiliar2
                    }
                }
            }
        }
    }

    /**
     * función que ordena el array de los productos y el de sus correspondientes cantidades y precio unitario según el orden alfabetico de los nombres del producto
     */
    fun ordenarListaDeLaCestaSegunNombreProducto(){
        for(j in listaProductos.indices) {
            for (i in listaProductos.indices - j) {
                if (listaProductos[i] != null && listaProductos[i + 1] != null) {
                    if (listaProductos[i]!!.nombre.compareTo(listaProductos[i + 1]!!.nombre) > 0) {
                        val auxiliar1 = listaProductos[i]
                        listaProductos[i] = listaProductos[i + 1]
                        listaProductos[i + 1] = auxiliar1

                        val auxiliar2 = cantidadPrecioDelProducto[i]
                        cantidadPrecioDelProducto[i] = cantidadPrecioDelProducto[i + 1]
                        cantidadPrecioDelProducto[i + 1] = auxiliar2
                    }
                }
            }
        }
    }

    /**
     * función que sirve para representar la lista de la cesta, con los productos, cantidad y precio unitario
     */
    fun mostrarListaDeLaCesta() {
        if(estaVaciaLaLista() == false) {
            println("${Colores.GREEN.color}====================================================================================================================")
            println("                                          Lista de productos                                                        ")
            println("====================================================================================================================")
            for (i in listaProductos.indices) {
                if (listaProductos[i] != null) {
                    var datos = cantidadPrecioDelProducto[i].split("-")
                    println("${Colores.YELLOW.color}${i+1}.${Colores.CYAN.color}${listaProductos[i]}")
                    println("${Colores.CYAN.color}Cantidad de producto: ${Colores.ROSE.color}${datos[0]}  ${Colores.CYAN.color}Precio unitario producto: ${Colores.ROSE.color}${datos[1]}€")
                }
            }
            println("${Colores.GREEN.color}====================================================================================================================")
        }else{
            println("${Colores.YELLOW.color}Aun no hay nada en el carrito")
        }
    }

    /**
     * función que sirve para saber si la lista de la cesta está vacia o no
     * @return true si está vacía, false si no lo está
     */
    fun estaVaciaLaLista(): Boolean {
        var estaVacia = true
        for(i in listaProductos){
            if(i != null){
                estaVacia = false
                break
            }
        }
        return estaVacia
    }

    /**
     * función que sirve para introducir una cantidad de producto válida
     * @return la opcion válida
     */
    fun introducirCantidadProducto(): Int {
        var cantidadProducto = ""
        do {
            try {
                cantidadProducto = readln().trim()
                cantidadProductoValida(cantidadProducto)
            } catch (e: Exception) {
                println(e.message)
                cantidadProducto = ""
            }
        } while (cantidadProducto == "")
        return cantidadProducto.toInt()
    }

    /**
     * función que sirve para validar la cantidad de producto introducida por teclado
     * @param cantidadProducto lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    fun cantidadProductoValida(cantidadProducto: String?): Boolean {
        require(cantidadProducto != null){"${Colores.RED.color}La cantidad de producto introducida no puede ser nula, vuelve a probar:"}
        val regex = Regex("-?[0-9]+")
        require(cantidadProducto!!.matches(regex)){"${Colores.RED.color}La cantidad de producto introducida no es válida, porque no has introducido un número, vuelve a probar:"}
        require(cantidadProducto.toInt() in 1..10 || cantidadProducto.toInt() in -10..-1){"${Colores.RED.color}No has elegido una de las cantidad de producto posible, debe estar entre 1 y 10, vuelve a probar:"}
        return true
    }

    /**
     * función que sirve para introducir un nombre de producto válido
     * @return el nombre del producto introducido por teclado
     */
    fun introducirNombreProducto(): String {
        var nombre = ""
        do {
            try {
                nombre = readln().trim().lowercase()
                nombreValido(nombre)
            } catch (e: Exception) {
                println(e.message)
                nombre = ""
            }
        } while (nombre == "")
        return nombre
    }

    /**
     * función que sirve para validar el nombre del producto introducido por teclado
     * @param nombre lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    fun nombreValido(nombre: String?): Boolean {
        require(nombre != null) { "${Colores.RED.color}El nombre introducido no puede ser nulo, vuelve a probar:" }
        require(nombre.isNotEmpty()) { "${Colores.RED.color}El nombre introducido no puede estar vacio, vuelve a probar:" }
        return true
    }

    /**
     * función que sirve para introducir una opción válida
     * @return la opcion válida
     */
    fun introducirOpcion(): Int {
        var opcion = ""
        do {
            try {
                opcion = readln().trim()
                opcionValida(opcion)
            } catch (e: Exception) {
                println(e.message)
                opcion = ""
            }
        } while (opcion == "")
        return opcion.toInt()
    }

    /**
     * función que sirve para validar la opción introducida por teclado
     * @param opcion lo que queremos validar
     * @throws IllegalArgumentException un mensaje de error en caso de que sea inválido
     * @return true en caso de que sea válido
     */
    fun opcionValida(opcion: String?): Boolean {
        require(opcion != null){"${ModelsCestaDeCompra.Colores.RED.color}La opción no puede ser nula, vuelve a probar:"}
        val regex = Regex("-?[0-9]+")
        require(opcion!!.matches(regex)){"${ModelsCestaDeCompra.Colores.RED.color}La opción introducida no es válida, vuelve a probar:"}
        require(opcion.toInt() in 1..2){"${ModelsCestaDeCompra.Colores.RED.color}No has elegido una de las opciones posibles, vuelve a probar:"}
        return true
    }
}