//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Bajista

object BajistaFactory {
    var contador: Int = 0
    fun crearBajista(): Bajista {
        contador++
        return Bajista(nombres.random(), experiencia.random(), cuerdas.random())
    }
}