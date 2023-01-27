package simulacionBandaMusica.factories;

import simulacionBandaMusica.models.Trompetista;

import static simulacionBandaMusica.utils.sorteoDatos.*;

public class TrompetistaFactory {

    public static Trompetista create() {
        String name = randomName();
        int experienceYear = randomAnno();
        int pulmonarCapacity = randomPulmonarCapacity();
        return new Trompetista(name, "Trompeta", experienceYear, pulmonarCapacity);
    }

}
