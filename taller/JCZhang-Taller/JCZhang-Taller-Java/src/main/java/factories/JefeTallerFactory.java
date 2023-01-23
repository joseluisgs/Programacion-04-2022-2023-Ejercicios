package factories;

import models.JefeTaller;

public class JefeTallerFactory {
    public static int nominaJefeTaller = 0;

    public static JefeTaller crearJefeTallerRandom() {
        String[] nombres = {
                "Paquita",
                "Ernesto",
                "Antonio",
                "Alfonso",
                "Patricio",
                "BobEsponja",
                "Arenita",
                "DonCangrejo",
                "Calamardo",
                "Juan",
                "Laura",
                "Aitana",
                "Aitor"
        };

        int[] aniossExp = {
                2,
                4,
                25,
                6,
                8,
                54,
                56,
                3,
                6,
                27,
                4,
                1,
                7,
                36
        };

        String nombre = nombres[(int) (Math.random() * nombres.length)];
        int aniosExp = aniossExp[(int) (Math.random() * aniossExp.length)];
        nominaJefeTaller += 2500;
        return new JefeTaller(nombre, aniosExp);
    }
}
