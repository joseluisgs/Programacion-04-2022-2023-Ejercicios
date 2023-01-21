package salacine.models

import salacine.enums.ButacaEstado

data class Sala(val nombre: String, val film: Film, val size: Pair<Int, Int>){

    private var butacas: Array<Array<Butaca>> = Array(size.second){ Array(size.first){ Butaca(ButacaEstado.LIBRE) } }

    /**
     * Constructor secundario para indicar la probabilidad de que una butaca sea vip
     * @param size Par que indica la X -> fila y la Y -> columnas que va a tener la sala
     * @param vipProbability Rango que marca la probabilidad de que una butaca sea vip, la escala va de 0-100
     */
    constructor(nombre: String, film: Film, size: Pair<Int, Int>, vipProbability: Int): this(nombre, film, size) {
        butacas = Array(this.size.second){ Array(this.size.first){ Butaca(ButacaEstado.LIBRE, vipProbability) } }
    }

    fun mostrarSala(){
        // region Información general
        println("Disposición en la sala ${this.nombre}:")
        println("Para la película ${film.titulo}:\n")
        // endregion

        mostrarButacas()

        // region Información en cuanto a números
        println("Esto da un total de:\n" + countEstadosText())
        println("Y un balance total de ${balanceSala()} €.")
        // endregion
    }

    fun mostrarButacas() {
        mostrarIndices()
        println()
        for (i in butacas.indices.last downTo 0) {
            print("\t|  ${alphabetNumberToString(i)}  |\t")
            for (j in butacas[i].indices) {

                val vipMarc = if (butacas[i][j].getIsVip()) '*' else ' '

                print(
                    when (butacas[i][j].getEstado()) {
                        ButacaEstado.RESERVADA -> "\t| $vipMarc R $vipMarc |\t"
                        ButacaEstado.OCUPADA -> "\t| $vipMarc O $vipMarc |\t"
                        else -> "\t| $vipMarc L $vipMarc |\t"
                    }
                )
            }
            println()
        }
    }

    private fun mostrarIndices() {
        print("\t|     |\t")
        for (i in butacas[0].indices) {
            print("\t|   ${i + 1}  |\t")
        }
    }

    fun countEstadosText(): String{
        val countEstados = countEstados()
        return  "\t${countEstados[0]} butacas libres.\n" +
                "\t${countEstados[1]} butacas reservadas.\n" +
                "\t${countEstados[2]} butacas ocupadas."
    }

    /**
     * Hace la traducción de número a carácter según el alfabeto español.
     * 0 -> A; 26 -> Z; AA -> 27
     */
    fun alphabetNumberToString(num: Int): String {
        val alphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
        val result = StringBuilder()
        var number = num
        while (number >= 0) {
            result.append(alphabet[number % alphabet.length])
            number /= alphabet.length
            number -= 1
        }
        return result.reverse().toString()
    }

    /**
     * Función que edita el estado de una determinada butaca.
     * @param pos Es un par que almacena la X y la Y de la butaca, es decir su posición
     * @param estadoEqual Determina que actualmente la butaca requiere estar en ese estado
     * @param newEstado Es el nuevo estado de la butaca
     */
    private fun editButaca(pos: Pair<Int, Int>, estadoEqual: ButacaEstado, newEstado: ButacaEstado): Boolean{
        if(pos.second > butacas.lastIndex || pos.first > butacas[0].lastIndex) return false
        if (butacas[pos.second][pos.first].getEstado() != estadoEqual) return false
        butacas[pos.second][pos.first].setEstado(newEstado)
        return true
    }

    fun reservaButaca(pos: Pair<Int, Int>): Boolean{
        return editButaca(pos, ButacaEstado.LIBRE, ButacaEstado.RESERVADA)
    }

    fun formalizarReserva(pos: Pair<Int, Int>): Boolean{
        return editButaca(pos, ButacaEstado.RESERVADA, ButacaEstado.OCUPADA)
    }

    fun anularReserva(pos: Pair<Int, Int>): Boolean{
        if(pos.second > butacas.lastIndex || pos.first > butacas[0].lastIndex) return false
        if (butacas[pos.second][pos.first].getEstado() == ButacaEstado.LIBRE) return false
        butacas[pos.second][pos.first].setEstado(ButacaEstado.LIBRE)
        return true
    }

    internal fun countEstados(): IntArray{
        val newArray = IntArray(3)
        newArray[0] = countButacas(ButacaEstado.LIBRE)
        newArray[1] = countButacas(ButacaEstado.RESERVADA)
        newArray[2] = countButacas(ButacaEstado.OCUPADA)
        return newArray
    }

    fun balanceSala(precioNormal: Float = 5.35f, precioVip: Float = 8.5f): Float{
        var count = 0f
        for (i in butacas){
            for (j in i){
                if (j.getEstado() == ButacaEstado.OCUPADA) count += if (j.getIsVip()) precioVip else precioNormal
            }
        }
        return count
    }

    private fun countButacas(estado: ButacaEstado): Int {
        var count = 0
        for (i in butacas){
            for (j in i){
                if (j.getEstado() == estado) count++
            }
        }
        return count
    }

    internal fun getSize(): Pair<Int, Int> {
        return Pair(butacas[0].size, butacas.size)
    }
}