package factories

import models.Persona
import utils.*

// Esta clase sirve para crear talleres
class FactoryTaller {

    companion object {
        //Pongo esto para que quede más bonito en la salida, tonterías variar

        /**
         * Proceso que muestra un mensaje de inicio de creación del taller
         */
        private fun inicialización() {
            println("Inicializando taller...")
            println()
        }

        /**
         * Crea un array de personas de forma automatizada con probabilidades
         * @param numeroTrabajadores el número de personas que van a trabajar en el taller
         * @return array de personas que representa el taller
         */
        fun createTaller(numeroTrabajadores: Int = 50): Array<Persona?> {
            inicialización()
            val taller: Array<Persona?> = Array<Persona?>(numeroTrabajadores) { null }
            for (persona in taller.indices) {
                // Se realiza una tirada por cada iteración de bucle para decidir que objeto se va a crear
                val numeroAleatorio = (1..10).random()
                // Cada parámetro viene dado por el valor aleatorio de los rangos y arrays escritos en la carpeta utils
                when {
                    numeroAleatorio == 1 -> taller[persona] = FactoryJefeTaller.createJefeTaller(
                        nombres.random(),
                        experienciaDelJefe.random(),
                        trabajadoresACargo.random()
                    )

                    numeroAleatorio == 2 -> taller[persona] = FactoryElectricista.createElectricista(
                        nombres.random(),
                        experienciaDelTrabajador.random(),
                        horasAlDia.random()
                    )

                    (numeroAleatorio in 3..5) -> taller[persona] = FactoryChapista.createChapista(
                        nombres.random(),
                        experienciaDelTrabajador.random(),
                        horasAlDia.random()
                    )

                    (numeroAleatorio in 6..10) -> taller[persona] = FactoryTrabajador.createTrabajador(
                        nombres.random(),
                        experienciaDelTrabajador.random(),
                        horasAlDia.random()
                    )
                }
            }
            return taller
        }
    }
}