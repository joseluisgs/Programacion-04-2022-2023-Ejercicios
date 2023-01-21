package taller.models

class Chapista(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias) {
    override val salario: Int = 1700
    override fun comer() {
        println("El trabajador chapista $nombre come.")
    }

    fun arreglarChapa(){
        println("El chapista $nombre esta arreglando la chapa.")
    }
}