package resenas.modelo;

public class Usuario {

    private String IDUsuario;
    private String usuario;
    private String correo;
    private String password;

    private String IDPersona;

    public Usuario(){
    }

    public Usuario(String IDUsuario, String nombreUsuario, String correo, String password, String IDPersona) {
        this.IDUsuario = IDUsuario;
        this.usuario = nombreUsuario;
        this.correo = correo;
        this.password = password;
        this.IDPersona = IDPersona;
    }

    public String getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIDPersona() {
        return IDPersona;
    }

    public void setIDPersona(String IDPersona) {
        this.IDPersona = IDPersona;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "IDUsuario='" + IDUsuario + '\'' +
                ", nombreUsuario='" + usuario + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", IDPersona='" + IDPersona + '\'' +
                '}';
    }

}
