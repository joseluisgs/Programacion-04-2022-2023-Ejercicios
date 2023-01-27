package gameCatan.factories;

import gameCatan.models.Human;

public class HumanFactory {
    public static Human create() {
        return new Human(0, 0, 0);
    }
}
