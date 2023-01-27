package models

import java.time.LocalDate
import java.time.LocalTime

class Reloj {
    private val horaInicial = LocalTime.now().toString()
    private val horaInicialSplit = horaInicial.split(":",".")
    var hora = horaInicialSplit[0]
    var minutos = horaInicialSplit[1]
    var segundos = horaInicialSplit[2]
    var hora24 = hora+":"+minutos+"."+ segundos
    var hora12 = venticuatrodoce()

    var fechaAmericana = LocalDate.now().toString()
    private var fechaEuropeaSplit = fechaAmericana.split("-")
    var fechaEuropea = fechaEuropeaSplit[2]+"-"+fechaEuropeaSplit[1]+"-"+fechaEuropeaSplit[0]

    private fun venticuatrodoce():String{
        var horalocal = hora24.split(":",".")
        when(horalocal[0].toInt()){
            in 0..9    ->return "0"+(horalocal[0])+":"+horalocal[1]+"."+horalocal[2]+" AM"
            in 10..11  ->return (horalocal[0])+":"+horalocal[1]+"."+horalocal[2]+" AM"
            12               ->return (horalocal[0])+":"+horalocal[1]+"."+horalocal[2]+" PM"
            in 13..21  ->return "0"+(horalocal[0].toInt()-12).toString()+":"+horalocal[1]+"."+horalocal[2]+" PM"
            in 22..23  ->return (horalocal[0].toInt()-12).toString()+":"+horalocal[1]+"."+horalocal[2]+" PM"
        }
        return ""
    }

    fun avanzar() {
        var respuesta = ""
        var respuestaValida= false
        var regex = Regex("[1-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]|[1-9][0-9][0-9][0-9][0-9]")
        println("   ¿Cuantos segundos quieres hacer avanzar el tiempo?            max:99999")
        do {
            print("   :  ")
            respuesta= readln().trim()
            if (!regex.matches(respuesta)){ println("Fallo, Solo numeros entre 1-99999 ") }
            else{
                respuestaValida = true
            }
        }while(!respuestaValida)
       avanzarTiempo(respuesta.toInt())
    }

  private fun avanzarTiempo(cantidadtiempo:Int){
        var horaSplit = hora24.split(":",".")
        var fechaSplit = fechaAmericana.split("-")

        var horaActual = horaSplit[0].toInt()
        var minutosActuales = horaSplit[1].toInt()
        var segundosActuales = horaSplit[2].toInt() + cantidadtiempo
        var diaActual = fechaSplit[2].toInt()
        var mesActual = fechaSplit[1].toInt()
        var anoActual = fechaSplit[0].toInt()
        do{
            if(segundosActuales>=60){
                minutosActuales+=1
                segundosActuales-=60}
            if(minutosActuales>=60){
                horaActual+=1
                minutosActuales-=60}
            if(horaActual>=24){
                diaActual+=1
                horaActual= 0
            }
            when (mesActual) {
                1, 3, 5, 7, 8, 10 ->if (diaActual > 31) {
                    mesActual += 1
                    diaActual -= 31}
                2 ->if (diaActual > 28) {
                    mesActual += 1
                    diaActual -= 28}
                4, 6, 9, 11 -> if (diaActual > 30) {
                    mesActual += 1
                    diaActual -= 30 }
                12 ->if (diaActual > 31) {
                    mesActual = 1
                    anoActual += 1
                    diaActual -= 31
                }
            }
        }while(segundosActuales>=60)

        var horaSalida = horaActual.toString()
        if(horaActual<10){horaSalida ="0"+horaSalida }
        var minutosSalida = minutosActuales.toString()
        if(minutosActuales<10){minutosSalida ="0"+minutosSalida }
      var segundosSalida = segundosActuales.toString()
      if(segundosActuales<10){segundosSalida ="0"+segundosSalida }
        var diaSalida = diaActual.toString()
        if(diaActual<10){diaSalida ="0"+diaSalida }
        var mesSalida = mesActual.toString()
        if(mesActual<10){mesSalida ="0"+mesActual }
       hora = horaSalida
      minutos = minutosSalida
      segundos = segundosSalida
      hora24 = hora+":"+minutos+"."+ segundos
      hora12 = venticuatrodoce()
      fechaEuropea ="$diaSalida-$mesSalida-$anoActual"
      fechaAmericana ="$anoActual-$mesSalida-$diaSalida"
    }


}