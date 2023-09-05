package universidad.DAO;

import universidad.entidades.Inscripcion;

/**
 *
 * @author johan
 */
public class InscrpcionDAO extends Conexion {
    
    public void guardarInscripcion(Inscripcion i ) throws Exception {
        try {
            if (i == null) {
                throw new Exception("Debe indicar una Inscripcion");
            }
            String sql = "INSERT INTO inscripcion VALUES (" + i.getId_incripcion() + ", " +
                    i.getNota() + ", " + i.getId_alumno() + "," + i.getId_materia() + ");";
            modificarBase(sql);
        } catch (Exception e ) {
            System.out.println("Error al crear la Inscripcion");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void modificarInscrpcion(Inscripcion i ) throws Exception {
        try {
        if (i != null) {
            throw new Exception("Debe indicar una Inscrpcion");
        }
        String sql = "UPDATE inscripcion SET nota = " + i.getNota() + " WHERE id= " + i.getId_incripcion();
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
            String sql = "SELECT * FROM alumno WHERE apellido LIKE '" + apellido + "';";
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
