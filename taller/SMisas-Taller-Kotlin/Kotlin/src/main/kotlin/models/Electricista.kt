package models

// Hereda de Trabajador que a su vez hereda de Persona
class Electricista(
    override val nombre: String, override val experiencia: Int,
    override val salario: Double = 1800.00, override val horasDiarias: Int
) :
    Trabajador(nombre, experiencia, salario, horasDiarias) {

    /**
     * Imprime un mensaje del electricista comiendo su comida favorita
     */
    override fun comer() {
        println("Soy $nombre y como cables y amperios")
    }

    /**
     * Imprime un mensaje del electricista haciendo su trabajo
     */
    fun arreglarElectricidad() {
        println("$nombre te arregla la eléctrica el coche")
    }


}