import factories.SnakeFactory
import models.snake.Quiver

fun main() {
    println("Simulacion Snake")
    var snakeTest = SnakeFactory.getInstance().getSnakeRandom()
    println(snakeTest.printSnake())
//simula una serpiente
    for (i in 1 until 50) {
        if (snakeTest.isViva == false) break
        println("Año $i")
        snakeTest.simulaAno()
    }
    println("-------------------")
    println("Simulando Quiver")
    println("")
    var quiver:Quiver = Quiver(1)
    var contador = 0
    for(i in 1 until 301){
        println("Año $i")
        contador+=1
        quiver.simularAno()
        if(contador % 5 == 0) quiver.nidoCrece()
        if(contador %10 == 0) quiver.mangostAttack()
    }
}