package gameCatan.models;

public class Computer extends Player {
    public Computer(int storageWood, int storageCoal, int storageSeed) {
        super(storageWood, storageCoal, storageSeed);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "storageWood=" + storageWood +
                ", storageCoal=" + storageCoal +
                ", storageSeed=" + storageSeed +
                '}';
    }
}
