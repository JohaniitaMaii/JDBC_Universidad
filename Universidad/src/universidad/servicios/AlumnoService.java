package universidad.servicios;

import java.util.List;
import universidad.DAO.AlumnoDAO;
import universidad.entidades.Alumno;

/**
 *
 * @author johan
 */
public class AlumnoService {
    
    AlumnoDAO a = new AlumnoDAO();
    
    public void insertarAlumno(Alumno alumno ) throws Exception {
        if (alumno.getNombre().equals("") || alumno.getNombre().trim().isEmpty() ) {
            throw new Exception("Debe indicar el Nombre del Alumno");
        }
        if (alumno.getApellido().equals("") || alumno.getApellido().trim().isEmpty()) {
            throw new Exception("Debe indicar el apellido del Alumno");
        }
        if (alumno.getFecha_nac().toString().trim().isEmpty() || alumno.getFecha_nac().toString().equals("")) {
            throw new Exception("Debe indicar Fecha de Nacimiento del Alumno");
        }
        if (alumno.getId() == null || alumno.getId().toString().trim().isEmpty()) {
            throw new Exception("Debe indicar un id ");
        }
        if (alumno.getDni() == null || alumno.getDni().toString().trim().isEmpty()) {
            throw new Exception("Debe indicar DNI del Alumno");
        }
        a.guardarAlumno(alumno);
    }
    
    public void modificarAlumno(Integer id) throws Exception {
        Alumno alum = a.buscarAlumnoPorId(id);
        if (alum == null) {
            throw new Exception("El Alumno no existe en la Base de Datos");
        }
        a.modificarAlumno(alum);
    }
    
    public void buscarPorId(Integer id) throws Exception {
        Alumno alum = a.buscarAlumnoPorId(id);
        System.out.println(alum.toString());
    }
    
    public void listarPorApellido(String apellido) throws Exception {
        List<Alumno> alumnos = a.listarAlumnoApellido(apellido);
        for (Alumno a : alumnos) {
            System.out.println(a.toString());
        }
    }
    public void eliminarAlumno(Integer id) throws Exception {
        Alumno alum = a.buscarAlumnoPorId(id);
        if (alum == null) {
            throw new Exception("El Alumno no existe en la Base de Datos");
        }
        a.eliminarAlumno(alum.getId());
    }
}
