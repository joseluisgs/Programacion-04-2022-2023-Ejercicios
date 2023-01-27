package FactoriesCestaDeCompra

import ModelsCestaDeCompra.Usuario

class FactoryUsuario {

    companion object{
        private var instance: FactoryUsuario? = null

        fun getInstance(): FactoryUsuario?{
            if(instance == null){
                instance = FactoryUsuario()
            }
            return instance
        }
        var contadorUsuarios = 1
        fun nextId():Int{
            return contadorUsuarios++
        }
    }

    /**
     * función que sirve para crear un usuario aleatorio
     * @return el usuario cuyas propiedades se crearon al azar
     */
    fun crearUsuarioRandom(): Usuario{
        val nombres = arrayOf("Jose", "Paco", "Manuel", "Iván", "Romeo", "Belén", "Teseo")
        return Usuario(nextId(), nombres.random())
    }
}