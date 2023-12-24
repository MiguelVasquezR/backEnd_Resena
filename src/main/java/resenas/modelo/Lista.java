package resenas.modelo;

import java.io.FileInputStream;
import java.sql.Date;

public class Lista {

    private String ID;
    private int cantidad;
    private String privacidad;
    private String nombre;
    private String descripcion;
    private String IDImagen;
    private String IDUsuario;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIDImagen() {
        return IDImagen;
    }

    public void setIDImagen(String IDImagen) {
        this.IDImagen = IDImagen;
    }

    public String getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "ID='" + ID + '\'' +
                ", cantidad=" + cantidad +
                ", privacidad='" + privacidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", IDImagen='" + IDImagen + '\'' +
                ", IDUsuario='" + IDUsuario + '\'' +
                '}';
    }
}
