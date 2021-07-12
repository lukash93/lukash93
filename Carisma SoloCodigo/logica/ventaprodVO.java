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
public class ventaprodVO {
   String id_venta;
   String id_producto;
   String nombre_producto;
   String descuento_producto;
   String valor_producto;
   String cantidad;

    public ventaprodVO() {
    }

    public ventaprodVO(String id_venta, String id_producto, String nombre_producto, String descuento_producto, String valor_producto, String cantidad) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descuento_producto = descuento_producto;
        this.valor_producto = valor_producto;
        this.cantidad = cantidad;
    }

    public String getId_venta() {
        return id_venta;
    }

    public String getId_producto() {
        return id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getDescuento_producto() {
        return descuento_producto;
    }

    public String getValor_producto() {
        return valor_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setDescuento_producto(String descuento_producto) {
        this.descuento_producto = descuento_producto;
    }

    public void setValor_producto(String valor_producto) {
        this.valor_producto = valor_producto;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
   
   
}
