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
import paquete.controlador.EventoVentanaInscripcion;
import paquete.controlador.GestionDato;
import paquete.modelo.Aspirante;
import paquete.modelo.Carrera;
import paquete.modelo.Inscripcion;
import paquete.modelo.Universidad;

/**
 *
 * @author EstebanRM
 */
public class VentanaInscripcion extends JInternalFrame{
      private JPanel panel;
    private JPanel panelVista;
    private JPanel panelFondo;
    private List<JLabel> etiquetaList;
    private List<JButton> botonList;
    private List<JTextField> txtList;
    private JComboBox comboUniversidad;
    private JComboBox comboCarrera;
    private JComboBox comboAspirante;
    private GestionDato gestionDato;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;

    public VentanaInscripcion(GestionDato gestionDato) {
        super("Inscripcion",true,true,true,true);
        this.setSize(400,300);
        this.gestionDato=gestionDato;
        this.setVisible(true);
        this.iniciaComponente();
        
    }
    public void iniciaComponente() {
        LayoutManager disenioFondo=new GridLayout(2,1);
        LayoutManager disenio= new GridLayout(5,2);
        
        this.panel=new JPanel(disenio);
        this.panelFondo= new JPanel(disenioFondo);
        this.panelVista= new JPanel(new BorderLayout());
        this.etiquetaList=new ArrayList<JLabel>();
        
        this.etiquetaList.add(new JLabel("Universidad: "));
        this.etiquetaList.add(new JLabel("Carrera: "));
        this.etiquetaList.add(new JLabel("Aspirante: "));
        this.etiquetaList.add(new JLabel("Fecha: "));
        
        this.txtList=new ArrayList<JTextField>();
        this.txtList.add(new JTextField(15));
        
        this.comboUniversidad=new JComboBox(this.cargaComboUniversidad());
        this.comboCarrera=new JComboBox(this.cargaComboCarrera());
        this.comboAspirante=new JComboBox(this.cargaComboAspirante());
        
        this.encabezado= new Object[4];               
        this.encabezado[0]="Universidad";
        this.encabezado[1]="Carrera";
        this.encabezado[2]="Aspirante";
        this.encabezado[3]="Fecha";
        
        
       
        this.datos=cargaDatosTabla(this.gestionDato.getInscripcionList().size(),4);
        
        this.modeloTabla= new DefaultTableModel(this.datos,this.encabezado);
        this.tabla =new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
                
        
        this.botonList=new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        this.panel.add(etiquetaList.get(0));
        this.panel.add(this.comboUniversidad);
        this.panel.add(etiquetaList.get(1));
        this.panel.add(this.comboCarrera);
        this.panel.add(etiquetaList.get(2));
        this.panel.add(this.comboAspirante);
        this.panel.add(etiquetaList.get(3));
        this.panel.add(txtList.get(0));

        this.botonList.get(0).addActionListener(new EventoVentanaInscripcion(gestionDato,this));
        this.botonList.get(1).addActionListener(new EventoVentanaInscripcion(gestionDato,this));
        
        this.panelVista.add(this.scroll, BorderLayout.CENTER);
       
        this.panel.add(botonList.get(0));
        this.panel.add(botonList.get(1));
        this.panelFondo.add(this.panel);
        this.panelFondo.add(this.panelVista);
        
        this.add(this.panelFondo);
    }
     public Object[] cargaComboUniversidad()
    {
        
        Object [] combo=new Object[this.gestionDato.getUniversidadList().size()];
        int i =0;
        for(Universidad U: this.gestionDato.getUniversidadList())
        {
            combo[i]=(U.getNombre());
            i++;
        }
       return combo;
    }

     public Object[] cargaComboCarrera()
    {
        
        Object [] combo=new Object[this.gestionDato.getCarreraList().size()];
        int i =0;
       for(Carrera C: this.gestionDato.getCarreraList())
        {
            combo[i]=C.getNombre();
            i++;
        }
       return combo;
    }
      public Object[] cargaComboAspirante()
    {
        
        Object [] combo=new Object[this.gestionDato.getAspiranteList().size()];
        int i =0;
        for(Aspirante  A: this.gestionDato.getAspiranteList())
        {
            combo[i]=(A.getNombre());
            i++;
        }
       return combo;
    }
    public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;    
        for(Inscripcion I:this.gestionDato.getInscripcionList())
        {
            retorno[i][0]=I.getUniversidad().getNombre();
            retorno[i][1]=I.getCarrera().getNombre();
            retorno[i][2]=I.getAspirante().getNombre();
            retorno[i][3]=I.getFecha();
            
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

    public JComboBox getComboUniversidad() {
        return comboUniversidad;
    }

    public void setComboUniversidad(JComboBox comboUniversidad) {
        this.comboUniversidad = comboUniversidad;
    }

    public JComboBox getComboCarrera() {
        return comboCarrera;
    }

    public void setComboCarrera(JComboBox comboCarrera) {
        this.comboCarrera = comboCarrera;
    }

    public JComboBox getComboAspirante() {
        return comboAspirante;
    }

    public void setComboAspirante(JComboBox comboAspirante) {
        this.comboAspirante = comboAspirante;
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
