package repositories

import models.Musico

interface MusicosRepository {
    fun getAll(): Array<Musico>
    fun getSalarioTotal(): Int
    fun getSalarioMusico()
    fun getConocerMusico()
    fun getBuscarByNombre(nombre: String)
    fun getMusicoSalarioByEspecialidad()
}