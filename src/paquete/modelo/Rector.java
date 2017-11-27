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
public class Rector extends Persona{
    private String titulo;
    

    public Rector(String titulo, String nombre, String apellido, String cedula, String FechaNac) {
        super(nombre, apellido, cedula, FechaNac);
        this.titulo = titulo;
       
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

   

    @Override
    public String toString() {
        return super.toString()+"Rector{" + "titulo=" + titulo +  '}';
    }

    
    
    
    
}
