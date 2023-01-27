package simulacionBandaMusica.models;

import simulacionBandaMusica.enums.TipoGuitarra;

public class Guitarrista extends Musico {
    private static int contadorGuitarrista = 0;
    public final int salarioGuitarrista = (int) (salario * 1.35);
    final int id;
    TipoGuitarra tipoGuitarra;

    // Para instanciar posteriormente con el factory
    public Guitarrista(String name, String instrumento, int annoExperiencia, TipoGuitarra tipoGuitarra) {
        super(name, instrumento, annoExperiencia);
        this.tipoGuitarra = tipoGuitarra;
        id = autoContadorGuitarrista();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getContadorGuitarrista() {
        return contadorGuitarrista;
    }

    /**
     * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
     *
     * @return el ID del contador
     */
    private int autoContadorGuitarrista() {
        return contadorGuitarrista++;
    }

    @Override
    public String toString() {
        return "Guitarrista " + (id + 1) + "{" +
                " name= " + name +
                ", salarioGuitarrista=" + salarioGuitarrista +
                ", tipoGuitarra=" + tipoGuitarra +
                ", instrumento='" + instrumento + '\'' +
                ", annoExperiencia=" + annoExperiencia +
                '\'' +
                "}";
    }
}
