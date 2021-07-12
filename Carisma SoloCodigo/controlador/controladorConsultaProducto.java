/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import logica.productoVO;
import modelo.modeloProductos;
import vista.vistaConsultaProducto;
import vista.vistaDashboard;
import vista.vistaVentas;

/**
 *
 * @author Fernando
 */
//JORGE
public class controladorConsultaProducto implements ActionListener{
    
    modeloProductos objModeloProducto = null;
    vistaConsultaProducto objPantallaConsultaProducto = null;
    vistaDashboard objDashboard = null;
    vistaVentas objPantallaVentas = null;
    
    public static String volver = "A";
    public static String buscar = "B";    

    
    public controladorConsultaProducto(modeloProductos objModeloProducto, 
                            vistaConsultaProducto objPantallaConsultaProducto,vistaDashboard objDashboard, vistaVentas objPantallaVenta) {
        this.objModeloProducto = objModeloProducto;
        this.objPantallaConsultaProducto = objPantallaConsultaProducto;
        this.objDashboard = objDashboard;
        this.objPantallaVentas = objPantallaVenta;    
    }
    
    
    public void actionPerformed(ActionEvent objEvento){
        if (objEvento.getActionCommand().equals(controladorConsultaProducto.volver)){
            objPantallaConsultaProducto.limpiartexto();
            objPantallaConsultaProducto.limpiartabla();
            objPantallaVentas.despliegaPantalla();
            objDashboard.cerrarMenu();
            objPantallaConsultaProducto.dispose();
        }if (objEvento.getActionCommand().equals(controladorConsultaProducto.buscar)){
            String filtro = objPantallaConsultaProducto.getfiltro();
            System.out.println("PASA"+objPantallaConsultaProducto.getfiltro());
            objPantallaConsultaProducto.limpiartabla();
            ArrayList<productoVO> list = new ArrayList();
            list = objModeloProducto.filtrarproducto(filtro);
                for (int j = 0; j < list.size(); j++) {
                    objPantallaConsultaProducto.llenartabla(list,j, j);
                    System.out.println("SI PASA");
                }
           // String modi = objPantallaConsultaProducto.getcodigo2();
           // objPantallaVentas.setcodigo(modi);
        }
    }

    
}
