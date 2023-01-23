package models


class Chapista(nombre: String, aniosExp: Int, horasDiaras: Int) : Trabajador(nombre, aniosExp, horasDiaras), iChapista {


    fun Chapista(nombre: String, aniosExp: Int, horasDiaras: Int) {
        this.nombre = nombre
        this.aniosExp = aniosExp
        this.horasDiarias = horasDiaras
    }

    override fun comer() {
        println("Chapista: Hola! soy $nombre y estoy comiendo")
    }

    override fun arreglarChapa(){
        println("Chapista: Estoy arreglando chapa")

    }
    override fun toString(): String {
        return "Chapista ($nombre con $aniosExp años de experiencia trabaja $horasDiarias horas al dia)"
    }

}