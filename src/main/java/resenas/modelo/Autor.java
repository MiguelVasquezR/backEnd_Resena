package resenas.modelo;

public class Autor {

    private String IDAutor;
    private String Nacionalidad;
    private String IDPersona;

    public String getIDAutor() {
        return IDAutor;
    }

    public void setIDAutor(String IDAutor) {
        this.IDAutor = IDAutor;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        Nacionalidad = nacionalidad;
    }

    public String getIDPersona() {
        return IDPersona;
    }

    public void setIDPersona(String IDPersona) {
        this.IDPersona = IDPersona;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "IDAutor='" + IDAutor + '\'' +
                ", Nacionalidad='" + Nacionalidad + '\'' +
                ", IDPersona='" + IDPersona + '\'' +
                '}';
    }
}