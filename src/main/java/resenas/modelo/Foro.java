package resenas.modelo;

public class Foro {

    private String IDForo;
    private String Opcion;
    private String Descripcion;
    private String Nombre;
    private String Foto;
    private String IDUsuario;

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getIDForo() {
        return IDForo;
    }

    public void setIDForo(String IDForo) {
        this.IDForo = IDForo;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String opcion) {
        Opcion = opcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }
}
