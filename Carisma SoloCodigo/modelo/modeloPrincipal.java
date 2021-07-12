package modelo;
import java.util.ArrayList;
import vista.vistaLogin;

import logica.usuarioDAO;
import logica.usuarioVO;

public class modeloPrincipal {
    private usuarioDAO usuarioDAO;
    private usuarioVO usuarioVO;
    String usuario="";
    String contra="";
    
    public modeloPrincipal(){
        
    }
    
    public modeloPrincipal(modeloPrincipal objModelo, vistaLogin objPantalla){
        
    }
    
    public boolean validador(String user, String pass){
        usuario="";
        contra="";
        ArrayList <usuarioVO> validar = null;
        usuarioDAO userDAO = new usuarioDAO();
        validar = userDAO.getUsuario(user, pass);
        for (int i = 0; i < validar.size(); i++) {
            usuario=validar.get(i).getNomUsuario();
            contra=validar.get(i).getConUsuario();
        }
        System.out.println(usuario + contra);
        if (usuario.equals("")&& contra.equals("")) {
            return false;
        }
        else{
            return true;
        }
    }
    
}
