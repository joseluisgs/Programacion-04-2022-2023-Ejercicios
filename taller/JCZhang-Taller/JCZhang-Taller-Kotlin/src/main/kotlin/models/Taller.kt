package models

import NUM_PERSONAS_MAX
import factories.*

class Taller {


    fun informeDeNominas() {
        println("ESTE ES EL INFORME DE NOMINAS!")
        println()
        println(" - Las chapistas han cobrado un total de $nominaChapistas €")
        println(" - Las electricistas han cobrado un total de $nominaElectricista €")
        println(" - Las jefes de taller han cobrado un total de $nominaJefeTaller €")
        println(" - Las trabajadores normales han cobrado un total de $nominaTrabajadorNormal €")
        println(" - Las navajas suizas han cobrado un total de $nominaNavajaSuiza €")
        println()
        println("El total de dinero que se ha pagado en nominas es de ${nominaChapistas + nominaElectricista + nominaTrabajadorNormal + nominaJefeTaller + nominaNavajaSuiza} €")
    }

    fun numeroJefeTaller(arrayPersonas: Array<Persona?>): Int {
        var contadorJefesTaller = 0
        for (i in arrayPersonas){
            if (i is JefeTaller ){
                contadorJefesTaller++
            }
        }

        println("El numero de jefes de taller que hay en el total es de $contadorJefesTaller")
        return contadorJefesTaller
    }

    fun numeroDeElectricistas(arrayPersonas: Array<Persona?>): Int {
        var contadorElectricistas = 0
        for (i in arrayPersonas){
            if (i is Electricista ){
                contadorElectricistas++
            }
        }
        println("El numero de electricistas es de $contadorElectricistas")
        return contadorElectricistas
    }

    fun numeroDeChapistas(arrayPersonas: Array<Persona?>): Int {
        var contadorChapistas = 0
        for (i in arrayPersonas){
            if (i is Chapista){
                contadorChapistas++
            }
        }
        println("El numero de chapistas es de $contadorChapistas")
        return contadorChapistas
    }

    fun numeroDeTrabajadoresNormales(arrayPersonas: Array<Persona?>): Int {
        var contadorTrabajadoresNormales = 0
        for (i in arrayPersonas){
            if (i is Trabajador && i !is Chapista && i !is Electricista && i !is NavajaSuiza){
                contadorTrabajadoresNormales++
            }
        }
        println("Por lo que el numero de trabajadores normales sin contar a los chapistas y electricistas es de ${contadorTrabajadoresNormales - numeroDeChapistas(arrayPersonas) - numeroDeElectricistas(arrayPersonas)}")
        return contadorTrabajadoresNormales
    }


    fun seleccionarOpcion(): Int {

        val regex = """[0-9]""".toRegex()


        println("*** HOLA! BIENVENIDO AL TALLER! ***")
        println("¿Que quieres ver?")
        println("Introduce el numero de la opción que quieras")
        println(" - 1 --> Numero de personas totales que hay en el taller")
        println(" - 2 --> Numero de Trabajadores normales")
        println(" - 3 --> Numero de chapistas")
        println(" - 4 --> Numero de electricistas")
        println(" - 5 --> Numero de jefes de taller")
        println(" - 6 --> Numero de navajas suizas")
        println(" - 7 --> Informe de nominas")
        println(" - 8 --> Salir")

        do {
            println("Introduce la opción deseada: ")
            val entrada = readln()
            if (!regex.matches(entrada) || entrada.toInt() > 8|| entrada.toInt() < 1) {
                println("DEBES INTRODUCIR UN NUMERO ENTRE 1 Y 8!")
            } else {
                return entrada.toInt()
            }
        } while (!regex.matches(entrada) || entrada.toInt() > 8 || entrada.toInt() < 1)

        return 0

    }

    /**
     * Es una función que llena la matriz con distintos tipos de personas con los porcentajes que ha indicado el profesor
     * @author JiaCheng Zhang
     * @param arrayPersonas Es la matriz de las personas inicializada a null
     */
    fun llenarMatrizConPersonas(arrayPersonas: Array<Persona?>) {

        do {
            var contadorPersonas = 0
            // variable auxiliar que sirve para hacer los porcentajes de probabilidad
            var aux = 0
            for (i in arrayPersonas.indices) {
                aux = (1..100).random()
                if (aux in 1..10) {
                    arrayPersonas[i] = JefeTallerFactory().crearJefeTallerRandom()
                }
                if (aux in (11..40)) {
                    arrayPersonas[i] = ChapistasFactory().crearChapistaRandom()
                }
                if (aux in (41..50)) {
                    arrayPersonas[i] = ElectricistasFactory().crearElectricistaRandom()
                }
                if (aux in (51..90)) {
                    arrayPersonas[i] = TrabajadoresFactory().crearTrabajadorRandom()
                }
                if (aux in (91..100)){
                    arrayPersonas[i] = NavajaSuizaFactory().crearNavajaSuizaRandom()
                }
                contadorPersonas++
            }
        } while (contadorPersonas < NUM_PERSONAS_MAX)

    }


    fun numeroTotalDePersonas() {
        println("El númeor total de personas que hay en el taller es de $NUM_PERSONAS_MAX")
        println()
    }

    fun numeroNavajasSuizas(arrayPersonas: Array<Persona?>): Int {
        var contadorNavajasSuizas = 0
        for (i in arrayPersonas){
            if (i is NavajaSuiza){
                contadorNavajasSuizas++
            }
        }
        println("El numero de navajas suizas es de $contadorNavajasSuizas")
        return contadorNavajasSuizas
    }

}