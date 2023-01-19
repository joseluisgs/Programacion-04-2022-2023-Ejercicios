package interfaces

interface IGuitarrista {
    val tipoGuitarra:Tipoguitarra
    enum class Tipoguitarra{
        Clasica,Acustica,Flamenca,Electrica,Electroacustica
    }
}