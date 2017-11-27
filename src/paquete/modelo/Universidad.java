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
public class Universidad {
    private String nombre;
    private String ciudad;
    private Rector rector;

    public Universidad(String nombre, String ciudad, Rector rector) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.rector = rector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Rector getRector() {
        return rector;
    }

    public void setRector(Rector rector) {
        this.rector = rector;
    }

    @Override
    public String toString() {
        return "Universidad{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", rector=" + rector + '}';
    }
    
    
    
}
