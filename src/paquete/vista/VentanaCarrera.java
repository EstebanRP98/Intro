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
import paquete.controlador.EventoVentanaCarrera;
import paquete.controlador.GestionDato;
import paquete.modelo.Carrera;
import paquete.modelo.Universidad;

/**
 *
 * @author EstebanRM
 */
public class VentanaCarrera extends JInternalFrame {
    private JPanel panel;
    private JPanel panelVista;
    private JPanel panelFondo;
    private List<JLabel> etiquetaList;
    private List<JButton> botonList;
    private List<JTextField> txtList;
    private JComboBox comboUniversidad;
    private GestionDato gestionDato;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;

    public VentanaCarrera(GestionDato gestionDato) {
        super("Inscripcion Carrera",true,true,true,true);
        this.gestionDato=gestionDato;
        this.setSize(400, 300);
        this.setVisible(true);
        this.iniciaComponente();
    }
    
     public void iniciaComponente() {
        LayoutManager disenioFondo=new GridLayout(2,1);
        LayoutManager disenio= new GridLayout(4,2);
       
        this.panel=new JPanel(disenio);
        this.panelFondo= new JPanel(disenioFondo);
        this.panelVista= new JPanel(new BorderLayout());
        this.etiquetaList=new ArrayList<JLabel>();
        this.etiquetaList.add(new JLabel("Nombre: "));
        this.etiquetaList.add(new JLabel("Universidad: "));
        this.etiquetaList.add(new JLabel("Cupos disponibles: "));
        
        this.comboUniversidad=new JComboBox(this.cargaComboUniversidad());
        
        
        this.txtList=new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
       
       
        
       
        
        this.encabezado= new Object[3];               
        this.encabezado[0]="Nombre";
        this.encabezado[1]="Universidad";
        this.encabezado[2]="Cupos";
        
       
        this.datos=cargaDatosTabla(this.gestionDato.getCarreraList().size(),3);
        
        this.modeloTabla= new DefaultTableModel(this.datos,this.encabezado);
        this.tabla =new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
                
        
        this.botonList=new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        
        this.panel.add(etiquetaList.get(0));
        this.panel.add(txtList.get(0));
        this.panel.add(etiquetaList.get(1));
        this.panel.add(this.comboUniversidad);
        this.panel.add(etiquetaList.get(2));
        this.panel.add(txtList.get(1));

        this.botonList.get(0).addActionListener(new EventoVentanaCarrera(gestionDato,this));
        this.botonList.get(1).addActionListener(new EventoVentanaCarrera(gestionDato,this));
        
        this.panelVista.add(this.scroll, BorderLayout.CENTER);
       
        this.panel.add(botonList.get(0));
        this.panel.add(botonList.get(1));
        this.panelFondo.add(this.panel);
        this.panelFondo.add(this.panelVista);
        
        this.add(this.panelFondo);
    }
     public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        for(Carrera c:this.gestionDato.getCarreraList())
        {
            retorno[i][0]=c.getNombre();
            retorno[i][1]=c.getUniversidad().getNombre();
            retorno[i][2]=c.getCupos();
            i++;
        }        
        return retorno;
    }
    public Object[] cargaComboUniversidad()
    {
        
        Object [] combo=new Object[this.gestionDato.getUniversidadList().size()];
        int i =0;
        for(Universidad u: this.gestionDato.getUniversidadList())
        {
            combo[i]=u.getNombre();
            i++;
        }
       return combo;
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

    public JComboBox getComboUniversidad() {
        return comboUniversidad;
    }

    public void setComboUniversidad(JComboBox comboUniversidad) {
        this.comboUniversidad = comboUniversidad;
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
