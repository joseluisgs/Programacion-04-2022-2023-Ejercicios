package simulacionTaller.factories;

import org.junit.jupiter.api.Test;
import simulacionTaller.models.Multi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MultiFactoryTest {

    @Test
    void createTest() {
        Multi multi = MultiFactory.create();
        // No nulo, para ver si se han asignado correctamente los datos
        assertNotNull(multi);
    }
}