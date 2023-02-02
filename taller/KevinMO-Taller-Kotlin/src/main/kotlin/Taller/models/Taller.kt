package Taller.models

import Taller.factories.PersonaFactory

class Taller {
    private val personalDelTaller = Array(50) { Array(1) { PersonaFactory.getInstance().crearPersona() } }

    /**
     * Función que sirve para mostrar el personal del taller.
     */
    fun mostrarPersonal() {
        println()
        for (i in personalDelTaller.indices) {
            for (j in personalDelTaller[i].indices) {
                print(personalDelTaller[i][j])
            }
            println()
        }
        println()
    }

    /**
     * Función que sirve para calcular el dinero que se gasta en
     * salarios en el taller.
     */
    fun mostrarSalarios(){
        calcularSalarios(personalDelTaller)
    }

    fun calcularSalarios(personalDelTaller: Array<Array<Persona>>): Int {
        var salarioTotal = 0
        for (i in personalDelTaller.indices) {
            for (j in personalDelTaller[i].indices) {
                when (personalDelTaller[i][j]) {

                    is NavajaSuiza -> {
                        salarioTotal += 2000
                    }

                    is Chapista -> {
                        salarioTotal += 1600
                    }

                    is Electricista -> {
                        salarioTotal += 1600
                    }

                    is JefeDeTaller -> {
                        salarioTotal += 2300
                    }

                    is Trabajador -> {
                        salarioTotal += 1200
                    }
                }
            }
        }
        println("------------------------------------------")
        println(" El gasto total en salarios es de: $salarioTotal€")
        println("------------------------------------------")
        println()
        return salarioTotal
    }

    /**
     * Función que sirve para ver de que tipo es cada trabajadador.
     * Se elige la posición del trabajador que se quiera ver por teclado
     * y después se mostrarán los datos del trabajador, este saludará y finalmente
     * se dira el tipo de trabajador que es.
     */
    fun estadoTrabajador(): String {
        var eleccion: Int
        val regex = Regex("[1-5]?[0-9]?")
        mostrarPersonal()
        println("Elige la posicion del trabajador que quieres observar")
        do {
            eleccion = readln().toInt()
            if (!regex.matches(eleccion.toString())) {
                println("El valor no esta permitido, repita")
            }
        } while (!regex.matches(eleccion.toString()))
        when (personalDelTaller[eleccion - 1][0]) {

            is NavajaSuiza -> {
                isNavaja(eleccion, personalDelTaller)
            }

            is Chapista -> {
                isChapista(eleccion, personalDelTaller)
            }

            is Electricista -> {
                isElectricista(eleccion, personalDelTaller)
            }

            is JefeDeTaller -> {
                isJefe(eleccion, personalDelTaller)
            }

            is Trabajador -> {
                isTrabajador(eleccion, personalDelTaller)
            }
        }
        return ""
    }

    fun isNavaja(eleccion: Int, personalDelTaller: Array<Array<Persona>>): Boolean{
        if (personalDelTaller[eleccion - 1][0] is NavajaSuiza) {
                println("Datos:")
                println(personalDelTaller[eleccion - 1][0])
                println()
                personalDelTaller[eleccion - 1][0].saludar()
                println()
            return true
        } else return false
    }
    fun isChapista(eleccion: Int, personalDelTaller: Array<Array<Persona>>): Boolean {
        return if (personalDelTaller[eleccion - 1][0] is Chapista) {
            println("Datos:")
            println(personalDelTaller[eleccion - 1][0])
            println()
            personalDelTaller[eleccion - 1][0].saludar()
            println()
            true
        } else false
    }
    fun isElectricista(eleccion: Int, personalDelTaller: Array<Array<Persona>>): Boolean{
        return if (personalDelTaller[eleccion - 1][0] is Electricista) {
            println("Datos:")
            println(personalDelTaller[eleccion - 1][0])
            println()
            personalDelTaller[eleccion - 1][0].saludar()
            println()
            true
        } else false
    }
    fun isJefe(eleccion: Int, personalDelTaller: Array<Array<Persona>>): Boolean{
        if (personalDelTaller[eleccion - 1][0] is JefeDeTaller) {
                println("Datos:")
                println(personalDelTaller[eleccion - 1][0])
                println()
                personalDelTaller[eleccion - 1][0].saludar()
                println()
            return true
        } else return false
    }
    fun isTrabajador(eleccion: Int, personalDelTaller: Array<Array<Persona>>): Boolean{
        if (personalDelTaller[eleccion - 1][0] is Trabajador) {
                println("Datos:")
                println(personalDelTaller[eleccion - 1][0])
                println()
                personalDelTaller[eleccion - 1][0].saludar()
                println()
            return true
        } else return false
    }


    /**
     * Funcíon que calcula y muestra cuantos trabajadores de cada tipo hay.
     */
    fun numeroDeTrabajadores() {
        println()
        println("En el Taller hay:")
        println("-------------------------")
        numeroTrabajadoresNormales(personalDelTaller)
        numeroElectricistas(personalDelTaller)
        numeroChapistas(personalDelTaller)
        numeroJefes(personalDelTaller)
        numeroNavajas(personalDelTaller)
        println("-------------------------")
        println()
    }

    fun numeroTrabajadoresNormales(personalDelTaller: Array<Array<Persona>>): Int {
        var numeroTrabajadores = 0
        for (i in personalDelTaller.indices) {
            for (j in personalDelTaller[i].indices) {
                when (personalDelTaller[i][j]) {
                    is Trabajador -> {
                        numeroTrabajadores += 1
                    }
                }
            }
        }
        println("$numeroTrabajadores Trabajadores Normales")
        return numeroTrabajadores

    }

    fun numeroElectricistas(personalDelTaller: Array<Array<Persona>>): Int {
        var numeroElectricistas = 0
        for (i in personalDelTaller.indices) {
            for (j in personalDelTaller[i].indices) {
                when (personalDelTaller[i][j]) {
                    is Electricista -> {
                        numeroElectricistas += 1
                    }
                }
            }
        }
        println("$numeroElectricistas Electricistas")
        return numeroElectricistas

    }

    fun numeroChapistas(personalDelTaller: Array<Array<Persona>>): Int {
        var numeroChapistas = 0
        for (i in personalDelTaller.indices) {
            for (j in personalDelTaller[i].indices) {
                when (personalDelTaller[i][j]) {
                    is JefeDeTaller -> {
                        numeroChapistas += 1
                    }
                }
            }
        }
        println("$numeroChapistas Chapistas")
        return numeroChapistas

    }

    fun numeroJefes(personalDelTaller: Array<Array<Persona>>): Int {
        var numeroJefes = 0
        for (i in personalDelTaller.indices) {
            for (j in personalDelTaller[i].indices) {
                when (personalDelTaller[i][j]) {
                    is JefeDeTaller -> {
                        numeroJefes += 1
                    }
                }
            }
        }
        println("$numeroJefes Jefes de Talles")
        return numeroJefes

    }

    fun numeroNavajas(personalDelTaller: Array<Array<Persona>>): Int{
        var numeroNavajas = 0
        for (i in personalDelTaller.indices) {
            for (j in personalDelTaller[i].indices) {
                when (personalDelTaller[i][j]) {

                    is NavajaSuiza -> {
                        numeroNavajas += 1
                    }
                }
            }
        }
        println("$numeroNavajas NavajasSuizas")
        return numeroNavajas
    }
}