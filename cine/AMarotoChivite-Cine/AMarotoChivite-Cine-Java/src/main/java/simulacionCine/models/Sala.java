package simulacionCine.models;

import simulacionCine.enums.Color;
import simulacionCine.enums.EstadoButaca;

// Clase que representa una sala de cine.
public class Sala {
    private final String nombre;
    private final int tamannoFila;
    private final int tamannoColumna;
    public String id;
    public Pelicula pelicula;
    // La mantengo fuera del init para que todas las funciones tengan acceso a la matriz
    private Butaca[][] matrizButacas;

    public Sala(String id, String nombre, Pelicula pelicula, int tamannoFila, int tamannoColumna) {
        this.id = id;
        this.nombre = nombre;
        this.pelicula = pelicula;
        this.tamannoFila = tamannoFila;
        this.tamannoColumna = tamannoColumna;
        init();
    }

    /**
     * Ocupa la butaca especificada en la entrada.
     *
     * @param entradaButacaPosicion La posición de la butaca a ocupar,
     *                              en formato "FilaColumna", donde Fila es una letra mayúscula del abecedario,
     *                              y Columna es un número entero.
     */
    public void ocuparButaca(String entradaButacaPosicion) {
        // Conversión bastante fea...

        int columnaButacaOcupada = Integer.parseInt(entradaButacaPosicion.substring(1, 2));
        char filaButacaOcupada = entradaButacaPosicion.charAt(0);

        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int[] filaButacaEnNumero = new int[1];

        int contadorFila = 0;
        for (int i = 0; i < abecedario.length(); i++) {
            if (abecedario.charAt(i) == filaButacaOcupada) {
                filaButacaEnNumero[0] = contadorFila;
            }
            contadorFila += 1;
        }

        Butaca butacaActualizada = new Butaca(EstadoButaca.OCUPADO, Character.toString(filaButacaOcupada), Integer.toString(columnaButacaOcupada), matrizButacas[filaButacaEnNumero[0]][columnaButacaOcupada - 1].getBooleanButacaVip());
        // En la posición donde se encontraba la butaca introducimos la nueva ocupada
        matrizButacas[filaButacaEnNumero[0]][columnaButacaOcupada - 1] = butacaActualizada;
    }

    /**
     * Inicializa la matriz de butacas de la sala con butacas en estado Libre,
     * y su correspondiente posición.
     * También asigna aleatoriamente butacas VIP en la matriz.
     */
    public void init() {
        Butaca butacaMain = new Butaca(EstadoButaca.LIBRE, "A", "0", false);

        matrizButacas = new Butaca[tamannoFila][tamannoColumna];

        for (int i = 0; i < tamannoFila; i++) {
            for (int j = 0; j < tamannoColumna; j++) {
                matrizButacas[i][j] = butacaMain;
            }
        }
        generarButacasVIP();
    }

    /**
     * Devuelve la matriz de butacas de la sala.
     *
     * @return La matriz de butacas de la sala.
     */
    public Butaca[][] getMatrizSala() {
        return matrizButacas;
    }

    /**
     * Devuelve la cantidad máxima de filas de butacas en la sala.
     *
     * @return El número máximo de filas de butacas en la sala.
     */
    public int getCantidaMaxFilas() {
        return matrizButacas.length;
    }

    /**
     * Devuelve la cantidad máxima de columnas de butacas en la sala.
     *
     * @return El número máximo de columnas de butacas en la sala.
     */
    public int getCantidaMaxColumnas() {
        return matrizButacas[0].length;
    }

    /**
     * Asigna aleatoriamente butacas VIP en la matriz de butacas de la sala.
     */
    private void generarButacasVIP() {
        // 2 de cada 5 butacas son VIP
        int cantidadTotalButacas = tamannoFila * tamannoColumna;
        int butacasVip = ((cantidadTotalButacas / 5) * 2);
        int probabilidadButacaVip = 40;

        // Si no hay el total de butacasVIP, en nuestra SALA, el bucle infinito asignará hasta que haya el número de VIP deseado
        while (!verificarCalculoButacasVip(butacasVip)) {
            // Asignamos por defecto todas libres con su posición correspondiente
            asignarPosicionesButacasPorDefecto();

            for (int filas = 0; filas < matrizButacas.length; filas++) {
                for (int columnas = 0; columnas < matrizButacas[filas].length; columnas++) {
                    int sorteoVip = (int) (Math.random() * 100 + 1);
                    if (sorteoVip <= probabilidadButacaVip) {
                        matrizButacas[filas][columnas].setBooleanButacaVip(true);
                    }
                }
            }
        }
    }

    /**
     * Comprueba si se han asignado el número correcto de butacas VIP en la matriz de butacas de la sala.
     *
     * @param butacasVipLimite El número de butacas VIP que debe haber en la sala.
     * @return 'true' si se han asignado el número correcto de butacas VIP, 'false' en caso contrario.
     */
    private boolean verificarCalculoButacasVip(int butacasVipLimite) {
        int contadorButacasVip = 0;

        for (int filas = 0; filas < matrizButacas.length; filas++) {
            for (int columnas = 0; columnas < matrizButacas[filas].length; columnas++) {
                if (matrizButacas[filas][columnas].getBooleanButacaVip()) {
                    contadorButacasVip += 1;
                }
            }
        }
        return contadorButacasVip == butacasVipLimite;
    }

    /**
     * Devuelve el estado de la butaca especificada en la entrada.
     *
     * @param posicionButaca La posición de la butaca, en formato "FilaColumna",
     *                       donde Fila es una letra mayúscula del abecedario,
     *                       y Columna es un número entero.
     * @return El estado de la butaca especificada.
     */
    public EstadoButaca getEstadoButacaEspecifica(String posicionButaca) {
        char filaButaca = posicionButaca.charAt(0);
        int columnaButaca = Integer.parseInt(posicionButaca.substring(1, 2));

        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int filaButacaEnNumero = 0;

        int contadorFila = 0;
        for (int i = 0; i < abecedario.length(); i++) {
            if (abecedario.charAt(i) == filaButaca) {
                filaButacaEnNumero = contadorFila;
                break;
            }
            contadorFila += 1;
        }

        return matrizButacas[filaButacaEnNumero][columnaButaca - 1].getEstadoButaca();
    }

    /**
     * Devuelve si la butaca especificada en la entrada es VIP o no.
     *
     * @param entradaButacaPosicion La posición de la butaca, en formato "FilaColumna",
     *                              donde Fila es una letra mayúscula del abecedario,
     *                              y Columna es un número entero.
     * @return 'true' si la butaca es VIP, 'false' en caso contrario.
     */
    public boolean getBooleanButacaVipDesdeSala(String entradaButacaPosicion) {
        int columnaButaca = Integer.parseInt(entradaButacaPosicion.substring(1, 2));
        char filaButaca = entradaButacaPosicion.charAt(0);

        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int[] filaButacaEnNumero = new int[1];

        int contadorFila = 0;
        for (char element : abecedario.toCharArray()) {
            if (element == filaButaca) {
                filaButacaEnNumero[0] = contadorFila;
            }
            contadorFila += 1;
        }
        return matrizButacas[filaButacaEnNumero[0]][columnaButaca - 1].getBooleanButacaVip();
    }

    /**
     * Devuelve la cantidad total de butacas en la sala.
     *
     * @return El número total de butacas en la sala.
     */
    public int cantidadButacasTotal() {
        int contadorButacas = 0;
        for (int filas = 0; filas <= matrizButacas.length - 1; filas++) {
            for (int columnas = 0; columnas <= matrizButacas[filas].length - 1; columnas++) {
                contadorButacas += 1;
            }
        }
        return contadorButacas;
    }

    /**
     * Libera la butaca especificada en la entrada.
     *
     * @param entradaButacaPosicion La posición de la butaca a liberar,
     *                              en formato "FilaColumna", donde Fila es una letra mayúscula del abecedario,
     *                              y Columna es un número entero.
     */
    public void liberarButaca(String entradaButacaPosicion) {
        // Conversión bastante fea...

        int columnaButaca = Integer.parseInt(entradaButacaPosicion.substring(1, 2));
        char filaButaca = entradaButacaPosicion.charAt(0);

        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int[] filaButacaEnNumero = new int[1];

        int contadorFila = 0;
        for (char element : abecedario.toCharArray()) {
            if (element == filaButaca) {
                filaButacaEnNumero[0] = contadorFila;
            }
            contadorFila += 1;
        }

        Butaca butacaActualizada = new Butaca(EstadoButaca.LIBRE, Character.toString(filaButaca), Integer.toString(columnaButaca), matrizButacas[filaButacaEnNumero[0]][columnaButaca - 1].getBooleanButacaVip());
        // En la posición donde se encontraba la butaca introducimos la nueva libre
        matrizButacas[filaButacaEnNumero[0]][columnaButaca - 1] = butacaActualizada;
    }

    /**
     * Reserva la butaca especificada en la entrada.
     *
     * @param entradaButacaPosicion La posición de la butaca a reservar,
     *                              en formato "FilaColumna", donde Fila es una letra mayúscula del abecedario,
     *                              y Columna es un número entero.
     */
    public void reservarButaca(String entradaButacaPosicion) {
        // Conversión bastante fea...

        char filaButacaReservada = entradaButacaPosicion.charAt(0);
        int columnaButacaReservada = Integer.parseInt(entradaButacaPosicion.substring(1, 2));

        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int[] filaButacaEnNumero = new int[1];

        int contadorFila = 0;
        for (int i = 0; i < abecedario.length(); i++) {
            if (abecedario.charAt(i) == filaButacaReservada) {
                filaButacaEnNumero[0] = contadorFila;
            }
            contadorFila += 1;
        }

        Butaca butacaActualizada = new Butaca(EstadoButaca.RESERVADO, Character.toString(filaButacaReservada), Integer.toString(columnaButacaReservada), matrizButacas[filaButacaEnNumero[0]][columnaButacaReservada - 1].getBooleanButacaVip());
        // En la posición donde se encontraba la butaca introducimos
        matrizButacas[filaButacaEnNumero[0]][columnaButacaReservada - 1] = butacaActualizada;
    }

    /**
     * Asigna las posiciones de las butacas de la sala.
     */
    private void asignarPosicionesButacasPorDefecto() {
        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        for (int filas = 0; filas < matrizButacas.length; filas++) {
            for (int columnas = 0; columnas < matrizButacas[filas].length; columnas++) {
                Butaca butacaPorDefecto = new Butaca(EstadoButaca.LIBRE, "" + abecedario.charAt(filas), "" + (columnas + 1), false);
                matrizButacas[filas][columnas] = butacaPorDefecto;
            }
        }
    }

    /**
     * Muestra por pantalla la matriz de butacas de la sala.
     */
    public void imprimirMatrizButacas() {
        for (int filas = 0; filas < matrizButacas.length; filas++) {
            for (int columnas = 0; columnas < matrizButacas[filas].length; columnas++) {
                if (columnas == matrizButacas[filas].length - 1) {
                    if (matrizButacas[filas][columnas].getBooleanButacaVip()) {
                        System.out.println(Color.PURPLE.get() + matrizButacas[filas][columnas] + Color.RESET.get());
                    } else {
                        System.out.println(matrizButacas[filas][columnas]);
                    }
                } else {
                    if (matrizButacas[filas][columnas].getBooleanButacaVip()) {
                        System.out.print(Color.PURPLE.get() + matrizButacas[filas][columnas] + Color.RESET.get() + " ");
                    } else {
                        System.out.print(matrizButacas[filas][columnas] + " ");
                    }
                }
            }
        }
        System.out.println("----------------------------------");
        System.out.println("LEYENDA: " + Color.GREEN.get() + "L" + Color.RESET.get() + " -> (libre), " + Color.YELLOW.get() + "R" + Color.RESET.get() + " -> (reservado), " + Color.RED.get() + "O" + Color.RESET.get() + " -> (ocupado), " + Color.PURPLE.get() + "MORADO" + Color.RESET.get() + " -> (VIP)");
        System.out.println();
    }

    /**
     * Devuelve una representación en forma de cadena del objeto sala.
     *
     * @return Representación en forma de cadena del objeto sala.
     */
    @Override
    public String toString() {
        return "SALA -> (id='" + id + "', nombre='" + nombre + "') \n" + pelicula;
    }
}
