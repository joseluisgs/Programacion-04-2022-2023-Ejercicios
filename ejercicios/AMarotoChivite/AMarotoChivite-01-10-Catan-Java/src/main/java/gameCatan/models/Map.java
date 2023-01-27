package gameCatan.models;

import gameCatan.enums.TypeOwner;
import simulacionCine.enums.Color;

public class Map {
    public int sizeRow;
    public int sizeCol;
    public Box[][] matrix;

    public Map(int sizeRow, int sizeCol, Box[][] matrix) {
        this.sizeRow = sizeRow;
        this.sizeCol = sizeCol;
        this.matrix = matrix;
    }

    public void print() {
        for (int filas = 0; filas < matrix.length; filas++) {
            for (int columnas = 0; columnas < matrix[filas].length; columnas++) {
                if (columnas == matrix[filas].length - 1) {
                    if (matrix[filas][columnas].owner.equals(TypeOwner.HUMAN)) {
                        System.out.println(Color.PURPLE.get() + matrix[filas][columnas].typeResource.get() + Color.RESET.get() + matrix[filas][columnas].randomValue);
                    } else if (matrix[filas][columnas].owner.equals(TypeOwner.COMPUTER)) {
                        System.out.println(Color.RED.get() + matrix[filas][columnas].typeResource.get() + Color.RESET.get() + matrix[filas][columnas].randomValue);
                    } else {
                        System.out.println(matrix[filas][columnas].typeResource.get() + matrix[filas][columnas].randomValue);
                    }
                } else {
                    if (matrix[filas][columnas].owner.equals(TypeOwner.HUMAN)) {
                        System.out.print(Color.PURPLE.get() + matrix[filas][columnas].typeResource.get() + Color.RESET.get() + matrix[filas][columnas].randomValue + " ");
                    } else if (matrix[filas][columnas].owner.equals(TypeOwner.COMPUTER)) {
                        System.out.print(Color.RED.get() + matrix[filas][columnas].typeResource.get() + Color.RESET.get() + matrix[filas][columnas].randomValue + " ");
                    } else {
                        System.out.print(matrix[filas][columnas].typeResource.get() + matrix[filas][columnas].randomValue + " ");

                    }
                }
            }
        }
        System.out.println("----------------------------------");
        System.out.println("LEYENDA:" +
                "\nnº -> cantidad del material" +
                "\nM -> (madera), C -> (carbón), T -> (trigo) " +
                "\n" + Color.PURPLE.get() + "MORADO" + Color.RESET.get() + " -> (propiedad humano), " + Color.RED.get() + "ROJO" + Color.RESET.get() + " -> (propiedad máquina)"
        );
        System.out.println();
    }
}
