package factories

import models.Producto
import models.Usuario
import java.util.*

class ProductoFactory private constructor() {
    val nombre = "Factory de Productos + ${UUID.randomUUID()}"
    companion object {
        // Patrón Singleton
        // donde almaceno la instancia única
        private var instance: ProductoFactory? = null
        fun getInstance(): ProductoFactory {
            if (instance == null) {
                instance = ProductoFactory()
            }
            return instance!!
        }
    }

    fun createProductoRandom(): Producto {
        val listaDeNombres:Array<String> = arrayOf("Nevera","Robot","Lapiz","PS5","Gnomo Jardin","Pelota","Titulo DAM",
            "Piedra","Silla","Pantalla 4K 3DS TGT","Conecta 4 ","Movil","Confesionario portatil","Raqueta_POJO",
            "Caja Carton","Dinosaurio","Vieja en patinete","Libro: Los santos incocentes ","Funko Pop de Abascal",
            "Coleccion Delux Hotel Royal Manzanares","Fax","Muelle","CD:La Biblia narrada por Pablo Motos",
            "Colonoscopio","Amonal","Estampita de San Isicio","Maqueta de un Seat Ibiza","Kit de conectores",
            "Dvd: CSI temporada 342","Pin de Naranjito","Camiseta Proyecto Hombre Talla:L","Acelerador de Neutrinos",
            "Caracoles de Carreras","Juego de Sabanas TMNT","MegaZord","Flauta de Pan","Disfraz Mimo",
            "Repuesto tecla TAB ","Foto del lider de Corea la Buena Firmado","Batarang","Busto de Juan y Medio",
            "Libro Programacion sin portada de animal (Raro)","Monociclo para perros","Dientes de leche seminuevos",
            "Oso peluche con cara de Xi Jinping","Calcetines con la cara de Ayuso","Cd: Grandes exitos Cañita Brava",
            "Bateria 5000mah","Pitufo","Fanfarria","Dvd: Cuentame temporada 34","Pez Disecado con gorra",
            "Brujula","Mono fumador","TBO","Solex original","Compas","Pantalones patrón leopardo","Caja sorpresa",
            "Jaula para Mangostas","Circo de pulgas","Paquete Camel","Pela Patatas","Foto firmada Lina Morgan Freeman",
            "Ruperta","Condensador de fluzo","Je ne se quoi","Caramelo Pilarica","Agua de Lurdes","Bigote mexicano",
            "Peluca Juez Ingles","La vaca mas peqeña del mundo que ladra","El perro mas grande del mundo que hace Muu",
            "Piedra Roseta","Peluche Rodolfo Langostino","Gafas forma genitalia varón","Bolsa Pipas","Tetera","Alf")
        val precioUnitario:Int = (100 until 100000).random()

        return Producto(listaDeNombres.random(),precioUnitario)
    }

    override fun toString(): String {
        return "ProductoFactory(nombre='$nombre')"
    }
}
