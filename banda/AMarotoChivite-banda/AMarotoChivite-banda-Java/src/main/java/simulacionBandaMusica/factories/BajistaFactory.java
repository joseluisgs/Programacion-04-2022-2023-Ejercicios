package simulacionBandaMusica.factories;

import simulacionBandaMusica.models.Bajista;

import static simulacionBandaMusica.utils.sorteoDatos.*;

public class BajistaFactory {

    public static Bajista create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int numCuerdas = randomNumCuerdas();
        return new Bajista(name, "Bajo", experienceYear, numCuerdas);
    }

}
