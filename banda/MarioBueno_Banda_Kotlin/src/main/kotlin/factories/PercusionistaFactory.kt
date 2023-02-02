//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Percusionista

object PercusionistaFactory {
    var contador: Int = 0
    fun crearPercusionista(): Percusionista {
        contador++
        return Percusionista(nombres.random(), experiencia.random(), tipoDePercusion.random())
    }
}