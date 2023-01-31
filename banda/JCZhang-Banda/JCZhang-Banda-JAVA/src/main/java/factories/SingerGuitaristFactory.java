package factories;


import models.SingerGuitarist;

public class SingerGuitaristFactory {
    public static int counter = 0;

    public static SingerGuitarist createRandomSingerGuitarist() {
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
        String[] typeOfGuitar = {
                "A",
                "B"
        };

        String name = names[(int) (Math.random() * names.length)];
        int yearsOfExperience = expYears[(int) (Math.random() * expYears.length)];
        String tone = toneTypes[(int) (Math.random() * toneTypes.length)];
        String guitarType = typeOfGuitar[(int) (Math.random() * typeOfGuitar.length)];
        counter++;
        return new SingerGuitarist(name, yearsOfExperience, tone, guitarType);
    }
}