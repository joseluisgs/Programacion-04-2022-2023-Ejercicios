package gameCatan.models

class Computer(storageWood: Int, storageCoal: Int, storageSeed: Int) : Player(storageWood, storageCoal, storageSeed) {
    override fun toString(): String {
        return "Computer{" +
                "storageWood=" + storageWood +
                ", storageCoal=" + storageCoal +
                ", storageSeed=" + storageSeed +
                '}'
    }
}