package models;

/**
 * Butacas
 * @author Sergio Simón Fernández
 */
public class Butacas {
    private final int id = contadorID();
    private static int contador = 0;
    private final String nombre;
    private EstadoButaca estado;
    private final TipoButaca tipo;

    public Butacas(String nombre, EstadoButaca estado, TipoButaca tipo) {
        this.nombre = nombre;
        this.estado = estado;
        this.tipo = tipo;
    }

    public void setEstadoButaca(EstadoButaca estado) {
        this.estado = estado;
    }

    private int contadorID() {
        return ++contador;
    }

    public EstadoButaca getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoButaca getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return " ID " + this.id + " Nombre " + this.nombre + " Estado " + this.estado + " Tipo " + this.tipo;
    }

     enum EstadoButaca {
        LIBRE, RESERVADO, OCUPADO
    }

    public enum TipoButaca {
        NORMAL, VIP
    }
}
