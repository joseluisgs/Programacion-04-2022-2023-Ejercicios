package modelsBandaMusicos;

public class simulacionBanda {

    public static void main(String[] args){
        Banda banda = new Banda(50);

        banda.inicializarArray();

        System.out.println("En la banda hay un total de "+banda.arrayMusicos.length+" musicos:");
        banda.representarMusicosEnBanda();

        System.out.println();

        System.out.println("Tropetistas: "+banda.contarTrompetistas());
        System.out.println("Cantantes: "+banda.contarCantantes());
        System.out.println("Guitarristas: "+banda.contarGuitarristas());
        System.out.println("Bajistas: "+banda.contarBajistas());
        System.out.println("Teclistas: "+banda.contarTeclistas());
        System.out.println("Percusionistas: "+banda.contarPercusionistas());
        System.out.println("CantantesGuitarristas: "+banda.contarCantantesGuitarristas());
        System.out.println("Multinstrumentales: "+banda.contarMultinstrumentales());

        System.out.println();

        System.out.println("El salario total es: "+banda.hallarSalarioTotal());
    }
}
