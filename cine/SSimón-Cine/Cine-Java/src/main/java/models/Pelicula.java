package models;

import java.util.Scanner;

/**
 * Película con datos
 * @author Sergio Simón Fernández
 */
public class Pelicula {
    private static String Titulo = "Avatar";
    private static String Ano = "2022";
    private static String Director = "James Cameron";
    private static String Genero = "Ciencia Ficción";

    public Pelicula(String Titulo, String Ano, String Director, String Genero){

    }
    @Override
    public String toString() {
        return "\n" + "Titulo: " + Titulo + "\n" + " Ano: " + Ano + "\n"  + " Director: " + Director + "\n" + " Genero: " + Genero;
    }
}

