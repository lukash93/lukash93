package logica;

import conexion.conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class productoDAO {
    private Statement statement;
    private ResultSet resultSet;
    private Connection conexion;
    
    //NUEVO
    String query = "";
    
    public boolean valida = false;
     
    conexionBD bd = new conexionBD(); 
    
    public productoDAO(){
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/puntoDeVenta" , "root" , "toor");
            System.out.println ("Conexión exitosa");
        }catch (Exception error){
            error.printStackTrace();
        }
        
    }
    
    public void getIngreso (productoVO objProductoVO){
        
            String query1 = "INSERT INTO producto VALUES ('"+       objProductoVO.getCodProducto()+ "','" +
                                                                    objProductoVO.getNomProducto()+ "', '"+ 
                                                                    objProductoVO.getPrecioProducto()+ "','" +
                                                                    objProductoVO.getStockProducto()+ "','" +
                                                                    objProductoVO.getMarcaProducto()+ "','" +
                                                                    objProductoVO.getDescProducto()+ "','" +
                                                                    objProductoVO.getColorProducto()+ "','" +
                                                                    objProductoVO.getTallaProducto()+ "','" +
                                                                    objProductoVO.getCostoProducto()+ "','" +
                                                                    objProductoVO.getUtilidadProducto()+ "','" +
                                                                    objProductoVO.getCategoriaProducto()+ "') ";
          System.out.println(query1);
       int proc1=0;
        try {
            Statement st1 = this.conexion.createStatement();
            proc1 = st1.executeUpdate(query1); // debe tener valor: 1 si esta insertado ok
            
        }
        catch(SQLException ee){
            System.out.println(ee);
        }  
    }
    public boolean consultaValidarCodigo(String codigo){
        String sql = "select codigo_producto from producto where codigo_producto = '"+codigo+"'" ;
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
    
    public int consultaValidarCodigoRepetido(String codigo){
        String sql = "select codigo_producto from producto where codigo_producto in ("+codigo+")" ;
        ResultSet rs= bd.ejecutarselect20(sql);
        int rows=0;
        try{
            while(rs.next()){
                rows++;
            }
        }catch(Exception ee){
            //valida = false;
        }
        return rows;
    }
    //ULTIMO
    public ArrayList <productoVO> getValidarCodigo (String codigo){ 
       Connection conn;
       PreparedStatement pst;
       ResultSet rs; 
       String query = "SELECT codigo_producto FROM producto WHERE codigo_producto = '"+codigo+"'";
        //pasa por acá
       ArrayList <productoVO> resultado=new ArrayList();
       try {
           System.out.println("Pasa por acáaaaa" +query);
           Class.forName(bd.getDriver());
           conn = DriverManager.getConnection(
           bd.getUrl(), bd.getUsuario(), bd.getContraseña());
           pst = conn.prepareStatement(query);
           rs = pst.executeQuery();
           while (rs.next()){
               productoVO objproductoVO = new productoVO();
               objproductoVO .setCodProducto(rs.getString("codigo_producto"));
               //objusuarioVO .setConUsuario(rs.getString("contraseña_usuario"));
               resultado.add(objproductoVO);
           }
           conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            return resultado;
        }
        return resultado;
    }
    //NUEVO
    public ArrayList <productoVO> getListaProductos(String dato,  int uu){
         
         if(uu == 1){
             query = "SELECT * FROM producto where codigo_producto ='"+dato+"'";
         }else if(uu == 2){
             query = "SELECT * FROM producto where nombre_producto LIKE '"+dato+"%';";
         }
         
        ResultSet rs = bd.ejecutarselect20(query);

         ArrayList <productoVO> Listaden = new ArrayList();

       System.out.println(query);
        try {      
            
            while(rs.next()){
                
                productoVO objbusqVO = new productoVO();
                objbusqVO.setCodProducto(rs.getString("codigo_producto"));
                objbusqVO.setNomProducto(rs.getString("nombre_producto"));
                objbusqVO.setPrecioProducto(rs.getDouble("precio_producto"));
                objbusqVO.setStockProducto(rs.getString("stock_producto"));
                objbusqVO.setMarcaProducto(rs.getString("marca_producto"));
                objbusqVO.setDescProducto(rs.getString("descripcion_producto"));
                objbusqVO.setColorProducto(rs.getString("color_producto"));
                objbusqVO.setTallaProducto(rs.getString("talla_producto"));
                objbusqVO.setCostoProducto(rs.getDouble("costo_producto"));
                objbusqVO.setUtilidadProducto(rs.getDouble("utilidad_producto"));
                objbusqVO.setCategoriaProducto(rs.getString("FK_id_categoria"));
                
               Listaden.add(objbusqVO);

               
            }  
           return Listaden;
        }
        catch(Exception ee){
            
            
        }
        return Listaden;
    }        
    public ArrayList<productoVO> mostrarProducto (String codigoProducto){
        
        //System.out.println("pasa por acá"+codigoProducto);
        query= "SELECT * FROM producto WHERE  codigo_producto = '"+codigoProducto+"'";
        ArrayList<productoVO> resultado = new ArrayList();
        
        ResultSet rs = bd.ejecutarselect20(query);
        try{
           while (rs.next()){
            
               System.out.println("pasa por acá!!!");
               //String prueba =rs.getString("nombre_producto")
               productoVO objproductoVO = new productoVO();
               //objproductoVO.setNomProducto(prueba); 
               objproductoVO.setCodProducto(rs.getString("codigo_producto"));
               objproductoVO.setNomProducto(rs.getString("nombre_producto"));
               objproductoVO.setPrecioProducto(rs.getDouble("precio_producto"));
               objproductoVO.setStockProducto(rs.getString("stock_producto"));
               objproductoVO.setMarcaProducto(rs.getString("marca_producto"));
               objproductoVO.setDescProducto(rs.getString("descripcion_producto"));
               objproductoVO.setColorProducto(rs.getString("color_producto"));
               objproductoVO.setTallaProducto(rs.getString("talla_producto"));
               objproductoVO.setCostoProducto(rs.getDouble("costo_producto"));
               objproductoVO.setUtilidadProducto(rs.getDouble("utilidad_producto"));
               objproductoVO.setCategoriaProducto(rs.getString("FK_id_categoria"));
               resultado.add(objproductoVO);
               objproductoVO.getNomProducto();
               
           }
        }catch(Exception ee){
            return resultado;
        }
        return resultado;
    }
    //NUEVO
    public void modificarProducto (String codigo, String nombre, double precio, double utilidad,
            String stock, double costo, String marca, String descripcion, String color, String talla, String categoria){
            
           String query = "UPDATE  producto SET codigo_producto =  '"+codigo+"', nombre_producto =  '"+nombre+"'," +
            "precio_producto =  '"+precio+"'," +
            "utilidad_producto =  '"+utilidad+"'," +
            "stock_producto =  '"+stock+"'," +
            "costo_producto =  '"+costo+"'," +
            "marca_producto =  '"+marca+"'," +
            "descripcion_producto =  '"+descripcion+"'," +
            "color_producto =  '"+color+"'," +
            "talla_producto =  '"+talla+"'," +
            "FK_id_categoria =  '"+categoria+"'"
            + " WHERE codigo_producto = '"+codigo+"';";
        bd.ejecutarmodificacion(query);
    
    
    }
    public ArrayList<productoVO> buscarfiltradoprod(String filtro){
        String query = "SELECT * \n" +
                        "FROM producto\n" +
                        "WHERE nombre_producto LIKE '"+filtro+"%';";
        ResultSet rs = bd.ejecutarselect20(query);
        ArrayList<productoVO> listapro = new ArrayList();
        
      
          try{
            while(rs.next()){
                productoVO prod = new productoVO();
                prod.setCodProducto(rs.getString("codigo_producto"));
                prod.setNomProducto(rs.getString("nombre_producto"));
                prod.setPrecioProducto(rs.getDouble("precio_producto"));
                prod.setStockProducto(rs.getString("stock_producto"));
                prod.setMarcaProducto(rs.getString("marca_producto"));
                prod.setDescProducto(rs.getString("descripcion_producto"));
                prod.setColorProducto(rs.getString("color_producto"));
                prod.setTallaProducto(rs.getString("talla_producto"));
                prod.setCategoriaProducto(rs.getString("FK_id_categoria"));
              
                listapro.add(prod);
                
                for (int i = 0; i < listapro.size(); i++) {
                   
                }
                
            }
            return listapro;
        }catch(Exception ee){
            //valida = false;
        }
        return listapro;    
    }
    public ArrayList<productoVO> consultaproducto(String codigo){
        String sql = "select * from producto where codigo_producto = '"+codigo+"'";
        ResultSet rs = bd.ejecutarselect20(sql);
        ArrayList<productoVO> listapro = new ArrayList();
            
        try{
            while(rs.next()){
                productoVO prod = new productoVO();
                prod.setNomProducto(rs.getString("nombre_producto"));
                prod.setStockProducto(rs.getString("stock_producto"));
                prod.setPrecioProducto(rs.getDouble("precio_producto"));

                listapro.add(prod);
                
            }
            return listapro;
        }catch(Exception ee){
            //valida = false;
        }
        return listapro;
    }    
    //NUEVO
    public ArrayList <productoVO> getListarStockProductos(String dato,  int uu){
         
         if(uu == 1){
             query = "SELECT * FROM producto where codigo_producto ='"+dato+"'";
         }else if(uu == 2){
             query = "SELECT * FROM producto where nombre_producto ='"+dato+"'";
         }else if(uu == 3){
             query = "SELECT * FROM producto";
         }
         
        ResultSet rs = bd.ejecutarselect20(query);

         ArrayList <productoVO> Listaden = new ArrayList();

        try {      
            
            while(rs.next()){
                
                productoVO objbusqVO = new productoVO();
                objbusqVO.setCodProducto(rs.getString("codigo_producto"));
                objbusqVO.setNomProducto(rs.getString("nombre_producto"));
                objbusqVO.setPrecioProducto(rs.getDouble("precio_producto"));
                objbusqVO.setStockProducto(rs.getString("stock_producto"));
                objbusqVO.setMarcaProducto(rs.getString("marca_producto"));
                objbusqVO.setDescProducto(rs.getString("descripcion_producto"));
                objbusqVO.setColorProducto(rs.getString("color_producto"));
                objbusqVO.setTallaProducto(rs.getString("talla_producto"));
                objbusqVO.setCostoProducto(rs.getDouble("costo_producto"));
                objbusqVO.setUtilidadProducto(rs.getDouble("utilidad_producto"));
                objbusqVO.setCategoriaProducto(rs.getString("FK_id_categoria"));
                
               Listaden.add(objbusqVO);

               
            }  
           return Listaden;
        }
        catch(Exception ee){
            
            
        }
        return Listaden;
    } 
    //NUEVO
    public ArrayList<productoVO> mostrarTodo (){
        
        //System.out.println("pasa por acá"+codigoProducto);
        query= "SELECT * FROM producto";
        ArrayList<productoVO> resultado = new ArrayList();
        
        ResultSet rs = bd.ejecutarselect20(query);
        try{
           while (rs.next()){
           
               productoVO objproductoVO = new productoVO();
               objproductoVO.setCodProducto(rs.getString("codigo_producto"));
               objproductoVO.setNomProducto(rs.getString("nombre_producto"));
               objproductoVO.setPrecioProducto(rs.getDouble("precio_producto"));
               objproductoVO.setStockProducto(rs.getString("stock_producto"));
               objproductoVO.setMarcaProducto(rs.getString("marca_producto"));
               objproductoVO.setDescProducto(rs.getString("descripcion_producto"));
               objproductoVO.setColorProducto(rs.getString("color_producto"));
               objproductoVO.setTallaProducto(rs.getString("talla_producto"));
               objproductoVO.setCostoProducto(rs.getDouble("costo_producto"));
               objproductoVO.setUtilidadProducto(rs.getDouble("utilidad_producto"));
               objproductoVO.setCategoriaProducto(rs.getString("FK_id_categoria"));
               resultado.add(objproductoVO);
               objproductoVO.getNomProducto();
               
           }
        }catch(Exception ee){
            return resultado;
        }
        return resultado;
    }
    //INSERTAR DE BOTON IMPORTAR
    public void insertarproductos (String codigo, String nombProducto, Double precioprod, int stock, String marca, String descripcion, String color, String talla, Double costoprod, Double utilidad, String categoria) {
        String query = "INSERT INTO `producto` (`codigo_producto`, `nombre_producto`, `precio_producto`, `stock_producto`, `marca_producto`, `descripcion_producto`,`color_producto`, `talla_producto`,`costo_producto`, `utilidad_producto`, `FK_id_categoria`) VALUES ('"+codigo+"', '"+nombProducto+"', '"+precioprod+"', '"+stock+"', '"+marca+"','"+descripcion+"', '"+color+"', '"+talla+"', '"+costoprod+"', '"+utilidad+"', '"+categoria+"')";

        bd.ejecutarmodificacion(query);
        
    }   
    
    
}
