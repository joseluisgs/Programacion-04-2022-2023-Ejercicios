package models.snake

import factories.SnakeFactory

typealias  cantidadDeSerpientes = Int

class Quiver(private var cantidad:cantidadDeSerpientes ) {
    private val cantidadmaxima = 20
    var quiver:Array<Snake> = Array(20){SnakeFactory.getInstance().getSnakeRandom()}
    init {
        if(cantidad>cantidadmaxima){ cantidad = cantidadmaxima}
        var serpientesQuematar = cantidadmaxima - cantidad
        for(i in quiver.size-1 downTo 0){
            if(serpientesQuematar>0){ quiver[i].isViva = false
            serpientesQuematar-=1
        }}
    }


    fun nidoCrece(){
        var serpientesPorasignar= (1..3).random()
            for (i in quiver.indices) {
                if (!quiver[i].isViva && serpientesPorasignar > 0 ) {
                    quiver[i] = SnakeFactory.getInstance().getSnakeRandom()
                    println("Nace ${quiver[i].nombre}")
                    serpientesPorasignar -= 1
                    cantidad += 1
                }
            }

    }
    fun simularAno(){
        var contador = 0
        for (i in quiver.indices){
                if(quiver[i].isViva){
                    contador+=1
                    print("$contador.-")
                    quiver[i].edad+=1
                    val azar = (1..10).random()
                    if(quiver[i].edad<10){
                        when(azar){
                            in 1..8 -> if(quiver[i].largo<=20)quiver[i].crecer()
                            in 9..10 -> quiver[i].mudarPiel()}
                    }else{
                        when(azar){
                            in 1..9 -> quiver[i].decrecer()
                            in 9..10 -> quiver[i].mudarPiel()}
                    }
                }
        }
    }

    fun mangostAttack(){
        val azarAtaque = (1..5).random()
        if(azarAtaque==5){
            print("LA MANGOSTA ATACA!!! ")
            var azarVictima = (0..4).random()
            println("  -- $azarVictima serpientes murieron.")
            while(azarVictima>0){
                quiver.random().isViva = false
                azarVictima -=1
                cantidad-=1
            }
        }else println("La mangosta no detecto el nido.")
    }

}
