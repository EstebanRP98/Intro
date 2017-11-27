/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioninscripcion;

import java.util.ArrayList;
import java.util.List;
import paquete.controlador.GestionDato;
import paquete.modelo.Aspirante;
import paquete.modelo.Carrera;
import paquete.modelo.Inscripcion;
import paquete.modelo.Rector;
import paquete.modelo.Universidad;
import paquete.vista.VentanaAspirante;
import paquete.vista.VentanaPrincipal;
import paquete.vista.VentanaRector;

/**
 *
 * @author Estudiante
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Aspirante> a = new ArrayList<Aspirante>();
        List<Inscripcion> i = new ArrayList<Inscripcion>();
        List<Rector> r = new ArrayList<Rector>();
        List<Universidad> u= new ArrayList<Universidad>();
        List<Carrera> c= new ArrayList<Carrera>();
        
        GestionDato gd=new GestionDato(a,u,c,i,r);
        VentanaPrincipal vp = new VentanaPrincipal(gd);
        vp.setVisible(true);
       
    }
    
}
