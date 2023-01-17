package factories

import models.Electricista

class FactoryElectricista {
    companion object {
        /**
         * Crea un electricista
         * @param nombre del trabajador
         * @param experiencia años de experiencia
         * @param horasDiarias número de horas que trabaja al día
         * @return objeto electricista
         */
        fun createElectricista(nombre: String, experiencia: Int, horasDiarias: Int): Electricista {
            return Electricista(nombre, experiencia, 1800.00, horasDiarias)
        }
    }
}