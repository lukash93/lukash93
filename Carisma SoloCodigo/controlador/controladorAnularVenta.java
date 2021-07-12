package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.reponerStockVO;
import logica.ventaVO;
import modelo.modeloAnularVenta;
import vista.vistaEliminaventa;
import vista.vistaVentas;


public class controladorAnularVenta implements ActionListener{
    modeloAnularVenta objModeloAnularVenta= null;
    vistaVentas objPantallaVentas = null;
    vistaEliminaventa objPantallaEliminarVenta = null;
    DateFormat df = DateFormat.getDateInstance();
    
    public static String botonVolver= "B";
    public static String botonBuscar= "C";
    public static String botonAnular="D";
    
    public controladorAnularVenta (modeloAnularVenta objModeloAnularVenta, 
            vistaVentas objPantallaVentas, vistaEliminaventa objPantallaEliminarVenta){
        this.objModeloAnularVenta = objModeloAnularVenta;
        this.objPantallaEliminarVenta= objPantallaEliminarVenta;
        this.objPantallaVentas = objPantallaVentas;

    }

    public controladorAnularVenta() {
    }
    
    public void actionPerformed(ActionEvent objEvento){
    
    if (objEvento.getActionCommand().equals(controladorAnularVenta.botonBuscar)){
             objPantallaEliminarVenta.limpiartabla();
             String fechaDesde = objPantallaEliminarVenta.ObtenerfechaDesde();
             String fechaHasta = objPantallaEliminarVenta.ObtenerfechaHasta();
             if (fechaDesde.equals("")){
                 objPantallaEliminarVenta.Mensaje("Debe seleccionar fecha desde");
             }else if(fechaHasta.equals("")){
                     objPantallaEliminarVenta.Mensaje("Debe seleccionar fecha hasta");
                 
             }else{
                      modeloAnularVenta consulta = new modeloAnularVenta();
                      ArrayList<ventaVO> listaden = null;
                      listaden = consulta.consultaProducto(fechaDesde, fechaHasta);
                if (listaden.isEmpty()){
                    objPantallaEliminarVenta.Mensaje("No se encontraron resultados");
                }else{
                   for (int i = 0; i < listaden.size(); i++) {           
                      String idVenta = listaden.get(i).getIdVenta();
                      String tipoDocumento = listaden.get(i).getTipo_documento();
                      String tipoVenta = listaden.get(i).getTipo_pago();
                      String fecha = listaden.get(i).getFecha();
                      String hora = listaden.get(i).getHora();
                      String codigoProducto = listaden.get(i).getCodProducto();
                      double valorNeto =  listaden.get(i).getValorNeto();  
                      double valorDescuento = listaden.get(i).getValorDescuento();
                      double subtotal = listaden.get(i).getSubTotal();
                      double iva = listaden.get(i).getIva();
                      double total = listaden.get(i).getTotalProducto();
                      double sencillo = listaden.get(i).getSencillo();
                      double vuelto = listaden.get(i).getVuelto();
                      objPantallaEliminarVenta.llenarTabla(idVenta, tipoDocumento, tipoVenta, fecha,
                      hora, codigoProducto, valorNeto, valorDescuento, subtotal, iva, total, sencillo, vuelto, i+1);

                   }
                }
             }
         }
        if (objEvento.getActionCommand().equals(controladorAnularVenta.botonVolver)){
            objPantallaEliminarVenta.dispose();
            objPantallaVentas.despliegaPantalla();
            objPantallaEliminarVenta.limpiarCalendarios();
            objPantallaEliminarVenta.limpiartabla();
            
        }
        if (objEvento.getActionCommand().equals(controladorAnularVenta.botonAnular)){
             
            if(objPantallaEliminarVenta.selecciontabla().isEmpty()){
                  objPantallaEliminarVenta.Mensaje("Debe seleccionar una venta");
              }else if (JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                     
                     objPantallaEliminarVenta.selecciontabla();
                     objModeloAnularVenta.modificarVenta(objPantallaEliminarVenta.selecciontabla());
                     String codigos ="";
    
                    modeloAnularVenta consulta= new modeloAnularVenta();
                    ArrayList <reponerStockVO> listar=null;
                    int seleccion=objPantallaEliminarVenta.selecciontablanumero();
                    codigos =objPantallaEliminarVenta.capturacodigo(seleccion);
                    
                    objModeloAnularVenta.reponerStock(codigos);
                    listar=consulta.reponerStock(codigos);
                    objPantallaEliminarVenta.Mensaje("Venta anulada con éxito");
                    
                    
                    for (int i = 0; i < listar.size(); i++) {
                        String codigo = listar.get(i).getId_producto();
                        int cantidad = listar.get(i).getCantidad();
                        objModeloAnularVenta.modificarStock(cantidad, codigo);
                }
                    
                    objPantallaEliminarVenta.limpiartabla();

             }
                    
        }
    }
                
}
