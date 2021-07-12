package modelo;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;
import logica.productoDAO;
import logica.productoVO;


public class modeloStockProductos {
    Workbook wb;
    
    public String Exportar(File archivo, JTable tablaD){
        String respuesta="No se realizó con éxito la exportación.";
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
     public String Importar(File archivo, JTable tablaD){
        String respuesta="No se pudo realizar la importación.";
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        try {
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0);
            Iterator filaIterator = hoja.rowIterator();
            int indiceFila=-1;
            while (filaIterator.hasNext()) {                
                indiceFila++;
                Row fila = (Row) filaIterator.next();
                Iterator columnaIterator = fila.cellIterator();
                Object[] listaColumna = new Object[1000];
                int indiceColumna=-1;
                while (columnaIterator.hasNext()) {                    
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next();
                    if(indiceFila==0){
                        modeloT.addColumn(celda.getStringCellValue());
                    }else{
                        if(celda!=null){
                            switch(celda.getCellType()){
                                case Cell.CELL_TYPE_NUMERIC:
                                    listaColumna[indiceColumna]= (int)Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    listaColumna[indiceColumna]= celda.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    listaColumna[indiceColumna]= celda.getBooleanCellValue();
                                    break;
                                default:
                                    listaColumna[indiceColumna]=celda.getDateCellValue();
                                    break;
                            }
                            System.out.println("col"+indiceColumna+" valor: true - "+celda+".");
                        }                        
                    }
                }
                if(indiceFila!=0)modeloT.addRow(listaColumna);
            }
            respuesta="Importación exitosa";
        } catch (IOException | InvalidFormatException | EncryptedDocumentException e) {
            System.err.println(e.getMessage());
        }
        return respuesta;
    }
    public void insertaproducto(String codigo, String nombProducto, Double precioprod, int stock, String marca, String descripcion, String color, String talla, Double costoprod, Double utilidad, String categoria){
        productoDAO producto = new productoDAO();
        producto.insertarproductos(codigo, nombProducto, precioprod, stock, marca, descripcion, color, talla, costoprod, utilidad, categoria);
    }
    
     public boolean ValidarCodigo(String codigo){
        boolean Validar;
        productoDAO jGrupoDAO=new productoDAO();
        Validar=jGrupoDAO.consultaValidarCodigo(codigo);
        
        System.out.println(Validar);
        
        return Validar;
    }
         
     public int ValidarCodigoRepetido(String codigo){
        int Validar;
        productoDAO jGrupoDAO=new productoDAO();
        Validar=jGrupoDAO.consultaValidarCodigoRepetido(codigo);
        
        System.out.println(Validar);
        
        return Validar;
    }
//    public ArrayList <productoVO> ValidarCodigo (String codigo){ 
//        ArrayList <productoVO> Validar = null;
//        productoDAO UserDAO = new productoDAO();
//        Validar = UserDAO.getValidarCodigo(codigo);
//       
//        return Validar;
//    }
    
    
    
}
