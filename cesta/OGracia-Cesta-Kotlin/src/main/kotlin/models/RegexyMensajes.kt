package models

class RegexyMensajes private constructor() {
    companion object {
        // Patrón Singleton
        // donde almaceno la instancia única
        private var instance: RegexyMensajes? = null
        fun getInstance(): RegexyMensajes {
            if (instance == null) {
                instance = RegexyMensajes()
            }
            return instance!!
        }
    }
    val regexEmail= Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
    val regexNombreYPaswword= Regex("^(?=.*[A-Za-z])(?=\\S+\$)[\\d@\$!%*?&A-Za-z]{3,}\$")
    val regexDNI= Regex("^^[0-9]{8}[A-Z]\$")
    val regexMenu09S= Regex("^[0-9]||[S]\$")
    val regexMenu19= Regex("^[1-9]\$")
    val regexMenu110= Regex("^[0-9]||10\$")
    val regex120 = Regex("^[1]?[1-9]||20\$")
    val regex12= Regex("[1-2]")

    val mensajeErrorExcesoAdd ="La cantidad maxima permitida en el carrito es de 10 unidades."
    val mensajeErrorPosicionVacia = "No existe nada en esa posicion"
    val mensajeErrorUltimaPagina = ""
    val mensajeBorrarCesta = "   ¿Que Articulo quieres modificar"
    val mensajeChoiceCantidad= "    Que cantidad quieres agregar Max 10 "
    val mensajeChoiceCantidadDelete=  "    Que cantidad quieres eliminar     "
    val mensajeagregarCesta = "   ¿Que producto deseas agregar a la cesta? Numero entre el 1 y el 9 "
    val mensajeChoiceOption= "  ¿Que quieres hacer? "
    val mensajeCuentaBlock = "Cuenta Bloqueada"
    val mensajeIntroduceDNI = "||   -- Introduce tu DNI --       ||"
    val mensajeNewUsuarioNombre = "||   -- Introduce un nombre de usuario --     " +
                                  "  (longitud minima3 sin Espacios y almenos una letra)  ||"
    val mensajeIntroduceNombre = " Introduce tu usuario "
    val mensajeEspacioRespuesta= "  : "
    val mensajeIntroduceCorreo = "||   -- Introduce tu correo electronico --         ||"
    val mensajeIntroducePassword="||   -- Introduce una contraseña --  " +
            "     (longitud minima3 sin Espacios y almenos una letra)  ||"
    val mensajeMenuLog = arrayOf( "  __________________________",
        "||    Welcome to Amason™    ||",
        "||__________________________||",
        "||    Elige una Opción:     ||",
        "||                          ||",
        "||__________________________||",
        "|   1.-Entrar                |",
        "|   2.-Nuevo Usuario         |",
        "||__________________________||")

    fun printListaProductos(lista:Array<Producto>,cominezoPrint:Int){
        var contador = 0
        val paginaMuestra = Array(10){Pair(0,9)}
        for(i in paginaMuestra.indices){
            val incremento = 10
            val primero = 0
            val segundo = 9
            paginaMuestra[i]= Pair(primero+(incremento*contador),(segundo+(incremento*contador)))
            contador+=1
        }
        contador=0
        for(i in paginaMuestra[cominezoPrint].first until paginaMuestra[cominezoPrint].second){
            contador+=1
            print("$contador.-")
            println(lista[i].toString())
        }
    }
    fun printMensajeMenuLog(mensajeMenu:Array<String>){
        for(i in mensajeMenu.indices){
            println(mensajeMenu[i])
        }
    }
    fun printMensajeWelcome(nombre:String){
        println("   Hola  $nombre Bienvenido a Amason™ de nuevo  ")
        println("------------------------------------------------")
        println("Tenemos una selección de productos para ti:")
        println("")
    }

}