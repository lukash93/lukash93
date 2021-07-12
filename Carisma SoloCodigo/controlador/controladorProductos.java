package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import logica.categoriaDAO;
import logica.categoriaVO;
import modelo.modeloProductos;
import vista.vistaProductos;
import vista.vistaDashboard;
import logica.productoVO;


public class controladorProductos implements ActionListener {
    vistaProductos objPantallaProductos = null;
    vistaDashboard objPantallaDashboard = null;
    modeloProductos objModeloProductos = null;
    
    public static String botonGuardar = "A";
    public static String botonModificar = "B";
    public static String botonEliminar = "C";
    public static String botonVolver = "D";
    public static String botonBuscar = "E";
    public static String botonAceptar = "F";
    public static String botonCancelar = "G"; 
    
    public controladorProductos (modeloProductos objModeloProductos,vistaProductos objPantallaProductos, 
            vistaDashboard objPantallaDashboard){
        this.objModeloProductos = objModeloProductos;
        this.objPantallaProductos = objPantallaProductos;
        this.objPantallaDashboard = objPantallaDashboard;

    }

        public void actionPerformed(ActionEvent objEvento){
            int uu;
            String dato =objPantallaProductos.getBusqueda();
             
        if (objEvento.getActionCommand().equals(controladorProductos.botonGuardar)){
            String codigoProducto=objPantallaProductos.getCodigoProducto();
            String nombreProducto=objPantallaProductos.getNombreProducto();
            double precioProducto = objPantallaProductos.getPrecioProducto();
            String stockProducto=objPantallaProductos.getStockProducto();
            String marcaProducto=objPantallaProductos.getMarcaProducto();
            String descripProducto=objPantallaProductos.getDescripProducto();
            String colorProducto=objPantallaProductos.getColorProducto();
            String tallaProducto=objPantallaProductos.getTallaProducto();
            double costoProducto=objPantallaProductos.getCostoProducto();
            double utilidadProducto=objPantallaProductos.getUtilidadProducto();
            String categoriaProducto=objPantallaProductos.getCategoria();
        
           if (nombreProducto.isEmpty()){
               objPantallaProductos.Mensaje("Ingrese nombre de producto");
           }else if (descripProducto.isEmpty()){
               objPantallaProductos.Mensaje("Ingrese descripción de producto");  
           }else if (codigoProducto.isEmpty()){
               objPantallaProductos.Mensaje("Ingrese código de producto");  
           }else if (categoriaProducto == "Seleccionar"){
               objPantallaProductos.Mensaje("Seleccione categoría de producto");
           }else if (stockProducto.isEmpty()){
               objPantallaProductos.Mensaje("Ingrese Stock de producto");
           }else if (precioProducto == 0.0){
               objPantallaProductos.Mensaje("Ingrese precio de producto");
           }else if (utilidadProducto == 0.0){
               objPantallaProductos.Mensaje("Debe calcular la utilidad del producto");
           }else if (costoProducto == 0.0){
               objPantallaProductos.Mensaje("Ingrese costo de producto");
           }else{
               //String codigoCategoria = objModeloProductos.rescatarCategoria(categoriaProducto);
               objModeloProductos.rescatarCategoria(categoriaProducto);
               modeloProductos objMo= new modeloProductos();
               boolean producto = objMo.ValidarCodigo(codigoProducto);
                if (producto == false){
                    objModeloProductos.modeloProductos(codigoProducto, nombreProducto, precioProducto, stockProducto, marcaProducto, 
                            descripProducto, colorProducto, tallaProducto, categoriaProducto, costoProducto, utilidadProducto);
                    objPantallaProductos.Mensaje("Ingreso Exitoso");
                    objPantallaProductos.Limpiar();
                 
                }else if (producto == true){
                    objPantallaProductos.Mensaje("El código ya existe");
                }
           }
           
        }
        if (objEvento.getActionCommand().equals(controladorProductos.botonModificar)){
            //NUEVO
            categoriaDAO categoria = new categoriaDAO();
            ArrayList listacategoria = categoria.rescatarcategoria();
            objPantallaProductos.cargarCombo(listacategoria);
            objPantallaProductos.bloquearTB();

             if(objPantallaProductos.selecciontabla().isEmpty()){
                  objPantallaProductos.Mensaje("Seleccione producto");
              }else{
                  objPantallaProductos.mostrarPanel();
                  objPantallaProductos.selecciontabla();
                  modeloProductos consulta=new modeloProductos();
                  ArrayList <productoVO> listaden= new ArrayList();
                  listaden=consulta.MostrarProducto(objPantallaProductos.selecciontabla());
                  for (int i = 0; i < listaden.size(); i++) {
                      objPantallaProductos.setCodigoProducto(listaden.get(i).getCodProducto());
                      objPantallaProductos.setNombreProducto(listaden.get(i).getNomProducto());
                      objPantallaProductos.setPrecioProducto(listaden.get(i).getPrecioProducto());
                      objPantallaProductos.setStockProducto(listaden.get(i).getStockProducto());
                      objPantallaProductos.setMarcaProducto(listaden.get(i).getMarcaProducto());
                      objPantallaProductos.setDescripcionProducto(listaden.get(i).getDescProducto());
                      objPantallaProductos.setColorProducto(listaden.get(i).getColorProducto());
                      objPantallaProductos.setTallaProducto(listaden.get(i).getTallaProducto());
                      objPantallaProductos.setCostoProducto(listaden.get(i).getCostoProducto());
                      objPantallaProductos.setUtilidadProducto(listaden.get(i).getUtilidadProducto());
                      objPantallaProductos.setNombreCategoria(listaden.get(i).getCategoriaProducto());
                   }
              }
             
        }
        //NUEVO
        if (objEvento.getActionCommand().equals(controladorProductos.botonBuscar)){
            String busquedaProducto=objPantallaProductos.getBusqueda();
            objPantallaProductos.LimpiarTabla();
   
            if (busquedaProducto.isEmpty()){
                     objPantallaProductos.Mensaje("Ingrese datos en campo de texto");
            
            }else if(objPantallaProductos.saberradio().equals("codigoProducto")) {
               uu = 1;
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
                      objPantallaProductos.llenarTabla(codigo, nombre, descripcion, categoria,
                      marca, stock, color, talla,  precio, costo, utilidad, i+1);
                   }

           }else if (objPantallaProductos.saberradio().equals("nombreProducto")) {
               uu = 2;
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
                      objPantallaProductos.llenarTabla(codigo, nombre,descripcion,categoria,
                      marca, stock, color, talla,  precio, costo, utilidad, i+1);
                   }
           
           }
        }
        if (objEvento.getActionCommand().equals(controladorProductos.botonVolver)){ 
            objPantallaProductos.habilitarTB();
            objPantallaProductos.LimpiarTabla();
            objPantallaProductos.Limpiar();
            objPantallaProductos.dispose();
            objPantallaDashboard.cerrarMenu();
            objPantallaDashboard.despliegaPantalla();
        }
        //NUEVO
        if (objEvento.getActionCommand().equals(controladorProductos.botonAceptar)){ 
            String nombre=objPantallaProductos.getNombreProducto();
            String categoria=objPantallaProductos.getCategoria();
            String codigo=objPantallaProductos.getCodigoProducto();
            String stock=objPantallaProductos.getStockProducto();
            double precio=objPantallaProductos.getPrecioProducto();
            double costo=objPantallaProductos.getCostoProducto();
            double utilidad=objPantallaProductos.getUtilidadProducto();
            String marca=objPantallaProductos.getMarcaProducto();
            String talla=objPantallaProductos.getTallaProducto();
            String descripcion=objPantallaProductos.getDescripProducto();
            String color=objPantallaProductos.getColorProducto();
            
            try{
            if (nombre.isEmpty()) {
                objPantallaProductos.Mensaje("Debe ingresar nombre de producto");                
            }else if(categoria=="Seleccionar"){
                objPantallaProductos.Mensaje("Debe seleccionar categoría");
            }else if(codigo.isEmpty()){
                objPantallaProductos.Mensaje("Debe ingresar código de producto");
            }else if(stock.isEmpty()){
                objPantallaProductos.Mensaje("Debe ingresar stock de producto");
            }else if(precio == 0.0){
                objPantallaProductos.Mensaje("Debe ingresar precio de venta");
            }else if(costo == 0.0){
                objPantallaProductos.Mensaje("Debe ingresar precio de costo");
            }else if(utilidad == 0.0){
                objPantallaProductos.Mensaje("Debe ingesar utilidad");
            }else{
               objModeloProductos.modificarProducto(codigo, nombre, precio, utilidad, stock, costo, marca, 
                descripcion, color, talla, categoria);
               objPantallaProductos.Mensaje("Modificación Exitosa");
               objPantallaProductos.botoncancelar();
               objPantallaProductos.habilitarTB();
            }  
            }catch (Exception e){
                objPantallaProductos.Mensaje("No deje campos vacíos");
            }
        }
        //NUEVO
         if (objEvento.getActionCommand().equals(controladorProductos.botonCancelar)){ 
            objPantallaProductos.habilitarTB();
            objPantallaProductos.botoncancelar();
            objPantallaProductos.Limpiar();
        }
    }
    
}
