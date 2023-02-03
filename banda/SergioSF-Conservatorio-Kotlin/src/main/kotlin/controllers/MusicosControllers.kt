package controllers

import models.Musico
import repositories.MusicosRepository

class MusicosControllers(
    private val musicosRepository: MusicosRepository
) {
    fun getAll(): Array<Musico> {
        return musicosRepository.getAll()
    }

    fun getSalarioTotal(): Int {
        return musicosRepository.getSalarioTotal()
    }

    fun getSalarioMusico() {
        return musicosRepository.getSalarioMusico()
    }

    fun getConocerMusico() {
        return musicosRepository.getConocerMusico()
    }

    fun getBuscarByNombre(nombre: String) {
        return musicosRepository.getBuscarByNombre(nombre)
    }

    fun getSalarioByEspecialidad() {
        return musicosRepository.getMusicoSalarioByEspecialidad()
    }
}