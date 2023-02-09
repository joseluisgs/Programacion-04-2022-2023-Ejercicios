package models

//Clase principal para crear diferentes aparcamientos
class Aparcamiento (private val nombre: String, val filas: Int, val columnas: Int){
    private val arrayPlazasAparcamiento = Array(filas) { arrayOfNulls<PlazaAparcamiento>(columnas) }
    private val arrayCoches = Array(filas) { arrayOfNulls<Coche>(columnas)}
    //No he sido capaz de ordenar una array por la edad asique he utilizado una lista solo en esta función
    private val arrayCochesOrdenados = mutableListOf<Coche>()

    //Init de las plazas del Parking
    init {
        for (i in 0 until filas)
            for (j in 0 until columnas) {
                arrayPlazasAparcamiento[i][j] = PlazaAparcamiento()
                arrayCoches[i][j] = Coche()
            }
    }

    //Método para ver las plazas y los estados de las plazas de un parking seleccionado
    fun verPlazas() {
        for (i in filas - 1  downTo 0) {
            print("\t${i+1}")
            for (j in 0 until columnas) {
                when (arrayPlazasAparcamiento[i][j]?.estado) {
                    Estados.LIBRE -> print("\t$GREEN     $RESET")
                    Estados.OCUPADO -> print("\t$RED     $RESET")
                    else -> {}
                }
            }
            println()
            println()
        }
        print("\t\t")
        for (i in 0 until columnas) {
            print("  ${i + 1}\t")
        }
        println()
        println()
    }

    //Método para aparcar un coche en un parking en específico
    fun aparcarCoche(coche: Coche?, columna: Int, fila: Int) {
        if (arrayPlazasAparcamiento[fila][columna]?.estado == Estados.OCUPADO)
            println("Esta plaza ya está ocupada.")
        else{
            arrayPlazasAparcamiento[fila][columna] = PlazaAparcamiento(coche, Estados.OCUPADO)
            arrayCoches[fila][columna] = coche
            println("La plaza se ha ocupado.")
        }
    }

    //Método para desaparcar un coche
    fun quitarCoche(columna: Int, fila: Int) {
        if (arrayPlazasAparcamiento[fila][columna]?.estado == Estados.LIBRE)
            println("Esta plaza está libre.")
        else {
            arrayPlazasAparcamiento[fila][columna] = PlazaAparcamiento()
            arrayCoches[fila][columna] = Coche()
            println("La plaza se ha liberado.")
        }
    }

    //Método para imprimir en pantalla los coches ordenados por antiüedad de un parking
    fun cochesOrdenados() {
        for (i in 0 until filas){
            for (j in 0 until columnas)
                if (arrayPlazasAparcamiento[i][j]?.estado == Estados.OCUPADO)
                    arrayCochesOrdenados.add(arrayPlazasAparcamiento[i][j]!!.coche!!)
        }
        //No era capaz de hacerlo con array asique he utilizado una lista para ordenar los coches
        arrayCochesOrdenados.sortBy { it.antiguedad }
        for (coche in arrayCochesOrdenados)
            println("Marca: ${coche.marca}, Modelo: ${coche.modelo}, Antigüedad: ${coche.antiguedad} años.")
    }

    //Método para contar las plazas ocupadas de un parking
    fun contarPlazasOcupadas(): Int {
        var x = 0
        for (i in 0 until filas) {
            for (j in 0 until columnas)
                if (arrayPlazasAparcamiento[i][j]?.estado == Estados.OCUPADO)
                    x++
        }
        return x
    }

    //Método para buscar un coche en específico dentro de los parkings
    fun buscarCoche(coche: Coche?) {
        for (i in 0 until filas){
            for (j in 0 until columnas)
                if (arrayPlazasAparcamiento[i][j]?.estado == Estados.OCUPADO){
                    if (arrayPlazasAparcamiento[i][j]?.coche == coche)
                        println("Hay un ${coche?.marca} ${coche?.modelo} en el $nombre,  columna ${j+1}, fila ${i + 1}.")
                    else
                        println("En el $nombre no está ese coche.")
                }
        }
    }
}

