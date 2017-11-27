/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.modelo;

/**
 *
 * @author Estudiante
 */
public class Carrera {
    private String nombre;
    private Universidad universidad;
    private String cupos;

    public Carrera(String nombre, Universidad universidad, String cupos) {
        this.nombre = nombre;
        this.universidad = universidad;
        this.cupos = cupos;
    }

    public String getCupos() {
        return cupos;
    }

    public void setCupos(String cupos) {
        this.cupos = cupos;
    }

 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", universidad=" + universidad + ", cupos=" + cupos + '}';
    }

    
    
    
}
