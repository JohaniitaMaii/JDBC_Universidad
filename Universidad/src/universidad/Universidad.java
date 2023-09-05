package universidad;

import universidad.servicios.AlumnoService;

/**
 *
 * @author johan
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      try{
          AlumnoService as = new AlumnoService();
          as.buscarPorId(1);
          System.out.println("---------------");
          
      } catch(Exception e){
          e.fillInStackTrace();
          System.out.println(e.getMessage());
      }
        
        
    }

}
