package Factories

import ModelsSalaDeCine.pelicula
import ModelsSalaDeCine.salaDeCine

class SalaDeCineFactory {

    companion object{
        private var instance: SalaDeCineFactory? = null

        fun getInstance(): SalaDeCineFactory?{
            if(instance == null){
                instance = SalaDeCineFactory()
            }
            return instance
        }
    }

    /**
     * función que sirve para crear y devolver una sala de cine
     * @param nombre es el nombre de la sala de cine
     * @param fila es el número de filas de butacas en la sala
     * @param columna es el número de columnas de butacas en la sala
     * @param butacasVip es el número de butacas vip que habrá en la sala de cine
     * @param pelicula es el objeto pelicula que se representará en la sala del cine
     * @return la sala de cine creada según el parametro introducido
     */
    fun crearSalaDeCine(nombre: String, fila: Int, columna: Int, butacasVip: Int, pelicula: pelicula): salaDeCine {
        return salaDeCine(nombre, fila, columna, butacasVip,pelicula)
    }

    /**
     * función que genera cada uno de los apartados del cine de forma aleatorai
     * @return la sala de cine que se genero aleatoriamente
     */
    fun crearSalaDeCineCompletamenteAleatoria(): salaDeCine {
        val nombres = arrayOf("Teatro Chino TCL", "IMAX de Sidney", "Futuroscope", "Golden Village", "Sol Cinema")
        val filas = (1..26).random()
        val columnas = (1..26).random()
        var butacasVip = 0
        do{
            butacasVip = (1..676).random()
        }while(butacasVip > (filas*columnas))
        val pelicula = PeliculaFactory.getInstance()!!.crearPeliculaAleatoria()
        return salaDeCine(nombres.random(), filas, columnas, butacasVip, pelicula)
    }

}