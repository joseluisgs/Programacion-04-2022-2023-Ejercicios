package models;

import models.*;
import enums.*;
import javafx.util.Pair;

public class Sala {
    private String name;
    private Film film;
    private final Butaca[][] butacas;

    //region Constructor
    public Sala(String name, Film film, Pair<Integer,Integer> size){
        setName(name);
        setFilm(film);
        butacas = new Butaca[size.getKey()][size.getValue()];
        for (int i = 0; i < size.getKey(); i++) {
            for (int j = 0; j < size.getValue(); j++) {
                butacas[i][j] = new Butaca();
            }
        }
    }
    public Sala(String name, Film film, Pair<Integer,Integer> size, int probability){
        setName(name);
        setFilm(film);
        butacas = new Butaca[size.getKey()][size.getValue()];
        for (int i = 0; i < size.getKey(); i++) {
            for (int j = 0; j < size.getValue(); j++) {
                butacas[i][j] = new Butaca(probability);
            }
        }
    }
    //endregion

    //region Getter
    public String getName(){
        return this.name;
    }
    public Film getFilm(){
        return this.film;
    }
    public Butaca[][] getButacas(){
        return this.butacas;
    }
    //endregion

    //region Setter
    public void setName(String newName){
        this.name = newName;
    }
    public void setFilm (Film newFilm){
        this.film = newFilm;
    }
    //endregion

    //region Methods
    //region Output
    public void mostrarSala(){
        //General Info
        System.out.println("Disposición en la sala " + getName() + ":");
        System.out.println("Para la película " + getFilm().getTitulo() + ":");

        //Mapeado de la sala
        MostrarButacas();

        System.out.println("Esto da un total de:\n" + countEstadosText());
        System.out.println("Y un balance total de: " + getBalance() + "€");
    }

    private void MostrarButacas() {
        for (int i = 0; i < butacas.length - 1; i++) {
            for (int j = 0; j < butacas[0].length; j++) {
                char vipMarc = butacas[i][j].getIsVip() ? '*' : ' ';
                switch (butacas[i][j].getEstado()){
                    case LIBRE -> System.out.print("\t| " + vipMarc + " L " + vipMarc + " |\t");
                    case RESERVADA -> System.out.print("\t| " + vipMarc + " R " + vipMarc + " |\t");
                    case OCUPADA -> System.out.print("\t| " + vipMarc + " O " + vipMarc + " |\t");
                }
            }
            System.out.println();
        }
    }
    //endregion

    //region CountEstados
    public String countEstadosText(){
        int[] countEstados = countEstados();
        return  "\t" + countEstados[0] + " butacas libres.\n" +
                "\t" + countEstados[1] + " butacas reservadas.\n" +
                "\t" + countEstados[2] + " butacas ocupadas.";
    }

    public int[] countEstados(){
        int[] newArray = new int[3];
        newArray[0] = countButacas(ButacaEstado.LIBRE);
        newArray[1] = countButacas(ButacaEstado.RESERVADA);
        newArray[2] = countButacas(ButacaEstado.OCUPADA);
        return newArray;
    }

    private int countButacas(ButacaEstado estado) {
        int count = 0;
        for (Butaca[] i : butacas){
            for (Butaca j : i){
                if (j.getEstado() == estado) count++;
            }
        }
        return count;
    }
    //endregion

    //region getBalance
    public Float getBalance(){
        return getBalance(5.35f, 8.5f);
    }
    public Float getBalance(Float normalPrice, Float vipPrice){
        float count = 0f;
        for (Butaca[] i : butacas){
            for (Butaca j : i){
                if (j.getEstado() == ButacaEstado.OCUPADA) count += j.getIsVip() ? vipPrice : normalPrice;
            }
        }
        return count;
    }
    //endregion

    //region CRUD Butaca
    private boolean editButaca(Pair<Integer, Integer> pos, ButacaEstado estadoEqual, ButacaEstado newEstado){
        if (butacas[pos.getValue()][pos.getKey()] == null) return false;
        if(pos.getValue() > butacas.length - 1 || pos.getKey() > butacas[0].length - 1) return false;
        if (butacas[pos.getValue()][pos.getKey()].getEstado() != estadoEqual) return false;
        butacas[pos.getValue()][pos.getKey()].setEstado(newEstado);
        return true;
    }

    public boolean reservaButaca(Pair<Integer, Integer> pos){
        return editButaca(pos, ButacaEstado.LIBRE, ButacaEstado.RESERVADA);
    }

    public boolean formalizarReserva(Pair<Integer, Integer> pos){
        return editButaca(pos, ButacaEstado.RESERVADA, ButacaEstado.OCUPADA);
    }

    public boolean anularReserva(Pair<Integer, Integer> pos){
        if (butacas[pos.getValue()][pos.getKey()] == null) return false;
        if(pos.getValue() > butacas.length - 1 || pos.getKey() > butacas[0].length - 1) return false;
        if (butacas[pos.getValue()][pos.getKey()].getEstado() == ButacaEstado.LIBRE) return false;
        butacas[pos.getValue()][pos.getKey()].setEstado(ButacaEstado.LIBRE);
        return true;
    }
    //endregion

    /**
     * Hace la traducción de número a carácter según el alfabeto español.
     * 0 -> A; 26 -> Z; AA -> 27
     */
    public String alphabetNumberToString(int num) {
        String alphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        var number = num;
        while (number >= 0) {
            result.append(alphabet.indexOf(number % alphabet.length()));
            number /= alphabet.length();
            number -= 1;
        }
        return result.reverse().toString();
    }

    public Pair<Integer, Integer> getSize(){
        return new Pair<>(butacas[0].length - 1, butacas.length - 1);
    }
    //endregion
}