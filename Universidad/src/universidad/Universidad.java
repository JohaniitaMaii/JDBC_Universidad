package universidad;

import java.sql.Date;
import universidad.entidades.Alumno;
import universidad.servicios.AlumnoService;

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
      } catch(Exception e){
          e.fillInStackTrace();
          System.out.println(e.getMessage());
      }
       
      // http://190-114-70-58.sanluisctv.com.ar/
        
    }

}
