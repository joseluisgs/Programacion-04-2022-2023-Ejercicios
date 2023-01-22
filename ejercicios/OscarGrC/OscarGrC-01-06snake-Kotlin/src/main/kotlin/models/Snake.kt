package models.snake

import factories.SnakeFactory

class Snake (val nombre:String){
    var largo = 5
    var edad = 0
    var isViva = true
    var snake:Array<TipoColorAnilla> = Array(5){SnakeFactory.getInstance().getAnillaRandom()}

    fun crecer(){
        val snakeSalida:Array<TipoColorAnilla> = Array(largo+1){SnakeFactory.getInstance().getAnillaRandom()}
        for(i in snake.indices){
            snakeSalida[i]= snake[i]
        }
           snake = snakeSalida
        largo +=1
        print ("$nombre crecio ahora es: ")
        println(printSnake())
    }
    fun decrecer(){
        if(largo>1){
        var snakeSalida:Array<TipoColorAnilla> = Array(largo-1){SnakeFactory.getInstance().getAnillaRandom()}
        for(i in snakeSalida.indices){
            snakeSalida[i]= snake[i]
        }
        snake = snakeSalida
        largo -=1
        print("$nombre decrece ahora es: ")
            println(printSnake())
    }else{ println("$nombre murio de viejita a los $edad años")
        isViva = false
        }
    }

    fun mudarPiel(){
        for (i in snake.indices){
            snake[i]= SnakeFactory.getInstance().getAnillaRandom()
        }
        print("$nombre muda la piel ahora es : ")
        println(printSnake())
    }

    private fun mangostaAttack(){
        val azar = (1..10).random()
        if(azar==7){
            isViva = false
            println("$nombre murio atacada por una mangosta a la tierna edad de $edad")
        }
    }

    fun simulaAno(){
        if(isViva){
            edad+=1
            val azar = (1..10).random()
            if(edad<10){
                      when(azar){
                      in 1..8 -> if(largo<=20)crecer()
                      in 9..10 -> mudarPiel()}
            }else{
                when(azar){
                    in 1..9 -> decrecer()
                    in 9..10 -> mudarPiel()}
            }
            mangostaAttack()
        }
}
    fun printSnake():String{
        var salida:String = "\uD83D\uDC32"
        for(i in snake.indices){
            when(snake[i]){
                TipoColorAnilla.Azul -> salida +="A"
                TipoColorAnilla.Rojo -> salida +="R"
                TipoColorAnilla.Verde-> salida +="V"
            }
        }
        return salida
    }
    enum class TipoColorAnilla{
        Rojo,Verde,Azul
    }
}