package simulacionBandaMusica.factories;

import simulacionBandaMusica.enums.TipoGuitarra;
import simulacionBandaMusica.models.Guitarrista;

import static simulacionBandaMusica.utils.sorteoDatos.*;

public class GuitarristaFactory {

    public static Guitarrista create() {
        String name = randomName();
        int experienceYear = randomAnno();
        TipoGuitarra tipoGuitarra = randomTipoGuitarra();
        return new Guitarrista(name, "Guitarra", experienceYear, tipoGuitarra);
    }

}
