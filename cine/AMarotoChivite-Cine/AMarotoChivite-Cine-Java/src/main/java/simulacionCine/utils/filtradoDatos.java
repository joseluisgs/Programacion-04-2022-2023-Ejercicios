package simulacionCine.utils;

import simulacionCine.enums.EstadoButaca;
import simulacionCine.models.Sala;

public class filtradoDatos {
    /**
     * Filtra una cadena de caracteres según una expresión regular para asegurar que tiene entre 3 y 20 letras.
     *
     * @param letrasCliente La cadena de caracteres a filtrar.
     * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
     */
    public static boolean filtroMaxLetras(String letrasCliente) {
        String regex = "[a-zA-Z]{3,20}";
        if (!letrasCliente.matches(regex)) {
            System.out.println("Como mínimo 3 letras y como máximo 20");
            System.out.println();
            return false;
        }
        return true;
    }

    /**
     * Filtra una cadena de caracteres para asegurar que tiene 16 números.
     *
     * @param tarjetaCliente La cadena de caracteres a filtrar.
     * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
     */
    public static Boolean filtroTarjetaCredito(String tarjetaCliente) {
        String regex = "[0-9]{16}";
        if (!tarjetaCliente.matches(regex)) {
            System.out.println("La tarjeta debe estar compuesto de 16 números!");
            System.out.println();
            return false;
        }
        return true;
    }

    /**
     * Filtra una cadena de caracteres para asegurar que tiene el formato de un correo electrónico válido.
     *
     * @param emailCliente La cadena de caracteres a filtrar.
     * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
     */
    public static boolean filtroEmail(String emailCliente) {
        String regex = "[A-Za-z0-9]+@[A-Za-z0-9.-]+.[A-Za-z]{2,}";
        if (!emailCliente.matches(regex)) {
            System.out.println("El email debe estar compuesto de: xxx@xxx.xx");
            System.out.println();
            return false;
        }
        return true;
    }

    /**
     * Filtra una cadena de caracteres para asegurar que tiene 9 números.
     *
     * @param telefonoCliente La cadena de caracteres a filtrar.
     * @return "true" si la cadena cumple con la expresión regular, "false" en caso contrario.
     */
    public static boolean filtroTelefono(String telefonoCliente) {
        String regex = "[0-9]{9}|";
        if (!telefonoCliente.matches(regex)) {
            System.out.println("El teléfono debe tener 9 números: (612345678)!");
            System.out.println();
            return false;
        }
        return true;
    }

    /**
     * Verifica si el DNI de un cliente es válido.
     * Un DNI válido debe tener 8 números y una letra.
     *
     * @param dniCliente El DNI del cliente a verificar.
     * @return {@code true} si el DNI es válido, {@code false} si no lo es.
     */
    public static Boolean filtroDNI(String dniCliente) {
        String regex = ("[0-9]{8}[A-Za-z]");
        if (!dniCliente.matches(regex)) {
            System.out.println("El DNI debe tener 8 número y una letra: (12345678A)!");
            System.out.println();
            return false;
        }
        return true;
    }

    /**
     * Verifica si la cantidad de entradas es válida.
     * Una cantidad de entradas válida debe ser un número entero mayor a 0 y menor o igual al número máximo de butacas.
     *
     * @param cantidadEntradas La cantidad de entradas a verificar.
     * @param maxButacas       El número máximo de butacas disponibles.
     * @return "true" si la cantidad de entradas es válida, "false" si no lo es.
     */
    public static Boolean filtroCantidadEntradas(String cantidadEntradas, int maxButacas) {
        // Filtro valores alfabéticos
        String regexValorUnico = "\\d+";
        if (!cantidadEntradas.matches(regexValorUnico)) {
            System.out.println("ERROR: Debe ser un número!");
            System.out.println();
            return false;
        }
        if (Integer.parseInt(cantidadEntradas) > maxButacas) {
            System.out.println("ERROR: Como mínimo es 1, y como máximo $maxButacas!");
            System.out.println();
            return false;
        } else if (Integer.parseInt(cantidadEntradas) <= 0) {
            System.out.println("ERROR: Como mínimo es 1, y como máximo $maxButacas!");
            System.out.println();
            return false;
        }
        return true;
    }

    /**
     * Verifica si una butaca es válida para ser reservada u ocupada.
     * Una butaca es válida si cumple con los siguientes criterios:
     * - Debe tener un formato válido: una letra seguida de un número.
     * - No debe estar ocupada o reservada previamente.
     * - Debe estar dentro de los límites de la sala en cuestión.
     *
     * @param cine          El cine al que pertenece la sala.
     * @param idSala        El ID de la sala a verificar.
     * @param entradaButaca La butaca a verificar.
     * @return "true" si la butaca es válida, "false" si no lo es.
     */
    public static boolean filtradoButacas(Sala[] cine, String idSala, String entradaButaca) {
        // Filtro si me devuelven un valor distinto de dos índices
        int contadorLimite = 0;
        for (int i = 0; i < entradaButaca.length(); i++) {
            contadorLimite += 1;
        }
        if (contadorLimite != 2) {
            System.out.println("ERROR: Debes introducir una letra y un número: (ejemplo -> A1)");
            System.out.println();
            return false;
        }

        // COLUMNAS
        // Filtro para ser las columnas siempre números
        String regexColumna = "\\d+";
        if (!entradaButaca.substring(1, 2).matches(regexColumna)) {
            System.out.println("ERROR: Debes introducir en las columnas un número: (ejemplo -> A1)");
            System.out.println();
            return false;
        }
        // Filtrado para limitar respecto al tamaño de sala
        if (Integer.parseInt(entradaButaca.substring(1, 2)) > cine[0].getCantidaMaxColumnas()) {
            System.out.println("ERROR: No existe la butaca seleccionada");
            System.out.println("Has asignado una butaca en una posición de columna más grande que la SALA!");
            System.out.println();
            return false;
        }
        if (Integer.parseInt(entradaButaca.substring(1, 2)) <= 0) {
            System.out.println("ERROR: No existe la butaca seleccionada");
            System.out.println("Has asignado una butaca en una posición de columna más pequeña de la SALA!");
            System.out.println();
            return false;
        }

        // FILAS
        // Filtro para ser las filas siempre letras
        String regexFila = ("[a-z]|[A-Z]");
        if (!entradaButaca.substring(0, 1).matches(regexFila)) {
            System.out.println("ERROR: Debes introducir en las filas una letra: (ejemplo -> A1)");
            System.out.println();
            return false;
        }

        // Filtrado para limitar respecto al tamaño de sala
        String filaButaca = entradaButaca.substring(0, 1);
        String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        int contadorFilaSeleccionada = 0;
        for (char element : abecedario.toCharArray()) {
            contadorFilaSeleccionada += 1;
            if (contadorFilaSeleccionada > cine[0].getCantidaMaxFilas()) {
                System.out.println("ERROR: No existe la butaca seleccionada");
                System.out.println("Has asignado una butaca en una posición de fila más grande de la SALA!");
                System.out.println();
                return false;
            } else if (Character.toString(element).equals(filaButaca) && contadorFilaSeleccionada <= cine[0].getCantidaMaxFilas()) {
                break;
            }
        }

        // Filtro butaca ya reservada u ocupada
        // Nos dirigimos a la sala que necesitemos
        for (int i = 0; i < cine.length; i++) {
            if (cine[i].id.equals(idSala)) {
                EstadoButaca estadoButacaParaFiltrar = cine[i].getEstadoButacaEspecifica(entradaButaca);
                if (estadoButacaParaFiltrar.equals(EstadoButaca.OCUPADO)) {
                    System.out.println("ERROR: La butaca " + entradaButaca + " está ocupada!");
                    return false;
                }
                if (estadoButacaParaFiltrar.equals(EstadoButaca.RESERVADO)) {
                    System.out.println("ERROR: La butaca " + entradaButaca + " está reservada!");
                    return false;
                }
            }
        }
        return true;
    }
}
