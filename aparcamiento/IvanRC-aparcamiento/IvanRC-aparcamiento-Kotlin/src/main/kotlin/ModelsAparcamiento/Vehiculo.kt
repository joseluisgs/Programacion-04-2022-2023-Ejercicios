package ModelsAparcamiento

data class Vehiculo(val matricula: String, val añoFabricacion: Int, val tipo: tipoVehiculo, val conductor: Conductor) {
    val id: Int = nextId()

    companion object{
        private var contador = 1
        fun nextId(): Int {
            return contador++
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vehiculo

        if (matricula != other.matricula) return false
        if (añoFabricacion != other.añoFabricacion) return false
        if (tipo != other.tipo) return false
        if (conductor != other.conductor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = matricula.hashCode()
        result = 31 * result + añoFabricacion
        result = 31 * result + tipo.hashCode()
        result = 31 * result + conductor.hashCode()
        return result
    }

    override fun toString(): String {
        return "Vehiculo(matricula='$matricula', añoFabricacion=$añoFabricacion, tipo=$tipo, conductor=$conductor, id=$id)"
    }
}