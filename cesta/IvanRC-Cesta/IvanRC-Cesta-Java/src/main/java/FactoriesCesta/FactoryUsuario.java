package FactoriesCesta;

import ModelsCesta.Usuario;

public class FactoryUsuario {

    public FactoryUsuario(){}
    private static FactoryUsuario instance = null;

    public static FactoryUsuario getInstance(){
        if(instance == null){
            instance = new FactoryUsuario();
        }
        return instance;
    }
    private static int contadorUsuarios = 1;
    private int nextId(){
        return contadorUsuarios++;
    }

    /**
     * función que sirve para crear un usuario aleatorio
     * @return el usuario cuyas propiedades se crearon al azar
     */
    public Usuario crearUsuarioRandom(){
        String[] nombres = {"Jose", "Paco", "Manuel", "Iván", "Romeo", "Belén", "Teseo"};
        return new Usuario(nextId(), nombres[(int) (Math.random()* nombres.length)]);
    }
}
