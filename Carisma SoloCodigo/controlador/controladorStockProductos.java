package controlador;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import logica.productoVO;
import modelo.modeloProductos;
import vista.vistaStockProductos;
import vista.vistaDashboard;
import modelo.modeloStockProductos;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.productoDAO;

public class controladorStockProductos implements ActionListener {
    modeloStockProductos objModeloStockProductos = null;
    vistaStockProductos objPantallaStockProductos = null;
    vistaDashboard objPantallaDashboard = null;
    
    public static String botonExportar = "A";
    public static String botonVolver = "B";
    public static String botonBuscar = "C";
    public static String botonBuscarTodo = "D";
    public static String botonImportar = "E";
    public static String botonGuardar = "F";
    
    //nuevo

    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contAccion=0;
    
    public controladorStockProductos (modeloStockProductos objModeloStockProductos, 
            vistaStockProductos objPantallaStockProductos,
                            vistaDashboard objPantallaDashboard){
        this.objModeloStockProductos = objModeloStockProductos;
        this.objPantallaDashboard = objPantallaDashboard;
        this.objPantallaStockProductos = objPantallaStockProductos;
        this.objPantallaStockProductos.exportarBTN.addActionListener(this);
        this.objPantallaStockProductos.importarBTN.addActionListener(this);
    }
    //NUEVO
         public void AgregarFiltro(){
            selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
            selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
            
    }

    public void actionPerformed(ActionEvent objEvento){
         String dato =objPantallaStockProductos.getBusqueda();
         int uu;

             contAccion++;
             if(contAccion==1)AgregarFiltro();
             
             
             if(objEvento.getSource() == objPantallaStockProductos.exportarBTN){
                 if (objPantallaStockProductos.productosJT.getRowCount()==0){
                 objPantallaStockProductos.Mensaje("No hay datos en la tabla para exportar");
                 
             }else if(objEvento.getSource() == objPantallaStockProductos.exportarBTN){
            if(selecArchivo.showDialog(null, "Exportar")==JFileChooser.APPROVE_OPTION){
                archivo=selecArchivo.getSelectedFile();
                String filtroSelect = selecArchivo.getFileFilter().getDescription();
                String extension = filtroSelect.equalsIgnoreCase("Libro de Excel") ? ".xlsx" : ".xls";
                String url = archivo.getParent()+"\\"+archivo.getName()+extension;
                JOptionPane.showMessageDialog(null, objModeloStockProductos.Exportar(new File(url), objPantallaStockProductos.productosJT));
            }
           
            }
         }
         if(objEvento.getSource() == objPantallaStockProductos.importarBTN){
            if(selecArchivo.showDialog(null, "Seleccionar archivo")==JFileChooser.APPROVE_OPTION){
                archivo=selecArchivo.getSelectedFile();
                if(archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")){
                    JOptionPane.showMessageDialog(null, 
                            objModeloStockProductos.Importar(archivo, objPantallaStockProductos.productosJT) + "\n Formato ."+ archivo.getName().substring(archivo.getName().lastIndexOf(".")+1), 
                            "IMPORTAR EXCEL", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Elija un formato valido.");
                }
            }
        }
         if (objEvento.getActionCommand().equals(controladorStockProductos.botonVolver)){
             objPantallaDashboard.despliegaPantalla();
             objPantallaStockProductos.limpiartabla();
             objPantallaStockProductos.dispose();
             objPantallaDashboard.cerrarMenu();
         }
         if (objEvento.getActionCommand().equals(controladorStockProductos.botonBuscar)){
             String busquedaProducto=objPantallaStockProductos.getBusqueda();
            
            
            if (busquedaProducto.isEmpty()){
                     objPantallaStockProductos.Mensaje("Ingrese datos en campo de texto");
            
            }else 
                if(objPantallaStockProductos.saberradio().equals("codigoProducto")) {
               uu = 1;
               objPantallaStockProductos.LimpiarTabla();
                      modeloProductos consulta = new modeloProductos();
                      ArrayList<productoVO> listaden = null;
                      listaden = consulta.consultaProducto(dato, uu);

                   for (int i = 0; i < listaden.size(); i++) {           
                      String codigo = listaden.get(i).getCodProducto();
                      String nombre = listaden.get(i).getNomProducto();
                      String descripcion = listaden.get(i).getDescProducto();
                      String categoria = listaden.get(i).getCategoriaProducto();
                      String marca = listaden.get(i).getMarcaProducto();
                      String stock = listaden.get(i).getStockProducto();
                      String color =  listaden.get(i).getColorProducto();  
                      String talla = listaden.get(i).getTallaProducto();
                      double precio = listaden.get(i).getPrecioProducto();
                      double costo = listaden.get(i).getCostoProducto();
                      double utilidad = listaden.get(i).getUtilidadProducto();
                      objPantallaStockProductos.llenarTabla(codigo, nombre, descripcion, categoria,
                      marca, stock, color, talla,  precio, costo, utilidad, i+1);

                   }

           }else if (objPantallaStockProductos.saberradio().equals("nombreProducto")) {
               uu = 2;
               objPantallaStockProductos.LimpiarTabla();
                     modeloProductos consulta = new modeloProductos();
                      ArrayList<productoVO> listaden = null;
                      listaden = consulta.consultaProducto(dato, uu);

                   for (int i = 0; i < listaden.size(); i++) {           
                      String codigo = listaden.get(i).getCodProducto();
                      String nombre = listaden.get(i).getNomProducto();
                      String descripcion = listaden.get(i).getDescProducto();
                      String categoria = listaden.get(i).getCategoriaProducto();
                      String marca = listaden.get(i).getMarcaProducto();
                      String stock = listaden.get(i).getStockProducto();
                      String color =  listaden.get(i).getColorProducto();  
                      String talla = listaden.get(i).getTallaProducto();
                      double precio = listaden.get(i).getPrecioProducto();
                      double costo = listaden.get(i).getCostoProducto();
                      double utilidad = listaden.get(i).getUtilidadProducto();
                      objPantallaStockProductos.llenarTabla(codigo, nombre,descripcion,categoria,
                      marca, stock, color, talla,  precio, costo, utilidad, i+1);
                   }
            }
         }
         //NUEVO
         if (objEvento.getActionCommand().equals(controladorStockProductos.botonBuscarTodo)){
            String codigo="";
            String nombre="";
            String descripcion="";
            String categoria="";
            String marca="";
            String stock="";
            String color="";
            String talla="";
            double precio=0.0;
            double costo=0.0;
            double utilidad=0.0;
            
            ArrayList <productoVO> listaden=null;
            modeloProductos objJefe=new modeloProductos();
            listaden=objJefe.MostrarTodo();
              for (int i = 0; i < listaden.size(); i++) {
                  codigo=listaden.get(i).getCodProducto();
                  nombre=listaden.get(i).getNomProducto();
                  descripcion=listaden.get(i).getDescProducto();
                  categoria=listaden.get(i).getCategoriaProducto();
                  marca=listaden.get(i).getMarcaProducto();
                  stock=listaden.get(i).getStockProducto();
                  color=listaden.get(i).getColorProducto();
                  talla=listaden.get(i).getTallaProducto();
                  precio=listaden.get(i).getPrecioProducto();
                  costo=listaden.get(i).getCostoProducto();
                  utilidad=listaden.get(i).getUtilidadProducto();
                  
                  objPantallaStockProductos.tabla(codigo, nombre, descripcion, categoria, marca, 
                  stock, color, talla, precio, costo, utilidad, i+1);
              }
         }
         //INSERTAR VENTA
            if(objEvento.getSource() == objPantallaStockProductos.guardarBTN){
                 if (objPantallaStockProductos.productosJT.getRowCount()==0){
                 objPantallaStockProductos.Mensaje("No hay datos en la tabla para guardar");
                 
            }else if (objEvento.getActionCommand().equals(controladorStockProductos.botonGuardar)){
                    int count = objPantallaStockProductos.getrowtabla();
                    String cad = "";
                    String existen = "";
                    for (int i = 0; i < count; i++) {
                      String codigo = objPantallaStockProductos.getcod_prod(i);
                      if(objModeloStockProductos.ValidarCodigo(codigo) == true)
                          existen = existen + codigo + ", ";
                      
                      
                      cad = cad + "'" + codigo + "',";
                      
                    }  
                    cad = cad.substring(0,cad.length()-1);
                     // String valor  = objPantallaStockProductos.productosJT.getValueAt(i, 0).toString().trim();
                     if (objModeloStockProductos.ValidarCodigoRepetido(cad) == 0){  
                        int counttabla = objPantallaStockProductos.getrowtabla();
                        for (int j = 0; j < counttabla; j++) {
                            String codigo2 = objPantallaStockProductos.getcod_prod(j);
                            String nombProducto = objPantallaStockProductos.getnombreprod(j);
                            Double precioprod = Double.valueOf(objPantallaStockProductos.getprecio_venta(j));
                            int stock = Integer.valueOf(objPantallaStockProductos.getstock_prod(j));
                            String marca = objPantallaStockProductos.getmarca(j);
                            String descripcion = objPantallaStockProductos.getdescripcion(j);
                            String color = objPantallaStockProductos.getcolor(j);
                            String talla = objPantallaStockProductos.gettalla(j);
                            Double costoprod = Double.valueOf(objPantallaStockProductos.getprecio_costo(j));
                            Double utilidad = Double.valueOf(objPantallaStockProductos.getutilidad(j));
                            String categoria = objPantallaStockProductos.getcategoria(j);

                            objModeloStockProductos.insertaproducto(codigo2, nombProducto, precioprod, stock, marca, descripcion, color, talla, costoprod, utilidad, categoria);
                        }
                        try{
                              objPantallaStockProductos.Mensaje("Datos guardados con éxito");
                              objPantallaStockProductos.LimpiarTabla(); 
                        }catch(Exception e){

                        }  
                    }else{
                          objPantallaStockProductos.Mensaje("El código "+existen.substring(0,existen.length()-1)+" ya existe");

                     }
                }
            }
         
    }
    }
    
    
    
    

