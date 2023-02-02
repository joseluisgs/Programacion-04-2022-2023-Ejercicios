//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Electricista
import kotlin.math.round

object ElectricistaFactory {
    var nominaElectricista: Double = round(0.0)
    var contador: Int = 0

    fun crearElectricista(): Electricista {
        contador++
        nominaElectricista += 1800
        return Electricista(nombres.random(), experiencia.random(), horasTrabajadas.random())
    }
}