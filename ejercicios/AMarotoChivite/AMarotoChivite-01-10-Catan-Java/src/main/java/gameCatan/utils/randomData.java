package gameCatan.utils;

import gameCatan.enums.TypeResource;

public class randomData {
    public static TypeResource randomType() {
        int random = (int) (Math.random() * 3 + 1);
        if (random == 1) {
            return TypeResource.WOOD;
        } else if (random == 2) {
            return TypeResource.COAL;
        } else {
            return TypeResource.SEED;
        }
    }
}
