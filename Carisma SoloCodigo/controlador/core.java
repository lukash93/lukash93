package controlador;

import vista.vistaLogin;
import vista.vistaDashboard;
import modelo.modeloPrincipal;
import modelo.modeloDashboard;
import vista.vistaProductos;
import modelo.modeloProductos;
import vista.vistaCategorias;
import modelo.modeloVentas;
import vista.vistaVentas;
import modelo.modeloCategoria;
import vista.vistaConsultaProducto;
import vista.vistaVentasRealizadas;
import modelo.modeloVentasRealizadas;
import vista.vistaStockProductos;
import modelo.modeloStockProductos;
import vista.vistaConfigurarUsuario;
import modelo.modeloConfigurarUsuario;
import vista.vistaEliminaventa;
import modelo.modeloAnularVenta;

public class core {
        public static void main(String args[]) {
            //Inicialización de vistas
            vistaLogin objPantallaLogin = new vistaLogin();
            vistaDashboard objPantallaDashboard = new vistaDashboard();
            vistaProductos objPantallaProductos = new vistaProductos();
            vistaCategorias objPantallaCategorias = new vistaCategorias();
            vistaVentas objPantallaVentas = new vistaVentas();
            vistaConsultaProducto objpantallaconsultaprod = new vistaConsultaProducto(objPantallaVentas);
            vistaVentasRealizadas objPantallaVentasRealizadas = new vistaVentasRealizadas();
            vistaStockProductos objPantallaStockProductos = new vistaStockProductos();
            vistaConfigurarUsuario objPantallaConfigurarUsuario = new vistaConfigurarUsuario();
            vistaEliminaventa objPantallaEliminarVenta = new vistaEliminaventa();
            
            //Declaración de modelo y controlador de Pantalla Login con los objetos que ocupa
            modeloPrincipal objModeloPrincipal = new modeloPrincipal();
            controladorLogin objControladorLogin = new controladorLogin(objModeloPrincipal, objPantallaLogin, objPantallaDashboard);
            objPantallaLogin.setControlador(objControladorLogin);
            objPantallaLogin.despliegaPantalla();
            
            //Declaración de modelo y controlador de Pantalla Dashboard con los objetos que ocupa
            modeloDashboard objModeloDashboard = new modeloDashboard();
            controladorDashboard objControladorDashboard = new controladorDashboard (objModeloDashboard, objPantallaProductos, 
            objPantallaDashboard, objPantallaCategorias, objPantallaVentas, objPantallaVentasRealizadas, objPantallaStockProductos,
            objPantallaConfigurarUsuario);
            objPantallaDashboard.setControladorDashboard(objControladorDashboard);
            
            //Declaración de modelo y controlador de Pantalla Producto con los objetos que ocupa
            modeloProductos objModeloProductos = new modeloProductos();
            controladorProductos objControladorProductos = new controladorProductos (objModeloProductos, objPantallaProductos, 
            objPantallaDashboard);
            objPantallaProductos.setControladorProductos(objControladorProductos);
            
            //Declaración de modelo y controlador de Pantalla Categorías con los objetos que ocupa
            modeloCategoria objModeloCategoria = new modeloCategoria();
            controladorCategorias objControladorCategorias = new controladorCategorias(objPantallaDashboard, 
            objPantallaCategorias, objModeloCategoria);
            objPantallaCategorias.setControladorCategorias(objControladorCategorias);
            
            //Declaración de modelo y controlador de Pantalla Ventas con los objetos que ocupa
            modeloVentas objModeloVentas = new modeloVentas();
            controladorVentas objControladorVentas = new controladorVentas(objModeloVentas, objPantallaVentas, objPantallaDashboard, 
            objpantallaconsultaprod, objPantallaEliminarVenta);
            objPantallaVentas.setControladorVentas(objControladorVentas);
            
            controladorConsultaProducto objControladorConsultaProducto = new controladorConsultaProducto(objModeloProductos,objpantallaconsultaprod, 
            objPantallaDashboard, objPantallaVentas);
            objpantallaconsultaprod.setControlador(objControladorConsultaProducto); 
            
            //Declaración de modelo y controlador de Pantalla Ventas Realizadas con los objetos que ocupa
            modeloVentasRealizadas objModeloVentasRealizadas = new modeloVentasRealizadas();
            controladorVentasRealizadas objControladorVentasRealizadas = new controladorVentasRealizadas(objModeloVentasRealizadas, 
                    objPantallaVentasRealizadas, objPantallaDashboard);
            objPantallaVentasRealizadas.setControladorVentasRealizadas(objControladorVentasRealizadas);
            
            //Declaración de modelo y controlador de Pantalla Stock Productos con los objetos que ocupa
            modeloStockProductos objModeloStockProductos = new modeloStockProductos();
            controladorStockProductos objControladorStockProductos = new controladorStockProductos(objModeloStockProductos,
                    objPantallaStockProductos, objPantallaDashboard);
            objPantallaStockProductos.setControladorStockProductos(objControladorStockProductos);
            
            //Declaración de modelo y controlador de Pantalla Configurar Usuario con los objetos que ocupa
            modeloConfigurarUsuario objModeloConfigurarUsuario = new modeloConfigurarUsuario();
            controladorConfigurarUsuario objControladorConfigurarUsuario = new controladorConfigurarUsuario(objModeloConfigurarUsuario,
                    objPantallaConfigurarUsuario, objPantallaDashboard);
            objPantallaConfigurarUsuario.setControladorConfigurarUsuario(objControladorConfigurarUsuario);
            
            //Declaración de modelo y controlador de Pantalla Anular venta con los objetos que ocupa
            modeloAnularVenta objModeloAnularVenta = new modeloAnularVenta();
            controladorAnularVenta objControladorAnularVenta = new controladorAnularVenta(objModeloAnularVenta, 
            objPantallaVentas, objPantallaEliminarVenta);
            objPantallaEliminarVenta.setControladorAnularVenta(objControladorAnularVenta);
    }
}
