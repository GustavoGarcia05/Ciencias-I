/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.sun.glass.ui.Cursor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Gustavo
 */
public class Ventana extends JFrame {

    JPanel panelPrincipal = new JPanel();
    JPanel panelBotones = new JPanel();
    JButton inOrden = new JButton("In-Order");

    public Ventana() {
        setExtendedState(MAXIMIZED_BOTH);
        System.out.println("altura ventana"+getHeight());
        inicializarLayout();
        setMinimumSize(new Dimension(800, 600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void inicializarLayout() {
        inicializarPaneles();
        JScrollPane panel= new JScrollPane(panelPrincipal);
        panel.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        
        add(panelBotones,BorderLayout.SOUTH);
        

    }

    private void inicializarPaneles() {
        panelPrincipal.setSize(4000, 2000);
        panelPrincipal.setBackground(Color.DARK_GRAY);
        
        panelBotones.setBackground(Color.orange);
        panelBotones.add(inOrden);
    }

}
