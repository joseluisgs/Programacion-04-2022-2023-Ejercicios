package models

data class Entrada (val sala:Int,val asiento:ButacaCine,val horaSesion:String ){

    val id:Int = getId()
    private var isPagada:Boolean = false
    val precio:Int = getPrecio(asiento)
    companion object {
        private var contador: Int = 0
        private fun getId(): Int {
            contador += 1
            return contador
        }
    }

    fun getPrecio(asiento: ButacaCine):Int{
            val precioNormal = 535
            val precioVip = 753
            return if(asiento.isVip) precioVip
            else precioNormal
    }

    fun pagar(){
        isPagada = true
    }
}