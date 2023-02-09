package models

import colores
import java.util.UUID

open class Trabajador(
    nombre: String,
    apellido: String,
    experiencia: Int
): Persona(nombre, apellido, experiencia) {

    override var salario: Int = 1200
    open var horasDiarias: Int = 8
    open lateinit var jefe: JefeTaller

    constructor(
        nombre: String,
        apellido: String,
        experiencia: Int,
        jefe: JefeTaller
    ): this(nombre, apellido, experiencia) {
        this.jefe = jefe
    }

    override fun toString(): String {
        return "${colores.rojo}Trabajador${colores.reset} -> " +
                "${colores.morado}id:${colores.reset} $id, " +
                "${colores.morado}nombre:${colores.reset} $nombre $apellido, " +
                "${colores.morado}experiencia:${colores.reset} $experiencia años, " +
                "${colores.morado}salario:${colores.reset} $salario€, " +
                "${colores.morado}horas diarias:${colores.reset} $horasDiarias horas. " +
                "${colores.morado}JEFE:${colores.reset} $jefe"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Trabajador) return false
        return this.id == other.id && this.nombre == other.nombre && this.apellido == other.apellido && this.experiencia == other.experiencia && this.salario == other.salario
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun saludar() {
        super.saludar()
    }

    fun trabajar() {
        println("El trabajador $nombre $apellido está trabajando...")
    }

    open fun descansar() {
        println("El trabajador $nombre $apellido está descansando...")
    }

    fun comer() {
        println("El trabajador $nombre $apellido está comiendo...")
    }
}