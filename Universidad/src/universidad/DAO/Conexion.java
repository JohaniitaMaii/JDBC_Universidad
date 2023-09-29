package universidad.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author johan
 */
public abstract class Conexion {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "estudiante"; // root
    private final String PASSWORD = "estudiante";
    private final String DATABASE = "estudiante"; // universidad - estudiante
    private final String DRIVER = "org.mariadb.jdbc.Driver";
    
    protected void conectarBase() throws Exception {  // jdbc:mariadb://localhost:1234/ 
        try {
            Class.forName(DRIVER);   //  + "useSSL=false"
            String url = "jdbc:mariadb://localhost/" + DATABASE ;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al conectar a la base de datos");
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            System.out.println(sql);

            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Error al consultar la Base de Datos");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    protected void modificarBase(String sql) throws Exception {
        try {
            System.out.println(sql);
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error al ejecutar modificacion");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("Error al desconectar Base");
            throw e;
        }
    }
    public String clearQuery( String arg ) {
        return arg.replaceAll("[\\W]", "").trim();
    }

     
}
