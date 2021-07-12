package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.ventaVO;
import logica.ventaprodVO;
import modelo.modeloVentasRealizadas;
import vista.vistaVentasRealizadas;
import vista.vistaDashboard;


public class controladorVentasRealizadas implements ActionListener{
    modeloVentasRealizadas objModeloVentasRealizadas = null;
    vistaVentasRealizadas objPantallaVentasRealizadas = null;
    vistaDashboard objPantallaDashboard = null;
    DateFormat df = DateFormat.getDateInstance();
    
    public static String botonExportar = "A";
    public static String botonVolver= "B";
    public static String botonBuscar= "C";
    
    //NUEVO
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contAccion=0;
    
    public controladorVentasRealizadas (modeloVentasRealizadas objModeloVentasRealizadas, 
            vistaVentasRealizadas objPantallaVentasRealizadas,
                            vistaDashboard objPantallaDashboard){
        this.objModeloVentasRealizadas = objModeloVentasRealizadas;
        this.objPantallaDashboard = objPantallaDashboard;
        this.objPantallaVentasRealizadas = objPantallaVentasRealizadas;
        this.objPantallaVentasRealizadas.exportarBTN.addActionListener(this);
        this.objPantallaVentasRealizadas.exportarDetalleBTN.addActionListener(this);
    }
    //NUEVO
         public void AgregarFiltro(){
            selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
            selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));      
    }

    public controladorVentasRealizadas() {
    }
    
    public void actionPerformed(ActionEvent objEvento){
        contAccion++;
             if(contAccion==1)AgregarFiltro();  
             
             if(objEvento.getSource() == objPantallaVentasRealizadas.exportarBTN){
                 if (objPantallaVentasRealizadas.ventasJT.getRowCount()==0){
                 objPantallaVentasRealizadas.Mensaje("No hay datos en la tabla para exportar");
                 
             }else if(objEvento.getSource() == objPantallaVentasRealizadas.exportarBTN){
            if(selecArchivo.showDialog(null, "Exportar Ventas")==JFileChooser.APPROVE_OPTION){
                archivo=selecArchivo.getSelectedFile();
                String filtroSelect = selecArchivo.getFileFilter().getDescription();
                String extension = filtroSelect.equalsIgnoreCase("Libro de Excel") ? ".xlsx" : ".xls";
                String url = archivo.getParent()+"\\"+archivo.getName()+extension;
                JOptionPane.showMessageDialog(null, objModeloVentasRealizadas.Exportar(new File(url), objPantallaVentasRealizadas.ventasJT));
            }
           
         }
     }         
            //TABLA 2
           if(objEvento.getSource() == objPantallaVentasRealizadas.exportarDetalleBTN){
                if(contAccion==1)AgregarFiltro();  
             
             if(objEvento.getSource() == objPantallaVentasRealizadas.exportarDetalleBTN){
                 if (objPantallaVentasRealizadas.detalleJT.getRowCount()==0){
                 objPantallaVentasRealizadas.Mensaje("No hay datos en la tabla para exportar");
                 
             }else if(selecArchivo.showDialog(null, "Exportar Detalle")==JFileChooser.APPROVE_OPTION){
                archivo=selecArchivo.getSelectedFile();
                String filtroSelect = selecArchivo.getFileFilter().getDescription();
                String extension = filtroSelect.equalsIgnoreCase("Libro de Excel") ? ".xlsx" : ".xls";
                String url = archivo.getParent()+"\\"+archivo.getName()+extension;
                JOptionPane.showMessageDialog(null, objModeloVentasRealizadas.Exportar2(new File(url), objPantallaVentasRealizadas.detalleJT));
                objPantallaVentasRealizadas.limpiartabla2();
            }
          }
         }
         if (objEvento.getActionCommand().equals(controladorVentasRealizadas.botonBuscar)){
             objPantallaVentasRealizadas.limpiartabla();
             String fechaDesde = objPantallaVentasRealizadas.ObtenerfechaDesde();
             String fechaHasta = objPantallaVentasRealizadas.ObtenerfechaHasta();
             if (fechaDesde.equals("")){
                 objPantallaVentasRealizadas.Mensaje("Debe seleccionar fecha desde");
             }else if(fechaHasta.equals("")){
                     objPantallaVentasRealizadas.Mensaje("Debe seleccionar fecha hasta");
                 
             }else{
                      modeloVentasRealizadas consulta = new modeloVentasRealizadas();
                      ArrayList<ventaVO> listaden = null;
                      listaden = consulta.consultaProducto(fechaDesde, fechaHasta);
                if (listaden.isEmpty()){
                    objPantallaVentasRealizadas.Mensaje("No se encontraron resultados");
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
                      objPantallaVentasRealizadas.llenarTabla(idVenta, tipoDocumento, tipoVenta, fecha,
                      hora, codigoProducto, valorNeto, valorDescuento, subtotal, iva, total, sencillo, vuelto, i+1);

                   }
                }
             }
         }

         if (objEvento.getActionCommand().equals(controladorVentasRealizadas.botonVolver)){
             objPantallaDashboard.despliegaPantalla();
             objPantallaVentasRealizadas.limpiartabla();
             objPantallaVentasRealizadas.limpiartabla2();
             objPantallaVentasRealizadas.limpiarCalendarios();
             objPantallaVentasRealizadas.dispose();
             objPantallaDashboard.cerrarMenu();
         }
    }
    
    
}
