package interfaces

interface ITeclista {
    val tipoTeclaco:TipoTeclado
    enum class TipoTeclado{
        Electrico,Acordeon,Piano
    }
}