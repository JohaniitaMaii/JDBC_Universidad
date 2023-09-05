/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad.entidades;

/**
 *
 * @author cisco
 */
public class Materia {
    private Integer idMateria, año, estado;
    private String nombre;

    public Materia(Integer idMateria, String nombre, Integer año, Integer estado) {
        this.idMateria = idMateria;
        this.año = año;
        this.estado = estado;
        this.nombre = nombre;
    }

    public Materia( String nombre, Integer año, Integer estado) {
        this.año = año;
        this.estado = estado;
        this.nombre = nombre;
    }

    
    
    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String Stringify() {
        return (
                "{\n"+
               "\t'id' : " + this.idMateria + ",\n"+
               "\t'nombre' : '" + this.nombre + "',\n"+
               "\t'año': " + this.año + ",\n"+
               "\t'estado': " + this.estado+ "\n}"
        );
    }
    
    
}
