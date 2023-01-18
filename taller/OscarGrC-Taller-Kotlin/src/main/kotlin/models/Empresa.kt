package models

import Factories.PersonaFactory

class Empresa (val nombre:String,var numeroTrabajadores:Int) {
    var plantilla:Array<Any?> = Array(numeroTrabajadores){null}
    init{
        var trabajadorPorAsignar = numeroTrabajadores
         for(i in plantilla.indices){
             val azar = (1 until 10).random()
                 when(azar){
                     1-> {
                     val salida = PersonaFactory.getInstance().getJefeTaller(nombre)
                         plantilla[i]= salida

                     }
                     2-> {
                         val salida = PersonaFactory.getInstance().getElectricista(nombre)
                         plantilla[i]= salida
                     }
                     3,4,5->{
                         val salida= PersonaFactory.getInstance().getChapista(nombre)
                         plantilla[i]= salida
                     }
                     6,7,8,9,10->{
                         val salida = PersonaFactory.getInstance().getTrabajador(nombre)
                         plantilla[i]= salida
                     }
                 }
         }
        val salida = PersonaFactory.getInstance().getJefeTaller(nombre)
        plantilla[0]= salida
        while(trabajadorPorAsignar>0){
        for(i in plantilla.indices){
            if(plantilla[i] is JefeTaller){
               val jefesalida:JefeTaller = plantilla[i] as JefeTaller
                jefesalida.personasAlCargo+=1
                plantilla[i]= jefesalida
                trabajadorPorAsignar-=1
                }}
        }
    }

    fun calcularNomina():String{
        var dineros = 0
        for(i in plantilla.indices){
            when(plantilla[i]){
                is JefeTaller -> dineros+= 2500
                is Electricista-> dineros+=1800
                is Chapista-> dineros+= 1700
                is Trabajador -> dineros+= 1200
            }
        }
        return "Este mes las nominas son $dineros €. Que caros me salis"
    }

    fun printPlantillaResumen(){
        var jefeDeTaller = 0
        var electricistas = 0
        var chapistas = 0
        var trabajadorSinEspecializar = 0
        for(i in plantilla.indices){
            when(plantilla[i]){
                is JefeTaller -> jefeDeTaller+= 1
                is Electricista-> electricistas+=1
                is Chapista-> chapistas+= 1
                is Trabajador -> trabajadorSinEspecializar+= 1
            }
        }
        println("Jefes de Taller: $jefeDeTaller ")
        println("Electricistas: $electricistas")
        println("Chapistas: $chapistas")
        println("Resto de Masillas: $trabajadorSinEspecializar")
    }

    fun printPlantilla(){
        var contador = 0
        var jefeDeTaller:JefeTaller
        var electricistas:Electricista
        var chapistas:Chapista
        var trabajadorSinEspecializar:Trabajador
        for(i in plantilla.indices){
            contador+=1
            when(plantilla[i]){
                is JefeTaller ->{
                    jefeDeTaller = plantilla[i] as JefeTaller
                    println(" $contador.- ${jefeDeTaller.nombre} --Jefe de Taller ")
                }
                is Electricista->{
                    electricistas = plantilla[i] as Electricista
                    println(" $contador.- ${electricistas.nombre} --Electricista ")
                }
                is Chapista->{
                    chapistas = plantilla[i] as Chapista
                    println(" $contador.- ${chapistas.nombre} --Chapista ")
                }
                is Trabajador ->{
                    trabajadorSinEspecializar = plantilla[i] as Trabajador
                    println(" $contador.- ${trabajadorSinEspecializar.nombre} -- Masilla ")
                }
            }
        }
    }

    fun printSalarios(){
        var contador = 0
        var jefeDeTaller:JefeTaller
        var electricistas:Electricista
        var chapistas:Chapista
        var trabajadorSinEspecializar:Trabajador
        for(i in plantilla.indices){
            contador+=1
            when(plantilla[i]){
                is JefeTaller ->{
                    jefeDeTaller = plantilla[i] as JefeTaller
                    println(" $contador.- ${jefeDeTaller.nombre} --Sueldo:~${jefeDeTaller.sueldo}€ ")
                }
                is Electricista->{
                    electricistas = plantilla[i] as Electricista
                    println(" $contador.- ${electricistas.nombre} --Sueldo:~${electricistas.sueldo}€ ")
                }
                is Chapista->{
                    chapistas = plantilla[i] as Chapista
                    println(" $contador.- ${chapistas.nombre} --Sueldo:~${chapistas.sueldo}€ ")
                }
                is Trabajador ->{
                    trabajadorSinEspecializar = plantilla[i] as Trabajador
                    println(" $contador.- ${trabajadorSinEspecializar.nombre} " +
                            "--Sueldo:~${trabajadorSinEspecializar.sueldo}€ ")
                }
            }
        }
    }
}