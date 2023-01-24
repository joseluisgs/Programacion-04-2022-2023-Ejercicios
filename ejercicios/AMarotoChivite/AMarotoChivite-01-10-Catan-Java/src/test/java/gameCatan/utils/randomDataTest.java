package gameCatan.utils;

import gameCatan.enums.TypeResource;
import org.junit.jupiter.api.Test;

import static gameCatan.utils.randomData.randomType;
import static org.junit.jupiter.api.Assertions.fail;

class randomDataTest {

    @Test
    void randomTypeTest() {
        TypeResource typeTest = randomType();
        TypeResource[] correctTypes = {TypeResource.WOOD, TypeResource.COAL, TypeResource.SEED};

        int count = 0;
        for (int i = 0; i < correctTypes.length; i++) {
            if (correctTypes[i].equals(typeTest)) {
                count++;
            }
        }
        if (count != 1) {
            fail();
        }
    }
}