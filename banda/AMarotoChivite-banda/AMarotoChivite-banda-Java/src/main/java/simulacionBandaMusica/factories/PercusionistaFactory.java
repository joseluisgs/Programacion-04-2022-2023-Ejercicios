package simulacionBandaMusica.factories;

import simulacionBandaMusica.enums.TipoPercusion;
import simulacionBandaMusica.models.Percusionista;

import static simulacionBandaMusica.utils.sorteoDatos.*;

public class PercusionistaFactory {

    public static Percusionista create() {
        String name = randomName();
        int experienceYear = randomAnno();
        TipoPercusion tipoPercusion = randomTipoPercusion();
        return new Percusionista(name, "Percusión", experienceYear, tipoPercusion);
    }

}
