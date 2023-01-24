package gameCatan.models;

public abstract class Player {

    public int storageWood;
    public int storageCoal;
    public int storageSeed;

    public Player(int storageWood, int storageCoal, int storageSeed) {
        this.storageWood = storageWood;
        this.storageCoal = storageCoal;
        this.storageSeed = storageSeed;
    }

}
