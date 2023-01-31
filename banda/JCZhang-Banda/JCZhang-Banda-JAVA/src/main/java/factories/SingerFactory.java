package factories;


import models.Singer;

public class SingerFactory {
    public static int counter = 0;

    public static Singer createRandomSinger() {
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

        String[] toneTypes = {
                "High",
                "Low"
        };

        String name = names[(int) (Math.random() * names.length)];
        int yearsOfExperience = expYears[(int) (Math.random() * expYears.length)];
        String tone = toneTypes[(int) (Math.random() * toneTypes.length)];
        counter++;
        return new Singer(name, yearsOfExperience, tone);
    }
}