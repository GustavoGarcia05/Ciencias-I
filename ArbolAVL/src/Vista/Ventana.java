package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo_2
 */
public class Ventana extends JFrame {
    
    JButton btnInsetar;
    JButton btnBuscar;
    JButton btnEliminar;
    
    JPanel pnlBotones;
    
    public Ventana() {
        
        setTitle("Arbol AVL");
        setVisible(true);
        setResizable(true);
        
        setLayout(new BorderLayout());
        setSize(500, 500);
        
        inicializarPaneles();
        inicializarBotones();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    void inicializarBotones() {
        
        btnInsetar = new JButton("insertar");
        btnBuscar = new JButton("buscar");
        btnEliminar = new JButton("eliminar");
        
        pnlBotones.add(btnInsetar);
        pnlBotones.add(btnBuscar);
        pnlBotones.add(btnEliminar);
    }
    
    void inicializarPaneles() {
        pnlBotones = new JPanel();
        add(pnlBotones);
        pnlBotones.setBackground(Color.yellow);
    }
    
}
