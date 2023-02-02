package models

import kotlin.random.Random

class Cuadricula(private val filas: Int, private val columnas: Int, private val droides: Int) {
    private val random = Random
    private var droidesIniciales = 0
    private var droidesDestruidos = 0
    private var disparosRealizados = 0
    private var criticos = 0
    private var disparosFallados = 0
    private var tiempoInicial = System.currentTimeMillis()
    private var tiempoFinal = tiempoInicial + (1000 * (1 + random.nextInt(3))) //De uno a tres segundos
    private val arrayDroides = Array(filas) { arrayOfNulls<Droide>(columnas) }

    //Inicializa el array con las posibilidades indicadas en el enunciado
    init {
        for (i in 1..droides) {
            val tipoDroide = when (random.nextInt(100) + 1) {
                in 1..30 -> "SW348"
                in 31..80 -> "SW447"
                else -> "SW4421"
            }
            val energiaDroide = when (tipoDroide) {
                "SW348" -> 50
                "SW447" -> 100
                else -> random.nextInt(51) + 100
            }
            var x: Int
            var y: Int
            val droide = Droide(tipoDroide, energiaDroide)
            do {
                x = random.nextInt(filas)
                y = random.nextInt(columnas)
            }while(arrayDroides[x][y] != null)
            arrayDroides[x][y] = droide
            droidesIniciales++
        }
    }

    //Realiza una simulación con los parámetros indicados
    fun simulacion() {
        while (System.currentTimeMillis() < tiempoFinal && droidesDestruidos != droides) {
            val x = random.nextInt(filas)
            val y = random.nextInt(columnas)
            val droideDisparado = arrayDroides[x][y]
            var i = 1
            do {
                if (droideDisparado != null && droideDisparado.energia > 0) {
                    disparosRealizados++
                    if (random.nextInt(100) + 1 <= 15) {
                        droideDisparado.energia -= 5
                        criticos++
                    } else {
                        droideDisparado.energia --
                    }
                    if (droideDisparado.energia <= 0) {
                        droidesDestruidos++
                        arrayDroides[x][y] = null
                    }
                }else {
                    disparosRealizados++
                    disparosFallados++
                }
                Thread.sleep(100)
                i += 1
            }while (i < 3)
            moverDroides()
        }
    }

    //Mueve los droides por el array
    private fun moverDroides() {
        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                val droid = arrayDroides[i][j]
                if (droid != null) {
                    val newX = random.nextInt(filas)
                    val newY = random.nextInt(columnas)
                    val newDroid = arrayDroides[newX][newY]
                    arrayDroides[newX][newY] = droid
                    arrayDroides[i][j] = newDroid
                }
            }
        }
    }

    //Devuelve la lista de los droides ordenada por vida
    private fun listaDroidesOrdenada(): Array<Droide?> {
        var contador = 0
        val lista = arrayOfNulls<Droide>(droides)
        for (i in 0 until filas) {
            for (j in 0 until columnas) {
                val droide = arrayDroides[i][j]
                if (droide != null) {
                    lista[contador] = droide
                    contador++
                }
            }
        }
        lista.sortBy { it?.energia }
        return lista
    }


    //Lo he hecho también con listas porque se que es más cómodo pero lo he entregado con array

    /*private fun listaDroidesOrdenada(): List<Droide> {
         val lista = arrayListOf<Droide>()
         for (i in 0 until filas) {
             for (j in 0 until columnas) {
                 val droide = arrayDroides[i][j]
                 if (droide != null) {
                     lista.add(droide)
                 }
             }
         }
         return lista.sortedBy {it.energia}
    }*/

    //Muestra los críticos acertados a lo largo de la simulación, esto no lo pide el ejercicio pero lo he añadido porque me parecía importante
    private fun porcentajeDeCriticos(): String {
        return if (disparosRealizados != 0)
            "Porcentaje de criticos: ${(criticos*100/disparosRealizados)}% ($criticos)"
        else
            "Porcentaje de criticos: 0%"
    }

    //Realiza un informe de la simulación
    fun informe(){
        println("Disparos realizados: $disparosRealizados")
        println(porcentajeDeCriticos())
        println("Porcentaje de acierto: ${((disparosRealizados - disparosFallados)*100)/disparosRealizados}% (${disparosRealizados - disparosFallados})")
        println("Droides destruidos: $droidesDestruidos")
        println("Duración de la simulación: ${(tiempoFinal - tiempoInicial) / 1000} segundo/s")
        println("Droides Iniciales: $droidesIniciales")
        println("Droides Finales: ${droidesIniciales - droidesDestruidos}")
        println("Lista de droides ordenados: ")
        for (droide in listaDroidesOrdenada()) {
            println("Tipo: ${droide?.tipo} - Energía: ${droide?.energia}")
        }
    }
}
