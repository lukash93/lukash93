package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.modeloPrincipal;
import vista.vistaLogin;
import vista.vistaDashboard;

public class controladorLogin implements ActionListener{
    modeloPrincipal objModeloPrincipal = null;
    vistaLogin objPantallaLogin = null;
    vistaDashboard objPantallaDashboard = null;
    
    public static String botonLogin = "A";
    public static String passTextbox = "B";
    
    public controladorLogin(modeloPrincipal objModeloPrincipal, 
                            vistaLogin objPantallaLogin,
                            vistaDashboard objPantallaDashboard){
        this.objModeloPrincipal = objModeloPrincipal;
        this.objPantallaLogin = objPantallaLogin;
        this.objPantallaDashboard = objPantallaDashboard;
    }
    
    public void actionPerformed(ActionEvent objEvento){
        String usuario = objPantallaLogin.getUsuario();
        String contraseña = objPantallaLogin.getPassword();
        
        if (objEvento.getActionCommand().equals(controladorLogin.botonLogin)) {
            if (usuario.isEmpty()) {
                objPantallaLogin.mensaje("Ingrese Usuario");
            }else if (contraseña.isEmpty()) {
                objPantallaLogin.mensaje("Ingrese Contraseña");
            }else{
                if (objModeloPrincipal.validador(usuario, contraseña) == true) {
                    objPantallaDashboard.despliegaPantalla();
                    objPantallaLogin.dispose();
                }else{
                    objPantallaLogin.mensaje("Usuario y/o Contraseña Errónea");
                }
            }
        }
        
        if (objEvento.getActionCommand().equals(controladorLogin.passTextbox)) {
            if (usuario.isEmpty()) {
                objPantallaLogin.mensaje("Ingrese Usuario");
            }else if (contraseña.isEmpty()) {
                objPantallaLogin.mensaje("Ingrese Contraseña");
            }else{
                if (objModeloPrincipal.validador(usuario, contraseña) == true) {
                    objPantallaDashboard.despliegaPantalla();
                    objPantallaLogin.dispose();
                }else{
                    objPantallaLogin.mensaje("Usuario y/o Contraseña Errónea");
                }
            }
        }
    }
}