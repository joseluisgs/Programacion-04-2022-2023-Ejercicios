import Aparcamiento.colores
import Aparcamiento.menuAparcarCoche
import Aparcamiento.imprimirLista
import Aparcamiento.imprimirListaCompleta
import Aparcamiento.imprimirParking
import Aparcamiento.listaClientes
import Aparcamiento.listaCoches
import Aparcamiento.menuDatosSitios
import Aparcamiento.menuOrdenCoches
import Aparcamiento.parking
import Aparcamiento.recaudacion
import Aparcamiento.sacarCoche

fun main() {

    var resp: String
    val respRegex = Regex("[1-9]")

    do {
        imprimirParking(parking)
        println()
        println("\n${colores.azul}1.${colores.reset}\tVer lista de clientes y sus coches")
        println("${colores.azul}2.${colores.reset}\tVer lista de clientes")
        println("${colores.azul}3.${colores.reset}\tVer lista de coches")
        println("${colores.azul}4.${colores.reset}\tVer lista de coches ordenada")
        println("${colores.azul}5.${colores.reset}\tVer recaudación actual del parking")
        println("${colores.azul}6.${colores.reset}\tAparcar un coche")
        println("${colores.azul}7.${colores.reset}\tSacar un coche")
        println("${colores.azul}8.${colores.reset}\tComprobar datos de las plazas")
        println("${colores.azul}9.${colores.reset}\tSalir")

        print("\n${colores.verde}Seleccione una acción:${colores.reset} ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("${colores.rojo}Seleccione una acción válida:${colores.reset} ")
            resp = readln()
        }

        when (resp) {
            "1" -> imprimirListaCompleta()
            "2" -> imprimirLista(listaClientes as Array<Any?>)
            "3" -> imprimirLista(listaCoches as Array<Any?>)
            "4" -> menuOrdenCoches()
            "5" -> println("\n${colores.morado}Se han recaudado $recaudacion€${colores.reset}")
            "6" -> menuAparcarCoche()
            "7" -> sacarCoche()
            "8" -> menuDatosSitios()
        }

    } while (resp != "9")

    println("\nCerrando programa...")

}