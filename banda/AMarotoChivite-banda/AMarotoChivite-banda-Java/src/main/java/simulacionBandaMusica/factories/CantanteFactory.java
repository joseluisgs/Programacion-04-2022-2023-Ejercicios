package simulacionBandaMusica.factories;

import simulacionBandaMusica.models.Cantante;

import static simulacionBandaMusica.utils.sorteoDatos.*;

public class CantanteFactory {

    public static Cantante create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int pulmonarCapacity = randomPulmonarCapacity();
        return new Cantante(name, "Voz", experienceYear, pulmonarCapacity);
    }

}
