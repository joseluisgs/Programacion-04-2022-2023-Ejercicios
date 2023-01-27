package simulacionBandaMusica.models;

import simulacionBandaMusica.enums.TipoPercusion;

public class MultiInstrumentista extends Musico {

    private static int contadorMultiInstrumento = 0;
    public final int salarioMultiInstrumento = (int) (salario * 1.65);
    final int id;
    int numCuerdas;
    int numTeclas;
    TipoPercusion tipoPercusion;

    public MultiInstrumentista(String name, String instrumento, int annoExperiencia, int numCuerdas, int numTeclas, TipoPercusion tipoPercusion) {
        super(name, instrumento, annoExperiencia);
        this.numCuerdas = numCuerdas;
        this.numTeclas = numTeclas;
        this.tipoPercusion = tipoPercusion;
        id = autoContadorMultiInstrumento();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    static int getContadorBajista() {
        return contadorMultiInstrumento;
    }

    /**
     * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
     *
     * @return el ID del contador
     */
    private int autoContadorMultiInstrumento() {
        return contadorMultiInstrumento++;
    }

    @Override
    public String toString() {
        return "MultiInstrumento " + (id + 1) + "{" +
                " name= " + name +
                ", salarioBajista=" + salarioMultiInstrumento +
                ", numCuerdasBajo=" + numCuerdas +
                ", numTeclasTeclado=" + numTeclas +
                ", tipoPercusión=" + tipoPercusion +
                ", instrumento='" + instrumento + '\'' +
                ", annoExperiencia=" + annoExperiencia +
                '\'' +
                "}";
    }
}
