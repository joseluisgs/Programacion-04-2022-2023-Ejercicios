package models

import java.time.LocalDateTime
import java.util.UUID

class Cesta (  val masterCesta : Usuario){
    var lineasProductos:Array<LineaCesta>  =Array(20){LineaCesta(Producto("",0),0)}
    private val id = UUID.randomUUID()
    var totalCesta = 0
    var fecha = LocalDateTime.now()
    fun ordenarCesta(){
            for (i in 0 until lineasProductos.size - 1) {
                for (j in 0 until lineasProductos.size - 1 - i) {
                    if (lineasProductos[j].producto.nombre=="") {
                        val aux = lineasProductos[j]
                        lineasProductos[j] = lineasProductos[j + 1]
                        lineasProductos[j + 1] = aux
                    }
                }
            }
        }

        fun printCesta(){
            var contador= 0
            for(i in lineasProductos.indices){
                contador+=1
                if(lineasProductos[i].producto.nombre!=""){
                    print("$contador.-")
                    println(lineasProductos[i].toString())
                }}
        }
    }


