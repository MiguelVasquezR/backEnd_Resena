package resenas.modelo;

public class Foro {

    private String IDForo;
    private String Opcion;
    //private String foto;
    private String Descripcion;
    private String Nombre;
    private String IDUsuario;

    public Foro(){
    }

    public Foro(String Opcion, String Descripcion, String Nombre) {
        this.Opcion = Opcion;
        this.Descripcion = Descripcion;
        this.Nombre = Nombre;
    }

    public String getIDForo() {
        return IDForo;
    }

    public String getOpcion() {
        return Opcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getIDUsuario() {
        return IDUsuario;
    }

    public void setIDForo(String IDForo) {
        this.IDForo = IDForo;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
