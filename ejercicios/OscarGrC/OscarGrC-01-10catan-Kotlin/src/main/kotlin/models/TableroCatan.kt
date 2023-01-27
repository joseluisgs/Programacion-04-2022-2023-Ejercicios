package models

class TableroCatan {
    var tablero = Array(4){Array(3){CasillaCatan()}}

    init {
        var contador = 0
        for(i in tablero.indices){
            for(j in tablero[i].indices){
                contador +=1
                tablero[i][j].posicionEnTablero = contador
                }
            }
        }

    fun printTablero(){
        println("  ---------------------------------------------------------------------------------------------------")
        var ajusteVisual1 = ""
        var ajusteVisual2 =""
        for(i in tablero.indices){
            print(" | ")
            for(j in tablero[i].indices){
                if(tablero[i][j].recurso==CasillaCatan.TipoRecurso.Trigo)ajusteVisual1+=" "
                if(tablero[i][j].master=="IA")ajusteVisual2+="     "
                print(  "Valor:${tablero[i][j].valor} " +
                        "Recurso ${tablero[i][j].recurso}$ajusteVisual1" +
                        " Prodiedad ${tablero[i][j].master}$ajusteVisual2 | ")
                ajusteVisual1 = ""
                ajusteVisual2= ""
            }
            println ("")
            println("  -----------------------------------------------------------------------------------------------")
        }

    }
    fun printTableroColocacion(){
        println("  -------------------------------------------------------------------------------------------------" +
                "----------------------------------------------")

        var ajusteVisual1 = ""
        var ajusteVisual2 = ""

        for(i in tablero.indices){
            print(" | ")
            for(j in tablero[i].indices){
                if(tablero[i][j].recurso==CasillaCatan.TipoRecurso.Trigo)ajusteVisual1+=" "
                if(tablero[i][j].posicionEnTablero<10)ajusteVisual2+=" "
                print("Posicion: ${tablero[i][j].posicionEnTablero}$ajusteVisual2 Recurso ${tablero[i][j].recurso}" +
                        "$ajusteVisual1 Propiedad ")
                when(tablero[i][j].master){
                    "" ->print("Libre   | ")
                    "Jugador" -> print("Jugador | ")
                    "IA"-> print("IA      | ")}
                ajusteVisual1 = ""
                ajusteVisual2 = ""
            }
            println ("")
            println("  -------------------------------------------------------------------------------------------------" +
                    "----------------------------------------------")
        }

    }
}
