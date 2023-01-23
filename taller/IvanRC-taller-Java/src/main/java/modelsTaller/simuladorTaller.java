package modelsTaller;

public class simuladorTaller {

    public static void main(String[] args){

        Taller taller = new Taller(50);

        taller.inicializarArray();

        System.out.println("Las personas del taller son:");
        taller.representarListaPersonas();

        System.out.println();

        System.out.println("La nómina total en el taller es: "+taller.calcularNominaTotal()+"€");

        System.out.println();

        int numeroPersonas = taller.arrayTaller.length;
        int jefesTaller = taller.calcularNumeroDeJefesTaller();
        int trabajadores = taller.calcularNumeroDeTrabajadores();
        int chapistas = taller.calcularNumeroDeChapistas();
        int electricistas = taller.calcularNumeroDeElectricistas();
        int navajaSuiza = taller.calcularNumeroDeNavajasSuizas();

        System.out.println("En el taller hay un total de "+numeroPersonas+" personas:");
        System.out.println("Un total de "+jefesTaller+" son jefes de taller");
        System.out.println("Y el resto ("+(numeroPersonas-jefesTaller)+"), son:");
        System.out.println(""+trabajadores+" trabajadores");
        System.out.println(""+chapistas+" chapistas");
        System.out.println(""+electricistas+" electricistas");
        System.out.println(""+navajaSuiza+" navas suizas");
    }
}
