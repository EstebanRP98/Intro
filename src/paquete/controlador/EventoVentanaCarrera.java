/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import paquete.modelo.Carrera;
import paquete.vista.VentanaCarrera;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaCarrera implements ActionListener{
     private GestionDato gestionDato;
     private VentanaCarrera ventanaCarrera;

    public EventoVentanaCarrera(GestionDato gestionDato, VentanaCarrera ventanaCarrera) {
        this.gestionDato = gestionDato;
        this.ventanaCarrera = ventanaCarrera;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public VentanaCarrera getVentanaCarrera() {
        return ventanaCarrera;
    }

    public void setVentanaCarrera(VentanaCarrera ventanaCarrera) {
        this.ventanaCarrera = ventanaCarrera;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.ventanaCarrera.getBotonList().get(0))){
            try{
            String n=this.ventanaCarrera.getTxtList().get(0).getText();
            String u=this.ventanaCarrera.getComboUniversidad().getSelectedItem().toString();
            String c=this.ventanaCarrera.getTxtList().get(1).getText();
                    
            
            Carrera carrera = new Carrera(n ,this.ventanaCarrera.getGestionDato().buscarUniversidad(u),c);
            
            if(n.length()==0){
               throw new NullPointerException(); 
            }
             if(u.length()==0){
               throw new NullPointerException(); 
            }
             if(c.length()==0){
               throw new NullPointerException(); 
            }
              
            boolean retorno=false;
             for(Carrera ca:this.getGestionDato().getCarreraList()){
               if(n.equals(ca.getNombre())==true && u.equals(ca.getUniversidad().getNombre())){
                  retorno=true;
                  break;
                   }
              
               }
          
             if(retorno==true){
            
                throw new TestException("no debe ser repetido");
             }
             else{
            this.gestionDato.addCarrera(carrera);
             }
            Object[][] datoCarrera=this.ventanaCarrera.cargaDatosTabla(this.ventanaCarrera.getGestionDato().getCarreraList().size(),3);
            this.ventanaCarrera.setDatos(datoCarrera);
            this.ventanaCarrera.getModeloTabla().setDataVector(this.ventanaCarrera.getDatos(), this.ventanaCarrera.getEncabezado());
            }
             catch(TestException te){
                JOptionPane.showMessageDialog(ventanaCarrera, "No ingresar Carreras Repetidas en la misma Universidad", "Error", JOptionPane.ERROR_MESSAGE);
            }
             catch( java.lang.NullPointerException np){
               JOptionPane.showMessageDialog(ventanaCarrera, "Ingrese los datos en todas las casillas", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource().equals(this.ventanaCarrera.getBotonList().get(1))){
            this.ventanaCarrera.getTxtList().get(0).setText("");
            
           
            
            
        }
    }

     
}
