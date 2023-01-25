package simulacionCine.models

// Clase que representa una película
class Pelicula(var nombre: String, var anno: String, var director: String, var genero: String) {

    /**
     * Devuelve el nombre de la película.
     *
     * @return Nombre de la película.
     */
    fun nombrePeliculaString(): String {
        return nombre
    }

    /**
     * Devuelve una cadena con información de la película.
     *
     * @return Cadena con información de la película.
     */
    override fun toString(): String {
        return "PELICULA -> (nombre='$nombre', año='$anno', director='$director', género='$genero')"
    }
}

