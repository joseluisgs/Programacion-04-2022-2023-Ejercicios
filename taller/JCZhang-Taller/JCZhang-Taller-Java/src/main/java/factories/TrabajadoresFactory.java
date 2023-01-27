package factories;

import models.Trabajador;

public class TrabajadoresFactory {
    public static int nominaTrabajadorNormal = 0;

    public static Trabajador crearTrabajadorRandom() {
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
                "Aitor",
                "Juanjo",
                "Paco",
                "Casper"
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
                36,
                0,
                13
        };

        int[] tiempoDiario = {
                8,
                5,
                16,
                4,
                5,
                7,
                10,
                9,
                1,
                20,
                12,
                14,
                23
        };

        String nombre = nombres[(int) (Math.random() * nombres.length)];
        int aniosExp = aniossExp[(int) (Math.random() * aniossExp.length)];
        int horasDiarias = tiempoDiario[(int) (Math.random() * tiempoDiario.length)];

        nominaTrabajadorNormal += 1200;
        return new Trabajador(nombre, aniosExp, horasDiarias);
    }

}
