package simulacionTaller.factories;

import org.junit.jupiter.api.Test;
import simulacionTaller.models.Worker;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WorkerFactoryTest {

    @Test
    void createTest() {
        Worker worker = WorkerFactory.create();
        // No nulo, para ver si se han asignado correctamente los datos
        assertNotNull(worker);
    }
}