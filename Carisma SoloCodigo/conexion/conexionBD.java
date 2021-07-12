package conexion;

import java.sql.*;

public class conexionBD {  
    private String driver;
    private String url;
    private String usuario;
    private String contraseña;
    public ResultSet resultado;
    
    public void ejecutarmodificacion(String query1){
        // Recibe la actualización y la ejecuta sobre la base de datos
        String user="root";
        // Password de protección al acceso a la base de datos
        String pass="toor";
        try {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/puntoDeVenta";
        Connection conector2 = DriverManager.getConnection(url, user, pass);
        Statement lectura2 = conector2.createStatement();
        lectura2.executeUpdate(query1);

        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public conexionBD() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost/puntoDeVenta";
        this.usuario = "root";
        this.contraseña = "toor";
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
 
public ResultSet ejecutarselect20(String query1){
        // Recibe la actualización y la ejecuta sobre la base de datos
         String user="root";
        // Password de protección al acceso a la base de datos
        String pass="toor";
        try {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/puntoDeVenta";
         Connection conector  = DriverManager.getConnection(url, user, pass);
        Statement lectura = conector.createStatement();
        resultado = lectura.executeQuery(query1);
            System.out.println("exito");
          return resultado;
        }
        catch(SQLException e){
            System.out.println(e);
            
        }
        return null;
    }
    
    
}
