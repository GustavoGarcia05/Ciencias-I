/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Control;
import Modelo.AVL.ArbolAVL;
import Modelo.RN.ArbolRN;
import Vista.dibujo.DibujoAVL;
import Vista.dibujo.DibujoRN;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Gustavo
 */
public class Ventana extends JFrame {

    //Controlador
    public Control c = new Control(this);

    //Arboles
    private ArbolAVL arbolAVL = new ArbolAVL();
    private ArbolRN arbolRN = new ArbolRN();

    //Dibujo arboles
    private DibujoAVL dibujoAVL = new DibujoAVL();
    private DibujoRN dibujoRN = new DibujoRN();

    //Paneles
    private JPanel panelBotones = new JPanel();

    private JPanel panelCentral = new JPanel();
    private JScrollPane panelAVL = new JScrollPane();
    private JScrollPane panelRN = new JScrollPane();
    private JScrollPane scPane;
    private JScrollPane scPane2;

    //Botones
    private JButton insertar = new JButton("Insertar");
    private JButton retirar = new JButton("Retirar");

    //Cajas de texto
    private JTextField cajaInsertar = new JTextField(5);
    private JTextField cajaRetirar = new JTextField(5);

    public Ventana() {
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        arbolRN.inicializar();
        inicializar();

        setVisible(true);
    }

    private void inicializar() {
        Container cont = getContentPane();
        cont.setLayout(null);
        setTitle("Arboles avl y rojinegro");
        
        insertar.addActionListener(c);
        retirar.addActionListener(c);

        panelBotones.setBackground(Color.white);
        panelBotones.add(insertar);
        panelBotones.add(retirar);
        panelBotones.add(cajaRetirar);
        cont.add(panelBotones);
        panelBotones.setBounds(50, 15, 300, 50);
        //panel Central
        panelCentral.setLayout(new GridLayout(2, 1));
        scPane = new JScrollPane(panelAVL, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scPane2 = new JScrollPane(panelRN, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelAVL.setPreferredSize(new Dimension(5000, 500));
        panelRN.setPreferredSize(new Dimension(5000, 500));
        panelCentral.add(scPane);
        panelCentral.add(scPane2);
        cont.add(panelCentral);
        panelCentral.setBounds(0, 100, 1920, 900);
    }

    public JScrollPane getPanelAVL() {
        return panelAVL;
    }

    public JScrollPane getPanelRN() {
        return panelRN;
    }

    public JButton getInsertar() {
        return insertar;
    }

    public JButton getRetirar() {
        return retirar;
    }

    public JTextField getCajaInsertar() {
        return cajaInsertar;
    }

    public JTextField getCajaRetirar() {
        return cajaRetirar;
    }

    public ArbolAVL getArbolAVL() {
        return arbolAVL;
    }

    public DibujoAVL getDibujoAVL() {
        return dibujoAVL;
    }

    public ArbolRN getArbolRN() {
        return arbolRN;
    }

    public DibujoRN getDibujoRN() {
        return dibujoRN;
    }
}
