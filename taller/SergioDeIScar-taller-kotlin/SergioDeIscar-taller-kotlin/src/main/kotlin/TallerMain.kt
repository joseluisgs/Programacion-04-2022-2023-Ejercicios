package taller

import taller.factories.PersonaFactory
import taller.models.*

fun main(){
    val personas = PersonaFactory.getInstance().getRandomTallerCompleto()
    println("---------------------")
    println("Simulador de taller con 50 trabajadores:")
    println("---------------------")
    println("Número de personas: ${countType(personas, 0)}")
    println("Número de jefes: ${countType(personas, 2)}")
    println("Número de trabajadores: ${countType(personas, 1)} ->")
    println("\t-> Número de chapistas: ${countType(personas, 3)}")
    println("\t-> Número de electricistas: ${countType(personas, 4)}")
    println("---------------------")
    println("Nomina total del taller ${calculateNomina(personas)}€")
    println("---------------------")
    val primerJefe = findFirstType(personas, 2) as JefeTaller
    primerJefe.darLatigazo(primerJefe.getTrabajador(0)!!)
    println("---------------------")
    val chapista= (findFirstType(personas, 3) as Chapista)
    chapista.arreglarChapa()
    chapista.descansar()
    chapista.comer()
    println("---------------------")
    val electricista = (findFirstType(personas, 4) as Electricista)
    println(electricista)
    electricista.descansar()
    electricista.comer()
    println("---------------------")
}

/*fun mainOld(){
    val personas = PersonaFactory.getInstance().getRandomTallerCompleto()
    println("---------------------")
    println("Simulador de taller con 50 trabajadores:")
    println("---------------------")
    println("Número de personas: ${countType<Persona>(personas)}")
    println("Número de jefes: ${countType<JefeTaller>(personas)}")
    println("Número de trabajadores: ${countType<Trabajador>(personas)} ->")
    println("\t-> Número de chapistas: ${countType<Chapista>(personas)}")
    println("\t-> Número de electricistas: ${countType<Electricista>(personas)}")
    println("---------------------")
    println("Nomina total del taller ${calculateNomina(personas)}€")
    println("---------------------")
    val primerJefe = findFirstType<JefeTaller>(personas) as JefeTaller
    primerJefe.darLatigazo(primerJefe.getTrabajador(0)!!)
    println("---------------------")
    val chapista= (findFirstType<Chapista>(personas) as Chapista)
    chapista.arreglarChapa()
    chapista.descansar()
    chapista.comer()
    println("---------------------")
    val electricista = (findFirstType<Electricista>(personas) as Electricista)
    println(electricista)
    electricista.descansar()
    electricista.comer()
    println("---------------------")
}*/

internal fun calculateNomina(personas: Array<Persona?>): Int {
    var total = 0
    for (i in personas){
        total += i?.salario ?: 0
    }
    return total
}

/**
 * @param type 0: Persona, 1: Trabajador, 2: JefeTaller, 3: Chapista, 4: Electricista
 */
internal fun countType(personas: Array<Persona?>, type: Int): Int{
    var count = 0
    for (i in personas){
        when(type){
            0 -> if (i is Persona) count++
            1 -> if (i is Trabajador) count++
            2 -> if (i is JefeTaller) count++
            3 -> if (i is Chapista) count++
            4 -> if (i is Electricista) count++
        }
    }
    return count
}

/**
 * @param type 0: Persona, 1: Trabajador, 2: JefeTaller, 3: Chapista, 4: Electricista
 */
internal fun findFirstType(personas: Array<Persona?>, type: Int): Persona? {
    for (i in personas.indices){
        when(type){
            0 -> if (personas[i] is Persona) return personas[i]
            1 -> if (personas[i] is Trabajador) return personas[i]
            2 -> if (personas[i] is JefeTaller) return personas[i]
            3 -> if (personas[i] is Chapista) return personas[i]
            4 -> if (personas[i] is Electricista) return personas[i]
        }
    }
    return null
}

// Muy parecido a C#
/*internal inline fun <reified Type : Persona> countType(personas: Array<Persona?>): Int {
    var count = 0
    for (i in personas){
        if (i is Type) count++
    }
    return count
}

internal inline fun <reified Type : Persona> findFirstType(personas: Array<Persona?>): Persona? {
    for (i in personas.indices){
        if (personas[i] is Type)
            return personas[i]
    }
    return null
}*/

