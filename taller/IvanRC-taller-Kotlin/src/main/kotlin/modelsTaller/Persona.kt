package modelsTaller

interface IJefeTaller{
    fun saludar(){
        println("Jajajaja, hola empleado, soy tu jefe *derrogatorio*")
    }

    fun darLatigazos()

    fun pagar(){
        println("Hola, empleado, te pago *tristeza*")
    }
}

interface ITrabajador{
    fun saludar(){
        println("Hola jefe, como está el día de hoy *amable*")
    }

    fun comer()

    fun trabajar()

    fun descansar()
}

interface IChapista{
    fun comer()

    fun trabajar()

    fun descansar()
}

interface IElectricista{
    fun comer()

    fun trabajar()

    fun descansar()
}


sealed class Persona(val nombre: String, val añosExperiencia: Int) {
    val id = nextId()

    companion object{
        var contador = 1
        fun nextId(): Int{
            return contador++
        }
    }
    class JefeTaller(nombre: String, experiencia: Int, val personasACargo: Int): Persona(nombre, experiencia), IJefeTaller{
        override fun toString(): String {
            return "Soy un jefe de taller, me llamo $nombre, tengo un total de $añosExperiencia años de experiencia, mi id es: $id y tengo a mi cargo a $personasACargo personas"
        }

        override fun darLatigazos(){
            println("*Pum* Soy tu jefe $nombre y te pego...")
        }
    }
    open class Trabajador(nombre: String, experiencia: Int, val horasDiarias: Int): Persona(nombre, experiencia), ITrabajador{
        override fun comer(){
            println("Soy el trabajador $nombre y estoy comiendo...")
        }

        override fun trabajar() {
            println("Soy el trabajador $nombre y estoy trabajando...")
        }

        override fun descansar() {
            println("Soy el trabajador $nombre y estoy descansando...")
        }

        override fun toString(): String {
            return "Soy un trabajador, me llamo $nombre, tengo un total de $añosExperiencia años de experiencia, mi id es: $id y trabajo un total de $horasDiarias horas al día"
        }
    }
    class Chapista(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias), IChapista {
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
    class Electricista(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias), IElectricista {
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
    class NavajaSuiza(nombre: String, experiencia: Int, horasDiarias: Int): Trabajador(nombre, experiencia, horasDiarias), IChapista, IElectricista{
        override fun comer(){
            println("Soy el Navaja Suiza $nombre y estoy comiendo...")
        }

        override fun trabajar() {
            println("Soy el Navaja Suiza $nombre y estoy trabajando...")
        }

        override fun descansar() {
            println("Soy el Navaja Suiza $nombre y estoy descansando...")
        }

        override fun toString(): String {
            return "Soy un Navaja Suiza, me llamo $nombre, tengo un total de $añosExperiencia años de experiencia, mi id es: $id y trabajo un total de $horasDiarias horas al día"
        }
    }
}

