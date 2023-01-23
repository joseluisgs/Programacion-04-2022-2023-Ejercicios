package taller.models

open class Electricista(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias) {
    override val salario: Int = 1800
    override fun comer() {
        println("El trabajador electricista $nombre come.")
    }

    override fun toString(): String {
        return "Electricusta -> Nombre: $nombre, Experiencia: $experiencia, Horas diarias: $horasDiarias, Salario: $salario"
    }
}