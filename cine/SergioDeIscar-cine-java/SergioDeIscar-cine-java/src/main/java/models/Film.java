package models;


import enums.FilmGenero;

public class Film {
    private String titulo;
    private int year;
    private String director;
    private FilmGenero genero;

    //region Constructor
    public Film(String titulo, int year, String director, FilmGenero genero){
        setTitulo(titulo);
        setYear(year);
        setDirector(director);
        setGenero(genero);
    }
    //endregion

    //region Getter
    public String getTitulo(){
        return titulo;
    }
    public int getYear(){
        return year;
    }
    public String getDirector(){
        return director;
    }
    public FilmGenero getGenero(){
        return genero;
    }
    //endregion

    //region Setter
    public void setTitulo(String newTitulo){
        titulo = newTitulo;
    }
    public void setYear(int newYear){
        year = newYear;
    }
    public void setDirector(String newDirector){
        director = newDirector;
    }
    public void setGenero(FilmGenero newGenero){
        genero = newGenero;
    }
    //endregion
}