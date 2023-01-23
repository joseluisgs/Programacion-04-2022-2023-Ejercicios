package models

class Electricista(nombre: String, aniosExp: Int, horasDiarias: Int) : Trabajador(nombre, aniosExp, horasDiarias), iElectricista{

    fun Electricista(nombre: String, aniosExp: Int, horasDiaras: Int) {
        this.nombre = nombre
        this.aniosExp = aniosExp
        this.horasDiarias = horasDiaras
    }

    override fun comer() {
        println("Electricista: Hola! soy $nombre y estoy comiendo")
    }

    override fun arreglarElectricidad(){
        println("Electricista: Estoy arreglando los circuitos eléctricos")
    }

    override fun toString(): String {
        return "Electricista ($nombre con $aniosExp años de experiencia trabaja $horasDiarias horas al dia)"
    }

}