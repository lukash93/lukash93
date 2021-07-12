package modelo;

import java.util.ArrayList;
import logica.categoriaDAO;
import logica.categoriaVO;
import logica.productoDAO;
import logica.productoVO;
import vista.vistaProductos;

public class modeloProductos {
    private productoDAO producDAO;
    private productoVO producVO;
    //Datos productos
    String pkProducto="";
    String codigoProducto ="";
    String nombreProducto="";
    double precioProducto=0.0;
    String stockProducto="";
    String marcaProducto="";
    String descProducto="";
    String colorProducto="";
    String tallaProducto="";
    double costoProducto=0.0;
    double utilidadProducto=0.0;
    String categoriaProducto="Seleccionar";
    
    
    public modeloProductos (modeloProductos objModeloProductos, vistaProductos objVistaProductos){
        
    }
    public modeloProductos(){ //constructor vacío
        
    }
    public void modeloProductos (String codigoProducto, String nombreProducto, double precioProducto,
                                 String stockProducto, String marcaProducto, String descProducto,
                                 String colorProducto, String tallaProducto, String categoriaProducto,
                                 double costoProducto, double utilidadProducto){ 
        productoVO producVO = new productoVO();
        producVO.setCodProducto(codigoProducto);
        producVO.setNomProducto(nombreProducto);
        producVO.setPrecioProducto(precioProducto);
        producVO.setStockProducto(stockProducto);
        producVO.setMarcaProducto(marcaProducto);
        producVO.setDescProducto(descProducto);
        producVO.setColorProducto(colorProducto);
        producVO.setTallaProducto(tallaProducto);
        producVO.setCostoProducto(costoProducto);
        producVO.setUtilidadProducto(utilidadProducto);
        producVO.setCategoriaProducto(categoriaProducto);

        productoDAO productoDAO = new productoDAO();
        productoDAO.getIngreso (producVO);
    }
    
    public boolean ValidarCodigo(String codigo){
        boolean Validar;
        productoDAO jGrupoDAO=new productoDAO();
        Validar=jGrupoDAO.consultaValidarCodigo(codigo);
        
        System.out.println(Validar);
        
        return Validar;
    }
   
    public void rescatarCategoria(String nombrecategoria){
        categoriaDAO categoria = new categoriaDAO();
        ArrayList codigoCat = categoria.guardarCategoria(nombrecategoria);

       // return codigoCategoria;
        
    }
    //NUEVO
     public ArrayList <productoVO> consultaProducto(String dato, int uu){
        
        productoDAO consulta = new productoDAO();
        ArrayList <productoVO> listaden = null;
        listaden = consulta.getListaProductos(dato, uu);
        ArrayList <productoVO> Listaden2 = new ArrayList();
        
         for (int i = 0; i < listaden.size(); i++) {
             productoVO producVO = new productoVO();
             producVO.setCodProducto(listaden.get(i).getCodProducto());
             producVO.setNomProducto(listaden.get(i).getNomProducto());
             producVO.setPrecioProducto(listaden.get(i).getPrecioProducto());
             producVO.setStockProducto(listaden.get(i).getStockProducto());
             producVO.setMarcaProducto(listaden.get(i).getMarcaProducto());
             producVO.setDescProducto(listaden.get(i).getDescProducto());
             producVO.setColorProducto(listaden.get(i).getColorProducto());
             producVO.setTallaProducto(listaden.get(i).getTallaProducto());
             producVO.setCostoProducto(listaden.get(i).getCostoProducto());
             producVO.setUtilidadProducto(listaden.get(i).getUtilidadProducto());
             producVO.setCategoriaProducto(listaden.get(i).getCategoriaProducto());
             Listaden2.add(producVO);

         }
         return Listaden2;
         
     }

    public ArrayList<productoVO> MostrarProducto(String codigo){
        ArrayList<productoVO> Modificar= new ArrayList();
        productoDAO jPolDAO=new productoDAO();
        Modificar=jPolDAO.mostrarProducto(codigo);
        
        return Modificar;
    }
    //NUEVO
    public void modificarProducto(String codigo, String nombre, double precio, double utilidad,
            String stock, double costo, String marca, String descripcion, String color, String talla, String categoria){
        productoDAO producto = new productoDAO();
        producto.modificarProducto(codigo, nombre, precio, utilidad, stock, costo, marca, 
                descripcion, color, talla, categoria);
        
    }
    public ArrayList<productoVO> filtrarproducto(String filtro){
        System.out.println(filtro);
        ArrayList <productoVO> Mostrar = null;
        productoDAO catDAO = new productoDAO();
        Mostrar=catDAO.buscarfiltradoprod(filtro);
        return Mostrar;
    }
    //NUEVO
    public ArrayList<productoVO> MostrarTodo(){
        ArrayList <productoVO> Mostrar = null;
        productoDAO jPolDAO = new productoDAO();
        Mostrar=jPolDAO.mostrarTodo();
        return Mostrar;
    }
    
}
