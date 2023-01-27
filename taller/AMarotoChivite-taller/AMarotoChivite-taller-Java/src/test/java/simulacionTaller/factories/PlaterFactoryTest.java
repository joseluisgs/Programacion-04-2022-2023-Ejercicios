package simulacionTaller.factories;

import org.junit.jupiter.api.Test;
import simulacionTaller.models.Plater;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlaterFactoryTest {

    @Test
    void createTest() {
        Plater plater = PlaterFactory.create();
        // No nulo, para ver si se han asignado correctamente los datos
        assertNotNull(plater);
    }
}