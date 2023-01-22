package simulacionBandaMusica.utils

import simulacionBandaMusica.enums.Color
import simulacionBandaMusica.models.Musico
import java.util.*

object funcionesMenu {
    /**
     * Menú de la banda de música
     */
    fun menuBandaMusica(banda: Array<Musico?>) {
        while (true) {
            println("(USUARIO) -> Selecciona la opción deseada: ")
            println()
            println(
                "1: Listar banda " +
                        "(músicos de cada tipo y cantantes/guitarristas y multi-instrumentistas) " +
                        "con sus salarios"
            )
            println("2: Calcular mantenimiento banda (salario total)")
            println("0: Salir")
            val sc = Scanner(System.`in`)
            when (sc.nextLine()) {
                "1" -> {
                    falsoBorradoDeConsola()
                    listarBanda(banda)
                    while (!volverAlMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola()
                }

                "2" -> {
                    falsoBorradoDeConsola()
                    println(calcularMantenimientoBanda(banda).toString() + " €")
                    while (!volverAlMenu()) {
                        // No saldremos del bucle hasta que introduzcamos "menu"
                    }
                    falsoBorradoDeConsola()
                }

                "0" -> {
                    falsoBorradoDeConsola()
                    System.exit(0)
                }
            }
        }
    }

    /**
     * Imprime en pantalla toda la banda
     */
    private fun listarBanda(bandaMusicos: Array<Musico?>) {
        println("Con un total de " + Musico.contadorMusic + " músicos:")
        println()
        for (i in bandaMusicos.indices) {
            println(bandaMusicos[i].toString())
        }
    }

    /**
     * Crea una sensación de borrado de la consola.
     * Mediante una impresión de varias líneas en blanco.
     */
    fun falsoBorradoDeConsola() {
        // Para crear una senación de borrado en consola
        for (i in 0..39) {
            println()
        }
    }

    /**
     * Calcula el salario total que costará mantener la banda
     *
     * @param banda donde se encuentran los músicos con sus salarios
     * @return el total del coste de mantenimiento
     */
    fun calcularMantenimientoBanda(banda: Array<Musico?>): Int {
        // Recorremos la banda, y practicamos casteo del polimorfismo
        var salarioTotal = 0
        for (i in banda.indices) {
            if (banda[i] is Musico.Bajista) {
                salarioTotal += (banda[i] as Musico.Bajista?)!!.salarioBajista
            }
            if (banda[i] is Musico.Cantante) {
                salarioTotal += (banda[i] as Musico.Cantante?)!!.salarioCantante
            }
            if (banda[i] is Musico.CantantePro) {
                salarioTotal += (banda[i] as Musico.CantantePro?)!!.salarioCantantePro
            }
            if (banda[i] is Musico.Guitarrista) {
                salarioTotal += (banda[i] as Musico.Guitarrista?)!!.salarioGuitarrista
            }
            if (banda[i] is Musico.MultiInstrumentista) {
                salarioTotal += (banda[i] as Musico.MultiInstrumentista?)!!.salarioMultiInstrumento
            }
            if (banda[i] is Musico.Percusionista) {
                salarioTotal += (banda[i] as Musico.Percusionista?)!!.salarioPercusionista
            }
            if (banda[i] is Musico.Teclista) {
                salarioTotal += (banda[i] as Musico.Teclista?)!!.salarioTeclista
            }
            if (banda[i] is Musico.Trompetista) {
                salarioTotal += (banda[i] as Musico.Trompetista?)!!.salarioTrompetista
            }
        }
        return salarioTotal
    }

    /**
     * Permite al usuario volver al menú principal.
     *
     * @return "true" si el usuario ha introducido "menu", "false" en caso contrario.
     */
    fun volverAlMenu(): Boolean {
        println("Introduzca (${Color.RED_BRIGHT.get()}menu${Color.RESET.get()}), para volver al menú principal:")
        val entradaDireccionMenu: String = readln().lowercase()
        if (entradaDireccionMenu == "menu") {
            return true
        }
        return false
    }
}