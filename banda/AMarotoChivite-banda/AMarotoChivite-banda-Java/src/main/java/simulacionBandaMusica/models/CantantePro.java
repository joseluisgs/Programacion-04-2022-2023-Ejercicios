package simulacionBandaMusica.models;

import simulacionBandaMusica.enums.TipoGuitarra;

public class CantantePro extends Musico {
    private static int contadorCantantePro = 0;
    public final int salarioCantantePro = (int) (salario * 1.5);
    final int id;
    int capacidadPulomar;

    TipoGuitarra tipoGuitarra;

    public CantantePro(String name, String instrumento, int annoExperiencia, int capacidadPulomar, TipoGuitarra tipoGuitarra) {
        super(name, instrumento, annoExperiencia);
        this.tipoGuitarra = tipoGuitarra;
        id = autoContadorCantantePro();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    static int getContadorBajista() {
        return contadorCantantePro;
    }

    /**
     * Aumentamos un ID por cada cantante que hemos creado, para disponer de un contador
     *
     * @return el ID del contador
     */
    private int autoContadorCantantePro() {
        return contadorCantantePro++;
    }

    @Override
    public String toString() {
        return "CantantePro " + (id + 1) + "{" +
                " name= " + name +
                ", salarioCantantePro=" + salarioCantantePro +
                ", capacidadPulmonar=" + capacidadPulomar +
                ", tipoGuitarra=" + tipoGuitarra +
                ", instrumento='" + instrumento + '\'' +
                ", annoExperiencia=" + annoExperiencia +
                '\'' +
                "}";
    }
}
