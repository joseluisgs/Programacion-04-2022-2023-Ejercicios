package FactorySalaDeCine;

import ModelsSalaDeCine.pelicula;
import ModelsSalaDeCine.salaDeCine;

public class FactorySala {

    public FactorySala(){}
    private static FactorySala instance = null;

    public static FactorySala getInstance(){
        if(instance == null){
            instance = new FactorySala();
        }
        return instance;
    }

    /**
     * función que sirve para crear y devolver una sala de cine
     * @param nombre es el nombre de la sala de cine
     * @param fila es el número de filas de butacas en la sala
     * @param columna es el número de columnas de butacas en la sala
     * @param pelicula es el objeto pelicula que se representará en la sala del cine
     * @return la sala de cine creada según el parametro introducido
     */
    public salaDeCine create(String nombre, int fila, int columna, pelicula pelicula){
        return new salaDeCine(nombre, fila, columna, pelicula);
    }

    /**
     * función que genera cada uno de los apartados del cine de forma aleatorai
     * @return la sala de cine que se genero aleatoriamente
     */
    public salaDeCine crearSalaDeCineCompletamenteAleatoria() {
        String[] nombres = {"Teatro Chino TCL", "IMAX de Sidney", "Futuroscope", "Golden Village", "Sol Cinema"};
        int filas = (int) (Math.random()*26);
        int columnas = (int) (Math.random()*26);
        pelicula pelicula = FactoryPelicula.getInstance().crearPeliculaAleatoria();
        return new salaDeCine(nombres[(int) (Math.random()*nombres.length)], filas, columnas, pelicula);
    }
}
