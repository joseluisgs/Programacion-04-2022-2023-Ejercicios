package simulacionBandaMusica.models;

public class Bajista extends Musico {
    private static int contadorBajista = 0;
    public final int salarioBajista = (int) (salario * 1.30);
    final int id;
    int numCuerdas;

    // Para instanciar posteriormente con el factory
    public Bajista(String name, String instrumento, int annoExperiencia, int numCuerdas) {
        super(name, instrumento, annoExperiencia);
        this.numCuerdas = numCuerdas;
        id = autoContadorBajista();
    }

    /**
     * Creamos un get, para encapsular el valor del contador en private y no poderlo manipular
     */
    public static int getContadorBajista() {
        return contadorBajista;
    }

    /**
     * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
     *
     * @return el ID del contador
     */
    private int autoContadorBajista() {
        return contadorBajista++;
    }

    @Override
    public String toString() {
        return "Bajista " + (id + 1) + "{" +
                " name= " + name +
                ", salarioBajista=" + salarioBajista +
                ", numCuerdas=" + numCuerdas +
                ", instrumento='" + instrumento + '\'' +
                ", annoExperiencia=" + annoExperiencia +
                '\'' +
                "}";
    }
}
