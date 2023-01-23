package simulacionTaller.utils

import simulacionTaller.models.*
import java.util.*


fun menuWorkShop(workShop: Array<PersonBrench?>) {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("(USUARIO) -> Selecciona la opción deseada: ")
        println()
        println("1: Listar todos los miembros del Taller")
        println("2: Listar Jefes del Taller")
        println("3: Listar todos los trabajadores")
        println("4: Listar todos los chapistas")
        println("5: Listar todos los electricistas")
        println("6: Listar trabajadores no chapistas")
        println("7: Listar trabajadores no electricistas")
        println("8: Listar trabajadores MultiNavajas")
        println("9: Ejecutar simulación del Taller")
        println("0: Salir")
        val option = scanner.nextLine()
        when (option) {
            "1" -> {
                falsoBorradoDeConsola()
                listAllMembers(workShop)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
                break
            }

            "2" -> {
                falsoBorradoDeConsola()
                listBosses(workShop)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "3" -> {
                falsoBorradoDeConsola()
                listAllWorkers(workShop)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "4" -> {
                falsoBorradoDeConsola()
                listPlater(workShop)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "5" -> {
                falsoBorradoDeConsola()
                listElectrician(workShop)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "6" -> {
                falsoBorradoDeConsola()
                listNoPlater(workShop)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "7" -> {
                falsoBorradoDeConsola()
                listNoElectrician(workShop)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "8" -> {
                falsoBorradoDeConsola()
                listMulti(workShop)
                while (!returnToMenu()) {
                    // No saldremos del bucle hasta que introduzcamos "menu"
                }
                falsoBorradoDeConsola()
            }

            "9" -> {
                falsoBorradoDeConsola()
                simulacionTaller(workShop)
                while (!returnToMenu()) {
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

@Throws(InterruptedException::class)
private fun simulacionTaller(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        if (workShop[i] is Boss) {
            val random = (Math.random() * 5 + 1).toInt()
            if (random == 1) {
                println("El jefe " + workShop[i]!!.name + " hoy se ha levantado de mal humor...")
                println((workShop[i] as Boss).lashes())
                println()
                Thread.sleep(2000)
            } else {
                println((workShop[i] as Boss).greetAsBoss())
                Thread.sleep(1500)
                println()
                // Le responden sus trabajadores
                for (j in (workShop[i] as Boss).dependents.indices) {
                    println((workShop[i] as Boss).dependents[j]!!.greet())
                    Thread.sleep(500)
                }
                println()
                (workShop[i] as Boss).printPayWorkers()
                Thread.sleep(1000)
                println()
            }
        }
        if (workShop[i] is Electrician) {
            println("Soy " + workShop[i]!!.name + " electricista")
            Thread.sleep(500)
            println((workShop[i] as Electrician).fixElectrician())
            Thread.sleep(500)
            println((workShop[i] as Electrician).eatAsElectrician())
            Thread.sleep(500)
            println()
        }
        if (workShop[i] is Plater) {
            println("Soy " + workShop[i]!!.name + " chapista")
            Thread.sleep(500)
            println((workShop[i] as Plater).fixPlate())
            Thread.sleep(500)
            println((workShop[i] as Plater).restAsPlater())
            Thread.sleep(500)
            println()
        }
        if (workShop[i] is Multi) {
            println("Soy " + workShop[i]!!.name + " multi-navajas")
            Thread.sleep(500)
            println((workShop[i] as Multi).fixPlate())
            Thread.sleep(500)
            println((workShop[i] as Multi).restAsPlater())
            Thread.sleep(500)
            println((workShop[i] as Multi).fixElectrician())
            Thread.sleep(500)
            println((workShop[i] as Multi).eatAsElectrician())
            Thread.sleep(500)
            println()
        }
        if (workShop[i] is Worker && workShop[i] !is Plater && workShop[i] !is Electrician && workShop[i] !is Multi) {
            println("Soy " + workShop[i]!!.name + " trabajador normal")
            Thread.sleep(500)
            val random = (Math.random() * 4 + 1).toInt()
            if (random == 1) {
                println((workShop[i] as Worker).restAsWorker())
                Thread.sleep(500)
                println()
            } else {
                println((workShop[i] as Worker).work())
                Thread.sleep(500)
                println()
            }
        }
    }
    println("FIN SIMULACION")
}

/**
 * Lista todos los multi del Taller
 *
 * @param workShop el almacén donde se encuentran todos los miembros
 */
private fun listMulti(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        if (workShop[i] is Multi) {
            println(workShop[i])
        }
    }
}

/**
 * Lista todos los trabajadores no electricistas del Taller
 *
 * @param workShop el almacén donde se encuentran todos los miembros
 */
private fun listNoElectrician(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        if (workShop[i] !is Plater && workShop[i] !is Boss) {
            println(workShop[i])
        }
    }
}

/**
 * Lista todos los trabajadores no chapistas del Taller
 *
 * @param workShop el almacén donde se encuentran todos los miembros
 */
private fun listNoPlater(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        if (workShop[i] !is Plater && workShop[i] !is Boss) {
            println(workShop[i])
        }
    }
}

/**
 * Lista todos los electricistas del Taller
 *
 * @param workShop el almacén donde se encuentran todos los miembros
 */
private fun listElectrician(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        if (workShop[i] is Electrician) {
            println(workShop[i])
        }
    }
}

/**
 * Lista todos los chapistas del Taller
 *
 * @param workShop el almacén donde se encuentran todos los miembros
 */
private fun listPlater(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        if (workShop[i] is Plater) {
            println(workShop[i])
        }
    }
}

/**
 * Lista todos los jefes del Taller
 *
 * @param workShop el almacén donde se encuentran todos los miembros
 */
private fun listBosses(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        if (workShop[i] is Boss) {
            println(workShop[i])
        }
    }
}

/**
 * Lista todos los trabajadores del Taller
 *
 * @param workShop el almacén donde se encuentran todos los miembros
 */
private fun listAllWorkers(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        if (workShop[i] is Worker) {
            println(workShop[i])
        }
    }
}

/**
 * Lista todos los miembros del Taller
 *
 * @param workShop el almacén donde se encuentran todos los miembros
 */
private fun listAllMembers(workShop: Array<PersonBrench?>) {
    for (i in workShop.indices) {
        println(workShop[i])
    }
}

/**
 * Permite al usuario volver al menú principal.
 *
 * @return "true" si el usuario ha introducido "menu", "false" en caso contrario.
 */
fun returnToMenu(): Boolean {
    println("Introduzca (menu), para volver al menú principal:")
    val sc = Scanner(System.`in`)
    val entradaDireccionMenu = sc.nextLine().lowercase(Locale.getDefault())
    return entradaDireccionMenu == "menu"
}

/**
 * Crea una sensación de borrado de la consola.
 * Mediante una impresión de varias líneas en blanco.
 */
fun falsoBorradoDeConsola() {
    // Para crear una sensación de borrado en consola
    for (i in 0..39) {
        println()
    }
}
