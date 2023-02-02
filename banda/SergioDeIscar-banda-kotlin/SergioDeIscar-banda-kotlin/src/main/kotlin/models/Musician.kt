package bandamusical.models

abstract class Musician(nombre:String): Persona(nombre) {
    open val salario: Float = 1500.0f
    abstract val experiencia: Int
    fun interpretar() {
        println("El músico $nombre interpreter")
    }
    override fun respirar() {
        println("El músico $nombre respira.")
    }
}