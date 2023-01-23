package factoryPersonasTaller;

import modelsTaller.Persona;

public class FactoryPersonas {

    public FactoryPersonas(){}

    private static FactoryPersonas instance = null;

    public static FactoryPersonas getInstance(){
        if(instance == null){
            instance = new FactoryPersonas();
        }
        return instance;
    }

    /**
     * función que sirve para generar una persona, jefe de taller, traajador, chapista o electricista cuyos datos son aleatorios
     * @return el objeto creado con datos aleatorios
     */
    public Persona createRandomPersona(){
        Persona persona = null;

        String[] nombres = {"Iván","Jia","Javier","Ramón","Belén","Cristobal","Rapado","Elkevin","Mayorca","Jorge","Nefer","Sebastian","Álvaro","Romeo"};
        int añosExperiencia = (int)(Math.random()*64);
        int personasACargo = (int)(Math.random()*100);
        int horasDiarias = (int)(Math.random()*9);

        int chance = (int)(Math.random()*100);
        if(chance <= 10){
            persona = new Persona.JefeTaller(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, personasACargo);
        }else{
            if(chance <= 60){
                persona = new Persona.Trabajador(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, horasDiarias);
            }else{
                if(chance <= 80){
                    persona = new Persona.Chapista(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, horasDiarias);
                }else{
                    if(chance <= 90) {
                        persona = new Persona.Electricista(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, horasDiarias);
                    }else{
                        persona = new Persona.NavajaSuiza(nombres[(int)(Math.random()* nombres.length)], añosExperiencia, horasDiarias);
                    }
                }
            }
        }
        return persona;
    }
}
