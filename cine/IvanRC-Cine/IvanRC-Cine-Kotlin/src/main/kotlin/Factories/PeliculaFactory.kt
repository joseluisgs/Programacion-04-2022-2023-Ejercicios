package Factories

import ModelsSalaDeCine.pelicula

class PeliculaFactory {

    companion object{
        private var instance: PeliculaFactory? = null

        fun getInstance(): PeliculaFactory?{
            if(instance == null){
                instance = PeliculaFactory()
            }
            return instance
        }
    }

    /**
     * función que sirve para crear y devolver una pelicula
     * @param titulo es el título de la peli a crear
     * @param añoPublicacion es el año en que se publicó la peli a crear
     * @param director es el nombre del director que creó la peli
     * @param genero es el genero de la peli a crear
     * @return la pelicula creada según los parametros introducidos
     */
    fun crearPelicula(titulo: String, añoPublicacion: Int, director: String, genero: String): pelicula {
        return pelicula(titulo, añoPublicacion, director, genero)
    }

    /**
     * función que sirve para crear una pelicula generada aleatoriamente
     * @return la pelicula creada aleatoriamente
     */
    fun crearPeliculaAleatoria(): pelicula {
        val titulos = arrayOf("Los tres mosqueteros", "Los rivales más poderos", "El octavo pasajero", "E.T")
        val añoPublicacion = (1950..2023).random()
        val directores = arrayOf("Ridley Scott", "Paul W. S. Anderson", "Mitsuo Hashimoto", "Steven Spielberg")
        val generos = arrayOf("terror", "aventuras", "accion", "fantasia")
        return pelicula(titulos.random(), añoPublicacion, directores.random(), generos.random())
    }
}