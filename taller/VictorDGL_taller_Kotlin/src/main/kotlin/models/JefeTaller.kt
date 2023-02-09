package models

import colores

class JefeTaller(
    nombre: String,
    apellido: String,
    experiencia: Int
):Persona(nombre, apellido, experiencia){
    var personasACargo: Int = 0
    override var salario: Int = 2500
    override fun toString(): String {
        return "${colores.rojo}Jefe de Taller${colores.reset} -> " +
                "${colores.morado}id:${colores.reset} $id, " +
                "${colores.morado}nombre:${colores.reset} $nombre $apellido, " +
                "${colores.morado}experiencia:${colores.reset} $experiencia años, " +
                "${colores.morado}salario:${colores.reset} $salario€, " +
                "${colores.morado}personas a cargo:${colores.reset} $personasACargo personas"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is JefeTaller) return false
        return this.id == other.id && this.nombre == other.nombre && this.apellido == other.apellido && this.experiencia == other.experiencia && this.salario == other.salario
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    fun darLatigazos() {
        println("$nombre $apellido dando latigazos")
    }

    fun pagar(trabajador: Trabajador) {
        println("$nombre $apellido pagando a ${trabajador.nombre} ${trabajador.apellido} su nómina de ${trabajador.salario}€")
    }

    override fun saludar() {
        super.saludar()
    }
}