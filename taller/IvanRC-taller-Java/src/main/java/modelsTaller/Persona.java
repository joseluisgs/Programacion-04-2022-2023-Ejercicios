package modelsTaller;

interface IJefeTaller {
    default void saludar() {
        System.out.println("Jajajaja, hola empleado, soy tu jefe *derrogatorio*");
    }

    void darLatigazos();

    default void pagar() {
        System.out.println("Hola, empleado, te pago *tristeza*");
    }
}

interface ITrabajador {
    default void saludar() {
        System.out.println("Hola jefe, como está el día de hoy *amable*");
    }

    void comer();

    void trabajar();

    void descansar();
}

interface IChapista {
    void comer();

    void trabajar();

    void descansar();
}

interface IElectricista {
    void comer();

    void trabajar();

    void descansar();
}
sealed public class Persona {

    int id = nextId();
    String nombre;
    int añosExperiencia;

    public Persona(String nombre, int añosExperiencia){
        this.nombre = nombre;
        this.añosExperiencia = añosExperiencia;
    }

    static int contador = 1;
    public int nextId() {return contador++;}

    public static final class JefeTaller extends Persona implements IJefeTaller {
        String nombre;
        int experiencia;
        int personasACargo;

        public JefeTaller(String nombre, int añosExperiencia, int personasACargo) {
            super(nombre, añosExperiencia);
            this.personasACargo = personasACargo;
        }

        @Override
        public String toString () {
            return "Soy un jefe de taller, me llamo "+nombre+", tengo un total de "+añosExperiencia+" años de experiencia, mi id es: "+id+" y tengo a mi cargo a "+personasACargo+" personas";
        }

        @Override
        public void darLatigazos() {
            System.out.println("*Pum* Soy tu jefe "+nombre+" y te pego...");
        }
    }
    public non-sealed static class Trabajador extends Persona implements ITrabajador{

        String nombre;
        int experiencia;
        int horasDiarias;

        public Trabajador(String nombre, int añosExperiencia, int horasDiarias) {
            super(nombre, añosExperiencia);
            this.horasDiarias = horasDiarias;
        }

        @Override
        public void comer() {
            System.out.println("Soy el trabajador "+nombre+" y estoy comiendo...");
        }

        @Override
        public void trabajar() {
            System.out.println("Soy el trabajador "+nombre+" y estoy trabajando...");
        }

        @Override
        public void descansar() {
            System.out.println("Soy el trabajador "+nombre+" y estoy descansando...");
        }

        @Override
        public String toString() {
            return "Soy un trabajador, me llamo "+nombre+", tengo un total de "+añosExperiencia+" años de experiencia, mi id es: "+id+" y trabajo un total de "+horasDiarias+" horas al día";
        }
    }
    public static class Chapista extends Trabajador implements IChapista{

        String nombre;
        int experiencia;
        int horasDiarias;

        public Chapista(String nombre, int añosExperiencia, int horasDiarias) {
            super(nombre, añosExperiencia, horasDiarias);
        }


        @Override
        public void comer() {
            System.out.println("Soy el chapista "+nombre+" y estoy comiendo...");
        }

        @Override
        public void trabajar() {
            System.out.println("Soy el chapista "+nombre+" y estoy trabajando...");
        }

        @Override
        public void descansar() {
            System.out.println("Soy el chapista "+nombre+" y estoy descansando...");
        }

        @Override
        public String toString() {
            return "Soy un chapista, me llamo "+nombre+", tengo un total de "+añosExperiencia+" años de experiencia, mi id es: "+id+" y trabajo un total de "+horasDiarias+" horas al día";
        }
    }
    public static class Electricista extends Trabajador implements IElectricista{

        String nombre;
        int experiencia;
        int horasDiarias;

        public Electricista(String nombre, int añosExperiencia, int horasDiarias) {
            super(nombre, añosExperiencia, horasDiarias);
        }

        @Override
        public void comer() {
            System.out.println("Soy el electricista "+nombre+" y estoy comiendo...");
        }

        @Override
        public void trabajar() {
            System.out.println("Soy el electricista "+nombre+" y estoy trabajando...");
        }

        @Override
        public void descansar() {
            System.out.println("Soy el electricista "+nombre+" y estoy descansando...");
        }

        @Override
        public String toString() {
            return "Soy un electricista, me llamo "+nombre+", tengo un total de "+añosExperiencia+" años de experiencia, mi id es: "+id+" y trabajo un total de "+horasDiarias+" horas al día";
        }
    }
    public static class NavajaSuiza extends Trabajador implements IChapista, IElectricista{

        String nombre;
        int experiencia;
        int horasDiarias;

        public NavajaSuiza(String nombre, int añosExperiencia, int horasDiarias) {
            super(nombre, añosExperiencia, horasDiarias);
        }

        @Override
        public void comer() {
            System.out.println("Soy el Navaja Suiza "+nombre+" y estoy comiendo...");
        }

        @Override
        public void trabajar() {
            System.out.println("Soy el Navaja Suiza "+nombre+" y estoy trabajando...");
        }

        @Override
        public void descansar() {
            System.out.println("Soy el Navaja Suiza "+nombre+" y estoy descansando...");
        }

        @Override
        public String toString() {
            return "Soy un Navaja Suiza, me llamo "+nombre+", tengo un total de "+añosExperiencia+" años de experiencia, mi id es: "+id+" y trabajo un total de "+horasDiarias+" horas al día";
        }
    }
}
