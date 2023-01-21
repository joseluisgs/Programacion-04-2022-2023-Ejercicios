package bandamusical

import bandamusical.models.*

fun main() {
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
    cantanteGuitarrista.gitarrear()
    println("---------------------")
}

private fun calculateNomina(banda: Array<Musician>): Float {
    var total = 0.0f
    for (i in banda){
        total += i.salario
    }
    return total
}

private inline fun <reified Type : Musician> countType(banda: Array<Musician>): Int {
    var count = 0
    for (i in banda){
        if (i is Type) count++
    }
    return count
}

private inline fun <reified Type : Musician> findFirstType(personas: Array<Musician>): Musician? {
    for (i in personas.indices){
        if (personas[i] is Type)
            return personas[i]
    }
    return null
}