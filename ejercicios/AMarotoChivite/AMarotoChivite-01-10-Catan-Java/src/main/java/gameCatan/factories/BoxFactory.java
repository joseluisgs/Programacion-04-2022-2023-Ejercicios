package gameCatan.factories;

import gameCatan.enums.TypeOwner;
import gameCatan.enums.TypeResource;
import gameCatan.models.Box;

import static gameCatan.utils.randomData.randomType;

public class BoxFactory {
    public static Box create() {
        TypeResource type = randomType();
        int randomValue = (int) (Math.random() * 6 + 1);
        return new Box(type, TypeOwner.NONE, randomValue);
    }
}
