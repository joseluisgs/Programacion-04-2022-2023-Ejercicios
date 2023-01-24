package ModelsSalaDeCine;

import java.util.Objects;
import java.util.Scanner;

public class pelicula {

    private static Scanner sc = new Scanner(System.in);

    String titulo;
    int añoPublicacion;
    String director;
    String genero;

    /**
     * es el constructor del objeto "pelicula"
     * @param titulo es el título de la peli a crear
     * @param añoPublicacion es el año en que se publicó la peli a crear
     * @param director es el nombre del director que creó la peli
     * @param genero es el genero de la peli a crear
     */
    public pelicula(String titulo, int añoPublicacion, String director, String genero){
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
        this.director = director;
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pelicula pelicula = (pelicula) o;
        return añoPublicacion == pelicula.añoPublicacion && Objects.equals(titulo, pelicula.titulo) && Objects.equals(director, pelicula.director) && Objects.equals(genero, pelicula.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, añoPublicacion, director, genero);
    }

    @Override
    public String toString() {
        return "pelicula{" +
                "titulo='" + titulo + '\'' +
                ", añoPublicacion=" + añoPublicacion +
                ", director='" + director + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public static Scanner getSc() {
        return sc;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public String getDirector() {
        return director;
    }

    public String getGenero() {
        return genero;
    }
}
