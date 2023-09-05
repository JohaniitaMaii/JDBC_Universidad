package universidad.DAO;

import java.util.ArrayList;
import java.util.List;
import universidad.entidades.Alumno;

/**
 *
 * @author johan
 */
public final class AlumnoDAO extends Conexion {
        
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
    
    public Alumno buscarAlumnoPorNombre(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM alumno WHERE nombre = '" + nombre + "';" ;
            consultarBase(sql);
            Alumno alumno = null;
            while (resultado.next()){
                alumno = new Alumno();
                alumno.setId(resultado.getInt(1));
                alumno.setDni(resultado.getLong(2));
                alumno.setNombre(resultado.getString(3));
                alumno.setApellido(resultado.getString(4));
                alumno.setFecha_nac(resultado.getDate(5));
                alumno.setEstado(resultado.getBoolean(6));
            }              
            desconectarBase();
            return alumno;
        } catch (Exception e) {
            System.out.println("Error al buscar el Alumno");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public Alumno buscarAlumnoPorId(int id) throws Exception {
        try {
            String sql = "SELECT * FROM alumno WHERE id = " + id;
            consultarBase(sql);
            Alumno alumno = null;
            while (resultado.next()){
                alumno = new Alumno();
                alumno.setId(resultado.getInt(1));
                alumno.setDni(resultado.getLong(2));
                alumno.setNombre(resultado.getString(3));
                alumno.setApellido(resultado.getString(4));
                alumno.setFecha_nac(resultado.getDate(5));
                alumno.setEstado(resultado.getBoolean(6));
            }              
            desconectarBase();
            return alumno;
        } catch (Exception e) {
            System.out.println("Error al buscar el Alumno");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void eliminarAlumno(int id) throws Exception {
        try {
            String sql = " DELETE FROM alumno WHERE id = " + id;
            modificarBase(sql);
        } catch (Exception e) {
            System.out.println("Error al eliminar Alumno");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public List<Alumno> listarAlumnoApellido(String apellido) throws Exception {
        try {
            String sql = "SELECT * FROM alumno WHERE apellido AS '" + apellido + "';";
            Alumno alumno = null;
            List<Alumno> alumnos = new ArrayList<>();
            while (resultado.next()){
                alumno = new Alumno();
                alumno.setId(resultado.getInt(1));
                alumno.setDni(resultado.getLong(2));
                alumno.setNombre(resultado.getString(3));
                alumno.setApellido(resultado.getString(4));
                alumno.setFecha_nac(resultado.getDate(5));
                alumno.setEstado(resultado.getBoolean(6));
                alumnos.add(alumno);
            }
            return alumnos;
        } catch (Exception e) {
            
        } finally {
            desconectarBase();
        }
        return null;
    }
    
}
