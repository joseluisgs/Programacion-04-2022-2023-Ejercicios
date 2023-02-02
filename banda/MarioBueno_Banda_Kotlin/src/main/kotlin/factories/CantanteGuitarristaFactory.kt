//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.CantanteGuitarrista

object CantanteGuitarristaFactory {
    var contador: Int = 0
    fun crearCantanteGuitarrista(): CantanteGuitarrista {
        contador++
        return CantanteGuitarrista(nombres.random(), experiencia.random(), tono.random(), tipoDeGuitarra.random())
    }
}