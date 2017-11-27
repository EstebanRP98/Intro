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
public class Persona {
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String FechaNac;

    public Persona(String nombre, String apellido, String cedula, String FechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.FechaNac = FechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", FechaNac=" + FechaNac + '}';
    }
    
    
    
}
