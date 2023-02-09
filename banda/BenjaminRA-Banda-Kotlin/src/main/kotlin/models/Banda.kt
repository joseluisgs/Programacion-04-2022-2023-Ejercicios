package models

import factory.*
import kotlin.math.round

class Banda() {
    /*Se crea un array de músicos de tamaño: 50 empezando como nulos*/
    val tamañoBanda = 50
    val arrayBanda: Array<Musico?> = Array(tamañoBanda) { null }
    fun empezar() {
        crearBanda(arrayBanda)
        salarios()
        println("El salario total es de: ${calcularSalarioTotal()}")
    }
    /*Creación de músicos con sus respectivos porcentajes usando un when.*/
    fun crearBanda(arrayBanda: Array<Musico?>) {
        for (i in arrayBanda.indices) {
            var random = (1..100).random()
            arrayBanda[i] = when (random) {
                in 1..5 -> TrompetistaFactory.crearTrompetista()
                in 6..25 -> CantanteFactory.crearCantante()
                in 26..45 -> GuitarristaFactory.crearGuitarrista()
                in 46..55 -> BajistaFactory.crearBajista()
                in 56..65 -> TeclistaFactory.crearTeclista()
                in 66..80 -> PercusionistaFactory.crearPercusionista()
                in 81..95 -> CantanteyGuitarristaFactory.crearCantanteyGuitarrista()
                in 96..100 -> MultinstrumentalFactory.crearMultinstriumental()
                else -> {
                    null
                }
            }
        }
    }
    /*Lista de todos los músicos, cantidad de estos y el salario que les corresponde.*/
    fun salarios() {
        println("""
        |Bajistas: ${BajistaFactory.contadorBajistas} Cobran en total: ${BajistaFactory.contadorBajistas * 1950}€
        |Cantantes: ${CantanteFactory.contadorCantantes} Cobran en total: ${CantanteFactory.contadorCantantes * 2100}€
        |Guitarristas: ${GuitarristaFactory.contadorGuitarristas} Cobran en total: ${GuitarristaFactory.contadorGuitarristas * 2025}€
        |Percusionistas: ${PercusionistaFactory.contadorPercusionistas} Cobran en total: ${PercusionistaFactory.contadorPercusionistas * 2025}€
        |Teclistas: ${TeclistaFactory.contadorTeclistas} Cobran en total: ${TeclistaFactory.contadorTeclistas * 1950}€
        |Trompetistas: ${TrompetistaFactory.contadorTrompetistas} Cobran en total: ${TrompetistaFactory.contadorTrompetistas * 1800}€
        |Cantantes y Guitarristas: ${CantanteyGuitarristaFactory.contadorCantantesyGuitarristas} Cobran en total: ${CantanteyGuitarristaFactory.contadorCantantesyGuitarristas * 2250}€
        |Multinstrumentales: ${MultinstrumentalFactory.contadorMultinstrumentales} Cobran en total: ${MultinstrumentalFactory.contadorMultinstrumentales * 2175}€
        |------------------------------------------
    """.trimMargin())
    }
    /*Suma de todos los salarios*/
    fun calcularSalarioTotal(): Double {
        return(calcularSalarioCantante()+
                calcularSalarioBajista()+
                calcularSalarioGuitarrista()+
                calcularSalarioPercusionista()+
                calcularSalarioTeclista()+
                calcularSalarioTrompetista()+
                calcularSalarioCantanteyGuitarrista()+
                calcularSalarioMultinstrumental())

    }
    /*Calculos de todos los salarios por separado*/
    fun calcularSalarioBajista(): Double {
        return (round(Bajista.salario * BajistaFactory.contadorBajistas))
    }
    fun calcularSalarioCantante(): Double {
        return (round(Cantante.salario * CantanteFactory.contadorCantantes))
    }
    fun calcularSalarioGuitarrista(): Double {
        return (round(Guitarrista.salario * GuitarristaFactory.contadorGuitarristas))
    }
    fun calcularSalarioPercusionista(): Double {
        return (round(Percusionista.salario * PercusionistaFactory.contadorPercusionistas))
    }
    fun calcularSalarioTeclista(): Double {
        return (round(Teclista.salario * TeclistaFactory.contadorTeclistas))
    }
    fun calcularSalarioTrompetista(): Double {
        return (round(Trompetista.salario * TrompetistaFactory.contadorTrompetistas))
    }
    fun calcularSalarioMultinstrumental(): Double {
        return (round(Multinstrumental.salario * MultinstrumentalFactory.contadorMultinstrumentales))
    }
    fun calcularSalarioCantanteyGuitarrista(): Double {
        return (round(CantanteyGuitarrista.salario * CantanteyGuitarristaFactory.contadorCantantesyGuitarristas))
    }
}