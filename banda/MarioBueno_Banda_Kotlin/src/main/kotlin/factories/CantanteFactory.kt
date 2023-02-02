//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Cantante

object CantanteFactory {
    var contador: Int = 0
    fun crearCantante(): Cantante {
        contador++
        return Cantante(nombres.random(), experiencia.random(), tono.random())
    }
}