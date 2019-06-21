/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Gustavo
 */
public class Lienzo extends Canvas {

    public Lienzo() {
        setBackground(Color.LIGHT_GRAY);
        setSize(4000, 4000);

    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        Graphics2D grap=(Graphics2D)g;
        
        grap.setColor(Color.red);
        for (int i = 0; i < 4000; i++) {
            grap.fillOval(100*i, i*100, 50, 50);
        }

    }

}
