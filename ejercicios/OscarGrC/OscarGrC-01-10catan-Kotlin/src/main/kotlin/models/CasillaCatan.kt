package models

class CasillaCatan {
        val recurso:TipoRecurso = TipoRecurso.values().random()
        var master:String = ""
        val valor:Int= (1..6).random()
        var posicionEnTablero:Int = 0

    enum class TipoRecurso{
        Madera,Trigo,Piedra
    }
    }


