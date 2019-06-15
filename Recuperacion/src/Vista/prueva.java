/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Gustavo
 */
public class prueva extends JFrame{

    //JScrollPane jsp= new JScrollPane();
    JScrollPane jsp= new JScrollPane();
    JPanel p= new JPanel();
    
    public prueva() {
        setSize(800, 600);
        setLayout(null);
        
        jsp.setSize(new Dimension(400, 300));
        p.setSize(4000, 2000);
        p.setBackground(Color.GRAY);
        jsp.setViewportView(p);
        
        add(jsp);
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
