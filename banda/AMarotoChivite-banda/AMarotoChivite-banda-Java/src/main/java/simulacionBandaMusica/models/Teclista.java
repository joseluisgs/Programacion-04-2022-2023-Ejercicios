package simulacionBandaMusica.models;

public class Teclista extends Musico {
    private static int contadorTeclista = 0;
    public final int salarioTeclista = (int) (salario * 1.30);
    final int id;
    int numTeclas;

    // Para instanciar posteriormente con el factory
    public Teclista(String name, String instrumento, int annoExperiencia, int numTeclas) {
        super(name, instrumento, annoExperiencia);
        this.numTeclas = numTeclas;
        id = autoContadorTeclista();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getContadorTeclista() {
        return contadorTeclista;
    }

    /**
     * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
     *
     * @return el ID del contador
     */
    private int autoContadorTeclista() {
        return contadorTeclista++;
    }

    @Override
    public String toString() {
        return "Teclista " + (id + 1) + "{" +
                " name= " + name +
                ", salarioTeclista=" + salarioTeclista +
                ", numTeclas=" + numTeclas +
                ", instrumento='" + instrumento + '\'' +
                ", annoExperiencia=" + annoExperiencia +
                '\'' +
                "}";
    }
}
