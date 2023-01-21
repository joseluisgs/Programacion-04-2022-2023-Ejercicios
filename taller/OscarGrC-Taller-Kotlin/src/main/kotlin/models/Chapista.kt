package models

class Chapista():Trabajador("") {
    override val sueldo = 1700
    override var tipoTrabajador = TipoTrabajador.Chapista
    override fun trabajar() {
        EstadoTrabajador.Trabajando
        println("Soy $nombre. Chapista y estoy arreglando chapa")
    }
    override fun descansar(){
        EstadoTrabajador.Descansando
        println("Soy $nombre. Chapista y estoy descansando chapistamente")}
}