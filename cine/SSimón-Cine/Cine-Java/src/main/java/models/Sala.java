package models;

import java.util.Objects;

/**
 * Sala que contiene butacas
 * Sala con butacas las cuales pueden ser compradas, reservadas y devueltas.
 * @author Sergio Simón Fernandez
 * @version 1.0
 */
public class Sala {
    private static final int tamanoSala = 11; // MAX. 26 "Z"
    private static final int tamanoButacas = ((tamanoSala - 1) * (tamanoSala - 1));
    private static final Butacas[] clasesButacas = new Butacas[tamanoButacas];
    private static final String[] copiaArraySala = new String[tamanoButacas];
    private static final String[][] sala = new String[tamanoSala][tamanoSala];

    /**
     * Imprime la sala
     * Mediante un bucle imprime la matriz para mostrar la sala
     */
    public static void mostrarSala() {
        for (String[] strings : sala) {
            for (int j = 0; j < sala.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Compra una butaca
     * Comprueba que la butaca a comprar no está reservada y está libre, si es asi la butaca cambiará su estado de libre a ocupado, si no devuelve un mensaje de error.
     * @param indice Es la posición de la butaca dentro de clasesButacas la cual va a ser comprada.
     */
    public static void comprarButaca(int indice) {
        if (clasesButacas[indice].getEstado() != Butacas.EstadoButaca.RESERVADO) {
            if (clasesButacas[indice].getEstado() == Butacas.EstadoButaca.LIBRE) {
                clasesButacas[indice].setEstadoButaca(Butacas.EstadoButaca.OCUPADO);
                arraySalaComprar(indice);
            } else {
                System.out.println("Lo sentimos la butaca " + clasesButacas[indice].getNombre() + " ya esta ocupada. Por favor elige otra.");
            }
        } else {
            System.out.println("Lo sentimos la butaca " + clasesButacas[indice].getNombre() + " esta reservada. Por favor elige otra.");
        }
    }

    /**
     * Cambia en la matriz sala de L (Libre) a O (Ocupado)
     * Se cambia dentro de copiaArraySala la butaca que ha sido comprada de L a O en la posición que le indique índice y se copia sus datos a sala
     * @param indice posición de la butaca comprada dentro de copiaArraySala
     */
    private static void arraySalaComprar(int indice) {
        copiaArraySala[indice] = "O";
        int contador = 0;
        for (int i = 1; i < tamanoSala; i++) {
            for (int j = 1; j < tamanoSala; j++) {
                sala[i][j] = copiaArraySala[contador];
                contador++;
            }
        }
    }

    /**
     * Busca la posición de la butaca dentro de clasesButacas.
     * Al introducir el nombre de la butaca busca otro que sea igual dentro de clasesButacas y devuelve su posición.
     * @param nombre Es el nombre de la butaca la cual tiene que ser buscada dentro de clasesButacas
     * @return La posición del nombre de la butaca dentro de clasesButacas
     */
    public static int getButacaIdByNombre(String nombre) {
        int id = -1;
        for (int i = 0; i < clasesButacas.length; i++) {
            if (clasesButacas[i] != null && Objects.equals(clasesButacas[i].getNombre(), nombre)) {
                id = i;
            }
        }
        return id;
    }

    /**
     * Inicia la Sala
     * Ejecuta distintos métodos para inicializar la Sala
     */
    public static void iniciarSala() {
        establecerSala();
        String[] nombreButacas = iniciarNombreButacas();
        crearClaseButacas(nombreButacas);
        copiaArraySala();
    }

    /**
     * Inicializa la matriz sala
     * Escribe en la matriz sala los números y letras que componen sus bordes además de escribir los caracteres L (Libre) o V (VIP) las butacas VIP tienen un % de aparecer de forma aleatoria dentro de la matriz
     */
    private static void establecerSala() {

        String[] letraButacas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "U", "V", "W", "X", "Y", "Z"};

//      Inicializa la parte de la izquierda de la matriz es decir las letras.
        for (int i = 0; i < tamanoSala - 1; i++) {
            sala[i + 1][0] = letraButacas[i];
        }
//      Inicializa la parte superior de la matriz es decir los números.
        for (int i = 0; i < tamanoSala; i++) {
            sala[0][i] = String.valueOf(i);
        }
//      Inicia las butacas con (L) Libres
        for (int i = 1; i < tamanoSala; i++) {
            for (int j = 1; j < tamanoSala; j++) {
                sala[i][j] = "L";
            }
        }
        sala[0][0] = ("*");

//      Calcular el % de las butacas totales
        int porcentajeVIP = 20;

        int porcentajeButacas = tamanoButacas * porcentajeVIP / 100;

//      Da valor V en el % de la matriz
        for (int i = 0; i < porcentajeButacas; i++) {
            int columnaRandom;
            int filaRandom;
            do {
                columnaRandom = (int) (Math.random() * (tamanoSala - 1)) + 1;
                filaRandom = (int) (Math.random() * (tamanoSala - 1)) + 1;
            } while (Objects.equals(sala[columnaRandom][filaRandom], "V"));
            sala[columnaRandom][filaRandom] = "V";
        }
    }

    /**
     * Crea un array para el nombre de las butacas
     * Tomando del borde de la matriz sala coge la letra y el número y los une formando el nombre de las clases butaca
     * @return Array con el nombre que tendrían las clases butacas
     */
    private static String[] iniciarNombreButacas() {
        String[] nombreButacas = new String[tamanoButacas];
        int contador = 0;

        for (int i = 1; i < tamanoSala; i++) {
            for (int j = 1; j < tamanoSala; j++) {
                StringBuilder str = new StringBuilder();
                String temp2 = sala[i][0]; // Letras
                String temp = sala[0][j]; // Números
                str.append(temp2).append(temp);
                nombreButacas[contador] = str.toString();
                contador++;
            }
        }
        return nombreButacas;
    }

    /**
     * Crea en clasesButacas las classes butacas
     * Crea en clasesButacas las classes butacas leyendo la matriz sala para saber si la butaca es Vip o Normal y le da el nombre sacándolo del array nombreButacas
     * @param nombreButacas Array que contiene el nombre de las clases butacas
     */
    public static void crearClaseButacas(String[] nombreButacas) {
        int contador = 0;
        for (int i = 1; i < sala.length; i++) {
            for (int j = 1; j < sala.length; j++) {
                if (Objects.equals(sala[i][j], "V")) {
                    clasesButacas[contador] = new Butacas(nombreButacas[contador], Butacas.EstadoButaca.LIBRE, Butacas.TipoButaca.VIP);
                } else if (Objects.equals(sala[i][j], "L")){
                    clasesButacas[contador] = new Butacas(nombreButacas[contador], Butacas.EstadoButaca.LIBRE, Butacas.TipoButaca.NORMAL);
                }
                contador++;
            }
        }
    }

    /**
     * Copia la matriz sala a un array
     */
    private static void copiaArraySala() {
        int contador = 0;
        for (int i = 1; i < tamanoSala; i++) {
            for (int j = 1; j < tamanoSala; j++) {
                copiaArraySala[contador] = sala[i][j];
                contador++;
            }
        }

    }

    /**
     * Reserva butacas
     * Permite reservar butacas libres comparando el estado de la clase con la butaca que se quiere reservar. Si está libre el estado de la clase cambia a reservado y si no es así muestra un mensaje de error
     * @param indice Posición de la clase que se quiere reservar
     */
    public static void reservarButaca(int indice) {
        if (clasesButacas[indice].getEstado() != Butacas.EstadoButaca.RESERVADO) {
            if (clasesButacas[indice].getEstado() == Butacas.EstadoButaca.LIBRE) {
                clasesButacas[indice].setEstadoButaca(Butacas.EstadoButaca.RESERVADO);
                arrayButacaReservar(indice);
            } else {
                System.out.println("Lo sentimos la butaca " + clasesButacas[indice].getNombre() + " ya esta ocupada. Por favor elige otra.");
            }
        } else {
            System.out.println("Lo sentimos la butaca " + clasesButacas[indice].getNombre() + " esta reservada. Por favor elige otra.");
        }
    }

    /**
     * Cambia en la matriz sala de L (Libre) a R (Reservado)
     * Se cambia dentro de copiaArraySala la butaca que ha sido comprada de L a R en la posición que le indique índice y se copia sus datos a sala
     * @param indice posición de la butaca reservada dentro de copiaArraySala
     */
    private static void arrayButacaReservar(int indice) {
        copiaArraySala[indice] = "R";
        int contador = 0;
        for (int i = 1; i < tamanoSala; i++) {
            for (int j = 1; j < tamanoSala; j++) {
                sala[i][j] = copiaArraySala[contador];
                contador++;
            }
        }
    }

    /**
     * Formaliza la reserva
     * Permite ocupar una butaca que esta reservada previamente
     * @param indice Posición de la clase que se quiere formalizar la reserva
     */
    public static void comprarButacaReservada(int indice) {
        if (clasesButacas[indice].getEstado() != Butacas.EstadoButaca.OCUPADO) {
            if (clasesButacas[indice].getEstado() != Butacas.EstadoButaca.LIBRE) {
                clasesButacas[indice].setEstadoButaca(Butacas.EstadoButaca.OCUPADO);
                arraySalaComprar(indice);
            } else {
                System.out.println("Lo sentimos la butaca " + clasesButacas[indice].getNombre() + " ya esta libre, primero debe reservarla");
            }
        } else {
            System.out.println("Lo sentimos la butaca " + clasesButacas[indice].getNombre() + " esta ocupada. Por favor elige otra.");
        }
    }

    /**
     * Anula una compra/reserva
     * Pone el valor libre a la clase y a la butaca dentro de la matriz a la cual se quiere dejar libre
     * @param indice posición de la clase butaca que se va a anular dentro de clasesButacas
     */
    public static void anularCompraReservaButaca(int indice) {
        if (clasesButacas[indice].getEstado() == Butacas.EstadoButaca.RESERVADO || clasesButacas[indice].getEstado() == Butacas.EstadoButaca.OCUPADO) {
            clasesButacas[indice].setEstadoButaca(Butacas.EstadoButaca.LIBRE);
            arraySalaAnulaCompra(indice);
        } else  {
            System.out.println("La butaca " + clasesButacas[indice].getNombre() + " ya está libre");
        }
    }

    /**
     * Cambia en la matriz sala de O (Ocupado) / R (Reservado) a L (Libre)
     * Se cambia dentro de copiaArraySala la butaca que ha sido comprada o reservada de O o R a L en la posición que le indique índice y se copia sus datos a sala
     * @param indice posición de la butaca comprada dentro de copiaArraySala
     */
    private static void arraySalaAnulaCompra(int indice) {
        copiaArraySala[indice] = "L";
        int contador = 0;
        for (int i = 1; i < tamanoSala; i++) {
            for (int j = 1; j < tamanoSala; j++) {
                sala[i][j] = copiaArraySala[contador];
                contador++;
            }
        }
    }

    /**
     * Genera un informe
     * Genera un informe separando las butacas libres, reservadas y ocupadas dentro de estas tambien las separa por VIP y normales
     */
    public static void mostrarClaseButacasByTipo() {
        System.out.println("Estas son las butacas que están libres");
        System.out.println("Butacas normales : ");
        for (int i = 0; i < clasesButacas.length; i++) {
            if (clasesButacas[i] != null && clasesButacas[i].getEstado() == Butacas.EstadoButaca.LIBRE && clasesButacas[i].getTipo() == Butacas.TipoButaca.NORMAL) {
                System.out.println(clasesButacas[i]);
            }
        }
        System.out.println();
        System.out.println("Butacas VIP: ");
        for (int i = 0; i < clasesButacas.length; i++) {
            if (clasesButacas[i] != null && clasesButacas[i].getEstado() == Butacas.EstadoButaca.LIBRE && clasesButacas[i].getTipo() == Butacas.TipoButaca.VIP) {
                System.out.println(clasesButacas[i]);
            }
        }
        System.out.println();
        System.out.println("Estas son las butacas que están reservadas");
        System.out.println("Butacas normales : ");
        for (int i = 0; i < clasesButacas.length; i++) {
            if (clasesButacas[i] != null && clasesButacas[i].getEstado() == Butacas.EstadoButaca.RESERVADO && clasesButacas[i].getTipo() == Butacas.TipoButaca.NORMAL) {
                System.out.println(clasesButacas[i]);
            }
        }
        System.out.println();
        System.out.println("Butacas VIP: ");
        for (int i = 0; i < clasesButacas.length; i++) {
            if (clasesButacas[i] != null && clasesButacas[i].getEstado() == Butacas.EstadoButaca.RESERVADO && clasesButacas[i].getTipo() == Butacas.TipoButaca.VIP) {
                System.out.println(clasesButacas[i]);
            }
        }
        System.out.println();
        System.out.println("Estas son las butacas que están ocupadas");
        System.out.println("Butacas normales : ");
        for (int i = 0; i < clasesButacas.length; i++) {
            if (clasesButacas[i] != null && clasesButacas[i].getEstado() == Butacas.EstadoButaca.OCUPADO && clasesButacas[i].getTipo() == Butacas.TipoButaca.NORMAL) {
                System.out.println(clasesButacas[i]);
            }
        }
        System.out.println();
        System.out.println("Butacas VIP: ");
        for (int i = 0; i < clasesButacas.length; i++) {
            if (clasesButacas[i] != null && clasesButacas[i].getEstado() == Butacas.EstadoButaca.OCUPADO && clasesButacas[i].getTipo() == Butacas.TipoButaca.VIP) {
                System.out.println(clasesButacas[i]);
            }
        }
        System.out.println();
    }

    /**
     * Dice el dinero recaudado
     * Calcula el dinero obtenido basándose en el número de butacas compradas y luego dice el dinero recaudado
     */
    public static void caja() {
        double caja = 0;
        double vip = 8.50;
        double normal = 5.25;
        for (int i = 0; i < tamanoButacas; i++) {
            if (clasesButacas[i].getEstado() == Butacas.EstadoButaca.OCUPADO) {
                if (clasesButacas[i].getTipo() == Butacas.TipoButaca.NORMAL) {
                    caja = caja + normal;
                } else if (clasesButacas[i].getTipo() == Butacas.TipoButaca.VIP) {
                    caja = caja + vip;
                }
            }
        }
        System.out.println("El dinero recaudado es de: " + caja + "€");
    }
}