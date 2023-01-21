import factories.MusicoFactory
import models.*

fun main(){
    val danBand = MusicoFactory.getInstance().getBandaRandom(20)
    println("Prueba funcionalidad")
    println("Lista de musicos y posicon en la banda")
    println("")
    printBand(danBand)
    println("------------------------")
    println("La banda respira")
    println("")
    respirar(danBand)
    println("------------------------")
    println("La banda toca")
    println("")
    tocar(danBand)
    println("------------------------")
    println("La banda cobra")
    println("")
    cobrar(danBand)


}

fun printBand(banda:Array<Musico>){
    var contador = 0
    for (i in banda.indices){
        contador+=1
        println("$contador.- ${banda[i].nombre} y soy ${banda[i].titulo}. Tengo ${banda[i].experiencia} años de Exp.")
    }
}

fun tocar(banda:Array<Musico>){
    for (i in banda.indices){
        println(banda[i].interpretar())
    }
}
fun respirar(banda:Array<Musico>){
    for (i in banda.indices){
        println(banda[i].respirar())
    }
}

fun cobrar(banda:Array<Musico>){
    var contador = 0
    for (i in banda.indices){
        contador+=1
        when(banda[i]){
            is Cantante->{
                val musico: Cantante = banda[i] as Cantante
                println("$contador.- ${musico.nombre} cobro ${musico.sueldo}€.")
            }
            is Bajista->{
                val musico: Bajista = banda[i] as Bajista
                println("$contador.- ${musico.nombre} cobro ${musico.sueldo}€.")
            }
            is CantanteGuitarrista->{
                    val musico: CantanteGuitarrista = banda[i] as CantanteGuitarrista
                    println("$contador.- ${musico.nombre} cobro ${musico.sueldo}€.")
            }
            is Guitarrista->{
                val musico: Guitarrista = banda[i] as Guitarrista
                println("$contador.- ${musico.nombre} cobro ${musico.sueldo}€.")
            }
            is Multinstrumental->{
                val musico: Multinstrumental = banda[i] as Multinstrumental
                println("$contador.- ${musico.nombre} cobro ${musico.sueldo}€.")
            }
            is Percusionista-> {
                val musico: Percusionista = banda[i] as Percusionista
                println("$contador.- ${musico.nombre} cobro ${musico.sueldo}€.")
            }
            is Teclista->{
                val musico: Teclista = banda[i] as Teclista
                println("$contador.- ${musico.nombre} cobro ${musico.sueldo}€.")
            }
            is Trompetista->{
                val musico: Trompetista = banda[i] as Trompetista
                println("$contador.- ${musico.nombre} cobro ${musico.sueldo}€.")
            }
        }
    }
}