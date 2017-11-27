/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import paquete.modelo.Universidad;
import paquete.vista.VentanaPrincipal;
import paquete.vista.VentanaRector;
import paquete.vista.VentanaUniversidad;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaUniversidad implements ActionListener{
    private GestionDato gestionDato;
    private VentanaUniversidad ventanaUniversidad;
    private VentanaPrincipal ventanaPrincipal;

    public EventoVentanaUniversidad(GestionDato gestionDato, VentanaUniversidad ventanaUniversidad) {
        this.gestionDato = gestionDato;
        this.ventanaUniversidad = ventanaUniversidad;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }


    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public VentanaUniversidad getVentanaUniversidad() {
        return ventanaUniversidad;
    }

    public void setVentanaUniversidad(VentanaUniversidad ventanaUniversidad) {
        this.ventanaUniversidad = ventanaUniversidad;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.ventanaUniversidad.getBotonList().get(0))){
            try{
            String n=this.ventanaUniversidad.getTxtList().get(0).getText();
            String c=this.ventanaUniversidad.getTxtList().get(1).getText();
            String r=this.ventanaUniversidad.getComboRector().getSelectedItem().toString();
           
            
            Universidad universidad = new Universidad(n,c,this.ventanaUniversidad.getGestionDato().buscarRector(r));
            
             boolean retorno=false;
             for(Universidad u:this.getGestionDato().getUniversidadList()){
               if(n.equals(u.getNombre())==true){
                  retorno=true;
                  break;
                   }
               }
          
             if(retorno==true){
            
                throw new TestException("no debe ser repetido");
             }
             else{
            
            this.gestionDato.addUniversidad(universidad);
             }
            Object[][] datoUniversidad=this.ventanaUniversidad.cargaDatosTabla(this.ventanaUniversidad.getGestionDato().getUniversidadList().size(),3);
            this.ventanaUniversidad.setDatos(datoUniversidad);
            this.ventanaUniversidad.getModeloTabla().setDataVector(this.ventanaUniversidad.getDatos(), this.ventanaUniversidad.getEncabezado());
            }
            catch(TestException te){
                 JOptionPane.showMessageDialog(ventanaUniversidad, "No ingresar Universidades Repetidas", "Error", JOptionPane.ERROR_MESSAGE);

            }
             catch( java.lang.NullPointerException np){
                JOptionPane.showMessageDialog(ventanaUniversidad, "Ingrese los datos en cada casillero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource().equals(this.ventanaUniversidad.getBotonList().get(1))){
           this.ventanaUniversidad.getTxtList().get(0).setText("");
           this.ventanaUniversidad.getTxtList().get(1).setText("");
           
   
        }
         if (e.getSource().equals(this.ventanaUniversidad.getBotonList().get(2))){
           VentanaRector v=new VentanaRector(this.ventanaUniversidad.getGestionDato());
           v.setVisible(true);  
        }
         
         if (e.getSource().equals(this.ventanaUniversidad.getBotonList().get(3))){
             System.out.println("Actualiza");
             
             this.ventanaUniversidad.addcombo();
             
          
           
           
        }
         
    }
    
    
    
}
