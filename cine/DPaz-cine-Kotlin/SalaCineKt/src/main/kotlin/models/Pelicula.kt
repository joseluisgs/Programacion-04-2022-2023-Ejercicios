package models

import enums.GeneroPeli

data class Pelicula(val tituloPelicula:String,
                    val anyoPelicula: Int,
                    val director:String,
                    val genero: GeneroPeli
){

}