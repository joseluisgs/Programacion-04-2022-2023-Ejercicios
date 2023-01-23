package simulacionBandaMusica.factories;

import simulacionBandaMusica.enums.TipoPercusion;
import simulacionBandaMusica.models.MultiInstrumentista;

import static simulacionBandaMusica.utils.sorteoDatos.*;

public class MultiFactory {

    public static MultiInstrumentista create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int numCuerdas = randomNumCuerdas();
        int numTeclas = randomNumTeclas();
        TipoPercusion tipoPercusion = randomTipoPercusion();

        return new MultiInstrumentista(name, "Bajo,teclado y percusión", experienceYear, numCuerdas, numTeclas, tipoPercusion);
    }

}
