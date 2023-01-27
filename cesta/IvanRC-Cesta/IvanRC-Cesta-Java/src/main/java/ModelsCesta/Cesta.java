package ModelsCesta;

import java.time.LocalDate;
import java.util.Objects;

public class Cesta {

    private int idCesta;
    private LocalDate fechaCreacion;
    private Usuario usuario;
    ListaCesta listaCesta;

    public Cesta(int idCesta, LocalDate fechaCreacion, Usuario usuario, ListaCesta listaCesta) {
        this.idCesta = idCesta;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
        this.listaCesta = listaCesta;
    }

    public int getIdCesta() {
        return idCesta;
    }

    public Cesta setIdCesta(int idCesta) {
        this.idCesta = idCesta;
        return this;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Cesta setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Cesta setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public ListaCesta getListaCesta() {
        return listaCesta;
    }

    public Cesta setListaCesta(ListaCesta listaCesta) {
        this.listaCesta = listaCesta;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cesta cesta = (Cesta) o;
        return idCesta == cesta.idCesta && Objects.equals(fechaCreacion, cesta.fechaCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCesta, fechaCreacion);
    }

    @Override
    public String toString() {
        return "Cesta{" +
                "idCesta=" + idCesta +
                ", fechaCreacion=" + fechaCreacion +
                ", usuario=" + usuario +
                ", listaCesta=" + listaCesta +
                '}';
    }
}
