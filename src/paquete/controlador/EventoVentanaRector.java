/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import paquete.modelo.Rector;
import paquete.vista.VentanaRector;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaRector implements ActionListener{
    private GestionDato gestionDato;
    private VentanaRector ventanaRector;

    public EventoVentanaRector(GestionDato gestionDato, VentanaRector ventanaRector) {
        this.gestionDato = gestionDato;
        this.ventanaRector = ventanaRector;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public VentanaRector getVentanaRector() {
        return ventanaRector;
    }

    public void setVentanaRector(VentanaRector ventanaRector) {
        this.ventanaRector = ventanaRector;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource().equals(this.ventanaRector.getBotonList().get(0))){
            try{ 
            String n=this.ventanaRector.getTxtList().get(0).getText();
            String a=this.ventanaRector.getTxtList().get(1).getText();
            String c=this.ventanaRector.getTxtList().get(2).getText();
            String fn=this.ventanaRector.getTxtList().get(3).getText();
            String t=this.ventanaRector.getTxtList().get(4).getText();
            
            Rector rector = new Rector(t,n,a,c,fn);
            
             boolean retorno=false;
             for(Rector re:this.getGestionDato().getRectorList()){
               if(c.equals(re.getCedula())==true){
                  retorno=true;
                  break;
                   }
               }
             
            if(retorno==true){
            
                throw new TestException("no debe ser repetido");
             }
             else{ 
            
            this.gestionDato.addRector(rector);
            }
            }
            catch(TestException te){
               JOptionPane.showMessageDialog(ventanaRector, "No ingresar Rectores Repetidos", "Error", JOptionPane.ERROR_MESSAGE);

            }
 
        }
        if (e.getSource().equals(this.ventanaRector.getBotonList().get(1))){
            
            this.ventanaRector.getTxtList().get(0).setText("");
            this.ventanaRector.getTxtList().get(1).setText("");
            this.ventanaRector.getTxtList().get(2).setText("");
            this.ventanaRector.getTxtList().get(3).setText("");
            this.ventanaRector.getTxtList().get(4).setText("");
            
            
        }
        
        
    }
    
    
}
