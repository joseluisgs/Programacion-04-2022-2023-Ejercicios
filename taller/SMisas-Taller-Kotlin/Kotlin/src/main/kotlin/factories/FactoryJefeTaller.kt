package factories

import models.JefeTaller

// Una fábrica de jefes de taller
class FactoryJefeTaller {

    companion object {
        /**
         * Una fábrica de jefes de taller que desprecian a sus trabajadores
         * @param nombre el nombre de la persona
         * @param experiencia los años de experiencia del jefe
         * @param personasACargo el número de personas de las que se encarga
         * @return un objeto JefeTaller
         */
        fun createJefeTaller(nombre: String, experiencia: Int, personasACargo: Int): JefeTaller {
            return JefeTaller(nombre,experiencia,2500.00, personasACargo)
        }
    }
}