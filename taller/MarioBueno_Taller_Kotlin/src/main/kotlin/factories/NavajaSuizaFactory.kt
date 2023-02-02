//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.NavajaSuiza
import kotlin.math.round

object NavajaSuizaFactory {
    var nominaNavajaSuiza: Double = round(0.0)
    var contador: Int = 0

    fun crearNavajaSuiza(): NavajaSuiza {
        nominaNavajaSuiza += 2000
        contador++
        return NavajaSuiza(nombres.random(), experiencia.random(), horasTrabajadas.random())
    }
}