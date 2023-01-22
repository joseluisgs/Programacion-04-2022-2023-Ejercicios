package interfaces

interface IPercusionista {
    val tipoPercusion:TipoPercusion

    enum class TipoPercusion{
        Bateria,Tambor,Xilofono,Triangulo
    }
}