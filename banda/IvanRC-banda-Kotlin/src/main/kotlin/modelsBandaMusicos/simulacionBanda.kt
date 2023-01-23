package modelsBandaMusicos

fun main(args: Array<String>){
    val banda = Banda(50)

    println("En la banda hay un total de ${banda.arrayMusicos.size} musicos:")
    banda.representarMusicosEnBanda()

    println()

    println("Tropetistas: ${banda.contarTrompetistas()}")
    println("Cantantes: ${banda.contarCantantes()}")
    println("Guitarristas: ${banda.contarGuitarristas()}")
    println("Bajistas: ${banda.contarBajistas()}")
    println("Teclistas: ${banda.contarTeclistas()}")
    println("Percusionistas: ${banda.contarPercusionistas()}")
    println("CantantesGuitarristas: ${banda.contarCantantesGuitarristas()}")
    println("Multinstrumentales: ${banda.contarMultinstrumentales()}")

    println()

    println("El salario total es: ${banda.hallarSalarioTotal()}")
}