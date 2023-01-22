package simulacionParking.enums


enum class TipoVehiculo(private val t: String) {
    // Tamaño Grande
    CAMION("N"),

    // Tamaño Mediano
    COCHE("C"),

    // Tamaño Pequeño
    MOTO("M"),
    BICI("B"),
    PATINETE("P"),
    VACIO("-");

    fun get(): String {
        return t
    }
}