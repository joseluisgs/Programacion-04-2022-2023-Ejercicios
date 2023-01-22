package simulacionTaller.models;

public class Boss extends PersonBrench {
    // Campo de clase para mantener el incremento
    private static int countBoss = 0;
    private final int id = countBoss;
    public Worker[] dependents;

    public Boss(String name, int experienceYear, double salario, Worker[] dependents) {
        super(name, experienceYear, salario);
        this.dependents = dependents;
        autoCountBoss();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getCountBoss() {
        return countBoss;
    }

    /**
     * Establecer los trabajadores que dependen del jefe
     *
     * @param dependents
     */
    public void setDependents(Worker[] dependents) {
        this.dependents = dependents;
    }

    /**
     * El jefe dará latigazos de manera aleatoria a un miembro de su plantilla
     *
     * @return mensaje de los látigos del jefe
     */
    public String lashes() {
        int randomLashes = (int) (Math.random() * 10 + 1);
        int randomMember = (int) (Math.random() * dependents.length + 1);
        Worker dependentLashed = dependents[randomMember - 1];
        return "El jefe ha dado " + randomLashes + " latigazos a " + dependentLashed.name + "\nY NADIE COBRA HOY!";
    }

    /**
     * El jefe pagará a los empleados, se imprimirá en pantalla
     */
    public void printPayWorkers() throws InterruptedException {
        System.out.println("El jefa va a pagar el salario de cada empleado...");
        for (int i = 0; i < dependents.length; i++) {
            System.out.println(dependents[i].name + " ha cobrado " + dependents[i].salario);
            Thread.sleep(500);
        }
    }

    /**
     * El jefe nos saludará de una manera distinta a la de una persona normal
     *
     * @return saludo del jefe
     */
    public String greetAsBoss() {
        return "Soy " + name + ": Estoy saludando de forma chulesca como jefe... ";
    }

    /**
     * Aumentamos un ID por cada jefe que hemos creado, para disponer de un contador
     */
    private void autoCountBoss() {
        countBoss++;
    }

    @Override
    public String toString() {
        return "Jefe de Taller " + (id + 1) + "{" +
                " name= " + name +
                ", salario=" + salario +
                ", trabajadores a cargo = " + dependents.length +
                ", annoExperiencia=" + experienceYear +
                '\'' +
                "}";
    }
}
