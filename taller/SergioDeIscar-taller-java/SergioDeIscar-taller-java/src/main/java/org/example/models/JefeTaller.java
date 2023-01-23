package org.example.models;

public final class JefeTaller extends Persona{
    public JefeTaller(String nombre, int experiencia) {
        super(nombre, experiencia);
    }

    int salario = 2500;

    private int trabajadoresCount = calcularTrabajadoresCount();
    private Trabajador[] trabajadores = new Trabajador[trabajadoresCount];

    public JefeTaller(String nombre, int experiencia, Trabajador[] trabajadores) {
        super(nombre, experiencia);
        for (var item : trabajadores) {
            addTrabajador(item);
        }
    }

    public JefeTaller(String nombre, int experiencia, int trabajadoresCount){
        super(nombre, experiencia);
        this.trabajadoresCount = trabajadoresCount;
        this.trabajadores = new Trabajador[trabajadoresCount];
    }

    @Override
    void saludar() {
        System.out.println("El jefe " + nombre + " saluda.");
    }

    @Override
    public int getSalario() {
        return salario;
    }

    public void darLatigazo(Trabajador trabajador){
        if (!exitsTrabajador(trabajador)){
            System.out.println("El trabajador no esta bajo su cargo.");
            return;
        }
        System.out.println("El jefe " + nombre + " da latigazos a " + trabajador.nombre);
    }

    //region CRUD
    public Trabajador addTrabajador(Trabajador trabajador){
        for(int i = 0; i < trabajadores.length; i++){
            if (trabajadores[i] == null)
            {
                trabajadores[i] = trabajador;
                return trabajador;
            }
        }
        return null;
    }

    public boolean removeTrabajador(Trabajador trabajador){
        int index = findTrabajadorIndex(trabajador);
        if (index == -1) return false;
        return removeTrabajador(index);
    }

    public boolean removeTrabajador(int index){
        if (index < 0 || index > trabajadores.length) return false;
        if (trabajadores[index] == null) return false;
        trabajadores[index] = null;
        return true;
    }

    public boolean updateTrabajador(Trabajador oldTrabajador, Trabajador newTrabajador){
        int index = findTrabajadorIndex(oldTrabajador);
        if (index == -1) return false;
        return updateTrabajador(index, newTrabajador);
    }

    public boolean updateTrabajador(int index, Trabajador newTrabajador){
        if (!removeTrabajador(index)) return false;
        trabajadores[index] = newTrabajador;
        return true;
    }

    public int findTrabajadorIndex(Trabajador trabajador){
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] == trabajador){
                return i;
            }
        }
        return -1;
    }

    public boolean exitsTrabajador(Trabajador trabajador){
        return findTrabajadorIndex(trabajador) != -1;
    }

    public Trabajador getTrabajador(int index){
        if(index < 0 || index > trabajadores.length) return null;
        return trabajadores[index];
    }

    public int getSizeTrabajadores() throws Exception {
        if (trabajadoresCount != trabajadores.length + 1) throw new Exception("Error en el tamaño del jefe");
        return trabajadoresCount;
    }
    //endregion

    private int calcularTrabajadoresCount(){
        if( experiencia <= 5) {
            return 5;
        }else if( experiencia <= 15) {
            return 15;
        }else {
            return 25;
        }
    }
}
