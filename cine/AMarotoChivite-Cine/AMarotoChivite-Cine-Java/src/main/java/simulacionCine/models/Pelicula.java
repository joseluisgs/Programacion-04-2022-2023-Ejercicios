package simulacionCine.models;

// Clase que representa una película
public class Pelicula {
    final String nombre;
    final String anno;
    final String director;
    final String genero;

    public Pelicula(String nombre, String anno, String director, String genero) {
        this.nombre = nombre;
        this.anno = anno;
        this.director = director;
        this.genero = genero;
    }

    /**
     * Devuelve el nombre de la película.
     *
     * @return Nombre de la película.
     */
    public String nombrePeliculaString() {
        return nombre;
    }

    /**
     * Devuelve una cadena con información de la película.
     *
     * @return Cadena con información de la película.
     */
    @Override
    public String toString() {
        return "PELICULA -> (nombre='" + nombre + "', año='" + anno + "', director='" + director + ", género='" + genero + "')";
    }
}
