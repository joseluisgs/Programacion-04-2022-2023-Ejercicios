package gameCatan.factories;

import gameCatan.models.Box;
import gameCatan.models.Map;

import static gameCatan.utils.funciones.checkTwiceResources;

public class MapFactory {
    public static Map create() {
        int sizeRow = 3;
        int sizeCol = 4;
        Box[][] boxes = new Box[sizeRow][sizeCol];
        do {
            for (int i = 0; i < boxes.length; i++) {
                for (int j = 0; j < boxes[i].length; j++) {
                    boxes[i][j] = BoxFactory.create();
                }
            }
        } while (!checkTwiceResources(boxes));
        return new Map(sizeRow, sizeCol, boxes);
    }
}
