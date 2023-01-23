package simulacionBandaMusica.models;

public class Cantante extends Musico {
    private static int contadorCantante = 0;
    public final int salarioCantante = (int) (salario * 1.4);
    final int id;
    int capacidadPulomar;

    // Para instanciar posteriormente con el factory
    public Cantante(String name, String instrumento, int annoExperiencia, int Pulmonar) {
        super(name, instrumento, annoExperiencia);
        this.capacidadPulomar = Pulmonar;
        id = autoContadorCantante();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getContadorCantante() {
        return contadorCantante;
    }

    /**
     * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
     *
     * @return el ID del contador
     */
    private int autoContadorCantante() {
        return contadorCantante++;
    }

    public String respirarCantante() {
        return "Estoy respirando como cantante con una capacidad pulmonar de " + capacidadPulomar;
    }

    @Override
    public String toString() {
        return "Cantante " + (id + 1) + "{" +
                " name= " + name +
                ", salarioCantante=" + salarioCantante +
                ", capacidadPulmonar=" + capacidadPulomar +
                ", instrumento='" + instrumento + '\'' +
                ", annoExperiencia=" + annoExperiencia +
                '\'' +
                "}";
    }
}
