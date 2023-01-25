package models;

import enums.ButacaEstado;
import java.util.Random;

public class Butaca {
    private ButacaEstado estado;
    private boolean isVip = false;

    //region Constructor
    public Butaca(){
        setEstado(ButacaEstado.LIBRE);
        setIsVip(false);
    }
    public Butaca(int probability){
        setEstado(ButacaEstado.LIBRE);
        Random rdn = new Random();
        setIsVip(rdn.nextInt(100) < probability);
    }
    //endregion

    //region Getter
    public ButacaEstado getEstado(){
        return estado;
    }
    public boolean getIsVip(){
        return isVip;
    }
    //endregion

    //region Setter
    public void setEstado(ButacaEstado newEstado){
        estado = newEstado;
    }
    public void setIsVip(boolean newValue){
        isVip = newValue;
    }
    //endregion
}