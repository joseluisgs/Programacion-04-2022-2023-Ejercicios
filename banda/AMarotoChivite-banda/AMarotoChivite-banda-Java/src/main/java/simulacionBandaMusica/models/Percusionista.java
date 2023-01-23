package simulacionBandaMusica.models;

import simulacionBandaMusica.enums.TipoPercusion;

public class Percusionista extends Musico {
    private static int contadorPercusionista = 0;
    public final int salarioPercusionista = (int) (salario * 1.35);
    final int id;
    TipoPercusion tipoPercusion;

    // Para instanciar posteriormente con el factory
    public Percusionista(String name, String instrumento, int annoExperiencia, TipoPercusion tipoPercusion) {
        super(name, instrumento, annoExperiencia);
        this.tipoPercusion = tipoPercusion;
        id = autoContadorPercusionista();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getContadorPercusionista() {
        return contadorPercusionista;
    }

    /**
     * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
     *
     * @return el ID del contador
     */
    private int autoContadorPercusionista() {
        return contadorPercusionista++;
    }

    @Override
    public String toString() {
        return "Percusionista " + (id + 1) + "{" +
                " name= " + name +
                ", salarioPercusionista=" + salarioPercusionista +
                ", tipoPercusión=" + tipoPercusion +
                ", instrumento='" + instrumento + '\'' +
                ", annoExperiencia=" + annoExperiencia +
                '\'' +
                "}";
    }
}
