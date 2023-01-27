package simulacionTaller.models;

import simulacionTaller.interfaces.InterfaceElectrician;
import simulacionTaller.interfaces.InterfacePlater;

import static simulacionTaller.models.Electrician.getCountElectrician;
import static simulacionTaller.models.Plater.getCountPlater;

public class Multi extends Worker implements InterfacePlater, InterfaceElectrician {
    // Campo de clase para mantener el incremento
    private static int countMulti = 0;
    private final int id = countMulti;

    public Multi(String name, int experienceYear, double salario, int dailyHours, BossAssigment bossAssigment) {
        super(name, experienceYear, salario, dailyHours, bossAssigment);
        autoCountMulti();
        init();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getCountMulti() {
        return countMulti;
    }

    /**
     * Aumentamos la cantidad de electricistas y chapistas que hay, ya que el multi cuenta como uno de cada
     */
    public void init() {
        Plater.countPlater += 1;
        Electrician.countElectrician += 1;
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private void autoCountMulti() {
        countMulti++;
    }

    /**
     * El multi actuará como electricista y arreglará la electricidad
     *
     * @return mensaje del multi como eletricista arreglando
     */
    @Override
    public String fixElectrician() {
        return "El multi ha arreglado la electricidad...";
    }

    /**
     * El multi comerá
     *
     * @return mensaje del multi comiendo
     */
    @Override
    public String eatAsElectrician() {
        return "El multi está comiendo...";
    }

    /**
     * El multi actuará como chapista y arreglará la chapa
     *
     * @return mensaje del multi como chapista arreglando
     */
    @Override
    public String fixPlate() {
        return "El multi ha arreglado la chapa...";
    }

    /**
     * El multi descansará
     *
     * @return mensaje del multi descansando
     */
    @Override
    public String restAsPlater() {
        return "El multi está descansado...";
    }

    @Override
    public String toString() {
        return "Trabajador " + (id + 1 + (getCountElectrician() + getCountPlater()) - (getCountMulti() * 2)) + " Multi " + (id + 1) + "{" +
                " name= " + name +
                ", salario=" + salario +
                ", horas/día trabajadas= " + dailyHours +
                ", annoExperiencia=" + experienceYear +
                '\'' +
                "}";
    }
}
