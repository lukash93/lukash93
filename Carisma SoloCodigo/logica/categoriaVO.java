package logica;


public class categoriaVO {
   public String nombCategoria;
   public String codigoCategoria;

    public categoriaVO(String nombCategoria, String codigoCategoria) {
        this.nombCategoria = nombCategoria;
        this.codigoCategoria = codigoCategoria;
    }

    public categoriaVO() {
    }

    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
    
    public String getNombCategoria() {
        return nombCategoria;
    }

    public void setNombCategoria(String nombCategoria) {
        this.nombCategoria = nombCategoria;
    }
    
    
}
