package modelsBandaMusicos;

public class Musico extends Persona {

    String nombre;
    Double salario = 1500.00;
    int añosExperiencia;

    public Musico(String nombre, int añosExperiencia){
        this.nombre = nombre;
        this.añosExperiencia = añosExperiencia;
    }

    public void interpretar(){
        System.out.println("Músico: Soy "+nombre+" y estoy interpretando...");
    }
}
