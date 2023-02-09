//Mario Bueno López
//maarioo2525@gmail.com

package models

class TrabajadorNormal(nombre: String, experiencia: Int, horasDiarias: Int ): Trabajador(nombre, experiencia, horasDiarias) {
    override fun trabajar() {
        println("Me llamo $nombre y estoy trabajando")
    }
}