package universidad.servicios;

import universidad.entidades.Inscripcion;

/**
 *
 * @author johan
 */
public class InscripcionService {
    
    
    
    public void insertarAlumno(Inscripcion inscripcion ) throws Exception {
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
