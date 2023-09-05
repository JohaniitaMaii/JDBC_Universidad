
package universidad.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import universidad.entidades.Materia;

/**
 *
 * @author cisco
 */
public final class MateriaDAO extends Conexion {
    
    public void guardarMateria(Materia materia) throws Exception {
        String query = 
                "insert into materia values (" +
                "null, " +
                materia.getNombre() + ", " +
                materia.getAño() + ", " +
                materia.getEstado() + ");";
        modificarBase(query);
    }
    
    public Materia getMateria(String materia) throws Exception {
        
        String query = "select * from materia where nombre like %" + materia +"%;";

        consultarBase(query);
        
        String nombre = resultado.getString("nombre");
        int id = resultado.getInt("id"),
            año = resultado.getInt("año"),
            estado = resultado.getInt("estado");
        
        desconectarBase();
        
        return new Materia(id, nombre, año, estado);
    }
    
    public Materia getMateria(int materia) throws Exception {
        
        String query = "select * from materia where id = " + materia +";";

        consultarBase(query);
        
        String nombre = resultado.getString("nombre");
        int id = resultado.getInt("id"),
            año = resultado.getInt("año"),
            estado = resultado.getInt("estado");
        
        desconectarBase();
        
        return new Materia(id, nombre, año, estado);
    }
    
    
    
    public void deleteMateria(Materia materia) throws Exception {
        String query = "delete from materia where id = ";
        query += materia.getIdMateria();
        modificarBase(query);
    }
    
    public void deleteMateria(String materia) throws Exception {
        String query = "delete from materia where nombre like "+materia+";";
        modificarBase(query);
    }
    
    public void deleteMateria(int materia) throws Exception {
        String query = "delete from materia where id = "+materia;
        modificarBase(query);
    }
}