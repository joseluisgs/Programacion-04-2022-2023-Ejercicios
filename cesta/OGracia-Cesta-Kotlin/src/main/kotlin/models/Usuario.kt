package models

import factories.UsuarioFactory
import java.security.PrivateKey

data class Usuario(
    val nombre:String,
    private val password:String,
    private val correo:String,
    private val dni:String
) {
     override fun toString():String{
      return "Usuario:(Nombre=$nombre, Correo=$correo, Dni=$dni Contraseña=******"
 }
    fun isPassword(passwordUser:String):Boolean{
        if(password==passwordUser)return true
        return false
    }
}
