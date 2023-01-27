package ModelsAparcamiento

data class Conductor(val nombre: String, val dni: String) {
    val id: Int = nextId()

    companion object {
        private var contador = 1
        fun nextId(): Int {
            return contador++
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Conductor

        if (nombre != other.nombre) return false
        if (dni != other.dni) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + dni.hashCode()
        return result
    }

    override fun toString(): String {
        return "Conductor(nombre='$nombre', dni='$dni', id=$id)"
    }
}