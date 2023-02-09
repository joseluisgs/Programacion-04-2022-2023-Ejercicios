import factories.PlantillaFactory
import models.*
import java.lang.Exception

val colores = Colores()

/**
 * Funcion que muestra por pantalla el menú
 */

fun menu() {

    println("\n---------- GESTIÓN DE LA PLANTILLA DE UN TALLER ----------")
    println("${colores.azul}1.${colores.reset}\tCrear otra plantilla")
    println("${colores.azul}2.${colores.reset}\tVer plantilla entera")
    println("${colores.azul}3.${colores.reset}\tVer plantilla por tipos")
    println("${colores.azul}4.${colores.reset}\tOrdenar plantilla")
    println("${colores.azul}5.${colores.reset}\tVer sumario de nóminas")
    println("${colores.azul}6.${colores.reset}\tDespedir a una persona")
    println("${colores.azul}7.${colores.reset}\tContratar a una persona")
    println("${colores.azul}8.${colores.reset}\tSalir")

}

/**
 * Funcion MENU para elegir el tipo de lista
 * @param plantilla la plantilla del taller
 */

fun menuTipos(plantilla: Array<Persona?>) {

    var resp: String
    var respRegex = Regex("[1-8]")

    do {
        println("\n${colores.azul}1.${colores.reset}\tVer jefes del taller")
        println("${colores.azul}2.${colores.reset}\tVer trabajadores del taller")
        println("${colores.azul}3.${colores.reset}\tVer trabajadores sin especialidad del taller")
        println("${colores.azul}4.${colores.reset}\tVer chapistas del taller")
        println("${colores.azul}5.${colores.reset}\tVer electricistas del taller")
        println("${colores.azul}6.${colores.reset}\tVer trabajadores que no son chapistas del taller")
        println("${colores.azul}7.${colores.reset}\tVer trabajadores que no son electricistas del taller")
        println("${colores.azul}8.${colores.reset}\tVolver atrás")

        print("\n${colores.verde}Seleccione una acción:${colores.reset} ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("${colores.rojo}Seleccione una acción válida:${colores.reset} ")
            resp = readln()
        }

        when (resp) {
            "1" -> verJefes(plantilla)
            "2" -> verTrabajadores(plantilla)
            "3" -> verTrabajadoresSinEspecialidad(plantilla)
            "4" -> verChapistas(plantilla)
            "5" -> verElectricistas(plantilla)
            "6" -> verTrabajadoresNoChapistas(plantilla)
            "7" -> verTrabajadoresNoElectricistas(plantilla)
        }

    } while (resp != "8")

}

/**
 * Funcion MENU para elegir el tipo de ordenación y ver la lista ordenada
 * @param plantilla la plantilla del taller
 */

fun menuOrdenar(plantilla: Array<Persona?>) {

    var resp: String
    var respRegex = Regex("[1-5]")

    do {
        println("\n${colores.azul}1.${colores.reset}\tOrdenar por experiencia de menor a mayor")
        println("${colores.azul}2.${colores.reset}\tOrdenar por experiencia de mayor a menor")
        println("${colores.azul}3.${colores.reset}\tOrdenar por salario de menor a mayor")
        println("${colores.azul}4.${colores.reset}\tOrdenar por salario de mayor a menor")
        println("${colores.azul}5.${colores.reset}\tVolver atrás")

        print("\n${colores.verde}Seleccione una acción:${colores.reset} ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("${colores.rojo}Seleccione una acción válida:${colores.reset} ")
            resp = readln()
        }

        when (resp) {
            "1" -> imprimirPlantilla(ordenarExperiencia(plantilla))
            "2" -> imprimirPlantilla(ordenarExperiencia(plantilla).reversedArray())
            "3" -> imprimirPlantilla(ordenarSalario(plantilla))
            "4" -> imprimirPlantilla(ordenarSalario(plantilla).reversedArray())
        }

    } while (resp != "5")
}

/**
 * Función que ordena la plantilla de menor a mayor por experiencia
 * @param plantilla la plantilla del taller
 * @return la plantilla ordenada por experiencia
 */

fun ordenarExperiencia(plantilla: Array<Persona?>): Array<Persona?> {

    val plantillaOrdenada = plantilla
    var min = 0
    var guardar: Persona?

    for (i in 0 until plantillaOrdenada.size - 1) {
        min = i
        for (j in i+1 until plantillaOrdenada.size) {
            if (plantillaOrdenada[i] != null && plantillaOrdenada[j] != null && plantillaOrdenada[j]!!.experiencia < plantillaOrdenada[min]!!.experiencia) {
                min = j

            }
        }
        guardar = plantillaOrdenada[i]
        plantillaOrdenada[i] = plantillaOrdenada[min]
        plantillaOrdenada[min] = guardar
    }

    return plantillaOrdenada
}

/**
 * Función que ordena la plantilla de menor a mayor por salario
 * @param plantilla la plantilla del taller
 * @return la plantilla ordenada por salario
 */

fun ordenarSalario(plantilla: Array<Persona?>): Array<Persona?> {

    val plantillaOrdenada = plantilla
    var min = 0
    var guardar: Persona?

    for (i in 0 until plantillaOrdenada.size - 1) {
        min = i
        for (j in i+1 until plantillaOrdenada.size) {
            if (plantillaOrdenada[i] != null && plantillaOrdenada[j] != null && plantillaOrdenada[j]!!.salario < plantillaOrdenada[min]!!.salario) {
                min = j
            }
        }
        guardar = plantillaOrdenada[i]
        plantillaOrdenada[i] = plantillaOrdenada[min]
        plantillaOrdenada[min] = guardar
    }

    return plantillaOrdenada
}

/**
 * Función MENU para elegir el tipo de sumatorio de nóminas
 * @param plantilla la plantilla del taller
 */

fun menuNominas(plantilla: Array<Persona?>) {

    var resp: String
    var respRegex = Regex("[1-7]")

    do {
        println("\n${colores.azul}1.${colores.reset}\tVer el sumatorio de las nóminas del taller")
        println("${colores.azul}2.${colores.reset}\tVer el sumatorio de las nóminas de los jefes del taller")
        println("${colores.azul}3.${colores.reset}\tVer el sumatorio de las nóminas de los trabajadores sin especialidad")
        println("${colores.azul}4.${colores.reset}\tVer el sumatorio de las nóminas de los chapistas")
        println("${colores.azul}5.${colores.reset}\tVer el sumatorio de las nóminas de los electricistas")
        println("${colores.azul}6.${colores.reset}\tVer el sumatorio de las nóminas de todos los trabajadores")
        println("${colores.azul}7.${colores.reset}\tVolver atrás")

        print("\n${colores.verde}Seleccione una acción:${colores.reset} ")
        resp = readln()
        while (!respRegex.matches(resp)) {
            print("${colores.rojo}Seleccione una acción válida:${colores.reset} ")
            resp = readln()
        }

        when (resp) {
            "1" -> verSumatorio(plantilla)
            "2" -> verSumatorioJefesTaller(plantilla)
            "3" -> verSumatorioTrabajadoresSinEspecialidad(plantilla)
            "4" -> verSumatorioChapistas(plantilla)
            "5" -> verSumatorioElectricistas(plantilla)
            "6" -> verSumatorioTrabajadores(plantilla)
        }

    } while (resp != "7")

}

/**
 * Función para despedir un trabajador y ssacarlo de la plantilla
 * @param plantilla la plantilla del taller
 */

fun despedirPersona(plantilla: Array<Persona?>) {

    var jefe: JefeTaller
    var trabajadorADespedir: Trabajador

    if (hayTrabajadores(plantilla)) {
        jefe = seleccionarJefe(plantilla) as JefeTaller
        trabajadorADespedir = seleccionarTrabajadorADespedir(plantilla, jefe) as Trabajador

        for (i in plantilla.indices) {
            if (plantilla[i]!!.equals(trabajadorADespedir)) {
                plantilla[i] = null
                jefe.personasACargo--
                println("\n${colores.morado}TRABAJADOR DESPEDIDO${colores.reset}")
            }
        }

    } else println("\n${colores.morado}No hay trabajadores que despedir${colores.reset}")

}

/**
 * Función que devuelve si existen Trabajadores en la plantilla
 * @param plantilla la plantilla del taller
 * @return Boolean (True = Hay trabajadores, False = No hay Trabajadores)
 */

fun hayTrabajadores(plantilla: Array<Persona?>): Boolean {

    for (i in plantilla) {
        if (i is Trabajador) {
            return true
        }
    }

    return false
}

/**
 * Función que sirve para seleccionar un jefe para despedir un trabajador a su cargo
 * @param plantilla la plantilla del taller
 * @return El jefe que va a despedir
 */

fun seleccionarJefe(plantilla: Array<Persona?>): Persona? {

    val numJefes = numJefesTaller(plantilla).toInt()
    var resp: Int = 0
    var cont = 1
    var arrayPos = Array<Int>(numJefes) {-1} //Guardamos en un array las posiciones de los jefes

    println()

    for (i in plantilla.indices) {
        if (plantilla[i] is JefeTaller) {
            println("$cont ${plantilla[i]}")
            arrayPos[cont-1] = i
            cont++
        }
    }

    do {
        try {
            print("\n${colores.morado}Seleccione un jefe:${colores.reset} ")
            resp = readln().toInt()
            while (resp !in 1..numJefes) {
                print("${colores.rojo}Seleccione una acción válida:${colores.reset} ")
                resp = readln().toInt()
            }
        } catch (e: Exception) {
            println("${colores.rojo}Debe introducir un número${colores.reset}")
        }
        if ((plantilla[arrayPos[resp-1]] as JefeTaller).personasACargo == 0) {
            println("\n${colores.morado}El jefe seleccionado no tiene personas a cargo${colores.reset}")
            resp = 0
        }
    } while (resp !in 1..numJefes)

    return plantilla[arrayPos[resp-1]]
}

/**
 * Función que sirve para elegir el trabajador que un jefe dado va a despedir
 * @param plantilla la plantilla del taller
 * @param jefe el jefe que va a despedir
 * @return El trabajador a despedir
 */

fun seleccionarTrabajadorADespedir(plantilla: Array<Persona?>, jefe: JefeTaller): Persona? {

    val numTrabajadores = numTrabajadoresDelJefe(plantilla, jefe)
    var resp: Int = 0
    var cont = 1
    var arrayPos = Array<Int>(numTrabajadores) {-1}

    println("\n${colores.morado}PERSONAS A CARGO DEL $jefe${colores.reset}")
    println()

    for (i in plantilla.indices) {
        if (plantilla[i] is Trabajador && (plantilla[i] as Trabajador).jefe.equals(jefe)) {
            println("$cont ${plantilla[i]}")
            arrayPos[cont-1] = i
            cont++
        }
    }

    do {
        try {
            print("\n${colores.verde}Seleccione un trabajador:${colores.reset} ")
            resp = readln().toInt()
            while (resp !in 1..numTrabajadores) {
                print("${colores.rojo}Seleccione una acción válida:${colores.reset} ")
                resp = readln().toInt()
            }
        } catch (e: Exception) {
            println("${colores.rojo}Debe introducir un número${colores.reset}")
        }
    } while (resp !in 1..numTrabajadores)

    return plantilla[arrayPos[resp-1]]
}

/**
 * Función que nos devuelve el número de trabajadores que tiene un jefe a su cargo
 * @param plantilla la plantilla del taller
 * @param jefe el jefe
 * @return Número de trabajadores
 */

fun numTrabajadoresDelJefe(plantilla: Array<Persona?>, jefe: JefeTaller): Int {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i.jefe.equals(jefe)) {
            cont++
        }
    }
    return cont
}

/**
 * Función que sirve para contratar una persona y añadirla a la plantilla
 * @param plantilla la plantilla del taller
 */

fun contratarPersona(plantilla: Array<Persona?>) {

    var jefe: JefeTaller
    var persona: Persona
    var contratado: Boolean = false

    if (hayPlazasLibres(plantilla)) {
        jefe = seleccionarJefe(plantilla) as JefeTaller
        persona = PlantillaFactory.crearPersona()
        for (i in plantilla.indices) {
            if (!contratado && plantilla[i] == null) {
                plantilla[i] = persona
                contratado = true
            }
        }
        if (persona is Trabajador) persona.jefe = jefe
        jefe.personasACargo++
        println("\n${colores.morado}PERSONA CONTRATADA${colores.reset}")
        println(persona)

    } else println("\n${colores.morado}No hay plazas libres${colores.reset}")

}

/**
 * Función que nos dice si hay plazas libres o no
 * @param plantilla la plantilla del taller
 * @return Boolean (True = Hay plaza libre, False = No hay plazas libres)
 */

fun hayPlazasLibres(plantilla: Array<Persona?>): Boolean {

    for (i in plantilla) {
        if (i == null) return true
    }
    return false
}

/**
 * Función que muestra por pantalla la plantilla
 * @param plantilla la plantilla del taller
 */

fun imprimirPlantilla(plantilla: Array<Persona?>) {

    println()

    for (i in plantilla) {
        if (i != null) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Jefes de la plantilla
 * @param plantilla la plantilla del taller
 */

fun verJefes(plantilla: Array<Persona?>) {

    println("\n${colores.morado}Hay " + numJefesTaller(plantilla) + " jefes de taller${colores.reset}")
    println()

    for (i in plantilla) {
        if (i is JefeTaller) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Trabajadores de la plantilla
 * @param plantilla la plantilla del taller
 */

fun verTrabajadores(plantilla: Array<Persona?>) {

    println("\n${colores.morado}Hay " + numTrabajadores(plantilla) + " trabajadores${colores.reset}")
    println()

    for (i in plantilla) {
        if (i is Trabajador) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Trabjadores sin especialidad de la plantilla
 * @param plantilla la plantilla del taller
 */

fun verTrabajadoresSinEspecialidad(plantilla: Array<Persona?>) {

    println("\n${colores.morado}Hay " + numTrabajadoresSinEspecialidad(plantilla) + " trabajadores sin especialidad${colores.reset}")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Chapistas de la plantilla
 * @param plantilla la plantilla del taller
 */

fun verChapistas(plantilla: Array<Persona?>) {

    println("\n${colores.morado}Hay " + numChapistas(plantilla) + " chapistas${colores.reset}")
    println()

    for (i in plantilla) {
        if (i is Chapista) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Electricistas de la plantilla
 * @param plantilla la plantilla del taller
 */

fun verElectricistas(plantilla: Array<Persona?>) {

    println("\n${colores.morado}Hay " + numElectricistas(plantilla) + " electricistas${colores.reset}")
    println()

    for (i in plantilla) {
        if (i is Electricista) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Trabjadores no chapistas de la plantilla
 * @param plantilla la plantilla del taller
 */

fun verTrabajadoresNoChapistas(plantilla: Array<Persona?>) {

    println("\n${colores.morado}Hay " + numTrabajadoresNoChapistas(plantilla) + " trabajadores que no son chapistas${colores.reset}")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista) {
            println(i)
        }
    }
}

/**
 * Función que muestra por pantalla los Trabjadores no electricistas de la plantilla
 * @param plantilla la plantilla del taller
 */

fun verTrabajadoresNoElectricistas(plantilla: Array<Persona?>) {

    println("\n${colores.morado}Hay " + numTrabajadoresNoElectricistas(plantilla) + " trabajadores que no son electricistas${colores.reset}")
    println()

    for (i in plantilla) {
        if (i is Trabajador && i !is Electricista) {
            println(i)
        }
    }
}

/**
 * Función que sirve para ver el sumatorio de nóminas de todo el taller
 * @param plantilla la plantilla del taller
 */

fun verSumatorio(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i != null ) suma += i.salario
    }

    println("\n${colores.morado}La suma de nóminas del taller es de $suma€${colores.reset}")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de los Jefes
 * @param plantilla la plantilla del taller
 */

fun verSumatorioJefesTaller(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is JefeTaller) {
            suma += i.salario
        }
    }

    println("\n${colores.morado}La suma de nóminas de los jefes del taller es de $suma€${colores.reset}")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de los Trabajadores sin especialidad
 * @param plantilla la plantilla del taller
 */

fun verSumatorioTrabajadoresSinEspecialidad(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            suma += i.salario
        }
    }

    println("\n${colores.morado}La suma de nóminas de los trabajadores sin especialidad es de $suma€${colores.reset}")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de los Chapistas
 * @param plantilla la plantilla del taller
 */

fun verSumatorioChapistas(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Chapista) {
            suma += i.salario
        }
    }

    println("\n${colores.morado}La suma de nóminas de los chapistas es de $suma€${colores.reset}")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de los Electricistas
 * @param plantilla la plantilla del taller
 */

fun verSumatorioElectricistas(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Electricista) {
            suma += i.salario
        }
    }

    println("\n${colores.morado}La suma de nóminas de los electricistas es de $suma€${colores.reset}")
}

/**
 * Función que sirve para ver el sumatorio de nóminas de todos los Trabajadores
 * @param plantilla la plantilla del taller
 */

fun verSumatorioTrabajadores(plantilla: Array<Persona?>) {

    var suma = 0

    for (i in plantilla) {
        if (i is Trabajador) {
            suma += i.salario
        }
    }

    println("\n${colores.morado}La suma de nóminas de todos los trabajadores es de $suma€${colores.reset}")
}

/**
 * Funcion que nos devuelve una cadena con el número de Jefes de taller
 * @param plantilla la plantilla del taller
 * @return String
 */

fun numJefesTaller(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is JefeTaller) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Trabajadores
 * @param plantilla la plantilla del taller
 * @return String
 */

fun numTrabajadores(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Trabjadores sin especialidad
 * @param plantilla la plantilla del taller
 * @return String
 */

fun numTrabajadoresSinEspecialidad(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista && i !is Electricista) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Chapistas
 * @param plantilla la plantilla del taller
 * @return String
 */

fun numChapistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Chapista) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Electricistas
 * @param plantilla la plantilla del taller
 * @return String
 */

fun numElectricistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Electricista) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Trabajadores no chapistas
 * @param plantilla la plantilla del taller
 * @return String
 */

fun numTrabajadoresNoChapistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Chapista) {
            cont++
        }
    }
    return "$cont"
}

/**
 * Funcion que nos devuelve una cadena con el número de Trabajadores no electricistas
 * @param plantilla la plantilla del taller
 * @return String
 */

fun numTrabajadoresNoElectricistas(plantilla: Array<Persona?>): String {

    var cont = 0

    for (i in plantilla) {
        if (i is Trabajador && i !is Electricista) {
            cont++
        }
    }
    return "$cont"
}