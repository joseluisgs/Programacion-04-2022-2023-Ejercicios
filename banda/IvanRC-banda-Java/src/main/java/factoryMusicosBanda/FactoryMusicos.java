package factoryMusicosBanda;

import modelsBandaMusicos.*;

public class FactoryMusicos {

    public FactoryMusicos(){}
    private static FactoryMusicos instance = null;
    public static FactoryMusicos getInstance(){
        if(instance == null) instance = new FactoryMusicos();
        return instance;
    }

    /**
     * función que sirve para crear un musico con datos aleatorios
     * @return el musico creado con datos aleatorios
     */
    public Musico createMusicoRandom() {
        Musico musico = null;
        int chance = (int)(Math.random()*100);
        String[] nombres = {"Iván","Jia","Javier","Ramón","Belén","Cristobal","Rapado","Elkevin","Mayorca","Jorge","Nefer","Sebastian","Álvaro","Romeo"};
        int añosExperiencia = (int)(Math.random()*38);
        int capacidadPulmonar = (int)(Math.random()*10);
        String[] tonos = {"agudo", "grave", "suave", "profundo"};
        int cantidadTeclas = (int)(Math.random()*24);
        int numeroCuerdas = (int)(Math.random()*8);
        if(chance <= 5){
            musico = new Trompetista(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, capacidadPulmonar);
        }else{
            if(chance <= 25){
                musico = new Cantante(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, tonos[(int)(Math.random()* tonos.length)]);
            }else{
                if(chance <= 45){
                    musico = new Guitarrista(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, tipoGuitarra.values()[(int)(Math.random()* tipoGuitarra.values().length)]);
                }else{
                    if(chance <= 55){
                        musico = new Bajista(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, numeroCuerdas);
                    }else{
                        if(chance <= 65){
                            musico = new Teclista(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, cantidadTeclas);
                        }else{
                            if(chance <= 80){
                                musico = new Percusionista(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, tipoPercusion.values()[(int)(Math.random()* tipoPercusion.values().length)]);
                            }else{
                                if(chance <= 95){
                                    musico = new CantanteGuitarrista(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, tonos[(int)(Math.random()* tonos.length)], tipoGuitarra.values()[(int)(Math.random()* tipoGuitarra.values().length)]);
                                }else{
                                    musico = new Multinstrumental(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, numeroCuerdas, cantidadTeclas, tipoPercusion.values()[(int)(Math.random()* tipoPercusion.values().length)]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return musico;
    }
}
