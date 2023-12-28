package resenas.modelo;

public class Publicacion {

    private String IDUsuario;
    private String IDForo;
    //private String foto;
    private String Comentario;
    private int ReaccionLike;
    private int ReaccionDislike;

    public Publicacion(){
    }

    public Publicacion(String IDUsuario, String IDForo, String Comentario, int ReaccionLike, int ReaccionDislike) {
        this.IDUsuario = IDUsuario;
        this.IDForo = IDForo;
        this.Comentario = Comentario;
        this.ReaccionLike = ReaccionLike;
        this.ReaccionDislike = ReaccionDislike;
    }

    public String getIDUsuario() {
        return IDUsuario;
    }

    public String getIDForo() {
        return IDForo;
    }

    public String getComentario() {
        return Comentario;
    }

    public int getReaccionLike() {
        return ReaccionLike;
    }

    public int getReaccionDislike() {
        return ReaccionDislike;
    }

    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }
    
    public void setIDForo(String IDForo) {
        this.IDForo = IDForo;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public void setReaccionLike(int ReaccionLike) {
        this.ReaccionLike = ReaccionLike;
    }

    public void setReaccionDislike(int ReaccionDislike) {
        this.ReaccionDislike = ReaccionDislike;
    }
}
