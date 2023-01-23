package simulacionTaller.factories;

import org.junit.jupiter.api.Test;
import simulacionTaller.models.Electrician;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ElectricianFactoryTest {

    @Test
    void createTest() {
        Electrician electrician = ElectricianFactory.create();
        // No nulo, para ver si se han asignado correctamente los datos
        assertNotNull(electrician);
    }
}