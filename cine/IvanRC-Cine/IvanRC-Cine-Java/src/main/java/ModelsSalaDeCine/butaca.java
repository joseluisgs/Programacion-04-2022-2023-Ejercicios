package ModelsSalaDeCine;

import java.util.Objects;

public class butaca {

    public String identificador;
    public String estado;
    public Boolean esVip;

    /**
     * es el constructor del objeto "butaca"
     * @param identificador es la combinación de fila y columna única de la butaca
     * @param estado es el estado de la butaca, puede ser libre, reservado, o ocupado
     */
    public butaca(String identificador, String estado){
        this.identificador = identificador;
        this.estado = estado;
        this.esVip = seraVip();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        butaca butaca = (butaca) o;
        return Objects.equals(identificador, butaca.identificador) && Objects.equals(estado, butaca.estado) && Objects.equals(esVip, butaca.esVip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, estado, esVip);
    }

    @Override
    public String toString() {
        return "butaca{" +
                "identificador='" + identificador + '\'' +
                ", estado='" + estado + '\'' +
                ", esVip=" + esVip +
                '}';
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getEstado() {
        return estado;
    }

    public Boolean getEsVip() {
        return esVip;
    }

    /**
     * función que sirve para decidir si una butaca es vip o no, al momento en el que se crea
     */
    public Boolean seraVip(){
        Boolean vip = false;
        double probabilidad = Math.random();
        if(probabilidad > 0.4){
            vip = true;
        }
        return vip;
    }
}