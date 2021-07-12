package logica;

import conexion.conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class categoriaDAO {
    private Connection conexion;
    private Statement st;
    public boolean valida = false;
    conexionBD bd = new conexionBD();
    
         
    public ArrayList rescatarcategoria(){
        String sql= "SELECT nombre_categoria FROM categoria";
        ResultSet rs = bd.ejecutarselect20(sql);
        ArrayList listacat = new ArrayList();
        try{
            while(rs.next()){
                String conector = rs.getString("nombre_categoria");

                
                
                listacat.add(conector);
            }
        }catch(Exception ee){
            //valida = false;
        }
        return listacat;
    }
    public boolean consultaValidarCategoria(String categoria){
        String sql = "select nombre_categoria from categoria where nombre_categoria = '"+categoria+"'" ;
        ResultSet rs= bd.ejecutarselect20(sql);
        try{
            while(rs.next()){
                valida = true;
            }
        }catch(Exception ee){
            //valida = false;
        }
        return valida;
    }
    public void getIngreso(String categoria) {
        String sql="INSERT INTO  `puntodeventa`.`categoria` (\n" +
                    "`id_categoria` ,\n" +
                    "`nombre_categoria`\n" +
                    ")\n" +
                    "VALUES (\n" +
                    "NULL ,  '"+categoria+"'\n" +
                    "); ";

        bd.ejecutarmodificacion(sql);
        
        
    }
    public void modificarCategoria(String nombreCategoria, String nuevonombre) {
        String query = "UPDATE  `puntodeventa`.`categoria` SET  `nombre_categoria` =  '"+nuevonombre+"'"
                + " WHERE  `categoria`.`nombre_categoria` = '"+nombreCategoria+"';";

        bd.ejecutarmodificacion(query);
        
    }
    public void EliminarCiudad(String nombreCategoria) throws ClassNotFoundException{
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql="delete from categoria where nombre_categoria= '"+nombreCategoria+"' ";
        try{
           Class.forName(bd.getDriver());
           conn = DriverManager.getConnection(
           bd.getUrl(), bd.getUsuario(), bd.getContraseña());
           pst = conn.prepareStatement(sql);
          int nom = pst.executeUpdate(sql);
        }catch(SQLException ee){
            
        }
        
    }
 
    
    public ArrayList guardarCategoria(String nombreCategoria){
        System.out.println(nombreCategoria+"categoria");
        String sql= "SELECT id_categoria FROM categoria WHERE nombre_categoria = '"+nombreCategoria+"' ";
        ResultSet rs = bd.ejecutarselect20(sql);
        ArrayList listacat = new ArrayList();
        try{
            while(rs.next()){
                String conector = rs.getString("nombre_categoria");

                
                
                listacat.add(conector);
                for (int i = 0; i < listacat.size(); i++) {
                }
            }
        }catch(Exception ee){
            //valida = false;
        }
        return listacat;
    }
   
    

}
