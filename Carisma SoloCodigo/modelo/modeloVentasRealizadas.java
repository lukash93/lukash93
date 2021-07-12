package modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JTable;
import logica.ventaDAO;
import logica.ventaVO;
import logica.ventaprodVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vista.vistaVentasRealizadas;


public class modeloVentasRealizadas {
    Workbook wb;
    
    
    public modeloVentasRealizadas (modeloProductos objModeloProductos, vistaVentasRealizadas objVistaVentasRealizadas){
        
    }
    public modeloVentasRealizadas(){ //constructor vacío
        
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
     public ArrayList <ventaprodVO> consultaDetalleProducto(String codigo){
        
        ventaDAO consulta = new ventaDAO();
        ArrayList <ventaprodVO> listaden = null;
        listaden = consulta.mostrarDetalle(codigo);
        ArrayList <ventaprodVO> Listaden2 = new ArrayList();
        
         for (int i = 0; i < listaden.size(); i++) {
             ventaprodVO ventaVO = new ventaprodVO();
             ventaVO.setId_producto(listaden.get(i).getId_producto());
             ventaVO.setNombre_producto(listaden.get(i).getNombre_producto());
             ventaVO.setDescuento_producto(listaden.get(i).getDescuento_producto());
             ventaVO.setValor_producto(listaden.get(i).getValor_producto());
             ventaVO.setCantidad(listaden.get(i).getCantidad());
             Listaden2.add(ventaVO);

         }
         return Listaden2;
         
     }
     public String Exportar(File archivo, JTable tablaD){
        String respuesta="No se realizo con exito la exportación.";
        int numFila=tablaD.getRowCount(), numColumna=tablaD.getColumnCount();
     
        if(archivo.getName().endsWith("xls")){
            wb = new HSSFWorkbook();
        }else{
            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Stock Productos");
        
        try {
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i+1);
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                    }else{
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            respuesta="Exportación exitosa.";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return respuesta;
        
    }
    public String Exportar2(File archivo, JTable tablaD){
        String respuesta="No se realizo con exito la exportación.";
        int numFila=tablaD.getRowCount(), numColumna=tablaD.getColumnCount();
     
        if(archivo.getName().endsWith("xls")){
            wb = new HSSFWorkbook();
        }else{
            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Detalle Productos");
        
        try {
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i+1);
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                    }else{
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }
            respuesta="Exportación exitosa.";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return respuesta;
        
    }
    
}
