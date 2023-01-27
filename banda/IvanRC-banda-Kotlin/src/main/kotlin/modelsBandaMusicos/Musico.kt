package modelsBandaMusicos

open class Musico(nombre: String, var salario: Double = 1500.00, val añosExperiencia: Int): Persona(nombre) {
    fun interpretar(){
        println("Músico: Soy $nombre y estoy interpretando...")
    }
}