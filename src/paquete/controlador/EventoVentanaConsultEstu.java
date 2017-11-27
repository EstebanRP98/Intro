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
import paquete.vista.VentanaConsultEstu;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaConsultEstu implements ActionListener{
    private GestionDato gestionDato;
    private VentanaConsultEstu ventanaConsultEstu;

    public EventoVentanaConsultEstu(GestionDato gestionDato, VentanaConsultEstu ventanaConsultEstu) {
        this.gestionDato = gestionDato;
        this.ventanaConsultEstu = ventanaConsultEstu;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public VentanaConsultEstu getVentanaConsultEstu() {
        return ventanaConsultEstu;
    }

    public void setVentanaConsultEstu(VentanaConsultEstu ventanaConsultEstu) {
        this.ventanaConsultEstu = ventanaConsultEstu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.ventanaConsultEstu.getBotonList().get(0))){
            try{
            String u=this.ventanaConsultEstu.getComboUniversidad().getSelectedItem().toString();
            String c=this.ventanaConsultEstu.getComboCarrera().getSelectedItem().toString();
            
            if(u.length()==0){
               throw new NullPointerException(); 
            }
             if(c.length()==0){
               throw new NullPointerException(); 
            }
            
            int cont=0;
            ArrayList<Integer> posiciones = new ArrayList<Integer>();
            for(Inscripcion i: this.ventanaConsultEstu.getGestionDato().getInscripcionList()){
                if(u.equals(i.getUniversidad().getNombre())==true && c.equals(i.getCarrera().getNombre())==true){
                    posiciones.add(cont);
                }
                cont++;
            }
            
            Object[][] datoInscripcion=this.ventanaConsultEstu.cargaDatosTabla(posiciones);
            this.ventanaConsultEstu.setDatos(datoInscripcion);
            this.ventanaConsultEstu.getModeloTabla().setDataVector(this.ventanaConsultEstu.getDatos(), this.ventanaConsultEstu.getEncabezado());
            }
            catch(java.lang.NullPointerException npe){
                JOptionPane.showMessageDialog(ventanaConsultEstu, "Ingrese los datos en todas las casillas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    
}
}