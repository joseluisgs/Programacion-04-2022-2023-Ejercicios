package models

// Hereda de Persona aunque es cuestionable
class JefeTaller(override val nombre: String,override val experiencia: Int,override val salario: Double = 2500.00, val personasACargo: Int) :
    Persona(nombre, experiencia, salario) {

    /**
     * Imprime un mensaje del jefe explotando y agrediendo a sus trabajadores
     */
    fun darLatigazos() {
        println("$nombre da latigazos")
    }

    /**
     * El jefe saluda de forma ruda e irrespetuosa
     */
    override fun saludar() {
        println("Me llamo $nombre, ponte a trabajar, YA!")
    }

    /**
     * El jefe hace lo que menos le gusta hacer, pagar a sus trabajadores
     */
    fun pagar() {
        println("Toma tu sucio dinero")
    }
}