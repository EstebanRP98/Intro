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
public class Inscripcion {
    private Universidad universidad;
    private Carrera carrera;
    private String fecha;
    private Aspirante aspirante;
    
    public Inscripcion(Universidad universidad, Carrera carrera, String fecha, Aspirante aspirante) {
        this.universidad = universidad;
        this.carrera = carrera;
        this.fecha = fecha;
        this.aspirante = aspirante;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "universidad=" + universidad + ", carrera=" + carrera + ", fecha=" + fecha + ", aspirante=" + aspirante + '}';
    }

   
    
}
