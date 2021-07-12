package logica;

import conexion.conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class usuarioDAO {
    private Statement statement;
    private ResultSet resultSet;
    private Connection conexion;
     
    conexionBD bd = new conexionBD();
    
    
    public usuarioDAO() {
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/puntoDeVenta" , "root" , "toor");
            System.out.println ("Conexión exitosa");
        }catch (Exception error){
            error.printStackTrace();
        }
        
    }
      
    
    public ArrayList <usuarioVO> getUsuario (String Usuario, String Password){
        String sql="SELECT * FROM Usuario WHERE nombre_usuario='" + Usuario +
                      "' AND contraseña_usuario= '"+ Password + "'";
        ArrayList <usuarioVO> listaUsuarios=new ArrayList();
        try {
            
            resultSet=bd.ejecutarselect20(sql);
            if(resultSet.next()){
                usuarioVO usuario=new usuarioVO();
                usuario.setNomUsuario(resultSet.getString("nombre_usuario"));
                usuario.setConUsuario(resultSet.getString("contraseña_usuario"));
                listaUsuarios.add(usuario);
                
                return listaUsuarios;
            }
        }catch (Exception error){
            error.printStackTrace();
        }
        return listaUsuarios;
    }  
    //NUEVO
     public void modificarUsuario (String nombreAntiguo, String nombreNuevo){
            
           String query = "UPDATE  usuario SET nombre_usuario =  '"+nombreNuevo+"' WHERE nombre_usuario = '"+nombreAntiguo+"'";
           bd.ejecutarmodificacion(query);

    }
    //NUEVO
     public void modificarPassword (String passAntigua, String passNueva, String nombreUsuario){
            
           String query = "UPDATE  usuario SET contraseña_usuario =  '"+passNueva+"' , nombre_usuario =  '"+nombreUsuario+"' WHERE contraseña_usuario = '"+passAntigua+"'";
           bd.ejecutarmodificacion(query);

    }
    //NUEVO
     public ArrayList <usuarioVO> getValidarUsuario (String nombreAntiguo){ 
       Connection conn;
       PreparedStatement pst;
       ResultSet rs; 
       String query = "SELECT * FROM usuario WHERE nombre_usuario = '"+nombreAntiguo+"'";
        //pasa por acá
       ArrayList <usuarioVO> resultado=new ArrayList();
       try {
           Class.forName(bd.getDriver());
           conn = DriverManager.getConnection(
           bd.getUrl(), bd.getUsuario(), bd.getContraseña());
           pst = conn.prepareStatement(query);
           rs = pst.executeQuery();
           while (rs.next()){
               usuarioVO objusuarioVO = new usuarioVO();
               objusuarioVO .setNomUsuario(rs.getString("nombre_usuario"));
               //objusuarioVO .setConUsuario(rs.getString("contraseña_usuario"));
               resultado.add(objusuarioVO);
           }
           conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            return resultado;
        }
        return resultado;
    }
    //NUEVO
     public ArrayList <usuarioVO> getValidarPassword (String passAntigua){ 
       Connection conn;
       PreparedStatement pst;
       ResultSet rs; 
       String query = "SELECT * FROM usuario WHERE contraseña_usuario = '"+passAntigua+"'";
        //pasa por acá
       ArrayList <usuarioVO> resultado=new ArrayList();
       try {
           Class.forName(bd.getDriver());
           conn = DriverManager.getConnection(
           bd.getUrl(), bd.getUsuario(), bd.getContraseña());
           pst = conn.prepareStatement(query);
           rs = pst.executeQuery();
           while (rs.next()){
               usuarioVO objusuarioVO = new usuarioVO();
               objusuarioVO .setConUsuario(rs.getString("contraseña_usuario"));
               //objusuarioVO .setConUsuario(rs.getString("contraseña_usuario"));
               resultado.add(objusuarioVO);
           }
           conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            return resultado;
        }
        return resultado;
    
    }
}