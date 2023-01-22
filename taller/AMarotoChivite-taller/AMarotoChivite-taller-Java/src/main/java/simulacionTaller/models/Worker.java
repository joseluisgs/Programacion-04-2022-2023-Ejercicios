package simulacionTaller.models;

public class Worker extends PersonBrench {
    // Campo de clase para mantener el incremento
    private static int countWorkerGeneral = 0;
    protected final int id = countWorkerGeneral;
    public BossAssigment bossAssigment;
    int dailyHours;

    public Worker(String name, int experienceYear, double salario, int dailyHours, BossAssigment bossAssigment) {
        super(name, experienceYear, salario);
        this.dailyHours = dailyHours;
        this.bossAssigment = bossAssigment;
        autoCountWorker();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getCountWorkerGeneral() {
        return countWorkerGeneral;
    }

    /**
     * El trabajador trabajará
     *
     * @return mensaje de trabajo del trabajador
     */
    public String work() {
        return "El trabajador está trabajando... ";
    }

    /**
     * El trabajador descansará
     *
     * @return mensaje de descanso del trabajador
     */
    public String restAsWorker() {
        return "El trabajador está descansando... ";
    }

    /**
     * El trabajador nos saludará de una manera distinta a la de una persona normal
     *
     * @return saludo del trabajador
     */
    public String greet() {
        return "Soy " + name + " Estoy saludando con respeto como trabajador... ";
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private void autoCountWorker() {
        countWorkerGeneral++;
    }

    @Override
    public String toString() {
        return "Trabajador " + (id + 1) + "{" +
                " name= " + name +
                ", salario=" + salario +
                ", horas/día trabajadas= " + dailyHours +
                ", annoExperiencia=" + experienceYear +
                '\'' +
                "}";
    }

    public enum BossAssigment {
        WITH_BOSS,
        WITHOUT_BOSS
    }
}
