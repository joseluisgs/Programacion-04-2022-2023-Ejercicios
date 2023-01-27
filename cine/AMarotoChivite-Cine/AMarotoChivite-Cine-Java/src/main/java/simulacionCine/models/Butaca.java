package simulacionCine.models;

import simulacionCine.enums.Color;
import simulacionCine.enums.EstadoButaca;

// Clase que representa una butaca de un cine.
public class Butaca {
    private final EstadoButaca estado;
    private final String posicionFila;
    private final String posicionColumna;
    private boolean vip;

    public Butaca(EstadoButaca estado, String fila, String columna, boolean esVip) {
        this.estado = estado;
        this.posicionFila = fila;
        this.posicionColumna = columna;
        this.vip = esVip;
    }

    /**
     * Devuelve si la butaca es VIP o no.
     *
     * @return 'true' si la butaca es VIP, 'false' en caso contrario.
     */
    public boolean getBooleanButacaVip() {
        return vip;
    }

    /**
     * Establece si la butaca es VIP o no.
     *
     * @param vip Valor a establecer.
     */
    public void setBooleanButacaVip(Boolean vip) {
        this.vip = vip;
    }

    /**
     * Devuelve la posición completa de la butaca en formato "fila + columna".
     *
     * @return Posición completa de la butaca.
     */
    public String getPosicionCompletaButaca() {
        return ("" + posicionFila + posicionColumna + "");
    }

    /**
     * Devuelve el estado de la butaca.
     *
     * @return Estado de la butaca.
     */
    public EstadoButaca getEstadoButaca() {
        return estado;
    }

    /**
     * Devuelve una cadena con la posición de la butaca y su estado.
     * Si el estado es LIBRE, se devuelve "L".
     * Si el estado es RESERVADO, se devuelve "R".
     * Si el estado es OCUPADO, se devuelve "O".
     * En cualquier otro caso, se devuelve "error".
     *
     * @return Cadena con la posición de la butaca y su estado.
     */
    @Override
    public String toString() {
        if (estado == EstadoButaca.LIBRE) {
            return "" + posicionFila + posicionColumna + ":" + Color.GREEN.get() + "L" + Color.RESET.get();
        }
        if (estado == EstadoButaca.RESERVADO) {
            return "" + posicionFila + posicionColumna + ":" + Color.YELLOW.get() + "R" + Color.RESET.get();
        }
        if (estado == EstadoButaca.OCUPADO) {
            return "" + posicionFila + posicionColumna + ":" + Color.RED.get() + "O" + Color.RESET.get();
        }
        return "" + posicionFila + posicionColumna + ":error";
    }
}