package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import logica.categoriaDAO;
import modelo.modeloDashboard;
import modelo.modeloVentas;
import vista.vistaProductos;
import vista.vistaDashboard;
import vista.vistaCategorias;
import vista.vistaVentas;
import vista.vistaVentasRealizadas;
import vista.vistaStockProductos;
import vista.vistaConfigurarUsuario;

public class controladorDashboard implements ActionListener{
    modeloDashboard objModeloDashboard = null;
    vistaProductos objPantallaProductos = null;
    vistaDashboard objPantallaDashboard = null;
    vistaCategorias objPantallaCategorias = null;
    vistaVentas objPantallaVentas = null;
    vistaVentasRealizadas objPantallaVentasRealizadas = null;
    vistaStockProductos objPantallaStockProductos = null;
    vistaConfigurarUsuario objPantallaConfigurarUsuario = null;
    
    public static String botonProductos = "A";
    public static String botonCategorias = "B";
    public static String botonDetalleVenta = "C";
    public static String botonVentasRealizadas = "D";
    public static String botonStockProductos = "E";
    public static String botonConfigurarUsuario = "F";

    public controladorDashboard (modeloDashboard objModeloDashboard, 
                            vistaProductos objPantallaProductos, vistaDashboard objPantallaDashboard,
                            vistaCategorias objPantallaCategorias, vistaVentas objPantallaVenta, 
                            vistaVentasRealizadas objPantallaVentasRealizadas, vistaStockProductos objPantallaStockProductos,
                            vistaConfigurarUsuario objPantallaConfigurarUsuario){
        this.objModeloDashboard = objModeloDashboard;
        this.objPantallaProductos = objPantallaProductos;
        this.objPantallaDashboard = objPantallaDashboard;
        this.objPantallaCategorias = objPantallaCategorias;
        this.objPantallaVentas = objPantallaVenta;
        this.objPantallaVentasRealizadas = objPantallaVentasRealizadas;
        this.objPantallaStockProductos = objPantallaStockProductos;
        this.objPantallaConfigurarUsuario = objPantallaConfigurarUsuario;
    }
    
    public void actionPerformed(ActionEvent objEvento){
        if (objEvento.getActionCommand().equals(controladorDashboard.botonProductos)){
            objPantallaProductos.despliegaPantalla();
            categoriaDAO categoria = new categoriaDAO();
            ArrayList listacategoria = categoria.rescatarcategoria();
            objPantallaProductos.cargarCombo(listacategoria);
            
            
            //for (int i = 0; i < listacategoria.size() ; i++) {
                //objPantallaProductos.llenarCategoria(listacategoria.get(i).toString());
                
            //}
            
            objPantallaDashboard.dispose();
        }
        if (objEvento.getActionCommand().equals(controladorDashboard.botonCategorias)){
            objPantallaCategorias.despliegaPantalla();
            categoriaDAO categoria = new categoriaDAO();
            ArrayList listacategoria = categoria.rescatarcategoria();
            objPantallaCategorias.cargarCombo(listacategoria);
            objPantallaDashboard.dispose();
        }
        if (objEvento.getActionCommand().equals(controladorDashboard.botonDetalleVenta)){
            objPantallaVentas.despliegaPantalla();
            modelo.modeloVentas venta  = new modeloVentas();
            int mayor = venta.obtenermayornumero() +1;
            objPantallaVentas.setnumeroventa(mayor);
            objPantallaDashboard.dispose();
        }
        if (objEvento.getActionCommand().equals(controladorDashboard.botonVentasRealizadas)){
            objPantallaVentasRealizadas.despliegaPantalla();
            objPantallaDashboard.dispose();
        }
        if (objEvento.getActionCommand().equals(controladorDashboard.botonStockProductos)){
            objPantallaStockProductos.despliegaPantalla();
            objPantallaDashboard.dispose();
        }
        if (objEvento.getActionCommand().equals(controladorDashboard.botonConfigurarUsuario)){
            objPantallaConfigurarUsuario.despliegaPantalla();
            objPantallaDashboard.dispose();
        }
        
    }
    
    
}
