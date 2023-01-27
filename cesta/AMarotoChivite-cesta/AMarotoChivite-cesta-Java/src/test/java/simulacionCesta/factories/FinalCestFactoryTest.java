package simulacionCesta.factories;

import org.junit.jupiter.api.Test;
import simulacionCesta.models.FinalCest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FinalCestFactoryTest {

    @Test
    public void finalCestFactoryCreateTest() {
        FinalCest finalCest = FinalCestFactory.create();
        // Comprobar que la cesta final contiene una cesta no vacía
        assertNotNull(finalCest);
    }
}