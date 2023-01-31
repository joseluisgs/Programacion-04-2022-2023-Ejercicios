package factories;

import models.Pianist;


public class PianistFactory {
    public static int counter = 0;
    public static Pianist createRandomPianist() {
        String[] names = {
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
                "Paco"
        };

        int[] expYears = {
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

        int[] keyNumber = {
                49,
                61,
                88
        };

        String name = names[(int) (Math.random() * names.length)];
        int yearsOfExperience = expYears[(int) (Math.random() * expYears.length)];
        int numberOfKeys = keyNumber[(int) (Math.random() * keyNumber.length)];
        counter++;
        return new Pianist(name, yearsOfExperience, numberOfKeys);
    }
}
