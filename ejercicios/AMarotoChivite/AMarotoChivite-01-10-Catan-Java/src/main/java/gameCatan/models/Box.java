package gameCatan.models;

import gameCatan.enums.TypeOwner;
import gameCatan.enums.TypeResource;

public class Box {
    // Campo de clase para mantener el incremento
    private static int countBox = 1;
    // Mediante el ID, podremos tener un control mayor sobre nuestra matriz
    public final String idBox = getBetterVisualNextId();

    public TypeResource typeResource;
    public TypeOwner owner;
    public int randomValue;

    public Box(TypeResource typeResource, TypeOwner owner, int randomValue) {
        this.typeResource = typeResource;
        this.owner = owner;
        this.randomValue = randomValue;
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getCountBox() {
        return countBox;
    }


    /**
     * Cuando al método, aumentará nuestro ID
     *
     * @return nextId aumentado
     */
    public static String getBetterVisualNextId() {
        int contadorCantidadCifras = 0;
        String cifrasID = countBox + "";
        for (int i = 0; i < cifrasID.length(); i++) {
            contadorCantidadCifras++;
        }
        if (contadorCantidadCifras == 1) {
            return "0" + countBox++;
        } else {
            String finalID = countBox++ + "";
            return finalID;
        }
    }

}
