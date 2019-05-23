/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo_2
 */
public class VentanaManual extends JFrame {

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    //------------- botones-----------
    JButton insertar = new JButton("Insertar");
    JButton remover = new JButton("Remover");
    JButton buscar = new JButton("Buscar");
    JButton dibujar = new JButton("Dibujar");

    //---------Cajas de texto---------------
    JTextField cajaInsertar = new JTextField();
    JTextField cajaRemover = new JTextField();
    JTextField cajaBuscar = new JTextField();

    //---------- canvas-----------------------
    Lienzo lienzo = new Lienzo();
    //----------Scroll------------------------
    JScrollPane scroll=new JScrollPane(lienzo);

    public VentanaManual() {

        inicializarPanel();
        inicializarPanel2();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        this.getContentPane().add(panel, BorderLayout.NORTH);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void inicializarPanel() {
        System.out.println("size de insertar " + insertar.getSize());
        panel.add(insertar);
        panel.add(cajaInsertar);
        panel.add(remover);
        panel.add(buscar);
        panel.setBackground(Color.white);
    }

    public void inicializarPanel2() {
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout());
        lienzo.setSize(panel2.getSize());
        panel2.add(scroll,BorderLayout.CENTER);
        panel2.add(dibujar, BorderLayout.SOUTH);

    }

}
