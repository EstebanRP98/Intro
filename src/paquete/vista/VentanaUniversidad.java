/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import paquete.controlador.EventoVentanaUniversidad;
import paquete.controlador.GestionDato;
import paquete.modelo.Rector;
import paquete.modelo.Universidad;


/**
 *
 * @author EstebanRM
 */
public class VentanaUniversidad extends JInternalFrame{
    
    private JPanel panel;
    private JPanel panelCentro;
    private JPanel panelVista;
    private JPanel panelFondo;
    private JPanel panelSup;
    private JPanel panelBotonRector;
    private JPanel panelBotonesInferior;
    private List<JLabel> etiquetaList;
    private List<JButton> botonList;
    private List<JTextField> txtList;
    private JComboBox comboRector;
    private JComboBox nuevoCombo;
    private GestionDato gestionDato;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    
    public VentanaUniversidad(GestionDato gestionDato){
        super("Registro Universidad",true,true,true,true);
        this.gestionDato=gestionDato;
        this.setSize(400, 300);
        this.iniciaComponentes();
        
    }
    public void iniciaComponentes(){
       
        this.comboRector=new JComboBox(this.cargaComboRector());
        
        LayoutManager disenioFondo=new GridLayout(2,1);
        LayoutManager disenioCentro= new GridLayout(3,2);
        LayoutManager disenioBotInf= new GridLayout(1,3);
        LayoutManager disenioBotSup= new FlowLayout(2);
        LayoutManager disenioNota= new GridLayout(1,1);
        
        
        this.panelBotonesInferior=new JPanel(disenioBotInf);
        this.panelBotonRector=new JPanel(disenioBotSup);
        this.panelCentro=new JPanel(disenioCentro);
        this.panelFondo= new JPanel(disenioFondo);
        this.panel= new JPanel(disenioNota);
        this.panelVista= new JPanel(new BorderLayout());
        this.panelSup=   new JPanel(new BorderLayout());
        this.etiquetaList=new ArrayList<JLabel>();
        
        this.etiquetaList.add(new JLabel("Nombre: "));
        this.etiquetaList.add(new JLabel("Ciudad: "));
        this.etiquetaList.add(new JLabel("Rector: "));
        
        
        
        this.txtList=new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        
        
        this.encabezado= new Object[3];               
        this.encabezado[0]="Nombre";
        this.encabezado[1]="Ciudad";
        this.encabezado[2]="Rector";
        
        
        this.modeloTabla= new DefaultTableModel(this.datos,this.encabezado);
        this.tabla =new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
         this.botonList=new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        this.botonList.add(new JButton("Add Rector"));
        this.botonList.add(new JButton("Actualizar"));
        
        this.datos=cargaDatosTabla(this.gestionDato.getUniversidadList().size(),3);
        
        this.modeloTabla= new DefaultTableModel(this.datos,this.encabezado);
        this.tabla =new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
       
        this.panelVista.add(this.scroll, BorderLayout.CENTER);
        
        this.panelCentro.add(this.etiquetaList.get(0));
        this.panelCentro.add(this.txtList.get(0));
        this.panelCentro.add(this.etiquetaList.get(1));
        this.panelCentro.add(this.txtList.get(1));
        this.panelCentro.add(this.etiquetaList.get(2));
        this.panelCentro.add(comboRector);
      
        this.panelBotonesInferior.add(this.botonList.get(0));
        this.panelBotonesInferior.add(this.botonList.get(1));
        this.panelBotonesInferior.add(this.botonList.get(3));
        
        this.botonList.get(0).addActionListener(new EventoVentanaUniversidad(gestionDato,this));
        this.botonList.get(1).addActionListener(new EventoVentanaUniversidad(gestionDato,this));
        this.botonList.get(2).addActionListener(new EventoVentanaUniversidad(gestionDato,this));
        this.botonList.get(3).addActionListener(new EventoVentanaUniversidad(gestionDato,this));
        
       
        this.panelBotonRector.add(this.botonList.get(2));
        this.panelSup.add(this.panelBotonRector,BorderLayout.NORTH);
        this.panelSup.add(this.panelCentro,BorderLayout.CENTER);
        this.panelSup.add(this.panelBotonesInferior,BorderLayout.SOUTH);

        this.panelFondo.add(this.panelSup);
        this.panelFondo.add(this.panelVista);
        
        this.add(this.panelFondo);
        
    }
     public Object[][] cargaDatosTabla(int h, int w)
    {
        Object[][] retorno= new Object[h][w];
        int i=0;
        
        for(Universidad u:this.gestionDato.getUniversidadList())
        {
            retorno[i][0]=u.getNombre();
            retorno[i][1]=u.getCiudad();
            retorno[i][2]=u.getRector().getNombre();
            i++;
        }        
        return retorno;
    }
      public Object[] cargaComboRector()
    {
        
        Object [] combo=new Object[this.gestionDato.getRectorList().size()];
        int i =0;
        for(Rector r: this.gestionDato.getRectorList())
        {
            combo[i]=(r.getNombre());
            
            i++;
        }
       return combo;
    }
      
      public void addcombo(){
          for(Rector r: this.gestionDato.getRectorList()){
          this.comboRector.addItem(r.getNombre());
          }
      }
      
      
            

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanelCentro() {
        return panelCentro;
    }

    public void setPanelCentro(JPanel panelCentro) {
        this.panelCentro = panelCentro;
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

    public JPanel getPanelSup() {
        return panelSup;
    }

    public void setPanelSup(JPanel panelSup) {
        this.panelSup = panelSup;
    }

    public JPanel getPanelBotonRector() {
        return panelBotonRector;
    }

    public void setPanelBotonRector(JPanel panelBotonRector) {
        this.panelBotonRector = panelBotonRector;
    }

    public JPanel getPanelBotonesInferior() {
        return panelBotonesInferior;
    }

    public void setPanelBotonesInferior(JPanel panelBotonesInferior) {
        this.panelBotonesInferior = panelBotonesInferior;
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

    public JComboBox getComboRector() {
        return comboRector;
    }

    public void setComboRector(JComboBox comboRector) {
        this.comboRector = comboRector;
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
