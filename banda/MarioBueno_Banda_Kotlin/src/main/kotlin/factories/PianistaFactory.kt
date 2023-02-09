//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Pianista

object PianistaFactory {
    var contador: Int = 0
    fun crearPianista(): Pianista {
        contador++
        return Pianista(nombres.random(), experiencia.random(), teclas.random())
    }
}