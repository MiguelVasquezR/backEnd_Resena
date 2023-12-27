package resenas.modelo;

public class LibroLista {

    private String IDLibroLista;
    private String IDLista;
    private String IDLibro;

    public LibroLista(String IDLibroLista, String IDLista, String IDLibro){
        this.IDLibroLista = IDLibroLista;
        this.IDLibro = IDLibro;
        this.IDLista = IDLista;
    }

    public String getIDLibroLista() {
        return IDLibroLista;
    }

    public void setIDLibroLista(String IDLibroLista) {
        this.IDLibroLista = IDLibroLista;
    }

    public String getIDLista() {
        return IDLista;
    }

    public void setIDLista(String IDLista) {
        this.IDLista = IDLista;
    }

    public String getIDLibro() {
        return IDLibro;
    }

    public void setIDLibro(String IDLibro) {
        this.IDLibro = IDLibro;
    }

    @Override
    public String toString() {
        return "LibroLista{" +
                "IDLibroLista='" + IDLibroLista + '\'' +
                ", IDLista='" + IDLista + '\'' +
                ", IDLibro='" + IDLibro + '\'' +
                '}';
    }
}
