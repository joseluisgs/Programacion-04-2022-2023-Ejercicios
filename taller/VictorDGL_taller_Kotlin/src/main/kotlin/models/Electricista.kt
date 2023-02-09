package models

import colores

class Electricista(
    nombre: String,
    apellido: String,
    experiencia: Int
): Trabajador(nombre, apellido, experiencia) {

    override var salario: Int = 1800
    override var horasDiarias: Int = 8
    override lateinit var jefe: JefeTaller

    override fun toString(): String {
        return "${colores.rojo}Electricista${colores.reset} -> " +
                "${colores.morado}id:${colores.reset} $id, " +
                "${colores.morado}nombre:${colores.reset} $nombre $apellido, " +
                "${colores.morado}experiencia:${colores.reset} $experiencia años, " +
                "${colores.morado}salario:${colores.reset} $salario€, " +
                "${colores.morado}horas diarias:${colores.reset} $horasDiarias horas. " +
                "${colores.morado}JEFE:${colores.reset} $jefe"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Electricista) return false
        return this.id == other.id && this.nombre == other.nombre && this.apellido == other.apellido && this.experiencia == other.experiencia && this.salario == other.salario
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun saludar() {
        super.saludar()
    }

    override fun descansar() {
        super.descansar()
    }

    fun arreglarElectricidad() {
        println("El electricista $nombre $apellido está arreglando electricidad...")
    }
}