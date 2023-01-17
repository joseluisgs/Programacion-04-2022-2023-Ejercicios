package models

import factories.UsuarioFactory

class BBDDUsuarios (val nombreBBDD:String) {
    private var listaUsuarios = Array(10) { Usuario("", "", "", "") }
    private var isLlenaLaLista = false
    fun getListaUsuarios(): Array<Usuario> {
        return listaUsuarios
    }

    fun arraytoString() {
        var salida = Array(listaUsuarios.size){""}
        for(i in listaUsuarios.indices){
            println(listaUsuarios[i].toString())
        }

    }


    fun getRandomBBDD() {

        for (i in listaUsuarios.indices) listaUsuarios[i] = UsuarioFactory.getInstance().createUsuarioRandom()
    }


    fun addNewUser(user:Usuario){
        val posicionLibre = getPositionLibre()
        listaUsuarios[posicionLibre]=user
    }
   private fun getPositionLibre(): Int {
        var posicionLocal: Int = -1
        do {
            for (i in listaUsuarios.indices) {
                if (listaUsuarios[i].nombre == "") return i
            }
            listaUsuariosAumenta()
        } while (posicionLocal==-1)
        return 0
    }
    private fun listaUsuariosAumenta(){
        var listaSalida = Array(listaUsuarios.size + 10) { Usuario("", "", "", "") }
        for (i in listaUsuarios.indices) {
            listaSalida[i] = listaUsuarios[i]
        }
        listaUsuarios= listaSalida
    }
}