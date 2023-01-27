package factories

import models.Chapista

class FactoryChapista {


    companion object {
        /**
         * Crea un chapista
         * @param nombre del trabajador
         * @param experiencia años de experiencia
         * @param horasDiarias número de horas que trabaja al día
         * @return objeto chapista
         */
        fun createChapista(nombre: String, experiencia: Int, horasDiarias: Int): Chapista {
            return Chapista(nombre, experiencia, 1700.00, horasDiarias)
        }
    }
}