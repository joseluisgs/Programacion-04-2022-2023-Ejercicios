//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.JefeDeTaller
import kotlin.math.round

object JefeDeTallerFactory {
    var contador: Int = 0
    var nominaJefeDeTaller: Double = round(0.0)

    fun crearJefeDeTaller(): JefeDeTaller {
        nominaJefeDeTaller += 2500
        contador ++
        return JefeDeTaller(nombres.random(), experiencia.random())
    }
}