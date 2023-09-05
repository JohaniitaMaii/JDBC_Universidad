
package universidad.DAO;


import universidad.entidades.Materia;

/**
 *
 * @author cisco
 */
public final class MateriaDAO extends Conexion {
    
    public void guardarMateria(Materia materia) throws Exception {
        String query = 
                "insert into materia values (" +
                "null, '" +
                materia.getNombre() + "', " +
                materia.getAño() + ", " +
                materia.getEstado() + ");";
        modificarBase(query);
    }
    
    public Materia getMateria(String nombre) throws Exception {
        nombre = clearArg(nombre);
        String query = "select * from materia where nombre like '%" + nombre +"%';";
        consultarBase(query);
        resultado.next();

        nombre = resultado.getString("nombre");
        int id = resultado.getInt("id_materia"),
            año = resultado.getInt("año"),
            estado = resultado.getInt("estado");
        
        return new Materia(id, nombre, año, estado);
    }
    
    public Materia getMateria(int materia) throws Exception {
        
        String query = "select * from materia where id_materia = " + materia +";";
        consultarBase(query);
        resultado.next();
        
        String nombre = resultado.getString("nombre");
        int id = resultado.getInt("id_materia"),
            año = resultado.getInt("año"),
            estado = resultado.getInt("estado");
        
        return new Materia(id, nombre, año, estado);  
    }
    
    
    
    public void deleteMateria(Materia materia) throws Exception {
        String query = "delete from materia where id = ";
        query += materia.getIdMateria();
        modificarBase(query);
    }
    
    public void deleteMateria(String materia) throws Exception {
        materia = clearArg(materia);
        String query = "delete from materia where nombre like "+materia+";";
        modificarBase(query);
    }
    
    public void deleteMateria(int materia) throws Exception {
        String query = "delete from materia where id = "+materia;
        modificarBase(query);
    }
}