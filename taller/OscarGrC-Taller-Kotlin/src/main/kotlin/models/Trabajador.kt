package models

open class Trabajador(var empresa:String): Persona("" ,Personalidad.Humilde) {
    var jornadaDiaria = 40
    var estadoTrabajador:EstadoTrabajador = EstadoTrabajador.Trabajando
    open var tipoTrabajador = TipoTrabajador.SinEspecialidad
    open val sueldo = 1200
    override fun saludar():String{
        return if(personalidad==Personalidad.Chulo) "Hola soy $nombre por las mañanas soy Trabajador en " +
                "por las tardes el pu** Amo."
        else "Hola, Soy $nombre. un admirador, un amigo, un esclavo, un siervo."
    }

     fun comer(){
        EstadoTrabajador.Descansando
        if(tipoTrabajador==TipoTrabajador.SinEspecialidad||tipoTrabajador==TipoTrabajador.Chapista)
            println("Soy $nombre y estoy comiendo")
         else  println("Soy ${nombre}. Electricista y estoy comiendo electricamente")
    }
    open fun trabajar(){
        EstadoTrabajador.Trabajando
        println("Soy $nombre y estoy trabajando")
    }
    open fun descansar(){
        EstadoTrabajador.Descansando
        println("Soy $nombre y estoy descansando")
    }
    enum class EstadoTrabajador{
        Descansando,Trabajando
    }
    enum class TipoTrabajador{
        Chapista,Electricista,SinEspecialidad
    }

}