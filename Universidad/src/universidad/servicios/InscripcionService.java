package universidad.servicios;

import java.util.List;
import universidad.DAO.InscripcionDAO;
import universidad.entidades.Inscripcion;

/**
 *
 * @author johan
 */
public class InscripcionService {

    InscripcionDAO idao = new InscripcionDAO();

    public void insertarInscripcion(Inscripcion inscripcion) throws Exception {
        if (inscripcion.getId_incripcion() == null || inscripcion.getId_incripcion().toString().trim().isEmpty()) {
            throw new Exception("Debe indicar el Id de Inscripcion");
        }
        if (inscripcion.getNota() == null || inscripcion.getNota().toString().trim().isEmpty()) {
            throw new Exception("Debe indicar la Nota");
        }
        if (inscripcion.getId_alumno() == null || inscripcion.getId_alumno().toString().equals("")) {
            throw new Exception("Debe indicar el Id del Alumno");
        }
        if (inscripcion.getId_materia() == null || inscripcion.toString().trim().isEmpty()) {
            throw new Exception("Debe indicar el Id de Materia");
        }

        idao.guardarInscripcion(inscripcion);
    }

    public void modificarInscripcion(Integer id) throws Exception {
        Inscripcion ins = idao.buscarInscripcionPorId(id);
        if (ins == null) {
            throw new Exception("La Inscripcion no existe en la Base de Datos");
        }
        idao.modificarInscrpcion(ins);
    }

    public void buscarInscripcionPorId(Integer id) throws Exception {
        Inscripcion ins = idao.buscarInscripcionPorId(id);
        System.out.println(ins.toString());
    }

    public void listarPorMateria(String materia) throws Exception {
        List<Inscripcion> inscripciones = idao.listarInscripcion();
        for (Inscripcion ins : inscripciones) {
            System.out.println(ins.toString());
        }
    }

    public void eliminarInscripcion(Integer id) throws Exception {
        Inscripcion ins = idao.buscarInscripcionPorId(id);
        if (ins == null) {
            throw new Exception("La Inscripcion no existe en la Base de Datos");
        }
        idao.eliminarInscripcion(ins.getId_incripcion());
    }
}
