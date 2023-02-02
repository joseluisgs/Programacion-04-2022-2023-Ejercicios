//Mario Bueno López
//maarioo2525@gmail.com

package factories

import models.Multiinstrumentista

object MultiinstrumentistaFactory {
    var contador: Int = 0
    fun crearMultiinstrumentista(): Multiinstrumentista {
        contador++
        return Multiinstrumentista(nombres.random(), experiencia.random(), teclas.random(), tipoDePercusion.random(), cuerdas.random())
    }
}
