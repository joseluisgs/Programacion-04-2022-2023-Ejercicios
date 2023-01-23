package modelsTaller;

import factoryPersonasTaller.FactoryPersonas;

public class Taller {

    public Taller(int numeroDeTrabajadores){
        this.numeroDeTrabajadores = numeroDeTrabajadores;
    }


    public final int JEFE_TALLER = 2500;
    public final int TRABAJADOR = 1200;
    public final int CHAPISTA = 1700;
    public final int ELECTRICISTA = 1800;
    public final int NAVAJA_SUIZA = 2000;

    public int numeroDeTrabajadores;
    public Persona[] arrayTaller = null;

    /**
     * función que sirve para rellenar el array de personas, con personas aleatorias
     */
    public void inicializarArray(){
        arrayTaller = new Persona[numeroDeTrabajadores];
        for(int i=0;i< arrayTaller.length;i++){
            arrayTaller[i] = FactoryPersonas.getInstance().createRandomPersona();
        }
    }

    /**
     * función que sirve para sacar por pantalla una lista de las personas de taller
     */
    public void representarListaPersonas() {
        for(int i=0;i<arrayTaller.length;i++){
            System.out.println(arrayTaller[i]);
        }
    }

    /**
     * función que sirve para hallar la nómina total en el taller
     * @return la nómina calculada
     */
    public int calcularNominaTotal(){
        var resultado = 0;
        for(int i=0;i<arrayTaller.length;i++){
            if(arrayTaller[i] instanceof Persona.JefeTaller){
                resultado += JEFE_TALLER;
            }else{
                if(arrayTaller[i] instanceof Persona.Trabajador && (arrayTaller[i] instanceof Persona.Electricista) == false && (arrayTaller[i] instanceof Persona.Chapista) == false && (arrayTaller[i] instanceof Persona.NavajaSuiza) == false){
                    resultado += TRABAJADOR;
                }else{
                    if(arrayTaller[i] instanceof Persona.Chapista){
                        resultado += CHAPISTA;
                    }else{
                        if(arrayTaller[i] instanceof Persona.Electricista){
                            resultado += ELECTRICISTA;
                        }else{
                            resultado += NAVAJA_SUIZA;
                        }
                    }
                }
            }
        }
        return resultado;
    }

    /**
     * función que calcula el número de jefes de taller que hay en el taller
     * @return el número de jefes de taller
     */
    public int calcularNumeroDeJefesTaller(){
        var contador = 0;
        for(int i=0;i<arrayTaller.length;i++){
            if(arrayTaller[i] instanceof Persona.JefeTaller) contador++;
        }
        return contador;
    }

    /**
     * función que calcula el número de trabajadores que hay en el taller
     * @return el número de trabajadores
     */
    public int calcularNumeroDeTrabajadores(){
        var contador = 0;
        for(int i=0;i<arrayTaller.length;i++){
            if(arrayTaller[i] instanceof Persona.Trabajador && (arrayTaller[i] instanceof Persona.Electricista) == false && (arrayTaller[i] instanceof Persona.Chapista) == false && (arrayTaller[i] instanceof Persona.NavajaSuiza) == false) contador++;
        }
        return contador;
    }

    /**
     * función que calcula el número de chapistas que hay en el taller
     * @return el número de chapistas
     */
    public int calcularNumeroDeChapistas(){
        var contador = 0;
        for(int i=0;i<arrayTaller.length;i++){
            if(arrayTaller[i] instanceof Persona.Chapista) contador++;
        }
        return contador;
    }

    /**
     * función que calcula el número de electricistas que hay en el taller
     * @return el número de electricistas
     */
    public int calcularNumeroDeElectricistas(){
        var contador = 0;
        for(int i=0;i<arrayTaller.length;i++){
            if(arrayTaller[i] instanceof Persona.Electricista) contador++;
        }
        return contador;
    }

    /**
     * función que calcula el número de navajas suizas que hay en el taller
     * @return el número de navajas suizas
     */
    public int calcularNumeroDeNavajasSuizas(){
        var contador = 0;
        for(int i=0;i<arrayTaller.length;i++){
            if(arrayTaller[i] instanceof Persona.NavajaSuiza) contador++;
        }
        return contador;
    }
}
