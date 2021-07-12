package modelo;

import java.util.ArrayList;
import logica.reponerStockVO;
import logica.ventaDAO;
import logica.ventaVO;
import vista.vistaEliminaventa;

/**
 *
 * @author Alisson
 */
public class modeloAnularVenta {
    public modeloAnularVenta (modeloAnularVenta objModeloAnularVenta, vistaEliminaventa objVistaEliminarVenta){
        
    }
    public modeloAnularVenta(){ //constructor vacío
        
    }
    public ArrayList <ventaVO> consultaProducto(String fechaDesde, String fechaHasta){
        
        ventaDAO consulta = new ventaDAO();
        ArrayList <ventaVO> listaden = null;
        listaden = consulta.mostrarVenta(fechaDesde, fechaHasta);
        ArrayList <ventaVO> Listaden2 = new ArrayList();
        
         for (int i = 0; i < listaden.size(); i++) {
             ventaVO ventaVO = new ventaVO();
             ventaVO.setIdVenta(listaden.get(i).getIdVenta());
             ventaVO.setTipo_documento(listaden.get(i).getTipo_documento());
             ventaVO.setTipo_pago(listaden.get(i).getTipo_pago());
             ventaVO.setFecha(listaden.get(i).getFecha());
             ventaVO.setHora(listaden.get(i).getHora());
             ventaVO.setCodProducto(listaden.get(i).getCodProducto());
             ventaVO.setValorNeto(listaden.get(i).getValorNeto());
             ventaVO.setValorDescuento(listaden.get(i).getValorDescuento());
             ventaVO.setSubTotal(listaden.get(i).getSubTotal());
             ventaVO.setIva(listaden.get(i).getIva());
             ventaVO.setTotalProducto(listaden.get(i).getTotalProducto());
             ventaVO.setSencillo(listaden.get(i).getSencillo());
             ventaVO.setVuelto(listaden.get(i).getVuelto());
             Listaden2.add(ventaVO);

         }
         return Listaden2;
         
     }
     public void modificarVenta(String idventa){
        ventaDAO venta = new ventaDAO();
        venta.modificarVenta(idventa);
    }
    public ArrayList <reponerStockVO> reponerStock(String codigo){
        ventaDAO consulta = new ventaDAO();
        ArrayList <reponerStockVO> listaden = null;
        listaden = consulta.sumarStock(codigo);
       // ArrayList <reponerStockVO> Listaden2 = new ArrayList();
//        for (int i = 0; i < listaden.size(); i++) {
//              cantidad = Integer.toString(listaden.get(i).getCantidad());
//        }
//         return Organizacion;
//    }
//        for (int i = 0; i < listaden.size(); i++) {
//            
//             reponerStockVO ventaVO = new reponerStockVO();
//             ventaVO.setId_producto(listaden.get(i).getId_producto());
//             ventaVO.setCantidad(listaden.get(i).getCantidad());
//
//             listaden.add(ventaVO);
//
//         }
//         return listaden;
        return listaden;
    }
    public void modificarStock(int cantidad, String idproducto){
        ventaDAO venta = new ventaDAO();
        venta.updateStock(cantidad, idproducto);
     }

   

}
