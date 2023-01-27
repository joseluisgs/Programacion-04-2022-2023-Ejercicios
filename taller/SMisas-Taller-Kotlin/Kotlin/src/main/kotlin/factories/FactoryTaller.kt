package factories

import models.Persona

// Esta clase sirve para crear talleres
class FactoryTaller {

    companion object {

        /**
         * Crea un array de personas de forma automatizada con probabilidades
         * @param numeroTrabajadores el número de personas que van a trabajar en el taller
         * @return array de personas que representa el taller
         */
        fun createTaller(numeroTrabajadores: Int = 50): Array<Persona> {
            return Array(numeroTrabajadores) { FactoryPersona.createPersona() }
        }
    }
}