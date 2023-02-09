//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Trompetista

object TrompetistaFactory {
    var contador: Int = 0
    fun crearTrompetista(): Trompetista {
        contador++
        return Trompetista(nombres.random(), experiencia.random(), capacidadPulmonar.random())
    }
}