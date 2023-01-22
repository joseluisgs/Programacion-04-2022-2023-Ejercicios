package simulacionBandaMusica.utils;

import org.junit.jupiter.api.Test;
import simulacionBandaMusica.factories.*;
import simulacionBandaMusica.models.Musico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static simulacionBandaMusica.utils.funcionesMenu.calcularMantenimientoBanda;

class funcionesMenuTest {

    @Test
    void calcularMantenimientoBandaTest() {
        Musico[] banda = {
                BajistaFactory.create(), CantanteFactory.create(),
                CantanteProFactory.create(), GuitarristaFactory.create(),
                MultiFactory.create(), PercusionistaFactory.create(),
                TeclistaFactory.create(), TrompetistaFactory.create()
        };
        
        assertEquals(16875, calcularMantenimientoBanda(banda));
    }
}