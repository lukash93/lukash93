package logica;

public class usuarioVO {
    String nomUsuario;
    String conUsuario;

    public usuarioVO(){
        
    }
    
    public usuarioVO(String nomUsuario, String conUsuario) {
        this.nomUsuario = nomUsuario;
        this.conUsuario = conUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getConUsuario() {
        return conUsuario;
    }

    public void setConUsuario(String conUsuario) {
        this.conUsuario = conUsuario;
    }
}