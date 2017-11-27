/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import paquete.controlador.EventoVentanaRector;
import paquete.controlador.GestionDato;

/**
 *
 * @author Estudiante
 */
public class VentanaRector extends JFrame{
     private JPanel panel;
    private JPanel panelFondo;
    private List<JLabel> etiquetaList;
    private List<JButton> botonList;
    private List<JTextField> txtList;
    private JComboBox combo;
    private GestionDato gestionDato;

    public VentanaRector(GestionDato gestionDato) {
        super("Registro de Rector");
        this.gestionDato=gestionDato;
        this.setSize(400, 300);
        this.setVisible(true);
        this.iniciaComponentes();
    }
    
    public void iniciaComponentes(){
         
        LayoutManager disenio = new GridLayout(6,2);
        
        this.panel=new JPanel(disenio);
       
       
        
        this.etiquetaList=new ArrayList<JLabel>();
        this.etiquetaList.add(new JLabel("Nombre:"));
        this.etiquetaList.add(new JLabel("Apellido:"));
        this.etiquetaList.add(new JLabel("Cedula:"));
        this.etiquetaList.add(new JLabel("Fecha Nacimiento:"));
        this.etiquetaList.add(new JLabel("Titulo:"));
        
        this.txtList=new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        
        this.botonList=new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar "));
        this.botonList.add(new JButton("Limpiar "));
        
        for(int i =0;i<5;i++){
            this.panel.add(this.etiquetaList.get(i));
            this.panel.add(this.txtList.get(i));
        }
        
       this.botonList.get(0).addActionListener(new EventoVentanaRector(gestionDato,this));
       this.botonList.get(1).addActionListener(new EventoVentanaRector(gestionDato,this));
       
        this.panel.add(this.botonList.get(0));
        this.panel.add(this.botonList.get(1));
       
        this.add(this.panel);
        
        
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanelFondo() {
        return panelFondo;
    }

    public void setPanelFondo(JPanel panelFondo) {
        this.panelFondo = panelFondo;
    }

    public List<JLabel> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<JLabel> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }
    
    
    
}
