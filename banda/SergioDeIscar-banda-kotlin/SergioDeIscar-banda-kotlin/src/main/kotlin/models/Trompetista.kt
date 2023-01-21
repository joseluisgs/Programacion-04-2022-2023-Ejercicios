package bandamusical.models

class Trompetista(nombre: String,
                  override val experiencia: Int,
                  val capacidadPulmonar: IntRange = 0..15): Musician(nombre) {
    override val salario: Float = super.salario * 1.2f
    override fun respirar() {
        println("El músico trompetista $nombre respira.")
        for (i in capacidadPulmonar){
            println("Coge aire")
        }
    }
}