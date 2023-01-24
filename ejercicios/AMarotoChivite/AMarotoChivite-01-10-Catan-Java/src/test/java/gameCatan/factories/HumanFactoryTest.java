package gameCatan.factories;

import gameCatan.models.Human;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class HumanFactoryTest {

    @Test
    void create() {
        Human humanTest = HumanFactory.create();
        assertNotNull(humanTest);
    }
}