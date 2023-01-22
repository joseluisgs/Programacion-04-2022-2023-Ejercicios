package simulacionBandaMusica.models;

public class Trompetista extends Musico {
    private static int contadorTrompetista = 0;
    public final int salarioTrompetista = (int) (salario * 1.4);
    final int id;
    int capacidadPulomar;

    // Para instanciar posteriormente con el factory
    public Trompetista(String name, String instrumento, int annoExperiencia, int capacidadPulomar) {
        super(name, instrumento, annoExperiencia);
        this.capacidadPulomar = capacidadPulomar;
        id = autoContadorTrompetista();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getContadorTrompetista() {
        return contadorTrompetista;
    }

    /**
     * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
     *
     * @return el ID del contador
     */
    private int autoContadorTrompetista() {
        return contadorTrompetista++;
    }

    public String respirarTrompetista() {
        return "Estoy respirando como trompetista con una capacidad pulmonar de " + capacidadPulomar;
    }

    @Override
    public String toString() {
        return "Trompetista " + (id + 1) + "{" +
                " name= " + name +
                ", salarioTrompetista=" + salarioTrompetista +
                ", capacidadPulomar=" + capacidadPulomar +
                ", instrumento='" + instrumento + '\'' +
                ", annoExperiencia=" + annoExperiencia +
                '\'' +
                "}";
    }
}
