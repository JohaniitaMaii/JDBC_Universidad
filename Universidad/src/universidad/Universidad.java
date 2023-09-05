package universidad;

import java.sql.Date;
import universidad.entidades.Alumno;
import universidad.entidades.Inscripcion;
import universidad.entidades.Materia;
import universidad.servicios.AlumnoService;
import universidad.servicios.InscripcionService;

/**
 *
 * @author johan
 */
public class Universidad {

    /**
     *  String textoLimpio = entrada.replaceAll("[^a-zA-Z0-9 ]", " ");
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      String a = "aaaaaaa", b = "b";
      a.replaceAll("\\w", b);
        System.out.println(a);
        
        
      try{
          AlumnoService as = new AlumnoService();
          as.buscarPorId(1);
          System.out.println("---------------");
          //Alumno a = new Alumno(3, Long.valueOf(39512364), "Juan", "Perez", Date.valueOf("2000-03-14"), true);
          //as.insertarAlumno(a);
          //System.out.println("---------------");
          as.buscarPorId(2);
          System.out.println("---------------");
          as.buscarPorId(3);
          System.out.println("----------");
          Materia aa = new Materia(1, "Lenguaje", 5, 1);
          Materia ab = new Materia(2, "Informatica", 4, 1);
          Materia ac = new Materia(3, "Logica", 3, 1);
          Materia ad = new Materia(4, "Matematica", 2, 1);
          System.out.println("-------------------");
          InscripcionService is = new InscripcionService();
          Inscripcion ia = new Inscripcion(1, 8, 1, 1);
          Inscripcion ib = new Inscripcion(2, 8, 1, 2);
          Inscripcion ic = new Inscripcion(3, 8, 2, 3);
          Inscripcion id = new Inscripcion(4, 8, 2, 4);
          Inscripcion ie = new Inscripcion(5, 8, 3, 3);
          Inscripcion ig = new Inscripcion(6, 8, 3, 2);
          is.insertarInscripcion(ia);
          is.insertarInscripcion(ib);
          is.insertarInscripcion(ic);
          is.insertarInscripcion(id);
          is.insertarInscripcion(ie);
          is.insertarInscripcion(ig);
          System.out.println("------------------");
          is.listarPorMateria("");
      } catch(Exception e){
          e.fillInStackTrace();
          System.out.println(e.getMessage());
      }
       
      // http://190-114-70-58.sanluisctv.com.ar/
        
    }

}
