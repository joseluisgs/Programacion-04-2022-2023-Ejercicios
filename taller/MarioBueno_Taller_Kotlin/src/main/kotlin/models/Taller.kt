//Mario Bueno López
//maarioo2525@gmail.com

package models

import factories.*

class Taller (maxSize: Int){
    private var taller = arrayOfNulls<Persona>(maxSize)
    init {
        for (i in taller.indices) {
            taller[i] = when ((1..100).random()){
                in 1..10 -> JefeDeTallerFactory.crearJefeDeTaller()
                in 11..40 -> ChapistaFactory.crearChapista()
                in 41..50 -> ElectricistaFactory.crearElectricista()
                in 51..90 -> TrabajadorNormalFactory.crearTrabajadorNormal()
                in 91..100 -> NavajaSuizaFactory.crearNavajaSuiza()
                else -> null
            }
        }
    }

    fun verTrabajadores(){
        println("""
            |
            |Hay ${ChapistaFactory.contador} Chapistas
            |Hay ${ElectricistaFactory.contador} Electricistas
            |Hay ${JefeDeTallerFactory.contador} Jefes de Taller
            |Hay ${NavajaSuizaFactory.contador} Navajas Suizas
            |Hay ${TrabajadorNormalFactory.contador} Trabajadores Normales
            |
        """.trimMargin())
    }

    fun verNominas(){
        println("""
            |
            |Cada Chapista cobra 1700.00 €, hay ${ChapistaFactory.contador} por lo que los Chapistas cobran en total ${ChapistaFactory.nominaChapistas} €
            |Cada Electricista cobra 1800.00 €, hay ${ElectricistaFactory.contador} por lo que los Electricistas cobran en total ${ElectricistaFactory.nominaElectricista} €
            |Cada Jefe De Taller cobra 2500.00 €, hay ${JefeDeTallerFactory.contador} por lo que los Jefes De Taller cobran en total ${JefeDeTallerFactory.nominaJefeDeTaller} €
            |Cada Navaja Suiza cobra 2000.00 €, hay ${NavajaSuizaFactory.contador} por lo que los Navajas Suizas cobran en total ${NavajaSuizaFactory.nominaNavajaSuiza} €
            |Cada Trabajador Normal cobra 1200.00 €, hay ${TrabajadorNormalFactory.contador} por lo que los Trabajadores Normales cobran en total ${TrabajadorNormalFactory.nominaTrabajadorNormal} €
            |
            |El total de nóminas de todos los trabajadores son ${ChapistaFactory.nominaChapistas + ElectricistaFactory.nominaElectricista + JefeDeTallerFactory.nominaJefeDeTaller + NavajaSuizaFactory.nominaNavajaSuiza + TrabajadorNormalFactory.nominaTrabajadorNormal} €
            """.trimMargin())
    }
}