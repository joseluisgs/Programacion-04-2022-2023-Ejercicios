package simulacionBandaMusica.models;

public abstract class Musico extends Person {
    public static final int salario = 1500;
    // Campo de clase para mantener el incremento
    private static int contadorMusic = 0;
    String instrumento;
    int annoExperiencia;

    public Musico(String name, String instrumento, int annoExperiencia) {
        super(name);
        this.instrumento = instrumento;
        this.annoExperiencia = annoExperiencia;
        autoContadorMusic();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getContadorMusic() {
        return contadorMusic;
    }

    /**
     * Aumentamos un ID por cada músico que hemos creado, para disponer de un contador
     */
    private void autoContadorMusic() {
        contadorMusic++;
    }

    /**
     * El musico nos informará que está interprentando con su instrumento
     *
     * @return mensaje del músico
     */
    public String interpretar() {
        return "Estoy interpretando con mi " + this.instrumento;
    }
}
