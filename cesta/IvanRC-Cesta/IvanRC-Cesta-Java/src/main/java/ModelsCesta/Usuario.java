package ModelsCesta;

import java.util.Objects;

public class Usuario {

    private int idUsuario;
    private String nombre;

    public Usuario(int idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Usuario setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario && nombre.equals(usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
