package models;

public interface iElectricista {
     default void arreglarElectricidad(){
        System.out.println("Arreglar electricidad Default");
    }
}
