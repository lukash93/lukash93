package logica;

import conexion.conexionBD;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Fernando
 */
public class ventaDAO {
    conexionBD bd = new conexionBD();
    
    //INSERTAR VENTAS
    public void modificarCategoria(int numeroventa, String tipo_documento, String tipo_venta, String fecha_venta, String hora_venta, String productos_venta, String valor_neto_venta, String valor_descuento_venta, String subtotal_venta, String iva_venta, String total_venta, String sencillo_venta, String vuelto_venta, String estado) {
        String query = "INSERT INTO `venta` (id_venta, tipo_documento, tipo_venta, fecha_venta, hora_venta, productos_venta, valor_neto_venta, valor_descuento_venta, subtotal_venta, iva_venta, total_venta, sencillo_venta, vuelto_venta, estado) VALUES ('"+numeroventa+"', '"+tipo_documento+"', '"+tipo_venta+"', '"+fecha_venta+"', '"+hora_venta+"', '"+productos_venta+"', '"+valor_neto_venta+"', '"+valor_descuento_venta+"', '"+subtotal_venta+"', '"+iva_venta+"', '"+total_venta+"', '"+sencillo_venta+"', '"+vuelto_venta+"', '"+estado+"')";

        bd.ejecutarmodificacion(query);
        
    }
    
    public void insertaproductos (int idventa, String idprod, String nombreprod, Double descuentoprod, Double valorprod, int cantidad ) {
        String query = "INSERT INTO `productos_venta` (`id_venta`, `id_producto`, `nombre_producto`, `descuento_producto`, `valor_producto`, `cantidad`) VALUES ('"+idventa+"', '"+idprod+"', '"+nombreprod+"', '"+descuentoprod+"', '"+valorprod+"', '"+cantidad+"')";

        bd.ejecutarmodificacion(query);
        
    }   
    
    public void modificastock(String codigo, int nuevostock){
        String query="UPDATE producto SET stock_producto = stock_producto - '"+nuevostock+"' WHERE producto.codigo_producto = '"+codigo+"';";
        bd.ejecutarmodificacion(query);
    }
    public int obtenermayor(){
        String query="SELECT * FROM venta WHERE id_venta = (SELECT max(id_venta) FROM venta)";
        ResultSet rs = bd.ejecutarselect20(query);
        int idmayor = 0;
        try{
            while(rs.next()){
                idmayor = rs.getInt("id_venta");
                
                return  idmayor;
            }

        }catch(Exception ee){
            //valida = false;
        }
        return  idmayor;
    }
    //NUEVO
    public ArrayList<ventaVO> mostrarVenta (String fechaDesde, String fechaHasta){
        
        //System.out.println("pasa por acá"+codigoProducto);
        String query= "SELECT * FROM venta WHERE fecha_venta BETWEEN "+fechaDesde+" AND "+fechaHasta+" and estado='activo';";
        ArrayList<ventaVO> resultado = new ArrayList();
        
        ResultSet rs = bd.ejecutarselect20(query);
        try{
           while (rs.next()){
               //String prueba =rs.getString("nombre_producto")
               ventaVO objventaVO = new ventaVO();
               //objproductoVO.setNomProducto(prueba); 
               objventaVO.setIdVenta(rs.getString("id_venta"));
               objventaVO.setTipo_documento(rs.getString("tipo_documento"));
               objventaVO.setTipo_pago(rs.getString("tipo_venta"));
               objventaVO.setFecha(rs.getString("fecha_venta"));
               objventaVO.setHora(rs.getString("hora_venta"));
               objventaVO.setCodProducto(rs.getString("productos_venta"));
               objventaVO.setValorNeto(rs.getDouble("valor_neto_venta"));
               objventaVO.setValorDescuento(rs.getDouble("valor_descuento_venta"));
               objventaVO.setSubTotal(rs.getDouble("subtotal_venta"));
               objventaVO.setIva(rs.getDouble("iva_venta"));
               objventaVO.setTotalProducto(rs.getDouble("total_venta"));
               objventaVO.setSencillo(rs.getDouble("sencillo_venta"));
               objventaVO.setVuelto(rs.getDouble("vuelto_venta"));
               resultado.add(objventaVO);
               
           }
        }catch(Exception ee){
            return resultado;
        }
        return resultado;
    }
    
    public ArrayList<ventaprodVO> mostrarDetalle (String codigo){
        
        //System.out.println("pasa por acá"+codigoProducto);
        String query= "SELECT * FROM productos_venta  WHERE id_venta= '"+codigo+"'";
        ArrayList<ventaprodVO> resultado = new ArrayList();
        
        ResultSet rs = bd.ejecutarselect20(query);
        try{
           while (rs.next()){

               ventaprodVO objventaVO = new ventaprodVO();
               objventaVO.setId_producto(rs.getString("id_producto"));
               objventaVO.setNombre_producto(rs.getString("nombre_producto"));
               objventaVO.setDescuento_producto(rs.getString("descuento_producto"));
               System.out.println(query);
               objventaVO.setValor_producto(rs.getString("valor_producto"));
               objventaVO.setCantidad(rs.getString("cantidad"));

               resultado.add(objventaVO);
               
           }
        }catch(Exception ee){
            return resultado;
        }
        return resultado;
    }
    //NUEVO
    public void modificarVenta(String idventa){
        String query="UPDATE venta SET estado = 'anulado' WHERE id_venta = "+idventa+";";
        bd.ejecutarmodificacion(query);
    }
    //NUEVO
    public ArrayList<reponerStockVO> sumarStock(String codigo){
        String query="SELECT SUM(a.cantidad+p.stock_producto) AS cantidad, \n" +
        "a.id_producto AS idproducto\n" +
        "FROM (venta v INNER JOIN productos_venta a ON (v.id_venta=a.id_venta)) INNER JOIN \n" +
        "producto p ON (p.codigo_producto=a.id_producto) where p.codigo_producto= a.id_producto and \n" +
        "p.nombre_producto = a.nombre_producto and a.id_venta = '"+codigo+"'" +
        "GROUP BY p.nombre_producto";
        ArrayList<reponerStockVO> resultado = new ArrayList();
        ResultSet rs = bd.ejecutarselect20(query);
        try{
           while (rs.next()){
               reponerStockVO objreponerStockVO = new reponerStockVO();
               objreponerStockVO.setId_producto(rs.getString("idproducto"));
               objreponerStockVO.setCantidad(rs.getInt("cantidad"));
               resultado.add(objreponerStockVO);
           }
        }catch(Exception ee){
            return resultado;
        }
        return resultado;
      
        
    }
    //NUEVO
    public void updateStock(int cantidad, String idproducto){
        String query = "UPDATE producto SET stock_producto = "+cantidad+" WHERE codigo_producto = '"+idproducto+"';";
        bd.ejecutarmodificacion(query);
 
    }
}
