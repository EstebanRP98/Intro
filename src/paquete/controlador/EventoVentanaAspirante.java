/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import paquete.modelo.Aspirante;
import paquete.vista.VentanaAspirante;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaAspirante implements ActionListener{
    private GestionDato gestionDato;
    private VentanaAspirante ventanaAspirante;

    public EventoVentanaAspirante(GestionDato gestionDato, VentanaAspirante ventanaAspirante) {
        this.gestionDato = gestionDato;
        this.ventanaAspirante = ventanaAspirante;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public VentanaAspirante getVentanaAspirante() {
        return ventanaAspirante;
    }

    public void setVentanaAspirante(VentanaAspirante ventanaAspirante) {
        this.ventanaAspirante = ventanaAspirante;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         
         if(e.getSource().equals(this.ventanaAspirante.getBotonList().get(0))){
             try{
            String n=this.ventanaAspirante.getTxtList().get(0).getText();
            String a=this.ventanaAspirante.getTxtList().get(1).getText();
            String c=this.ventanaAspirante.getTxtList().get(2).getText();
            String fn=this.ventanaAspirante.getTxtList().get(3).getText();
            String t=this.ventanaAspirante.getTxtList().get(4).getText();
 
            Aspirante aspirante = new Aspirante(t,n,a,c,fn);
                 
            if(n.length()==0){
               throw new NullPointerException(); 
            }
             if(a.length()==0){
               throw new NullPointerException(); 
            }
              if(c.length()==0){
               throw new NullPointerException(); 
            }
               if(fn.length()==0){
               throw new NullPointerException(); 
            }
               if(t.length()==0){
               throw new NullPointerException(); 
            }
             boolean retorno=false;
             for(Aspirante as:this.getGestionDato().getAspiranteList()){
               if(c.equals(as.getCedula())==true ){
                  retorno=true;
                  break;
                   }
               }
          
             if(retorno==true){
            
                throw new TestException("no debe ser repetido");
             }
             else{
            this.ventanaAspirante.getGestionDato().addAspirante(aspirante);
           
             }
            Object[][] datoAspirante=this.ventanaAspirante.cargaDatosTabla(this.ventanaAspirante.getGestionDato().getAspiranteList().size(),5);
            this.ventanaAspirante.setDatos(datoAspirante);
            this.ventanaAspirante.getModeloTabla().setDataVector(this.ventanaAspirante.getDatos(), this.ventanaAspirante.getEncabezado());
            
             }
            catch(TestException te){
                JOptionPane.showMessageDialog(ventanaAspirante, "No ingresar Aspirantes Repetidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(java.lang.NullPointerException npe){
                JOptionPane.showMessageDialog(ventanaAspirante, "Ingrese los datos en todas las casillas", "Error", JOptionPane.ERROR_MESSAGE);
            }
              
         }
        
        
       
         
         
          if (e.getSource().equals(this.ventanaAspirante.getBotonList().get(1))){
            this.ventanaAspirante.getTxtList().get(0).setText("");
            this.ventanaAspirante.getTxtList().get(1).setText("");
            this.ventanaAspirante.getTxtList().get(2).setText("");
            this.ventanaAspirante.getTxtList().get(3).setText("");
            this.ventanaAspirante.getTxtList().get(4).setText("");
            
            
        }
        
        
       
        
        
        
    }
    
    


    
}
