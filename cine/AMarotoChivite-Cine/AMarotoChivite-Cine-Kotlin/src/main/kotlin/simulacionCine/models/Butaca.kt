package simulacionCine.models

import simulacionCine.enums.Color
import simulacionCine.enums.EstadoButaca

// Clase que representa una butaca de un cine.
class Butaca(
    private var estado: EstadoButaca,
    private var posicionFila: String,
    private var posicionColumna: String,
    private var vip: Boolean
) {

    /**
     * Devuelve si la butaca es VIP o no.
     *
     * @return 'true' si la butaca es VIP, 'false' en caso contrario.
     */
    fun getBooleanButacaVip(): Boolean {
        return vip
    }

    /**
     * Devuelve la posición completa de la butaca en formato "fila + columna".
     *
     * @return Posición completa de la butaca.
     */
    fun getPosicionCompletaButaca(): String {
        return "$posicionFila$posicionColumna"
    }

    /**
     * Devuelve el estado de la butaca.
     *
     * @return Estado de la butaca.
     */
    fun getEstadoButaca(): EstadoButaca {
        return estado
    }

    /**
     * Establece si la butaca es VIP o no.
     *
     * @param vip Valor a establecer.
     */
    fun setBooleanButacaVip(vip: Boolean) {
        this.vip = vip
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
    override fun toString(): String {
        if (estado == EstadoButaca.LIBRE) {
            return "$posicionFila$posicionColumna:${Color.GREEN.color}L${Color.RESET.color}"
        }
        if (estado == EstadoButaca.RESERVADO) {
            return "$posicionFila$posicionColumna:${Color.YELLOW_BRIGHT.color}R${Color.RESET.color}"
        }
        if (estado == EstadoButaca.OCUPADO) {
            return "$posicionFila$posicionColumna:${Color.RED_BRIGHT.color}O${Color.RESET.color}"
        }
        return "$posicionFila$posicionColumna:error"
    }
}