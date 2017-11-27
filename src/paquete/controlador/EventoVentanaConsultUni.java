/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import paquete.modelo.Inscripcion;
import paquete.vista.VentanaConsultUni;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaConsultUni implements ActionListener{
    private GestionDato gestionDato;
    private VentanaConsultUni ventanaConsultUni;

    public EventoVentanaConsultUni(GestionDato gestionDato, VentanaConsultUni ventanaConsultUni) {
        this.gestionDato = gestionDato;
        this.ventanaConsultUni = ventanaConsultUni;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public VentanaConsultUni getVentanaConsultUni() {
        return ventanaConsultUni;
    }

    public void setVentanaConsultUni(VentanaConsultUni ventanaConsultUni) {
        this.ventanaConsultUni = ventanaConsultUni;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.ventanaConsultUni.getBotonList().get(0))){
           try{ 
            String n = this.ventanaConsultUni.getTxtList().get(0).getText();
            String a = this.ventanaConsultUni.getTxtList().get(1).getText();
            
             if(n.length()==0){
               throw new NullPointerException(); 
            }
             if(a.length()==0){
               throw new NullPointerException(); 
            }
             
            int contpos=0;
            
            ArrayList<Integer> posiciones=new ArrayList<Integer>();
            for(Inscripcion i: this.ventanaConsultUni.getGestionDato().getInscripcionList()){
               
                if(n.equals(i.getAspirante().getNombre())==true && a.equals(i.getAspirante().getApellido())==true){
                    
                    posiciones.add(contpos);
                }
                contpos++;
            }
            
            
            Object[][] datoInscripcion=this.ventanaConsultUni.cargaDatosTabla(posiciones);
            this.ventanaConsultUni.setDatos(datoInscripcion);
            this.ventanaConsultUni.getModeloTabla().setDataVector(this.ventanaConsultUni.getDatos(), this.ventanaConsultUni.getEncabezado());
           }
           catch(java.lang.NullPointerException npe){
                JOptionPane.showMessageDialog(ventanaConsultUni, "Ingrese los datos en todas las casillas", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    
    
}


