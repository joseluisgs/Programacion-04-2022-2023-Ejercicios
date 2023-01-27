package simulacionParking.models;

import simulacionParking.enums.TipoVehiculo;

public class Vehiculo {
    public final String id;
    public final String matricula;
    public final TipoVehiculo tipo;

    // anno no es final, ya que tenemos una ordenación en burbuja
    public String anno;

    // Estado por defecto NO_APARCADO, por ello no los pasamos al segundo constructor
    public EstadoVehiculo estado = EstadoVehiculo.NO_APARCADO;

    public Vehiculo(String id, String mattricula, String anno, TipoVehiculo tipo) {
        this.id = id;
        this.matricula = mattricula;
        this.anno = anno;
        this.tipo = tipo;
    }

    /**
     * Devuelve el estado del vehículo (APARCADO o NO_APARCADO)
     *
     * @return estado
     */
    public EstadoVehiculo getEstado() {
        return estado;
    }

    /**
     * Establece el estado del vehículo (APARCADO o NO_APARCADO)
     *
     * @param estado
     */
    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el tipo del vehículo (CAMION,COCHE,MOTO,BICI,PATINETE)
     *
     * @return tipo
     */
    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Devuelve el ID del vehículo
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve la matricula del vehículo
     *
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Devuelve el año de fabricación del vehículo
     *
     * @return anno
     */
    public String getAnno() {
        return anno;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id='" + id + '\'' +
                ", matricula='" + matricula + '\'' +
                ", anno='" + anno + '\'' +
                ", tipo=" + tipo +
                ", estado=" + estado +
                '}';
    }

    /**
     * Estado de vehículo que puede tener
     */
    public enum EstadoVehiculo {
        APARCADO,
        NO_APARCADO
    }
}
