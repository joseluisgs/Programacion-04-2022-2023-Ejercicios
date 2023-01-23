package modelsBandaMusicos;

import factoryMusicosBanda.FactoryMusicos;

public class Banda {

    int numerosDeMusicos;

    public Banda(int numeroDeMusicos){
        this.numerosDeMusicos = numeroDeMusicos;
    }
    public Musico[] arrayMusicos = null;

    /**
     * función que sirve para rellenar el array de musicos, con musicos aleatorios
     */
    public void inicializarArray(){
        arrayMusicos = new Musico[numerosDeMusicos];
        for(int i=0;i< arrayMusicos.length;i++){
            arrayMusicos[i] = FactoryMusicos.getInstance().createMusicoRandom();
        }
    }

    /**
     * función que sirve para contar el número de trompetistas en el array
     * @return el numero de trompetistas en el array
     */
    public int contarTrompetistas(){
        int contador = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Trompetista) contador++;
        }
        return contador;
    }

    /**
     * función que sirve para contar el número de cantantes en el array
     * @return el numero de cantantes en el array
     */
    public int contarCantantes(){
        int contador = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Cantante) contador++;
        }
        return contador;
    }

    /**
     * función que sirve para contar el número de guitarristas en el array
     * @return el numero de guitarristas en el array
     */
    public int contarGuitarristas(){
        int contador = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Guitarrista) contador++;
        }
        return contador;
    }

    /**
     * función que sirve para contar el número de bajista en el array
     * @return el numero de bajista en el array
     */
    public int contarBajistas(){
        int contador = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Bajista) contador++;
        }
        return contador;
    }

    /**
     * función que sirve para contar el número de teclistas en el array
     * @return el numero de teclistas en el array
     */
    public int contarTeclistas(){
        int contador = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Teclista) contador++;
        }
        return contador;
    }

    /**
     * función que sirve para contar el número de percusionista en el array
     * @return el numero de percusionista en el array
     */
    public int contarPercusionistas(){
        int contador = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Percusionista) contador++;
        }
        return contador;
    }

    /**
     * función que sirve para contar el número de cantantesGuitarristas en el array
     * @return el numero de cantantesGuitarristas en el array
     */
    public int contarCantantesGuitarristas(){
        int contador = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof CantanteGuitarrista) contador++;
        }
        return contador;
    }

    /**
     * función que sirve para contar el número de multinstrumentalista en el array
     * @return el numero de multinstrumentalista en el array
     */
    public int contarMultinstrumentales(){
        int contador = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Multinstrumental) contador++;
        }
        return contador;
    }

    /**
     * función que permite calcular el salario total
     * @return el salario total
     */
    public int hallarSalarioTotal(){
        int resultado = 0;
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Trompetista){
                resultado += ((Trompetista) arrayMusicos[i]).recalcularSalario(arrayMusicos[i].salario);
            }else{
                if(arrayMusicos[i] instanceof Cantante){
                    resultado += ((Cantante) arrayMusicos[i]).recalcularSalario(arrayMusicos[i].salario);
                }else{
                    if(arrayMusicos[i] instanceof Guitarrista){
                        resultado += ((Guitarrista) arrayMusicos[i]).recalcularSalario(arrayMusicos[i].salario);
                    }else{
                        if(arrayMusicos[i] instanceof Bajista){
                            resultado += ((Bajista) arrayMusicos[i]).recalcularSalario(arrayMusicos[i].salario);
                        }else{
                            if(arrayMusicos[i] instanceof Teclista) {
                                resultado += ((Teclista) arrayMusicos[i]).recalcularSalario(arrayMusicos[i].salario);
                            }else{
                                if(arrayMusicos[i] instanceof Percusionista) {
                                    resultado += ((Percusionista) arrayMusicos[i]).recalcularSalario(arrayMusicos[i].salario);
                                }else{
                                    if(arrayMusicos[i] instanceof CantanteGuitarrista) {
                                        resultado += ((CantanteGuitarrista) arrayMusicos[i]).recalcularSalario(arrayMusicos[i].salario);
                                    }else{
                                        resultado += ((Multinstrumental) arrayMusicos[i]).recalcularSalario(arrayMusicos[i].salario);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return resultado;
    }

    /**
     * función que sirve para mostrar todos los musicos que hay en el array y de que tipo son
     */
    public void representarMusicosEnBanda(){
        for(int i=0;i<arrayMusicos.length;i++){
            if(arrayMusicos[i] instanceof Trompetista){
                System.out.println("Soy un trompetista");
            }else{
                if(arrayMusicos[i] instanceof Cantante){
                    System.out.println("Soy un cantante");
                }else{
                    if(arrayMusicos[i] instanceof Guitarrista){
                        System.out.println("Soy un guitarrista");
                    }else{
                        if(arrayMusicos[i] instanceof Bajista){
                            System.out.println("Soy un bajista");
                        }else{
                            if(arrayMusicos[i] instanceof Teclista) {
                                System.out.println("Soy un teclista");
                            }else{
                                if(arrayMusicos[i] instanceof Percusionista) {
                                    System.out.println("Soy un percusionista");
                                }else{
                                    if(arrayMusicos[i] instanceof CantanteGuitarrista) {
                                        System.out.println("Soy un cantnate y guitarrista");
                                    }else{
                                        System.out.println("Soy un multinstrumental");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
