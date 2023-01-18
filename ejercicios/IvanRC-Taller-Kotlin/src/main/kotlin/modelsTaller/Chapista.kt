package modelsTaller

class Chapista(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias) {

    override fun comer(){
        println("Soy el chapista $nombre y estoy comiendo...")
    }

    override fun trabajar() {
        println("Soy el chapista $nombre y estoy trabajando...")
    }

    override fun descansar() {
        println("Soy el chapista $nombre y estoy descansando...")
    }

    override fun toString(): String {
        return "Soy un chapista, me llamo $nombre, tengo un total de $añosExperiencia años de experiencia, mi id es: $id y trabajo un total de $horasDiarias horas al día"
    }
}