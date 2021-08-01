package BL;
import java.sql.DriverManager;
import java.sql.Connection;


public class clsConexion {
    Connection conn=null;
    String stServidor, stDataBase, stUsuario, stPassword ="";
    
    public clsConexion(){
        try{
            stServidor="localhost";
            stDataBase="bdCRM";
            stUsuario="leo";
            stPassword="leo";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String stConexion="jdbc:sqlserver://"+stServidor+":1433; databaseName="+stDataBase;
            
            conn=DriverManager.getConnection(stConexion,stUsuario,stPassword);
            
        }catch(Exception ex){
           
        }
        
    }
    public Connection getConexion(){
        return conn;
    }
    public void cerrarConexion(Connection conn){
        try {
            conn.close();
        } catch (Exception ex) {
           
        }
    }
}
