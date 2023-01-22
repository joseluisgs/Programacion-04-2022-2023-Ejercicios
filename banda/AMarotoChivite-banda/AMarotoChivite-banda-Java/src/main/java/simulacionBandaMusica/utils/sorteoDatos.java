package simulacionBandaMusica.utils;

import simulacionBandaMusica.enums.TipoGuitarra;
import simulacionBandaMusica.enums.TipoPercusion;

import java.util.Random;

public class sorteoDatos {

    /**
     * Genera de manera aleatoria un nombre dentro de nuestro catálogo
     *
     * @return catalogoNombre[num], es el nombre aleatorio
     */
    public static String randomName() {
        Random r = new Random();
        int num = r.nextInt(24);
        String[] catalogoNombres = {
                "Pedro", "Alexandra", "Angel", "José",
                "Elena", "Ricardo", "Domingo", "Patricia",
                "Maribel", "Mariana", "Ivan", "Luis", "Mario", "Jorge", "Adrián", "Marcos", "Lara",
                "Marta", "Maria", "Claudia", "Sandra", "Fernando", "Roberto", "Marisa"
        };
        return catalogoNombres[num];
    }

    /**
     * Genera un número entre 1 y 35 (incluidos)
     *
     * @return años de experiencia
     */
    public static int randomAnno() {
        return (int) (Math.random() * 35 + 1);
    }

    /**
     * Genera un número entre 1 y 10 (incluidos)
     *
     * @return capacidad pulmonar, evaluada como si fuera un examen del 1 al 10
     */
    public static int randomPulmonarCapacity() {
        return (int) (Math.random() * 10 + 1);
    }

    /**
     * Genera un tipo de guitarra aleatoria (acústica y eléctrica)
     *
     * @return TipoGuitarra
     */
    public static TipoGuitarra randomTipoGuitarra() {
        int sorteo = (int) (Math.random() * 2 + 1);
        if (sorteo == 1) {
            return TipoGuitarra.ACUSTICA;
        }
        return TipoGuitarra.ELECTRICA;
    }

    /**
     * Genera un número entre 1 y 6 (incluidos)
     *
     * @return número de cuerdas que tendrá un bajista
     */
    public static int randomNumCuerdas() {
        return (int) (Math.random() * 6 + 1);
    }

    /**
     * Genera un número entre 35 y 60 (incluidos)
     *
     * @return número de cuerdas que tendrá un bajista
     */
    public static int randomNumTeclas() {
        return (int) (Math.random() * 25 + 35);
    }

    /**
     * Genera un tipo de percusión aleatoria
     *
     * @return TipoPercusion
     */
    public static TipoPercusion randomTipoPercusion() {
        int sorteo = (int) (Math.random() * 8 + 1);
        if (sorteo == 1) {
            return TipoPercusion.TAMBOR;
        }
        if (sorteo == 2) {
            return TipoPercusion.TIMBAL;
        }
        if (sorteo == 3) {
            return TipoPercusion.XILOFONO;
        }
        if (sorteo == 4) {
            return TipoPercusion.CAMPANA;
        }
        if (sorteo == 5) {
            return TipoPercusion.CROTALOS;
        }
        if (sorteo == 6) {
            return TipoPercusion.CELESTA;
        }
        if (sorteo == 7) {
            return TipoPercusion.CAJON;
        }
        return TipoPercusion.TRIANGULO;
    }
}
