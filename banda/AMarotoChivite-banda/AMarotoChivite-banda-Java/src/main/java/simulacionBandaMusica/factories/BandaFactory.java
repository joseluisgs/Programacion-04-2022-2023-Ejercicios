package simulacionBandaMusica.factories;

import simulacionBandaMusica.models.Banda;
import simulacionBandaMusica.models.Musico;

import java.util.Random;

public class BandaFactory {

    public static Banda create() {
        final int tammanoBanda = 50;

        Musico[] vectorMusicos = new Musico[tammanoBanda];
        final int probCantante = 20; //20%
        final int probGuitarrista = 40; //20%
        final int probBajista = 50; //10%
        final int probTeclista = 60; //10%
        final int probPercusionista = 75; //15%
        final int probTrompetista = 80; //5%
        final int probCantantePro = 95; //15%

        for (int i = 0; i < vectorMusicos.length; i++) {
            Random r = new Random();
            int num = r.nextInt(100) + 1;

            if (num <= probCantante && vectorMusicos[i] == null) {
                vectorMusicos[i] = CantanteFactory.create();
            } else if (num <= probGuitarrista && vectorMusicos[i] == null) {
                vectorMusicos[i] = GuitarristaFactory.create();
            } else if (num <= probBajista && vectorMusicos[i] == null) {
                vectorMusicos[i] = BajistaFactory.create();
            } else if (num <= probTeclista && vectorMusicos[i] == null) {
                vectorMusicos[i] = TeclistaFactory.create();
            } else if (num <= probPercusionista && vectorMusicos[i] == null) {
                vectorMusicos[i] = PercusionistaFactory.create();
            } else if (num <= probTrompetista && vectorMusicos[i] == null) {
                vectorMusicos[i] = TrompetistaFactory.create();
            } else if (num <= probCantantePro && vectorMusicos[i] == null) {
                vectorMusicos[i] = CantanteProFactory.create();
            } else if (vectorMusicos[i] == null) {
                vectorMusicos[i] = MultiFactory.create();
            }
        }
        return new Banda(vectorMusicos);
    }
}
