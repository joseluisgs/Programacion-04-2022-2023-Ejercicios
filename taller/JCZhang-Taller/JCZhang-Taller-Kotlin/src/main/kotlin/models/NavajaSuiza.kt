package models

class NavajaSuiza(nombre: String, aniosExp: Int, horasDiarias: Int) : Trabajador(nombre, aniosExp, horasDiarias), iChapista, iElectricista{


    fun NavajaSuiza(nombre: String, aniosExp: Int, horasDiarias: Int){
        this.nombre = nombre
        this.aniosExp = aniosExp
        this.horasDiarias = horasDiarias
    }


    override fun saludar() {
        println("Navaja Suiza: Hola! Soy la navaja suiza y puedo hacer tanto de chapista como de electricista ")
    }

    override fun toString(): String {
        return "Navaja Suiza( $nombre con $aniosExp años de experiencia trabaja $horasDiarias horas al dia)"
    }

    override fun arreglarElectricidad() {
        println("Navaja Suiza: Estoy arreglando los circuitos eléctricos")
    }

    override fun arreglarChapa() {
        println("Navaja Suiza: Estoy arreglando la chapa")
    }
}