//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Chapista
import kotlin.math.round

object ChapistaFactory {
    var contador: Int = 0
    var nominaChapistas: Double = round(0.0)

    fun crearChapista(): Chapista {
        contador++
        nominaChapistas += 1700
        return Chapista(nombres.random(), experiencia.random(), horasTrabajadas.random())
    }
}