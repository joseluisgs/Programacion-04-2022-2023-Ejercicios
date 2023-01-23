package simulacionBandaMusica.factories;

import simulacionBandaMusica.models.Teclista;

import static simulacionBandaMusica.utils.sorteoDatos.*;

public class TeclistaFactory {

    public static Teclista create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int numTeclas = randomNumTeclas();
        return new Teclista(name, "Teclado", experienceYear, numTeclas);
    }

}
