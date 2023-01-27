package simulacionParking.factories

import simulacionParking.models.Conductor
import java.util.*

class ConductorFactory {

    /**
     * Clase static para auto incrementar el ID, cada vez que creemos un objeto
     */
    object IdGenerator {
        /**
         * Campo de clase para mantener el incremento
         */
        var nextId = 1

        /**
         * Cuando llamemos a la clase y su método único, aumentará nuestro ID
         *
         * @return nextId aumentado
         */
        fun getNextID(): Int {
            return nextId++
        }
    }

    companion object {
        /**
         * Creación de un objeto Conductor aleatorio
         *
         * @return conductorAleatorio
         */
        fun create(): Conductor {
            val nombre = generarNombre()
            val DNI = generacionDNI()
            val ownerVehicles = VehiculoFactory.generacionAlmacenVehiculos()

            // Lo único por defecto es la cantidad de coches aparcados que iremos incrementando después
            return Conductor(IdGenerator.getNextID(), nombre, DNI, ownerVehicles, 0)
        }

        /**
         * Genera de manera aleatoria un nombre dentro de nuestro catálogo
         *
         * @return catalogoNombre[num], es el nombre aleatorio
         */
        fun generarNombre(): String {
            val r = Random()
            val num = r.nextInt(7)
            val catalogoNombres =
                arrayOf("Pedro", "Alexandra", "Angel", "José", "Elena", "Ricardo", "Domingo", "Patricia")
            return catalogoNombres[num]
        }

        /**
         * Genera de manera aleatoria un DNI, corresponde a 9 números y 1 letra
         *
         * @return DNI
         */
        fun generacionDNI(): String {
            val alfabetoDNI = "TRWAGMYFPDXBNJZSQVHLCKE"

            // DNI completo
            val DNI = StringBuilder()
            for (i in 0..8) {
                // Genera un número entre 0 y 22 (incluidos)
                val r = Random()
                val num = r.nextInt(9)
                DNI.append(num)
            }
            val r = Random()
            val num = r.nextInt(23)
            DNI.append(alfabetoDNI[num])
            return DNI.toString()
        }
    }
}