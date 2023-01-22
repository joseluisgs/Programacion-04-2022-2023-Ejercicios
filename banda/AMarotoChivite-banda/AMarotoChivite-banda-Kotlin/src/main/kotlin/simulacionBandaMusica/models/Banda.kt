package simulacionBandaMusica.models

data class Banda(val vectorMusicos: Array<Musico?>) {
    fun print() {
        for (i in vectorMusicos.indices) {
            println(vectorMusicos[i])
        }
    }
}