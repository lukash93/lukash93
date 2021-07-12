/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Fernando
 */
public class ventaVO {
   String idVenta;
   String codProducto;
   String nomProducto;
   String precioProducto;
   String stockProducto;
   String cantidadProducto;
   double totalProducto;
   String tipo_documento;
   String tipo_pago;
   String fecha;
   String Hora;
   double valorNeto;
   double valorDescuento;
   double subTotal;
   double iva;
   double sencillo;
   double vuelto;
   String estado;

    public ventaVO(String codProducto, String nomProducto, String precioProducto, String stockProducto, String cantidadProducto, double totalProducto,
            String tipo_documento, String tipo_pago, String fecha, String Hora, String idVenta, double valorDescuento,
            double valorNeto, double subTotal, double iva, double sencillo, double vuelto, String estado) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.cantidadProducto = cantidadProducto;
        this.totalProducto = totalProducto;
        this.tipo_documento = tipo_documento;
        this.tipo_pago = tipo_pago;
        this.fecha = fecha;
        this.Hora = Hora;
        this.idVenta = idVenta;
        this.valorDescuento = valorDescuento;
        this.valorNeto = valorNeto;
        this.subTotal = subTotal;
        this.iva = iva;
        this.sencillo = sencillo;
        this.vuelto = vuelto;
        this.estado = estado;
    }
    
    public ventaVO() {
    }

    public double getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(double totalProducto) {
        this.totalProducto = totalProducto;
    }
    
    public double getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(double valorNeto) {
        this.valorNeto = valorNeto;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSencillo() {
        return sencillo;
    }

    public void setSencillo(double sencillo) {
        this.sencillo = sencillo;
    }

    public double getVuelto() {
        return vuelto;
    }

    public void setVuelto(double vuelto) {
        this.vuelto = vuelto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }
    
    public String getCodProducto() {
        return codProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public String getStockProducto() {
        return stockProducto;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
   
   
}
