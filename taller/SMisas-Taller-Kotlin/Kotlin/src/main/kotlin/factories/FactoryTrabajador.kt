package factories


import models.Trabajador

/**
 * Crea un trabajador sin especialización
 * @param nombre del trabajador
 * @param experiencia años de experiencia
 * @param horasDiarias número de horas que trabaja al día
 * @return objeto trabajador
 */
class FactoryTrabajador {
    companion object {
        fun createTrabajador(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador {
            return Trabajador(nombre, experiencia, 1200.00, horasDiarias)
        }
    }
}