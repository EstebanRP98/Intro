/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import paquete.vista.VentanaAspirante;
import paquete.vista.VentanaCarrera;
import paquete.vista.VentanaConsultEstu;
import paquete.vista.VentanaConsultUni;
import paquete.vista.VentanaInscripcion;
import paquete.vista.VentanaPrincipal;
import paquete.vista.VentanaUniversidad;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaPrincipal implements ActionListener {
    
    
    private VentanaPrincipal ventanaPrincipal;

    public EventoVentanaPrincipal( VentanaPrincipal ventanaPrincipal) {
      
        this.ventanaPrincipal = ventanaPrincipal;
    }

    

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.ventanaPrincipal.getItemMenuList().get(0))){
            VentanaAspirante v= new VentanaAspirante(this.ventanaPrincipal.getGestionDato());
            v.setVisible(true);
            
            this.ventanaPrincipal.getEscritorio().add(v);
        }
        if(e.getSource().equals(this.ventanaPrincipal.getItemMenuList().get(1))){
            VentanaUniversidad vu=new VentanaUniversidad(this.ventanaPrincipal.getGestionDato());
            vu.setVisible(true);
            
            this.ventanaPrincipal.getEscritorio().add(vu);
        }
         if(e.getSource().equals(this.ventanaPrincipal.getItemMenuList().get(2))){
            VentanaCarrera vc=new VentanaCarrera(this.ventanaPrincipal.getGestionDato());
            vc.setVisible(true);
            
            this.ventanaPrincipal.getEscritorio().add(vc);
        }
         if(e.getSource().equals(this.ventanaPrincipal.getItemMenuList().get(3))){
            VentanaInscripcion vi=new VentanaInscripcion(this.ventanaPrincipal.getGestionDato());
            vi.setVisible(true);
            
            this.ventanaPrincipal.getEscritorio().add(vi);
        }
         if(e.getSource().equals(this.ventanaPrincipal.getItemMenuList().get(4))){
            VentanaConsultEstu vce=new VentanaConsultEstu(this.ventanaPrincipal.getGestionDato());
            vce.setVisible(true);
            
            this.ventanaPrincipal.getEscritorio().add(vce);
        }
         if(e.getSource().equals(this.ventanaPrincipal.getItemMenuList().get(5))){
            VentanaConsultUni vcu=new VentanaConsultUni(this.ventanaPrincipal.getGestionDato());
            vcu.setVisible(true);
            
            this.ventanaPrincipal.getEscritorio().add(vcu);
        }
    }
    
}
