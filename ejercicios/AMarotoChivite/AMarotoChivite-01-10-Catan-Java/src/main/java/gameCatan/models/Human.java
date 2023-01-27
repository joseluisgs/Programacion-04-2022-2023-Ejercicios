package gameCatan.models;

public class Human extends Player {

    public Human(int storageWood, int storageCoal, int storageSeed) {
        super(storageWood, storageCoal, storageSeed);
    }

    @Override
    public String toString() {
        return "Human{" +
                "storageWood=" + storageWood +
                ", storageCoal=" + storageCoal +
                ", storageSeed=" + storageSeed +
                '}';
    }
}
