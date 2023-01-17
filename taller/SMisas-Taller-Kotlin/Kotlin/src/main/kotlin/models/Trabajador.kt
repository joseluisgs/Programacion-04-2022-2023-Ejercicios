package models

// Hereda de Persona
open class Trabajador(
    override val nombre: String,
    override val experiencia: Int,
    override val salario: Double = 1200.00,
    open val horasDiarias: Int = 8
) :
    Persona(nombre, experiencia, salario) {

    /**
     * Saluda diciendo su nombre de forma respetuosa
     */
    override fun saludar() {
        println("Buenos días, me llamo $nombre")
    }

    /**
     * Imprime un mensaje del trabajador haciendo su trabajo, que es trabajar
     */
    fun trabajar() {
        println("$nombre está trabajando")
    }

    /**
     * Imprime un mensaje del trabajador descansando
     */
    open fun descansar() {
        println("$nombre está descansando")
    }

    // Esta función va a ser heredada por la clase electricista que es la que
    // la va a utilizar
    open fun comer() {}

}