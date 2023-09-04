package universidad.DAO;

import universidad.entidades.Alumno;

/**
 *
 * @author johan
 */
public class AlumnoDAO extends Conexion {
    
    Alumno a = new Alumno();
    
    public void guardarAlumno(Alumno a ) throws Exception {
        try {
            if (a != null) {
                throw new Exception("Debe indicar un alumno");
            }
            String sql = "INSERT INTO alumno(dni, nombre, apellido,fecha_nac) VALUES (" + a.getDni() + ", '" +
                    a.getNombre() + "', '" + a.getApellido() + "','" + a.getFecha_nac() + "');";
            modificarBase(sql);
        } catch (Exception e ) {
            System.out.println("Error al crear el Alumno");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void modificarAlumno(Alumno a ) throws Exception {
        try {
        if (a != null) {
            throw new Exception("Debe indicar el alumno");
        }
        String sql = "UPDATE alumno SET estado= " + a.isEstado() + " WHERE id= " + a.getId();
        modificarBase(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void buscarAlumnoPorNombre() throws Exception {
        
    }
    
    public void buscarAlumnoPorId() throws Exception {
        
    }
    
    public void eliminarAlumno() throws Exception {
        
    }
    
}
