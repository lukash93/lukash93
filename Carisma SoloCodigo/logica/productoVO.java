package logica;

public class productoVO {
   String codProducto;
   String nomProducto;
   double precioProducto;
   String stockProducto;
   String marcaProducto;
   String descProducto;
   String colorProducto;
   String tallaProducto;
   String categoriaProducto;
   double costoProducto;
   double utilidadProducto;
   String nombreVendedor;

    public productoVO() {
       codProducto ="";
       nomProducto="";
       precioProducto=0.0;
       stockProducto="";
       marcaProducto="";
       descProducto="";
       colorProducto="";
       tallaProducto="";
       categoriaProducto="";
       costoProducto=0.0;
       utilidadProducto=0.0;
       nombreVendedor="";
       
    }
    

    public productoVO(String codProducto, String nomProducto, double precioProducto, 
            String stockProducto, String marcaProducto, String descProducto, 
            String colorProducto, String tallaProducto, String categoriaProducto, 
            double costoProducto, double utilidadProducto, String nombreVendedor) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.marcaProducto = marcaProducto;
        this.descProducto = descProducto;
        this.colorProducto = colorProducto;
        this.tallaProducto = tallaProducto;
        this.categoriaProducto = categoriaProducto;
        this.costoProducto = costoProducto;
        this.utilidadProducto = utilidadProducto;
        this.nombreVendedor = nombreVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }
    

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public String getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(String colorProducto) {
        this.colorProducto = colorProducto;
    }

    public String getTallaProducto() {
        return tallaProducto;
    }

    public void setTallaProducto(String tallaProducto) {
        this.tallaProducto = tallaProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public double getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(double costoProducto) {
        this.costoProducto = costoProducto;
    }

    public double getUtilidadProducto() {
        return utilidadProducto;
    }

    public void setUtilidadProducto(double utilidadProducto) {
        this.utilidadProducto = utilidadProducto;
    }
   
}
