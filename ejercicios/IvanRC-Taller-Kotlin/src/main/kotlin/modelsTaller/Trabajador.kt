package modelsTaller

open class Trabajador(nombre: String, experiencia: Int, val horasDiarias: Int): Persona(nombre, experiencia) {

    override fun saludar(){
        println("Hola jefe, como está el día de hoy *amable*")
    }

    open fun comer(){
        println("Soy el trabajador $nombre y estoy comiendo...")
    }

    open fun trabajar() {
        println("Soy el trabajador $nombre y estoy trabajando...")
    }

    open fun descansar() {
        println("Soy el trabajador $nombre y estoy descansando...")
    }

    override fun toString(): String {
        return "Soy un trabajador, me llamo $nombre, tengo un total de $añosExperiencia años de experiencia, mi id es: $id y trabajo un total de $horasDiarias horas al día"
    }

}