package simulacionTaller.models;

public class Electrician extends Worker {
    // Campo de clase protected para mantener el incremento, también en Multi
    protected static int countElectrician = 0;

    private final int id = countElectrician;

    public Electrician(String name, int experienceYear, double salario, int dailyHours, BossAssigment bossAssigment) {
        super(name, experienceYear, salario, dailyHours, bossAssigment);
        autoCountElectrician();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getCountElectrician() {
        return countElectrician;
    }

    /**
     * El electricista arreglará la electricidad
     *
     * @return mensaje del electricista arreglando
     */
    public String fixElectrician() {
        return "El electricista ha arreglado la electricidad... ";
    }

    /**
     * El electricista está comiendo
     *
     * @return mensaje del comiendo
     */
    public String eatAsElectrician() {
        return "El electricista está comiendo... ";
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private void autoCountElectrician() {
        countElectrician++;
    }

    @Override
    public String toString() {
        return "Trabajador " + (id + 1) + " Electricista " + (id + 1) + "{" +
                " name= " + name +
                ", salario=" + salario +
                ", horas/día trabajadas= " + dailyHours +
                ", annoExperiencia=" + experienceYear +
                '\'' +
                "}";
    }
}
