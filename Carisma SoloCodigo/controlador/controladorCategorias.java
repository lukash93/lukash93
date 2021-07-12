package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.categoriaDAO;
import vista.vistaCategorias;
import vista.vistaDashboard;
import modelo.modeloCategoria;
import logica.categoriaVO;

public class controladorCategorias implements ActionListener{
    vistaDashboard objPantallaDashboard = null;
    vistaCategorias objPantallaCategorias = null;
    modeloCategoria objModeloCategoria = null;
    
    public static String botonGuardar = "A";
    public static String botonModificar = "B";
    public static String botonEliminar = "C";
    public static String botonVolver = "D";
    public static String botonBuscarCategoria = "E";
    public static String botonAceptar = "F";
    public static String botonCancelar = "G";    
    public String contenedor;
    
    public controladorCategorias ( vistaDashboard objPantallaDashboard,
                            vistaCategorias objPantallaCategorias, modeloCategoria objModeloCategoria){
        this.objPantallaDashboard = objPantallaDashboard;
        this.objPantallaCategorias = objPantallaCategorias;
        this.objModeloCategoria = objModeloCategoria;
    }
     public void actionPerformed(ActionEvent objEvento){
        String nombreCategoria= objPantallaCategorias.getNombreCategoriaTB();

        if (objEvento.getActionCommand().equals(controladorCategorias.botonGuardar)){
            if (nombreCategoria.isEmpty()) {
                objPantallaCategorias.Mensaje("Ingrese nombre de categoría");
            }else {
                  modeloCategoria objMo= new modeloCategoria();
                  boolean categoria = objMo.ValidarCodigo(nombreCategoria);
                     if (categoria == false){
                         objModeloCategoria.modeloCategoria(nombreCategoria);
                     objPantallaCategorias.Mensaje("Ingreso Exitoso");
                     objPantallaCategorias.Limpiar();
                }else if (categoria == true){
                    objPantallaCategorias.Mensaje("La categoría ya existe");
                }
           }
        }
        if (objEvento.getActionCommand().equals(controladorCategorias.botonModificar)){
            objPantallaCategorias.botonmodificar();
            contenedor= objPantallaCategorias.getCB();
            
        }
        if (objEvento.getActionCommand().equals(controladorCategorias.botonEliminar)){
            
        }
        if (objEvento.getActionCommand().equals(controladorCategorias.botonVolver)){
            objPantallaDashboard.despliegaPantalla();
            objPantallaDashboard.cerrarMenu();
            objPantallaCategorias.dispose();
        }
        if (objEvento.getActionCommand().equals(controladorCategorias.botonCancelar)){
            objPantallaCategorias.botoncancelar();
            categoriaDAO categoria = new categoriaDAO();
            ArrayList listacategoria = categoria.rescatarcategoria();
            objPantallaCategorias.cargarCombo(listacategoria);
        }
        if (objEvento.getActionCommand().equals(controladorCategorias.botonAceptar)){
            String nombrecategoria = contenedor;
            String nuevonombre = objPantallaCategorias.getTB();
            if (nuevonombre.trim().equals("")) {
                objPantallaCategorias.Mensaje("Debe Ingresar Caracteres");                
            }else if(nuevonombre.equals(nombrecategoria)){
                objPantallaCategorias.Mensaje("Ingrese Nuevo Nombre");
            }else{
               objModeloCategoria.modificarcategoria(nombrecategoria, nuevonombre);
               objPantallaCategorias.Mensaje("Modificación Exitosa");
               objPantallaCategorias.botoncancelar();
               //NUEVO
               categoriaDAO categoria = new categoriaDAO();
               ArrayList listacategoria = categoria.rescatarcategoria();
               objPantallaCategorias.cargarCombo(listacategoria);
            }
            
        }
    }
}
