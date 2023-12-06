package resenas.modelo;

public class GeneroUsuario {

    private String IDGeneroUsuario;
    private String IDGenero;
    private String IDUsuario;

    public GeneroUsuario(String IDGeneroUsuario, String IDGenero, String IDUsuario) {
        this.IDGeneroUsuario = IDGeneroUsuario;
        this.IDGenero = IDGenero;
        this.IDUsuario = IDUsuario;
    }

    public String getIDGeneroUsuario() {
        return IDGeneroUsuario;
    }

    public void setIDGeneroUsuario(String IDGeneroUsuario) {
        this.IDGeneroUsuario = IDGeneroUsuario;
    }

    public String getIDGenero() {
        return IDGenero;
    }

    public void setIDGenero(String IDGenero) {
        this.IDGenero = IDGenero;
    }

    public String getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }
}
