package FactorySalaDeCine;

import ModelsSalaDeCine.pelicula;

public class FactoryPelicula {

    public FactoryPelicula(){}
    private static FactoryPelicula instance = null;

    public static FactoryPelicula getInstance(){
        if(instance == null){
            instance = new FactoryPelicula();
        }
        return instance;
    }

    /**
     * función que sirve para crear y devolver una pelicula
     * @param titulo es el título de la peli a crear
     * @param añoPublicacion es el año en que se publicó la peli a crear
     * @param director es el nombre del director que creó la peli
     * @param genero es el genero de la peli a crear
     * @return la pelicula creada según los parametros introducidos
     */
    public static pelicula create(String titulo, int añoPublicacion, String director, String genero){
        return new pelicula(titulo, añoPublicacion, director, genero);
    }

    /**
     * función que sirve para crear una pelicula generada aleatoriamente
     * @return la pelicula creada aleatoriamente
     */
    public pelicula crearPeliculaAleatoria() {
        String[] titulos = {"Los tres mosqueteros", "Los rivales más poderos", "El octavo pasajero", "E.T"};
        int añoPublicacion = (int) (Math.random()*73+1950);
        String[] directores = {"Ridley Scott", "Paul W. S. Anderson", "Mitsuo Hashimoto", "Steven Spielberg"};
        String[] generos = {"terror", "aventuras", "accion", "fantasia"};
        return new pelicula(titulos[(int) (Math.random()* titulos.length)], añoPublicacion, directores[(int) (Math.random()* directores.length)], generos[(int) (Math.random()* generos.length)]);
    }
}
