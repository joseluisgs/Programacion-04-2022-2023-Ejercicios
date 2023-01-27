package bandamusical

import bandamusical.models.*

fun main(){
    val bandaRandom = MusicianFactory.getInstance().getBandaRandom()
    println("---------------------")
    println("Simulador de banda con 50 músicos:")
    println("---------------------")
    println("Número de músicos: ${countType(bandaRandom, 0)}")
    println("\t-> Número de cantantes: ${countType(bandaRandom, 1)}")
    println("\t-> Número de guitarrista: ${countType(bandaRandom, 2)}")
    println("\t-> Número de bajista: ${countType(bandaRandom, 3)}")
    println("\t-> Número de teclista: ${countType(bandaRandom, 4)}")
    println("\t-> Número de percusionista: ${countType(bandaRandom, 5)}")
    println("\t-> Número de trompetista: ${countType(bandaRandom, 6)}")
    println("\t-> Número de cantanteGuitarrista: ${countType(bandaRandom, 7)}")
    println("\t-> Número de multinstrimentalista: ${countType(bandaRandom, 8)}")
    println("---------------------")
    println("Nomina total de la banda ${calculateNomina(bandaRandom)}€")
    println("---------------------")
    (findFirstType(bandaRandom, 8) as Multinstrumentista).tocarPiano()
    println("---------------------")
    (findFirstType(bandaRandom, 4) as Teclista).tocarPiano()
    println("---------------------")
    (findFirstType(bandaRandom, 1) as Cantante).cantar()
    println("---------------------")
    val cantanteGuitarrista = findFirstType(bandaRandom, 7) as CantanteGuitarrista
    cantanteGuitarrista.cantar()
    cantanteGuitarrista.guitarrear()
    println("---------------------")
}

/*fun mainOld() {
    val bandaRandom = MusicianFactory.getInstance().getBandaRandom()
    println("---------------------")
    println("Simulador de banda con 50 músicos:")
    println("---------------------")
    println("Número de músicos: ${countType<Musician>(bandaRandom)}")
    println("\t-> Número de cantantes: ${countType<Cantante>(bandaRandom)}")
    println("\t-> Número de guitarrista: ${countType<Guitarrista>(bandaRandom)}")
    println("\t-> Número de bajista: ${countType<Bajista>(bandaRandom)}")
    println("\t-> Número de teclista: ${countType<Teclista>(bandaRandom)}")
    println("\t-> Número de percusionista: ${countType<Percusionista>(bandaRandom)}")
    println("\t-> Número de trompetista: ${countType<Trompetista>(bandaRandom)}")
    println("\t-> Número de cantanteGuitarrista: ${countType<CantanteGuitarrista>(bandaRandom)}")
    println("\t-> Número de multinstrimentalista: ${countType<Multinstrumentista>(bandaRandom)}")
    println("---------------------")
    println("Nomina total de la banda ${calculateNomina(bandaRandom)}€")
    println("---------------------")
    (findFirstType<Multinstrumentista>(bandaRandom) as Multinstrumentista).tocarPiano()
    println("---------------------")
    (findFirstType<Teclista>(bandaRandom) as Teclista).tocarPiano()
    println("---------------------")
    (findFirstType<Cantante>(bandaRandom) as Cantante).cantar()
    println("---------------------")
    val cantanteGuitarrista = findFirstType<CantanteGuitarrista>(bandaRandom) as CantanteGuitarrista
    cantanteGuitarrista.cantar()
    cantanteGuitarrista.guitarrear()
    println("---------------------")
}*/

internal fun calculateNomina(banda: Array<Musician>): Float {
    var total = 0.0f
    for (i in banda){
        total += i.salario
    }
    return total
}

/**
 * @param type 0 = Musician, 1 = Cantante, 2 = Guitarrista, 3 = Bajista, 4 = Teclista, 5 = Percusionista, 6 = Trompetista, 7 = CantanteGuitarrista, 8 = Multinstrumentista
 */
internal fun countType(banda: Array<Musician>, type: Int): Int {
    var count = 0
    for (i in banda){
        when(type) {
            1 -> if (i is Cantante) count++
            2 -> if (i is Guitarrista) count++
            3 -> if (i is Bajista) count++
            4 -> if (i is Teclista) count++
            5 -> if (i is Percusionista) count++
            6 -> if (i is Trompetista) count++
            7 -> if (i is CantanteGuitarrista) count++
            8 -> if (i is Multinstrumentista) count++
            else -> count++
        }
    }
    return count
}

internal fun findFirstType(banda: Array<Musician>, type: Int): Musician?{
    for (i in banda.indices){
        when(type) {
            1 -> if (banda[i] is Cantante) return banda[i]
            2 -> if (banda[i] is Guitarrista) return banda[i]
            3 -> if (banda[i] is Bajista) return banda[i]
            4 -> if (banda[i] is Teclista) return banda[i]
            5 -> if (banda[i] is Percusionista) return banda[i]
            6 -> if (banda[i] is Trompetista) return banda[i]
            7 -> if (banda[i] is CantanteGuitarrista) return banda[i]
            8 -> if (banda[i] is Multinstrumentista) return banda[i]
            else -> return banda[i]
        }
    }
    return null
}

/*
internal inline fun <reified Type : Musician> countType(banda: Array<Musician>): Int {
    var count = 0
    for (i in banda){
        if (i is Type) count++
    }
    return count
}

internal inline fun <reified Type : Musician> findFirstType(personas: Array<Musician>): Musician? {
    for (i in personas.indices){
        if (personas[i] is Type)
            return personas[i]
    }
    return null
}*/
