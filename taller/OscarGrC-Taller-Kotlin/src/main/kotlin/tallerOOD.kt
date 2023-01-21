import models.*

fun main(){
    println("Prueba de requerimientos Jefe taller:")
    var empresa = Empresa("NeoRumasa",20)
    println(" 1.- Los Jt tienen que tener personas al cargo. ")
    printPersonasAlCargo(empresa)
    println("")
    println(" 2.- dar  latigazos")
    darLatigazos(empresa)
    println("")
    println(" 3.- Pagar trabajadores")
    println("")
    println(empresa.calcularNomina())
    println("")
    println(" 4. Los trabajadores  tienen que comer ")
    println("")
    plantillaCome(empresa)
    println("")
    println(" 5.- Los trabajadores tienen que trabajar")
    println("")
    plantillaTrabaja(empresa)
    println("")
    println(" 6.- Los trabajadores tienen que descansar")
    println("")
    plantillaDescansa(empresa)
    println("")
    println(" 7.- Todos tienen que saludar")
    println("")
    plantillaSaluda(empresa)
    println("")
    println(" 8.- Tiene que existir una lista de empleados y resumen")
    println("")
    empresa.printPlantillaResumen()
    println("")
    empresa.printPlantilla()
    println("")
    println(" 9.- Tiene que tener una lista salarial")
    println("")
    empresa.printSalarios()

}

fun plantillaDescansa(empresa: Empresa) {
    for(i in empresa.plantilla.indices){
        var electricistas:Electricista
        var chapista:Chapista
        var trabajador:Trabajador
        when(empresa.plantilla[i]){
            is Electricista ->{
                electricistas= empresa.plantilla[i] as Electricista
                electricistas.descansar()
            }
            is Chapista ->{
                chapista= empresa.plantilla[i] as Chapista
                chapista.descansar()
            }
            is Trabajador ->{
                trabajador= empresa.plantilla[i] as Trabajador
                trabajador.descansar()
            }
        }
    }
}

fun plantillaTrabaja(empresa: Empresa) {
    for(i in empresa.plantilla.indices){
        var electricistas:Electricista
        var chapista:Chapista
        var trabajador:Trabajador
        when(empresa.plantilla[i]){
            is Electricista ->{
                electricistas= empresa.plantilla[i] as Electricista
                electricistas.trabajar()
            }
            is Chapista ->{
                chapista= empresa.plantilla[i] as Chapista
                chapista.trabajar()
            }
            is Trabajador ->{
                trabajador= empresa.plantilla[i] as Trabajador
                trabajador.trabajar()
            }
        }
    }
}

fun plantillaSaluda(empresa: Empresa){
    for(i in empresa.plantilla.indices){
        var jefeTaller:JefeTaller
        var electricistas:Electricista
        var chapista:Chapista
        var trabajador:Trabajador
        when(empresa.plantilla[i]){

            is JefeTaller ->{
                jefeTaller= empresa.plantilla[i] as JefeTaller
                println(jefeTaller.saludar())
            }
            is Electricista ->{
                electricistas= empresa.plantilla[i] as Electricista
                println(electricistas.saludar())
            }
            is Chapista ->{
                chapista= empresa.plantilla[i] as Chapista
                println(chapista.saludar())
            }
            is Trabajador ->{
                trabajador= empresa.plantilla[i] as Trabajador
                println(trabajador.saludar())
            }
        }
    }
}

fun plantillaCome(empresa: Empresa){
    for(i in empresa.plantilla.indices){
        var electricistas:Electricista
        var chapista:Chapista
        var trabajador:Trabajador
        when(empresa.plantilla[i]){
            is Electricista ->{
                electricistas= empresa.plantilla[i] as Electricista
                electricistas.comer()
            }
            is Chapista ->{
                chapista= empresa.plantilla[i] as Chapista
                chapista.comer()
            }
            is Trabajador ->{
                trabajador= empresa.plantilla[i] as Trabajador
                trabajador.comer()
            }
        }
    }
}

fun printPersonasAlCargo(empresa: Empresa){
    for(i in empresa.plantilla.indices){
        if(empresa.plantilla[i] is JefeTaller){
            var jefePrueba:JefeTaller = empresa.plantilla[i] as JefeTaller
            println(jefePrueba.cuantosMasillasTienes())

        }

    }
}

fun darLatigazos(empresa: Empresa){
    for(i in empresa.plantilla.indices){
        if(empresa.plantilla[i] is JefeTaller){
            val jefePrueba:JefeTaller = empresa.plantilla[i] as JefeTaller
            jefePrueba.darLatigazo(empresa.plantilla[getVictima(empresa)] as Trabajador)
        }
    }
}

fun getVictima(empresa: Empresa):Int {
    var posicion = 0
    var victimaApropiada = false
    do{
        var personaParaMotivarPosicion = (0..(empresa.numeroTrabajadores-1)).random()
       if(empresa.plantilla[personaParaMotivarPosicion] is Trabajador){
           posicion = personaParaMotivarPosicion
           victimaApropiada = true
       }
    }while(!victimaApropiada)
    return  posicion
}

