package models

// Hereda de Trabajador que a su vez hereda de Persona
class Chapista(
    override val nombre: String,
    override val experiencia: Int,
    override val salario: Double = 1700.00,
    override val horasDiarias: Int
) :
    Trabajador(nombre, experiencia, salario, horasDiarias) {

    /**
     * Imprime un mensaje del chapista haciendo su trabajo
     */
    fun arreglarChapa() {
        println("$nombre arregla la chapa de los coches")
    }

    /**
     * Imprime un mensaje del chapista descansando
     */
    override fun descansar() {
        println("$nombre el chapista está descansando")
    }
}