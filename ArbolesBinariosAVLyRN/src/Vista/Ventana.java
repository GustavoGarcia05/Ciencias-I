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
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class Ventana extends JFrame {
    
    //Controlador
    public Control c= new Control(this);
    
    //Arboles
    private ArbolAVL arbolAVL= new ArbolAVL();
    private ArbolRN arbolRN = new ArbolRN();
    
    
    //Dibujo arboles
    private DibujoAVL dibujoAVL= new DibujoAVL();
    private DibujoRN dibujoRN= new DibujoRN();
    
    //Paneles
    private JPanel panelBotones= new JPanel();
    
    private JPanel panelCentral= new JPanel();
    private JScrollPane panelAVL = new JScrollPane();
    private JScrollPane panelRN = new JScrollPane();
    
    //Botones
    private JButton insertar= new JButton("Insertar");
    private JButton retirar= new JButton("Retirar");
    
    //Cajas de texto
    private JTextField cajaInsertar= new JTextField(5);
    private JTextField cajaRetirar= new JTextField(5);
    
    
    
    

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
        
        panelBotones.setBackground(Color.white);
        panelBotones.add(insertar);
        panelBotones.add(cajaInsertar);
        panelBotones.add(retirar);
        panelBotones.add(cajaRetirar);
        
        getContentPane().add(panelBotones,BorderLayout.NORTH);
        


        panelCentral.setLayout(new GridLayout(2, 1));
        
        panelCentral.add(panelAVL);
        panelCentral.add(panelRN);
        
        getContentPane().add(panelCentral,BorderLayout.CENTER);
       
        
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
