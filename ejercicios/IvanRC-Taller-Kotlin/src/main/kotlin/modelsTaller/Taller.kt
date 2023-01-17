package modelsTaller

import factoryPersonasTaller.FactoryPersonas

class Taller(val numeroPersonas: Int) {
    val JEFE_TALLER = 2500
    val TRABAJADOR = 1200
    val CHAPISTA = 1700
    val ELECTRICISTA = 1800

    val  arrayTaller: Array<Persona?> = Array(numeroPersonas){ FactoryPersonas.getInstance()!!.createRandomPersona()}

    /**
     * función que sirve para sacar por pantalla una lista de las personas de taller
     */
    fun representarListaPersonas() {
        for(i in arrayTaller){
            println(i)
        }
    }

    /**
     * función que sirve para hallar la nómina total en el taller
     * @return la nómina calculada
     */
    fun calcularNominaTotal(): Int{
        var resultado = 0
        for(i in arrayTaller){
            when(i){
                is JefeTaller -> resultado += JEFE_TALLER
                is Chapista -> resultado += CHAPISTA
                is Electricista -> resultado += ELECTRICISTA
                is Trabajador -> resultado += TRABAJADOR
            }
        }
        return resultado
    }

    /**
     * función que calcula el número de jefes de taller que hay en el taller
     * @return el número de jefes de taller
     */
    fun calcularNumeroDeJefesTaller(): Int{
        var contador = 0
        for(i in arrayTaller){
            if(i is JefeTaller) contador++
        }
        return contador
    }

    /**
     * función que calcula el número de trabajadores que hay en el taller
     * @return el número de trabajadores
     */
    fun calcularNumeroDeTrabajadores(): Int{
        var contador = 0
        for(i in arrayTaller){
            if(i is Trabajador && i !is Electricista && i !is Chapista) contador++
        }
        return contador
    }

    /**
     * función que calcula el número de chapistas que hay en el taller
     * @return el número de chapistas
     */
    fun calcularNumeroDeChapistas(): Int{
        var contador = 0
        for(i in arrayTaller){
            if(i is Chapista) contador++
        }
        return contador
    }

    /**
     * función que calcula el número de electricistas que hay en el taller
     * @return el número de electricistas
     */
    fun calcularNumeroDeElectricistas(): Int{
        var contador = 0
        for(i in arrayTaller){
            if(i is Electricista) contador++
        }
        return contador
    }
}