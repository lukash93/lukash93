package modelo;

import java.util.ArrayList;
import logica.productoDAO;
import logica.productoVO;
import logica.ventaDAO;

/**
 *
 * @author Alisson
 */
public class modeloVentas {
    
    
    public ArrayList<productoVO> consultaproducto(String codigo){
        productoDAO producto = new productoDAO();
        ArrayList<productoVO> listprod = new ArrayList();
        listprod = producto.consultaproducto(codigo);
        return listprod;
    }
    //INSERTAR VENTA
    public void insertarventa(int numeroventa, String tipo_documento, String tipo_venta, String fecha_venta, String hora_venta, String productos_venta, String valor_neto_venta, String valor_descuento_venta, String subtotal_venta, String iva_venta, String total_venta, String sencillo_venta, String vuelto_venta, String estado){
        ventaDAO venta = new ventaDAO();
        venta.modificarCategoria(numeroventa, tipo_documento, tipo_venta, fecha_venta, hora_venta, productos_venta, valor_neto_venta, valor_descuento_venta, subtotal_venta, iva_venta, total_venta, sencillo_venta, vuelto_venta, estado);
    }
    
    public void insertaproducto(int idventa, String idprod, String nombreprod, Double descuentoprod, Double valorprod, int cantidad){
        ventaDAO venta = new ventaDAO();
        venta.insertaproductos(idventa, idprod, nombreprod, descuentoprod, valorprod, cantidad);
    }
    public void rebajarstock(String codigo, int nuevostock){
        ventaDAO venta = new ventaDAO();
        venta.modificastock(codigo, nuevostock);
    }
    public int obtenermayornumero(){
        ventaDAO venta = new ventaDAO();
        int mayor = venta.obtenermayor();
        return mayor;
    }
}
