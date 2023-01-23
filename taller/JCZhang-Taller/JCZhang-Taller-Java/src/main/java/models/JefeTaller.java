package models;


public class JefeTaller extends Persona {

    public JefeTaller(String nombre, int aniosExp) {
        this.nombre = nombre;
        this.aniosExp = aniosExp;
    }

    @Override
    void saludar() {
        System.out.println("Jefe De Taller: Hola! Me llamo " + nombre +", soy el jefe de taller y aquí mando yo");
    }

    @Override
    public String toString() {
        return "JefeTaller (" +nombre+" con " + aniosExp +"años de experiencia)";

    }

    public void darLatigazo(){
        System.out.println("Jefe De Taller: ESTOY DANDO LATIGAZOS!!! SUFREEE!!!!");
    }

    public void pagar(){
        System.out.println("Jefe De Taller: TE ESTOY PAGANDO PEDAZO DE VAGO SUCIO FEO ASQUEROSO RARO TONTO (insertar aquí cosas malas), ASI QUE TRABAJA PARA MI!!!!!");
    }
}
