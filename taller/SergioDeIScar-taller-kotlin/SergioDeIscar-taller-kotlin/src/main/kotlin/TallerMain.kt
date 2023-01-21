package taller

import taller.factories.PersonaFactory
import taller.models.*

fun main(){
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
    electricista.comer()
    electricista.descansar()
    electricista.comer()
    println("---------------------")
}

private fun calculateNomina(personas: Array<Persona?>): Int {
    var total = 0
    for (i in personas){
        total += i?.salario ?: 0
    }
    return total
}

// Muy parecido a C#
private inline fun <reified Type : Persona> countType(personas: Array<Persona?>): Int {
    var count = 0
    for (i in personas){
        if (i is Type) count++
    }
    return count
}

private inline fun <reified Type : Persona> findFirstType(personas: Array<Persona?>): Persona? {
    for (i in personas.indices){
        if (personas[i] is Type)
            return personas[i]
    }
    return null
}

