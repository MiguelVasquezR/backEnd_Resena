package resenas.modelo;

import java.util.Date;

public class Persona {
    private String IDPersona;
    private String nombre;
    private String paterno;
    private String materno;
    private Date fNacimiento;
    private Date fDeceso;
    private String biografia;

    public Persona(){
    }

    public Persona(String IDPersona, String nombre, String paterno, String materno, Date fNacimiento, Date fDeceso, String biografia) {
        this.IDPersona = IDPersona;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fNacimiento = fNacimiento;
        this.fDeceso = fDeceso;
        this.biografia = biografia;
    }

    public String getIDPersona() {
        return IDPersona;
    }

    public void setIDPersona(String IDPersona) {
        this.IDPersona = IDPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public Date getfDeceso() {
        return fDeceso;
    }

    public void setfDeceso(Date fDeceso) {
        this.fDeceso = fDeceso;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id='" + IDPersona + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", materno='" + materno + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", fDeceso=" + fDeceso +
                ", biografia='" + biografia + '\'' +
                '}';
    }

}
