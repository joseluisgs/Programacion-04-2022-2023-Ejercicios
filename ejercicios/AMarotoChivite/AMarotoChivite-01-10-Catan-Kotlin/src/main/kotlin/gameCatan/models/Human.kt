package gameCatan.models

class Human(storageWood: Int, storageCoal: Int, storageSeed: Int) : Player(storageWood, storageCoal, storageSeed) {
    override fun toString(): String {
        return "Human{" +
                "storageWood=" + storageWood +
                ", storageCoal=" + storageCoal +
                ", storageSeed=" + storageSeed +
                '}'
    }
}