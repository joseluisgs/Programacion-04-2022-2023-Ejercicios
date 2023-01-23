package simulacionBandaMusica;

import simulacionBandaMusica.factories.BandaFactory;
import simulacionBandaMusica.models.Banda;

import static simulacionBandaMusica.utils.funcionesMenu.menuBandaMusica;

public class simulacionBandaMusica {
    public static void main(String[] args) {
        // Instanciamos la banda
        Banda banda = BandaFactory.create();
        menuBandaMusica(banda.vectorMusicos());
    }
}
