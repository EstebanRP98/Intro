/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import paquete.controlador.EventoVentanaPrincipal;
import paquete.controlador.GestionDato;

/**
 *
 * @author Estudiante
 */
public class VentanaPrincipal extends JFrame{
    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu menu4;
    private JMenu menu5;
    private JMenu menu6;
    private List<JMenuItem> itemMenuList;
    private GestionDato gestionDato;

    public VentanaPrincipal(GestionDato gestionDato) {
        super("Gestion Inscripcion");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(3);
        this.gestionDato=gestionDato;
        this.setVisible(true);
        this.iniciaComponentes();
    }
    
    public void iniciaComponentes(){
        this.escritorio= new JDesktopPane();
        this.barraMenu= new JMenuBar();
        this.menu1= new JMenu("Registro de Persona");
        this.menu2= new JMenu("Registro de Universidad");
        this.menu3= new JMenu("Registro de Carrera");
        this.menu4= new JMenu("Inscripcion");
        this.menu5= new JMenu("Consulta Universidad");
        this.menu6= new JMenu("Consulta Carrera");
        this.itemMenuList= new ArrayList<JMenuItem>();
        this.itemMenuList.add(new JMenuItem("Registrar Persona"));
        this.itemMenuList.add(new JMenuItem("Registrar Universidad"));
        this.itemMenuList.add(new JMenuItem("Registrar Carrera"));
        this.itemMenuList.add(new JMenuItem("Registrar Inscripcion"));
        this.itemMenuList.add(new JMenuItem("consulta listado de Estudiantes"));
        this.itemMenuList.add(new JMenuItem("Registrar Carreras Estudiante"));
        
        this.setContentPane(this.escritorio);
        this.setJMenuBar(barraMenu);
        this.barraMenu.add(menu1);
        this.barraMenu.add(menu2);
        this.barraMenu.add(menu3);
        this.barraMenu.add(menu4);
        this.barraMenu.add(menu5);
        this.barraMenu.add(menu6);
        this.menu1.add(this.itemMenuList.get(0));
        this.menu2.add(this.itemMenuList.get(1));
        this.menu3.add(this.itemMenuList.get(2));
        this.menu4.add(this.itemMenuList.get(3));
        this.menu5.add(this.itemMenuList.get(4));
        this.menu6.add(this.itemMenuList.get(5));
        
        this.itemMenuList.get(0).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(1).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(2).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(3).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(4).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(5).addActionListener(new EventoVentanaPrincipal(this));
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public JMenu getMenu1() {
        return menu1;
    }

    public void setMenu1(JMenu menu1) {
        this.menu1 = menu1;
    }

    public JMenu getMenu2() {
        return menu2;
    }

    public void setMenu2(JMenu menu2) {
        this.menu2 = menu2;
    }

    public JMenu getMenu3() {
        return menu3;
    }

    public void setMenu3(JMenu menu3) {
        this.menu3 = menu3;
    }

    public JMenu getMenu4() {
        return menu4;
    }

    public void setMenu4(JMenu menu4) {
        this.menu4 = menu4;
    }

    public JMenu getMenu5() {
        return menu5;
    }

    public void setMenu5(JMenu menu5) {
        this.menu5 = menu5;
    }

    public JMenu getMenu6() {
        return menu6;
    }

    public void setMenu6(JMenu menu6) {
        this.menu6 = menu6;
    }

    public List<JMenuItem> getItemMenuList() {
        return itemMenuList;
    }

    public void setItemMenuList(List<JMenuItem> itemMenuList) {
        this.itemMenuList = itemMenuList;
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }
    
    
}
