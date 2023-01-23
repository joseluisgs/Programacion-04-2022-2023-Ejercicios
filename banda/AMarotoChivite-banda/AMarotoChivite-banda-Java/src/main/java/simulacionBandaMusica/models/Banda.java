package simulacionBandaMusica.models;

public record Banda(Musico[] vectorMusicos) {

    public void print() {
        for (int i = 0; i < vectorMusicos.length; i++) {
            System.out.println(vectorMusicos[i]);
        }
    }
}
