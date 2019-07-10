/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.control;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import modelo.ArbolAVL;
import modelo.ArbolPrueva;

/**
 *
 * @author Gustavo
 */
public class Ventana extends JFrame {

    control c= new control(this);
    ArbolPrueva abAVL= new ArbolPrueva();
    
    JPanel botones = new JPanel();
    PanelArbol lienzo = new PanelArbol();
    JScrollPane arbol = new JScrollPane();
    
    JButton insertar=new JButton("Insertar");
    JButton retirar=new JButton("Retirar");
    JButton dibujar=new JButton("Dibujar");
    
    JTextField cinsertar= new JTextField(5);
    JTextField cretirar= new JTextField(5);
    
    

    public Ventana() {
        //setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializar();
        setVisible(true);
    }
    
    private void inicializar(){
        insertar.addActionListener(c);
        retirar.addActionListener(c);
        dibujar.addActionListener(c);
        
        botones.add(insertar);
        botones.add(cinsertar);
        botones.add(retirar);
        botones.add(cretirar);
        botones.add(dibujar);
        
        getContentPane().add(botones, BorderLayout.NORTH);
        getContentPane().add(arbol, BorderLayout.CENTER);
        
    }

    public ArbolPrueva getAbAVL() {
        return abAVL;
    }
    
    
    
    public JScrollPane getArbol() {
        return arbol;
    }

    public JButton getInsertar() {
        return insertar;
    }

    public JButton getRetirar() {
        return retirar;
    }

    public JButton getDibujar() {
        return dibujar;
    }

    public JTextField getCinsertar() {
        return cinsertar;
    }

    public JTextField getCretirar() {
        return cretirar;
    }

    public PanelArbol getLienzo() {
        return lienzo;
    }
    
    
    
    

}
