package resenas.modelo;

import java.sql.Date;

public class Resena {

    private String ID;
    private String FotoID;
    private String contenido;
    private String nombreLibro;
    private String nombreAutor;
    private String idioma;
    private String editorial;
    private int calificacion;
    private Date fecha;
    private String IDUsuario;

    public String getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFotoID() {
        return FotoID;
    }

    public void setFotoID(String fotoID) {
        this.FotoID = fotoID;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Resena{" +
                "ID='" + ID + '\'' +
                ", fotoID='" + FotoID + '\'' +
                ", contenido='" + contenido + '\'' +
                ", nombreLibro='" + nombreLibro + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", editorial='" + editorial + '\'' +
                ", calificacion=" + calificacion +
                ", fecha=" + fecha +
                ", IDUsuario='" + IDUsuario + '\'' +
                '}';
    }
}
