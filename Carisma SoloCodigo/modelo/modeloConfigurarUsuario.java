package modelo;

import java.util.ArrayList;
import logica.usuarioDAO;
import logica.usuarioVO;
import modelo.modeloConfigurarUsuario;
import vista.vistaConfigurarUsuario;

public class modeloConfigurarUsuario {
    private usuarioDAO userDAO;
    private usuarioVO userVO;
    
    String nombreUsuario="";
    String password="";

    public modeloConfigurarUsuario(modeloConfigurarUsuario objModeloConfigurarUsuario, vistaConfigurarUsuario
            objVistaConfigurarUsuario) {
    }

    public modeloConfigurarUsuario() {
    }
    
    //NUEVO
    public void modificarUsuario(String nombreNuevo, String nombreAntiguo){
        usuarioDAO usuario = new usuarioDAO();
        usuario.modificarUsuario(nombreNuevo, nombreAntiguo);
        
    }
    //NUEVO
    public void modificarPassword(String passNueva, String passAntigua, String nombreUsuario){
        usuarioDAO usuario = new usuarioDAO();
        usuario.modificarPassword(passNueva, passAntigua, nombreUsuario);
        
    }
    //NUEVO
    public ArrayList <usuarioVO> BusquedarUsuario (String nombreAntiguo){ 
        ArrayList <usuarioVO> Validar = null;
        usuarioDAO UserDAO = new usuarioDAO();
        Validar = UserDAO.getValidarUsuario(nombreAntiguo);
       
        return Validar;
    }
    //NUEVO
    public ArrayList <usuarioVO> BusquedarPassword (String passAntigua){ 
        ArrayList <usuarioVO> Validar = null;
        usuarioDAO UserDAO = new usuarioDAO();
        Validar = UserDAO.getValidarPassword(passAntigua);
       
        return Validar;
    }
    
}
