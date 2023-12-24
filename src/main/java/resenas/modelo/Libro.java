package resenas.modelo;

import java.util.Date;

public class Libro {

    private String IDLibro;
    private String titulo;
    private String foto;
    private int numPag;
    private Date fechaPublicacion;
    private String idioma;
    private String editorial;
    private String IDAutor;
    private String IDGenero;

    public String getIDLibro() {
        return IDLibro;
    }

    public void setIDLibro(String IDLibro) {
        this.IDLibro = IDLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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

    public String getIDAutor() {
        return IDAutor;
    }

    public void setIDAutor(String IDAutor) {
        this.IDAutor = IDAutor;
    }

    public String getIDGenero() {
        return IDGenero;
    }

    public void setIDGenero(String IDGenero) {
        this.IDGenero = IDGenero;
    }
}
