package modelsTaller

fun main(){

    val taller = Taller(50)

    println("Las personas del taller son:")
    taller.representarListaPersonas()

    println()

    println("La nómina total en el taller es: ${taller.calcularNominaTotal()}€")

    println()

    val numeroPersonas = taller.arrayTaller.size
    val jefesTaller = taller.calcularNumeroDeJefesTaller()
    val trabajadores = taller.calcularNumeroDeTrabajadores()
    val chapistas = taller.calcularNumeroDeChapistas()
    val electricistas = taller.calcularNumeroDeElectricistas()

    println("En el taller hay un total de $numeroPersonas personas:")
    println("Un total de $jefesTaller son jefes de taller")
    println("Y el resto (${numeroPersonas-jefesTaller}), son:")
    println("$trabajadores trabajadores")
    println("$chapistas chapistas")
    println("$electricistas electricistas")
}
