package models

class Electricista:Trabajador("") {
    override val sueldo = 1800
    override var tipoTrabajador = TipoTrabajador.Electricista
    override fun trabajar(){
        EstadoTrabajador.Trabajando
        println("Soy $nombre. Electricista y estoy trabajando con los cables")}






}