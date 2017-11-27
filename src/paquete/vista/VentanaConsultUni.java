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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import paquete.controlador.EventoVentanaConsultUni;
import paquete.controlador.GestionDato;
import paquete.modelo.Aspirante;
import paquete.modelo.Inscripcion;

/**
 *
 * @author EstebanRM
 */
public class VentanaConsultUni extends JInternalFrame{
     private JPanel panel;
    private JPanel panelVista;
    private JPanel panelFondo;
    private List<JLabel> etiquetaList;
    private List<JButton> botonList;
    private List<JTextField> txtList;
    private GestionDato gestionDato;
    private List<Integer> posiciones;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;

    public VentanaConsultUni(GestionDato gestionDato) {
        super("Consulta Carrera",true,true,true,true);
        this.gestionDato=gestionDato;
        this.setSize(400, 300);
        this.setVisible(true);
        this.iniciaComponente();
    }
    
     public void iniciaComponente() {
        LayoutManager disenioFondo=new GridLayout(2,1);
        LayoutManager disenio= new GridLayout(3,2);
       
        this.posiciones=new ArrayList<Integer>();
        
        this.panel=new JPanel(disenio);
        this.panelFondo= new JPanel(disenioFondo);
        this.panelVista= new JPanel(new BorderLayout());
        this.etiquetaList=new ArrayList<JLabel>();
        
        this.etiquetaList.add(new JLabel("Nombre: "));
        this.etiquetaList.add(new JLabel("Apellido: "));
        this.etiquetaList.add(new JLabel());
        
        this.txtList=new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
      
        
        this.encabezado= new Object[2];               
        this.encabezado[0]="Carrera";
        this.encabezado[1]="Fecha";
        
        
        
        
        this.datos=cargaDatosTabla((ArrayList<Integer>) this.posiciones);
        
        this.modeloTabla= new DefaultTableModel(this.datos,this.encabezado);
        this.tabla =new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
                
        
        this.botonList=new ArrayList<JButton>();
        this.botonList.add(new JButton("Consultar"));
       
        
        this.panel.add(etiquetaList.get(0));
        this.panel.add(txtList.get(0));
        
        this.panel.add(etiquetaList.get(1));
        this.panel.add(txtList.get(1));
      

        this.botonList.get(0).addActionListener(new EventoVentanaConsultUni(gestionDato,this));
        
        
        this.panelVista.add(this.scroll, BorderLayout.CENTER);
        this.panel.add(this.etiquetaList.get(2));
        this.panel.add(botonList.get(0));
       
        this.panelFondo.add(this.panel);
        this.panelFondo.add(this.panelVista);
        
        this.add(this.panelFondo);
    }
    public Object[][] cargaDatosTabla(ArrayList<Integer> posiciones)
    {
        Object[][] retorno= new Object[posiciones.size()][2];
        int i=0;
        int add=0;
        for(Inscripcion I:this.gestionDato.getInscripcionList()){
            for(int k=0;k<posiciones.size();k++){
                if(i==posiciones.get(k)){
            retorno[add][0]=I.getCarrera().getNombre();
            retorno[add][1]=I.getFecha();
            add++;
            }
            }
            i++;
        }
            
                
        return retorno;
    }
    

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanelVista() {
        return panelVista;
    }

    public void setPanelVista(JPanel panelVista) {
        this.panelVista = panelVista;
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

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    
}
