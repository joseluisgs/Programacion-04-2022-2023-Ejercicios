package models;

import enums.ESTADOS;

public class Butaca {
    public ESTADOS estado;

    Butaca(ESTADOS estado){
        this.estado = estado;
    }
    static Butaca FREE_SEAT = new Butaca(ESTADOS.LIBRE);
    static Butaca RESERVED_SEAT = new Butaca(ESTADOS.RESERVADO);
    static Butaca SOLD_SEAT = new Butaca(ESTADOS.OCUPADO);
    static  Butaca VIP_SEAT = new Butaca(ESTADOS.VIP);

    @Override
    public String toString() {
        return switch (estado){
            case LIBRE -> "💺";
            case OCUPADO -> "🍿";
            case RESERVADO -> "❌";
            case VIP -> "🌟";
        };
    }
}