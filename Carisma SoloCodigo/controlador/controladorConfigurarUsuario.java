package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import logica.usuarioVO;
import vista.vistaConfigurarUsuario;
import modelo.modeloConfigurarUsuario;
import vista.vistaDashboard;

public class controladorConfigurarUsuario implements ActionListener {
    modeloConfigurarUsuario objModeloConfigurarUsuario = null;
    vistaConfigurarUsuario objPantallaConfigurarUsuario = null;
    vistaDashboard objPantallaDashboard = null;
    
    public static String botonAceptarUsuario = "A";
    public static String botonCancelarUsuario= "B";
    public static String botonAceptarPass = "C";
    public static String botonCancelarPass= "D";
    public static String botonVolver= "E";
    
    public controladorConfigurarUsuario(modeloConfigurarUsuario objModeloConfigurarUsuario, 
            vistaConfigurarUsuario objPantallaConfigurarUsuario,
                            vistaDashboard objPantallaDashboard){
        this.objModeloConfigurarUsuario = objModeloConfigurarUsuario;
        this.objPantallaDashboard = objPantallaDashboard;
        this.objPantallaConfigurarUsuario = objPantallaConfigurarUsuario;
    }
    public void actionPerformed(ActionEvent objEvento){
         if (objEvento.getActionCommand().equals(controladorConfigurarUsuario.botonAceptarUsuario)){
            String nombreAntiguo=objPantallaConfigurarUsuario.getNombreUsuarioAntiguo();
            String nombreNuevo=objPantallaConfigurarUsuario.getNombreUsuarioNuevo();
            
            ArrayList <usuarioVO> lista = null;
            lista = objModeloConfigurarUsuario.BusquedarUsuario(nombreAntiguo);
            if (lista.isEmpty()){
                objPantallaConfigurarUsuario.Mensaje("Ingrese usuario actual");
            }else 
            if (nombreAntiguo.isEmpty()) {
                objPantallaConfigurarUsuario.Mensaje("Debe ingresar nombre de usuario antiguo");                
            }else if(nombreNuevo.isEmpty()){
                objPantallaConfigurarUsuario.Mensaje("Debe ingresar nombre de usuario nuevo");
            }else{
               objModeloConfigurarUsuario.modificarUsuario(nombreAntiguo, nombreNuevo);
               objPantallaConfigurarUsuario.Mensaje("Modificación Exitosa");
               objPantallaConfigurarUsuario.limpiar();
            }
         }
         if (objEvento.getActionCommand().equals(controladorConfigurarUsuario.botonCancelarUsuario)){
             objPantallaConfigurarUsuario.limpiar();
         }
         if (objEvento.getActionCommand().equals(controladorConfigurarUsuario.botonAceptarPass)){
            String passAntigua=objPantallaConfigurarUsuario.getPassAntigua();
            String passNueva=objPantallaConfigurarUsuario.getPassNueva();
            String passConfirmar=objPantallaConfigurarUsuario.getConfirmarPass();
            String nombreUsuario=objPantallaConfigurarUsuario.getNombreUsuario();
            
            ArrayList <usuarioVO> lista2 = null;
            lista2 = objModeloConfigurarUsuario.BusquedarUsuario(nombreUsuario);
      
            ArrayList <usuarioVO> lista = null;
            lista = objModeloConfigurarUsuario.BusquedarPassword(passAntigua);
            if (lista2.isEmpty()){
                objPantallaConfigurarUsuario.Mensaje("Ingrese nombre de usuario actual");
            }else
            if (lista.isEmpty()){
                objPantallaConfigurarUsuario.Mensaje("Ingrese contraseña actual");
            }else
            if (passAntigua.isEmpty()) {
                objPantallaConfigurarUsuario.Mensaje("Debe ingresar contraseña antigua");                
            }else if(nombreUsuario.isEmpty()){
                objPantallaConfigurarUsuario.Mensaje("Debe ingresar nombre de usuario");
            }
            else if(passNueva.isEmpty()){
                objPantallaConfigurarUsuario.Mensaje("Debe ingresar contraseña nueva");
            }else if(passConfirmar.isEmpty()){
                objPantallaConfigurarUsuario.Mensaje("Debe confirmar contraseña nueva");
            }else if(!passNueva.equals(passConfirmar)){
                objPantallaConfigurarUsuario.Mensaje("Las contraseñas no coinciden ");
            }else{
               objModeloConfigurarUsuario.modificarPassword(passAntigua, passNueva, nombreUsuario);
               objPantallaConfigurarUsuario.Mensaje("Modificación Exitosa");
               objPantallaConfigurarUsuario.limpiar();
            }
         }
         if (objEvento.getActionCommand().equals(controladorConfigurarUsuario.botonCancelarPass)){
             objPantallaConfigurarUsuario.limpiar();
         }
         if (objEvento.getActionCommand().equals(controladorConfigurarUsuario.botonVolver)){
             objPantallaDashboard.despliegaPantalla();
             objPantallaConfigurarUsuario.dispose();
             objPantallaConfigurarUsuario.limpiar();
             objPantallaDashboard.cerrarMenu();
         }
    }
    
    
    
}
