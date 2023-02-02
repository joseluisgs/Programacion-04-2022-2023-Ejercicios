//Mario Bueno López
//maarioo2525@gmail.com

package models

import factories.*

class Banda(maxSize: Int) {
    private var banda = arrayOfNulls<Musico>(maxSize)
    private var probabilidad = 1..100
    var random = 0
    init {
        for (i in banda.indices) {
            random = probabilidad.random()
            banda[i] = when (random){
                in 1..5 -> TrompetistaFactory.crearTrompetista()
                in 6..25 -> CantanteFactory.crearCantante()
                in 26..45 -> GuitarristaFactory.crearGuitarrista()
                in 46..55 -> BajistaFactory.crearBajista()
                in 56..65 -> PianistaFactory.crearPianista()
                in 66..80 -> PercusionistaFactory.crearPercusionista()
                in 81..95 -> CantanteGuitarristaFactory.crearCantanteGuitarrista()
                in 96..100  -> MultiinstrumentistaFactory.crearMultiinstrumentista()
                else -> null
            }
        }
    }

    fun contarMusicos() {
        println("""
            |
            |Hay ${TrompetistaFactory.contador} trompetistas
            |Hay ${CantanteFactory.contador} cantantes
            |Hay ${GuitarristaFactory.contador} guitarristas
            |Hay ${BajistaFactory.contador} bajistas
            |Hay ${PianistaFactory.contador} pianistas
            |Hay ${PercusionistaFactory.contador} percusionistas
            |Hay ${CantanteGuitarristaFactory.contador} músicos que tocan la guitarra y cantan
            |Hay ${MultiinstrumentistaFactory.contador} músicos que tocan el bajo, el piano y percusión
            |
        """.trimMargin())
    }

    fun salarios () {
        println("""
            |
            |Cada Trompetista cobra ${Trompetista.salario} €, hay ${TrompetistaFactory.contador} Trompetistas, en total cobran ${TrompetistaFactory.contador * Trompetista.salario} €
            |Cada Cantante cobra ${Cantante.salario} €, hay ${CantanteFactory.contador} Cantantes, en total cobran ${TrompetistaFactory.contador * Trompetista.salario} €
            |Cada Guitarrista cobra ${Guitarrista.salario} €, hay ${GuitarristaFactory.contador} Guitarristas, en total cobran ${GuitarristaFactory.contador * Guitarrista.salario} €
            |Cada Bajista cobra ${Bajista.salario} €, hay ${BajistaFactory.contador} Bajistas, en total cobran ${BajistaFactory.contador * Bajista.salario} €
            |Cada Pianista cobra ${Pianista.salario} €, hay ${PianistaFactory.contador} Pianistas, en total cobran ${PianistaFactory.contador * Pianista.salario} €
            |Cada Percusionista cobra ${Percusionista.salario} €, hay ${PercusionistaFactory.contador} Trompetistas, en total cobran ${PercusionistaFactory.contador * Percusionista.salario} €
            |Cada Músico que toca la guitarra y canta cobra ${CantanteGuitarrista.salario} €, hay ${CantanteGuitarristaFactory.contador} de estos músicos, en total cobran ${CantanteGuitarristaFactory.contador * CantanteGuitarrista.salario} €
            |Cada Músico que toca el bajo, el piano y la percusión cobra ${Multiinstrumentista.salario} €, hay ${MultiinstrumentistaFactory.contador} de estos músicos, en total cobran ${MultiinstrumentistaFactory.contador * Multiinstrumentista.salario} €
            |
            |Esta banda cobra en total ${TrompetistaFactory.contador * Trompetista.salario + TrompetistaFactory.contador * Trompetista.salario + GuitarristaFactory.contador * Guitarrista.salario + BajistaFactory.contador * Bajista.salario + PianistaFactory.contador * Pianista.salario + PercusionistaFactory.contador * Percusionista.salario + CantanteGuitarristaFactory.contador * CantanteGuitarrista.salario + MultiinstrumentistaFactory.contador * Multiinstrumentista.salario} €
        """.trimMargin())
    }
}