package modelsTaller

class Electricista(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias) {

    override fun comer(){
        println("Soy el electricista $nombre y estoy comiendo...")
    }

    override fun trabajar() {
        println("Soy el electricista $nombre y estoy trabajando...")
    }

    override fun descansar() {
        println("Soy el electricista $nombre y estoy descansando...")
    }

    override fun toString(): String {
        return "Soy un electricista, me llamo $nombre, tengo un total de $añosExperiencia años de experiencia, mi id es: $id y trabajo un total de $horasDiarias horas al día"
    }
}