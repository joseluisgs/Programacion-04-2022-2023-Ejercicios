import models.Reloj

fun main(){
    var tiempo = Reloj()
    println(tiempo.hora24)
    println(tiempo.hora12)
    println(tiempo.fechaAmericana)
    println(tiempo.fechaEuropea)
    tiempo.avanzar()
    println(tiempo.hora24)
    println(tiempo.hora12)
    println(tiempo.fechaAmericana)
    println(tiempo.fechaEuropea)

}