package universidad.entidades;

/**
 *
 * @author johan
 */
public class Inscripcion {
    
    private Integer id_incripcion;
    private Integer nota;
    private Integer id_alumno;
    private Integer id_materia;

    public Inscripcion() {
    }

    public Inscripcion(Integer id_incripcion, Integer nota, Integer id_alumno, Integer id_materia) {
        this.id_incripcion = id_incripcion;
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public Integer getId_incripcion() {
        return id_incripcion;
    }

    public void setId_incripcion(Integer id_incripcion) {
        this.id_incripcion = id_incripcion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Integer getId_materia() {
        return id_materia;
    }

    public void setId_materia(Integer id_materia) {
        this.id_materia = id_materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_incripcion=" + id_incripcion + ", nota=" + nota + ", id_alumno=" + id_alumno + ", id_materia=" + id_materia + '}';
    }
    
    
    
}
