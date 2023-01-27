package simulacionTaller.models;

public abstract class PersonBrench {
    private static int personCount = 0;
    public String name;
    int experienceYear;
    double salario;

    public PersonBrench(String name, int experienceYear, double salario) {
        this.name = name;
        this.experienceYear = experienceYear;
        this.salario = salario;
        autoCountPerson();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getPersonCount() {
        return personCount;
    }

    /**
     * La persona nos informa que está saludando
     *
     * @return el mensaje de la persona saludando
     */
    public String greetAsPerson() {
        return "Estoy saludando como persona... ";
    }

    /**
     * Aumentamos un ID por cada persona que hemos creado, para disponer de un contador
     */
    private void autoCountPerson() {
        personCount++;
    }

}
