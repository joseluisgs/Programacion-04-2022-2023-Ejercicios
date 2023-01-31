package factories;

import models.MultiInstrumentalist;

public class MultiInstrumentalistFactory {
    public static int counter = 0;
    public static MultiInstrumentalist createRandomMultiInstrumentalist() {
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



        String[] typeOfPercussion = {
                "A",
                "B"
        };

        int[] keyNumber = {
                49,
                61,
                88
        };

        String[] typeOfGuitar = {
                "A",
                "B"
        };




        String name = names[(int) (Math.random() * names.length)];
        int yearsOfExperience = expYears[(int) (Math.random() * expYears.length)];
        int numberOfKeys = keyNumber[(int) (Math.random() * keyNumber.length)];
        String PercussionType = typeOfPercussion[(int) (Math.random() * typeOfPercussion.length)];
        String guitarType = typeOfGuitar[(int) (Math.random() * typeOfGuitar.length)];
        counter++;
        return new MultiInstrumentalist(name, yearsOfExperience, PercussionType, numberOfKeys,guitarType );
    }
}
