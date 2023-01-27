package factories

import models.Persona
import utils.*

// Esta clase sirve para crear talleres
class FactoryPersona {

    companion object {
        /**
         * Crea un objeto persona inicializado
         * @return una persona con su ocupación
         */
        fun createPersona(): Persona {
            // Se realiza una tirada por cada iteración de bucle para decidir que objeto se va a crear
            val numeroAleatorio = (1..10).random()
            // Cada parámetro viene dado por el valor aleatorio de los rangos y arrays escritos en la carpeta utils
            return when {
                numeroAleatorio == 1 -> FactoryJefeTaller.createJefeTaller(
                    nombres.random(),
                    experienciaDelJefe.random(),
                    trabajadoresACargo.random()
                )

                numeroAleatorio == 2 -> FactoryElectricista.createElectricista(
                    nombres.random(),
                    experienciaDelTrabajador.random(),
                    horasAlDia.random()
                )

                (numeroAleatorio in 3..5) -> FactoryChapista.createChapista(
                    nombres.random(),
                    experienciaDelTrabajador.random(),
                    horasAlDia.random()
                )

                else -> FactoryTrabajador.createTrabajador(
                    nombres.random(),
                    experienciaDelTrabajador.random(),
                    horasAlDia.random()
                )

            }
        }
    }
}