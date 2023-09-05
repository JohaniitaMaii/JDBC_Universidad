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
    
    protected void conectarBase() throws Exception {  // jdbc:mariadb://localhost:1234/ jdbc:mariadb://190-114-70-58.sanluisctv.com.ar/
        try {
            Class.forName(DRIVER);   //  + "useSSL=false"
            String url = "jdbc:mariadb://190-114-70-58.sanluisctv.com.ar/" + DATABASE ;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al conectar a la base de datos");
        }
    }

    protected ResultSet consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            return resultado;
        } catch (Exception e) {
            System.out.println("Error al consultar la Base de Datos");
            throw e;
        }
    }
    
    protected void modificarBase(String sql) throws Exception {
        try {
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

     
}
