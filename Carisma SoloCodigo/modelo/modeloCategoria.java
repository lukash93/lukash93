package modelo;

import java.util.ArrayList;
import logica.categoriaDAO;
import logica.categoriaVO;
import vista.vistaCategorias;

public class modeloCategoria {
    private categoriaDAO catDAO;
    private categoriaVO  catVO;
    //Datos categoría
    String nombreCategoria="";
    
    public modeloCategoria (modeloCategoria objModeloCategoria, vistaCategorias objVistaCategorias){
        
    }
    public modeloCategoria(){ //constructor vacío
        
    }
    public void modeloCategoria (String nombCategoria) { 
        categoriaDAO categoria = new categoriaDAO();
        categoria.getIngreso(nombCategoria);
    }
   
    public boolean ValidarCodigo(String categoria){
       boolean Validar;
        categoriaDAO jGrupoDAO=new categoriaDAO();
        Validar=jGrupoDAO.consultaValidarCategoria(categoria);
        
        System.out.println(Validar);
        
        return Validar;
   
    }
    public ArrayList<categoriaVO> MostrarCategorias(){
        ArrayList <categoriaVO> Mostrar = null;
        categoriaDAO catDAO = new categoriaDAO();
        Mostrar=catDAO.rescatarcategoria();
        return Mostrar;
    }
    
    public void modificarcategoria(String nombrecategoria, String nuevonombre){
        categoriaDAO categoria = new categoriaDAO();
        categoria.modificarCategoria(nombrecategoria, nuevonombre);
        
    }
    
    
}
