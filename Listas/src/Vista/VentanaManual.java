/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Dibujo;
import Modelo.Lista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo_2
 */
public class VentanaManual extends JFrame implements ActionListener{

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    //------------- botones-----------
    JButton insertar = new JButton("Insertar");
    JButton remover = new JButton("Remover");
    JButton buscar = new JButton("Buscar");
    JButton dibujar = new JButton("Dibujar");

    //---------Cajas de texto---------------
    JTextField cajaInsertar = new JTextField(5);
    JTextField cajaRemover = new JTextField(5);
    JTextField cajaBuscar = new JTextField(5);

    //---------- canvas-----------------------
    Lienzo lienzo = new Lienzo();
    //----------Scroll------------------------
    JScrollPane scroll = new JScrollPane(lienzo);
    //------------------lista--------------------
    private Lista lis= new Lista();
    //--------------dibujar---------------------
    private Dibujo dib=new Dibujo(lis);

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

        panel.add(insertar);
        panel.add(cajaInsertar);
        insertar.addActionListener(this);
        
        panel.add(remover);
        panel.add(cajaRemover);
        remover.addActionListener(this);
        
        panel.add(buscar);
        panel.add(cajaBuscar);
        buscar.addActionListener(this);

        panel.setBackground(Color.gray);
    }

    public void inicializarPanel2() {
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout());
        
        panel2.add(lienzo, BorderLayout.CENTER);
        dibujar.addActionListener(this);
        panel2.add(dibujar, BorderLayout.SOUTH);

    }

    public JTextField getCajaInsertar() {
        return cajaInsertar;
    }

    public JButton getInsertar() {
        return insertar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==insertar){
            lis.insertar(Integer.parseInt(cajaInsertar.getText()));
            cajaInsertar.setText("");
            
        }
        
        if(e.getSource()==remover){
            lis.retirar(Integer.parseInt(cajaRemover.getText()));
            System.out.println("eliminado: ");
            cajaInsertar.setText("");
            
        }
        
        if(e.getSource()==buscar){
            lis.buscar(Integer.parseInt(cajaBuscar.getText()));
            System.out.println("encontardo: ");
            cajaInsertar.setText("");
            
        }
        if(e.getSource()==dibujar){
            Graphics pincel=lienzo.getGraphics();
            
            lis.imprimir();
            dib.paint(pincel);
            
        }
    }
    
    

}
