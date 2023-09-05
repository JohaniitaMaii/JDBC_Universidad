package universidad.DAO;

import java.util.ArrayList;
import java.util.List;
import universidad.entidades.Inscripcion;

/**
 *
 * @author johan
 */
public class InscripcionDAO extends Conexion {
    
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
    
    public Inscripcion buscarInscripcionPorIdMateria(Integer id) throws Exception {
        try {
            String sql = "SELECT * FROM inscripcion WHERE id_materia = " + id ;
            consultarBase(sql);
            Inscripcion inscripcion = null;
            while (resultado.next()){
                inscripcion = new Inscripcion();
                inscripcion.setId_incripcion(resultado.getInt(1));
                inscripcion.setNota(resultado.getInt(2));
                inscripcion.setId_alumno(resultado.getInt(3));
                inscripcion.setId_materia(resultado.getInt(4));
            }              
            desconectarBase();
            return inscripcion;
        } catch (Exception e) {
            System.out.println("Error al buscar la Inscripcion");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public Inscripcion buscarInscripcionPorId(int id) throws Exception {
        try {
            String sql = "SELECT * FROM alumno WHERE id = " + id;
            consultarBase(sql);
            Inscripcion inscripcion = null;
            while (resultado.next()){
                inscripcion = new Inscripcion();
                inscripcion = new Inscripcion();
                inscripcion.setId_incripcion(resultado.getInt(1));
                inscripcion.setNota(resultado.getInt(2));
                inscripcion.setId_alumno(resultado.getInt(3));
                inscripcion.setId_materia(resultado.getInt(4));
            }              
            desconectarBase();
            return inscripcion;
        } catch (Exception e) {
            System.out.println("Error al buscar la Inscripcion");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void eliminarInscripcion(int id) throws Exception {
        try {
            String sql = " DELETE FROM inscripcion WHERE id_inscripcion = " + id;
            modificarBase(sql);
        } catch (Exception e) {
            System.out.println("Error al eliminar Inscripcion");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public List<Inscripcion> listarInscripcion() throws Exception {
        try {
            String sql = "SELECT * FROM inscripcion ";
            Inscripcion inscripcion = null;
            List<Inscripcion> inscripciones = new ArrayList<>();
            consultarBase(sql);
            while (resultado.next()){
                inscripcion = new Inscripcion();
                inscripcion.setId_incripcion(resultado.getInt(1));
                inscripcion.setNota(resultado.getInt(2));
                inscripcion.setId_alumno(resultado.getInt(3));
                inscripcion.setId_materia(resultado.getInt(4));
                inscripciones.add(inscripcion);
            }
            return inscripciones;
        } catch (Exception e) {
            System.out.println("Error al Listar las Inscripciones");
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    
}
