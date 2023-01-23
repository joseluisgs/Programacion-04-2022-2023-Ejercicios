package simulacionBandaMusica.models;

public abstract class Person {
    private static int contadorPerson = 0;
    String name;

    public Person(String name) {
        this.name = name;
        autoContadorPerson();
    }

    /**
     * Creamos un get, para encapsular el valor del contador y no poderlo manipular
     */
    public static int getContadorPerson() {
        return contadorPerson;
    }

    /**
     * Aumentamos un ID por cada persona que hemos creado, para disponer de un contador
     */
    private void autoContadorPerson() {
        contadorPerson++;
    }

    /**
     * La persona nos informa que está respirando, la asigno como filan, para que no me
     * sobreescriban esta función sus hijos
     *
     * @return el mensaje de la persona respirando
     */
    public String respirar() {
        return "Estoy respirando...";
    }
}
