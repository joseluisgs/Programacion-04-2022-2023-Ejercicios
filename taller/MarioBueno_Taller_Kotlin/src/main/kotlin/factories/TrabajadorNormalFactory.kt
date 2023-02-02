//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.TrabajadorNormal
import kotlin.math.round

object TrabajadorNormalFactory {
    var nominaTrabajadorNormal: Double = round(0.0)
    var contador: Int = 0

    fun crearTrabajadorNormal(): TrabajadorNormal {
        contador++
        nominaTrabajadorNormal += 1200
        return TrabajadorNormal(nombres.random(), experiencia.random(), horasTrabajadas.random())
    }
}