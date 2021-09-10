
package privilegios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "benjamin41";
    private static String database = "Gogrocery";
    private static final String url ="jdbc:mysql://34.67.124.153/"+database;
    public conectar() {
        conn = null;
        try{
           Class.forName(driver);
           conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexion establecida");
            }
        }catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error"+ex);
        }   
    }
    
    public Connection conexion()  {
        return conn;
    } 
    
    public void desconectar() throws SQLException{
        conn.close();
        System.out.println(conn);
    }                    

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDatabase() {
        return database;
    }
    
    
 
    
    
    
    
}
