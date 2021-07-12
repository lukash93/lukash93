package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import logica.productoVO;
import logica.ventaDAO;
import logica.ventaprodVO;
import modelo.modeloVentas;
import vista.vistaVentas;
import vista.vistaDashboard;
import vista.vistaConsultaProducto;
import vista.vistaEliminaventa;


public class controladorVentas implements ActionListener{
    modeloVentas objModeloVentas = null;
    vistaDashboard objPantallaDashboard = null;
    vistaVentas objPantallaVentas = null;
    vistaConsultaProducto objconsultaprod =null;
    vistaEliminaventa objPantallaEliminarVenta =null;
    
    public static String botonNuevo = "A";
    public static String botonSencillo= "B";
    public static String botonGenerar= "C";
    public static String botonVolver = "D";
    public static String botonBuscarNombreCategoria = "E";
    public static String buscarCodigoProductoBTN = "F";
    public static String text = "G";
    public static String agregarVentaBTN = "H";
    public static String quitarVentaBTN = "I";
    public static String buscarprod = "J";
    public static String botonAnularVenta = "K";
    
    public controladorVentas (modeloVentas objModeloVentas, vistaVentas objPantallaVentas,
                            vistaDashboard objPantallaDashboard, 
                            vistaConsultaProducto objconsultaprod,vistaEliminaventa objPantallaEliminarVenta){
        this.objModeloVentas = objModeloVentas;
        this.objPantallaDashboard = objPantallaDashboard;
        this.objPantallaVentas = objPantallaVentas;

        this.objconsultaprod = objconsultaprod;
        this.objPantallaEliminarVenta = objPantallaEliminarVenta;
    }
     public void actionPerformed(ActionEvent objEvento){
         //NUEVO
        if (objEvento.getActionCommand().equals(controladorVentas.botonAnularVenta)){
            objPantallaEliminarVenta.despliegaPantalla();
            objPantallaVentas.dispose();
        }
        // String estado = "activo";
        if (objEvento.getActionCommand().equals(controladorVentas.botonNuevo)){
            if (objPantallaVentas.gettipodeventa().equals("Seleccionar")) {
                objPantallaVentas.Mensaje("Debe Seleccionar tipo de venta");
            }else if (objPantallaVentas.gettipopago().equals("Seleccionar")) {
                objPantallaVentas.Mensaje("Debe Seleccionar tipo de pago");                
            }else if (objPantallaVentas.gettotalapagar().trim().equals("")|| objPantallaVentas.gettotalapagar().equals("0.0") ) {
                objPantallaVentas.Mensaje("No se ha realizado venta");
            }else{
                int numeroventas = objPantallaVentas.getnumeroventa();
                String tipo_documento = objPantallaVentas.gettipopago();
                String tipo_venta = objPantallaVentas.gettipodeventa();
                String fecha_venta = objPantallaVentas.getfecha();
                String hora_venta  = objPantallaVentas.gethora();
                String productos_venta= "";
                String valor_neto_venta= objPantallaVentas.getvalorventa();
                String valor_descuento_venta = objPantallaVentas.getdescuento();
                String subtotal_venta = objPantallaVentas.getsubtotal();
                String iva_venta = objPantallaVentas.getiva();
                String total_venta = objPantallaVentas.gettotalapagar();
                String sencillo_venta = objPantallaVentas.getsencillo();
                String vuelto_venta = objPantallaVentas.getvuelto();
                String estado = "activo";
                int stock =0;
                String codigos ="";
                ArrayList lista = new ArrayList();
                ArrayList lista2 = new ArrayList();
                ArrayList lista3 = new ArrayList();
                lista = objPantallaVentas.getproductos();
                lista2 = objPantallaVentas.getstocktabla();
                lista3 = objPantallaVentas.getcodigostabla();
                for (int i = 0; i < lista.size(); i++) {
                    productos_venta = productos_venta+lista.get(i);
                    codigos = lista3.get(i).toString();
                    stock = Integer.parseInt(lista2.get(i).toString());
                    objModeloVentas.rebajarstock(codigos, stock);
                    System.out.println(stock);
                }
                //INSERTAR VENTA
                ventaDAO venta = new ventaDAO();
                venta.modificarCategoria(numeroventas, tipo_documento, tipo_venta, fecha_venta, hora_venta, productos_venta, valor_neto_venta, valor_descuento_venta, subtotal_venta, iva_venta, total_venta, sencillo_venta, vuelto_venta, estado);
                int counttabla = objPantallaVentas.getrowtabla();
                for (int i = 0; i < counttabla; i++) {
                    int idventa = (objPantallaVentas.getnumeroventa());
                    String idprod = objPantallaVentas.getid_prod(i);
                    String nombreprod = objPantallaVentas.getnombreprod(i);
                    Double descuento = Double.valueOf(objPantallaVentas.getdescuentoprod(i));
                    Double valor = Double.valueOf(objPantallaVentas.getvalorprod(i));
                    int cantidad = Integer.valueOf(objPantallaVentas.getcantidadprod(i));
                    objModeloVentas.insertaproducto(idventa, idprod, nombreprod, descuento, valor, cantidad);
                }
                objPantallaVentas.Mensaje("Venta Realizada");
                objPantallaVentas.limpiartodo();
                objPantallaVentas.limpiarnombreprod();
                objPantallaVentas.limpiartabla();
                objPantallaVentas.limpiartotales();
                modeloVentas ventas  = new modeloVentas();
                int mayor = ventas.obtenermayornumero() +1;
                objPantallaVentas.setnumeroventa(mayor);
            }
        }
        if (objEvento.getActionCommand().equals(controladorVentas.botonGenerar)){
            
        }
        if (objEvento.getActionCommand().equals(controladorVentas.botonSencillo)){
            
        }
        if (objEvento.getActionCommand().equals(controladorVentas.botonVolver)){
            objPantallaVentas.limpiartodo();
            objPantallaDashboard.despliegaPantalla();
            objPantallaDashboard.cerrarMenu();
            objPantallaVentas.dispose();
        }
        if (objEvento.getActionCommand().equals(controladorVentas.botonBuscarNombreCategoria)){

        }
        if (objEvento.getActionCommand().equals(controladorVentas.buscarCodigoProductoBTN)){

        }
        if (objEvento.getActionCommand().equals(controladorVentas.text)){
            
        }
        if (objEvento.getActionCommand().equals(controladorVentas.quitarVentaBTN)){
            int posicion = objPantallaVentas.selecciontablanumero();
            if (posicion < 0) {
                objPantallaVentas.Mensaje("Seleccione producto a eliminar");
            }else{
                //objPantallaVentas.restartotales(posicion);
                double suma =0;
                int cantidadprod = objPantallaVentas.getposiciontabla();
                if(cantidadprod >= 0){
                    suma = objPantallaVentas.obtenersuma(false);
                    objPantallaVentas.setvalorventa(String.valueOf(suma));
                    objPantallaVentas.obtenertotales(suma);
                }
                objPantallaVentas.eliminadetabla(posicion);
                
            }
        }        
        if (objEvento.getActionCommand().equals(controladorVentas.agregarVentaBTN)){
        //try{
            String codProducto = objPantallaVentas.getcodproducto();
            String nomProducto = objPantallaVentas.getnomproducto();
            String precioProducto = objPantallaVentas.getprecioproducto();
            String stockProducto = objPantallaVentas.getstockproducto();
            String cantidadProducto = objPantallaVentas.getcantidadproducto();
            String totalProducto = objPantallaVentas.gettotalproducto().toString();
            int row = objPantallaVentas.getposiciontabla();
            
            if (!stockProducto.equals("")) {
               int stocke = Integer.parseInt(stockProducto); 
                if(nomProducto.trim().equals("")){
                   objPantallaVentas.Mensaje("ingrese Nombre del Producto");            
               }else if(precioProducto.trim().equals("")){
                   objPantallaVentas.Mensaje("ingrese Precio del Producto");            
               }else if(objPantallaVentas.getcodproducto().trim().equals("")){
                   objPantallaVentas.Mensaje("ingrese Precio del Producto");            
               }else if(stocke == 0){
                   objPantallaVentas.Mensaje("Producto sin stock");            
               }else if(cantidadProducto.trim().equals("")){
                   objPantallaVentas.Mensaje("Ingrese Cantidad de Producto");                
               }else if(totalProducto.trim().equals("")){
                   objPantallaVentas.Mensaje("Ingrese  total de Producto");  
               }else{        
                   double descuento = objPantallaVentas.obtenercantidaddescuento();
                   objPantallaVentas.llenartabla(codProducto, nomProducto, stockProducto, precioProducto, cantidadProducto, totalProducto, descuento, row);
                   objPantallaVentas.limpiarnombreprod();
                    double suma =0;
                    int cantidadprod = objPantallaVentas.getposiciontabla();
                    if(cantidadprod >= 0){
                        suma = objPantallaVentas.obtenersuma(true);
                        objPantallaVentas.setvalorventa(String.valueOf(suma));
                        objPantallaVentas.obtenertotales(suma);
                        objPantallaVentas.modificadescuento(objPantallaVentas.sumadescuentos());
                    }
                    
                }
            }else{
                objPantallaVentas.Mensaje("Ingrese Codigo del producto");
            }    
               // }catch(Exception e){
                       //objPantallaVentas.Mensaje("Ingrese Codigo del producto");
                //       System.out.println(e.toString());
                //}
           
        
        }if (objEvento.getActionCommand().equals(controladorVentas.buscarprod)){
            //objPantallaVentas.limpiartodo();
            objconsultaprod.despliegaPantalla();
            objPantallaDashboard.cerrarMenu();
            //objPantallaVentas.dispose();            
        }
        
     }

}
