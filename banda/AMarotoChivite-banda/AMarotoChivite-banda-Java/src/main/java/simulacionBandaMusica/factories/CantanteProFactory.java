package simulacionBandaMusica.factories;

import simulacionBandaMusica.enums.TipoGuitarra;
import simulacionBandaMusica.models.CantantePro;

import static simulacionBandaMusica.utils.sorteoDatos.*;

public class CantanteProFactory {

    public static CantantePro create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int capacidadPulmonar = randomPulmonarCapacity();
        TipoGuitarra tipoGuitarra = randomTipoGuitarra();

        return new CantantePro(name, "Voz y guitarra", experienceYear, capacidadPulmonar, tipoGuitarra);
    }
}
