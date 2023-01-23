package simulacionParking.models

import simulacionParking.enums.TipoVehiculo

class Vehiculo(
    val id: String,
    val matricula: String,
    // anno no es final, ya que tenemos una ordenación en burbuja
    var anno: String?,
    val tipo: TipoVehiculo
) {
    // Estado por defecto NO_APARCADO, por ello no los pasamos al segundo constructor
    var estado: EstadoVehiculo = EstadoVehiculo.NO_APARCADO

    /**
     * Establece el estado del vehículo (APARCADO o NO_APARCADO)
     *
     * @param estado
     */
    fun setEstadoVehiculo(estado: EstadoVehiculo) {
        this.estado = estado
    }

    override fun toString(): String {
        return "Vehiculo{" +
                "id='" + id + '\'' +
                ", matricula='" + matricula + '\'' +
                ", anno='" + anno + '\'' +
                ", tipo=" + tipo +
                ", estado=" + estado +
                '}'
    }

    /**
     * Estado de vehículo que puede tener
     */
    enum class EstadoVehiculo {
        APARCADO, NO_APARCADO
    }
}