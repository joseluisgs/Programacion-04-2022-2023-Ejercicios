package simulacionTaller.models;

import static simulacionTaller.models.Electrician.getCountElectrician;
import static simulacionTaller.models.Multi.getCountMulti;

public class Plater extends Worker {
    // Campo de clase protected para mantener el incremento, también en Multi
    protected static int countPlater = 0;

    private final int idPlater = countPlater;


    public Plater(String name, int experienceYear, double salario, int dailyHours, BossAssigment bossAssigment) {
        super(name, experienceYear, salario, dailyHours, bossAssigment);
        autoCountPlater();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getCountPlater() {
        return countPlater;
    }

    /**
     * El chapista arreglará la chapa
     *
     * @return mensaje de chapista arreglando
     */
    public String fixPlate() {
        return "El chapista ha arreglado la chapa... ";
    }

    /**
     * El chapista está descansando
     *
     * @return mensaje del chapista descansando
     */
    public String restAsPlater() {
        return "El chapista está descansando... ";
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private void autoCountPlater() {
        countPlater++;
    }

    @Override
    public String toString() {
        return "Trabajador " + (idPlater + 1 + getCountElectrician() - getCountMulti()) + " Chapista " + (idPlater + 1) + "{" +
                " name= " + name +
                ", salario=" + salario +
                ", horas/día trabajadas= " + dailyHours +
                ", annoExperiencia=" + experienceYear +
                '\'' +
                "}";
    }
}
