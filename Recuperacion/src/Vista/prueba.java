/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Gustavo
 */
public class prueba extends JFrame{


    TextArea ta= new TextArea(5, 30);
    JPanel p= new JPanel();
    Lienzo l= new Lienzo();
    JScrollPane jsp= new JScrollPane(p);
    
    JButton b1 = new JButton("boton1");
    JButton b2 = new JButton("boton2");
    JButton b3 = new JButton("boton3");
    JButton b4 = new JButton("boton4");
    JButton b5 = new JButton("boton5");
    JButton b6 = new JButton("boton6");
    JButton b7 = new JButton("boton7");
    JButton b8 = new JButton("boton8");
    JButton b9 = new JButton("boton9");
    JButton b10 = new JButton("boton10");
    JButton b11 = new JButton("boton11");
    JButton b12 = new JButton("boton12");
    JButton b13 = new JButton("boton13");
    JButton b14 = new JButton("boton14");
    JButton b15 = new JButton("boton15");
    JButton b16 = new JButton("boton16");
    JButton b17 = new JButton("boton17");
    JButton b18 = new JButton("boton18");
    JButton b19 = new JButton("boton19");
    JButton b20 = new JButton("boton20");
    
    public prueba() {
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        setSize(800,600);
        //p.setSize(4000, 2000);
        p.setBackground(Color.gray);
        agragarBotones();
        getContentPane().setPreferredSize(new Dimension(400, 100));
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        getContentPane().add(jsp,BorderLayout.CENTER);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void agragarBotones(){
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b10);
        p.add(b11);
        p.add(b12);
        p.add(b13);
        p.add(b14);
        p.add(b15);
        p.add(b16);
        p.add(b17);
        p.add(b18);
        p.add(b19);
        p.add(b20);
        
    }
    
}
