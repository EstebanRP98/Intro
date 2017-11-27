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
import paquete.modelo.Inscripcion;
import paquete.vista.VentanaInscripcion;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaInscripcion implements ActionListener{
    private GestionDato gestionDato;
    private VentanaInscripcion ventanaInscripcion;

    public EventoVentanaInscripcion(GestionDato gestionDato, VentanaInscripcion ventanaInscripcion) {
        this.gestionDato = gestionDato;
        this.ventanaInscripcion = ventanaInscripcion;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public VentanaInscripcion getVentanaInscripcion() {
        return ventanaInscripcion;
    }

    public void setVentanaInscripcion(VentanaInscripcion ventanaInscripcion) {
        this.ventanaInscripcion = ventanaInscripcion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x=1;
       if(e.getSource().equals(this.ventanaInscripcion.getBotonList().get(0))){
            try{
            String u=this.ventanaInscripcion.getComboUniversidad().getSelectedItem().toString();
            String c=this.ventanaInscripcion.getComboCarrera().getSelectedItem().toString();
            String a=this.ventanaInscripcion.getComboAspirante().getSelectedItem().toString();
            String f=this.ventanaInscripcion.getTxtList().get(0).getText();
               
            
            Inscripcion inscripcion = new Inscripcion(this.ventanaInscripcion.getGestionDato().buscarUniversidad(u),this.ventanaInscripcion.getGestionDato().buscarCarrera(c),f,this.ventanaInscripcion.getGestionDato().buscarAspirante(a));
            
            if(u.length()==0){
               throw new NullPointerException(); 
            }
             if(c.length()==0){
               throw new NullPointerException(); 
            }
              if(a.length()==0){
               throw new NullPointerException(); 
            }
               if(f.length()==0){
               throw new NullPointerException(); 
            }
            
             boolean retorno=false;
             if(parseInt(this.ventanaInscripcion.getGestionDato().buscarCarrera(c).getCupos())>x){
                 
             for(Inscripcion in:this.getGestionDato().getInscripcionList()){
               
               if(u.equals(in.getUniversidad().getNombre())==true && c.equals(in.getCarrera().getNombre())==true && a.equals(in.getAspirante().getNombre())==true){
                  retorno=true;
                  break;
                   }
               
               }
             }
             else{
                throw new ExcepcionCupo("no hay cupos");  
             }
             if(retorno==true){
            
                throw new TestException("no debe ser repetido");
             }
             else{
                 
            this.gestionDato.addInscripcion(inscripcion);
            x++;
                 System.out.println(x+"add");
             }
            Object[][] datoInscripcion=this.ventanaInscripcion.cargaDatosTabla(this.ventanaInscripcion.getGestionDato().getInscripcionList().size(),4);
            this.ventanaInscripcion.setDatos(datoInscripcion);
            this.ventanaInscripcion.getModeloTabla().setDataVector(this.ventanaInscripcion.getDatos(), this.ventanaInscripcion.getEncabezado());
            }
            catch(TestException te){
             JOptionPane.showMessageDialog(ventanaInscripcion, "No ingresar Aspirantes Repetidos en la misma carrera", "Error", JOptionPane.ERROR_MESSAGE);

            }
            catch(ExcepcionCupo ec){
             JOptionPane.showMessageDialog(ventanaInscripcion, "No haycupos en la carrera", "Error", JOptionPane.ERROR_MESSAGE);

            }
            catch(java.lang.NullPointerException npe){
                JOptionPane.showMessageDialog(ventanaInscripcion, "Ingrese los datos en todas las casillas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource().equals(this.ventanaInscripcion.getBotonList().get(1))){
            this.ventanaInscripcion.getTxtList().get(0).setText("");
            
            
            
        }
    }
    
    
}
