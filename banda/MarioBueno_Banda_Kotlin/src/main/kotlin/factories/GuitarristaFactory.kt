//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Guitarrista

object GuitarristaFactory {
    var contador: Int = 0
    fun crearGuitarrista(): Guitarrista {
        contador++
        return Guitarrista(nombres.random(), experiencia.random(), tipoDeGuitarra.random())
    }
}