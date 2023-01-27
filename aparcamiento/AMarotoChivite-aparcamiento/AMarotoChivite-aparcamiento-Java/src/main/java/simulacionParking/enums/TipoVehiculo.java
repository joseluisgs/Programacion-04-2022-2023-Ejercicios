package simulacionParking.enums;

public enum TipoVehiculo {
    // Tamaño Grande
    CAMION("N"),

    // Tamaño Mediano
    COCHE("C"),

    // Tamaño Pequeño
    MOTO("M"),
    BICI("B"),
    PATINETE("P"),
    VACIO("-");
    private final String t;

    TipoVehiculo(String t) {
        this.t = t;
    }

    public String get() {
        return t;
    }
}
