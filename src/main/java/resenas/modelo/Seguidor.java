package resenas.modelo;

public class Seguidor {

    private String IDSeguidor;
    private String IDUserOrigin;
    private String IDUserFollow;

    public String getIDSeguidor() {
        return IDSeguidor;
    }

    public void setIDSeguidor(String IDSeguidor) {
        this.IDSeguidor = IDSeguidor;
    }

    public String getIDUserOrigin() {
        return IDUserOrigin;
    }

    public void setIDUserOrigin(String IDUserOrigin) {
        this.IDUserOrigin = IDUserOrigin;
    }

    public String getIDUserFollow() {
        return IDUserFollow;
    }

    public void setIDUserFollow(String IDUserFollow) {
        this.IDUserFollow = IDUserFollow;
    }

    @Override
    public String toString() {
        return "Seguidor{" +
                "IDSeguidor='" + IDSeguidor + '\'' +
                ", IDUserOrigin='" + IDUserOrigin + '\'' +
                ", IDUserFollow='" + IDUserFollow + '\'' +
                '}';
    }
}
