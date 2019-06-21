/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.Control;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import javafx.scene.control.ScrollBar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class Ventana extends JFrame {

    //----Controlador---
    private Control controlador = new Control();

    //-----paneles-----
    //private JScrollPane panelArboles = new JScrollPane();
    private ScrollPane panelArboles = new ScrollPane();
    private JPanel panelBotones = new JPanel();

    //-----Cajas de Texto-----
    JTextField cajaIn = new JTextField("acbegfihd", 10);
    JTextField cajaPre = new JTextField("abcdefghi", 10);
    JTextField cajaPos = new JTextField("cgihfedba", 10);

    //-----Labels-----
    JLabel inOrden = new JLabel("In-Orden");
    JLabel preOrden = new JLabel("Pre-Orden");
    JLabel posOrden = new JLabel("Pos-Orden");

    //-----lienzo-----
    private Lienzo lienzo = new Lienzo();
    
    /*NOTA: JScrollpane y canvas son de librerias diferentes (swin y awt respectivamente) si se trabajan juntos puede
    ocasionar problemas, para esto existen ScrollPane y JComponent (awt y swin repectivamente).
    Lo mejor seria trabajar una sola libreria para no generar problemas; 
    ScrollPane con Canvas y JscrollPane con JComponent
    
    awt trabaja con el sistema operativo
    swin trabaja con java
    */

    public Ventana() {

        //setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        inicializarPaneles();

        getContentPane().add(panelArboles, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void inicializarPaneles() {

        panelArboles.add(lienzo);
        
        
        panelBotones.add(inOrden);
        panelBotones.add(cajaIn);
        panelBotones.add(preOrden);
        panelBotones.add(cajaPre);
        panelBotones.add(posOrden);
        panelBotones.add(cajaPos);

        panelBotones.add(controlador.getPreOrden());
        panelBotones.add(controlador.getPosOrden());

    }

    public JTextField getCajaIn() {
        return cajaIn;
    }

    public JTextField getCajaPre() {
        return cajaPre;
    }

    public JTextField getCajaPos() {
        return cajaPos;
    }

    public Lienzo getLienzo() {
        return lienzo;
    }

}
