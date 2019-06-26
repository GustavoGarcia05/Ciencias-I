/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author Gustavo
 */
public class Lienzo extends Canvas {

    private char[][] arbol;

    public Lienzo() {
        setBackground(Color.LIGHT_GRAY);
        setSize(4000, 4000);

    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        /*Graphics2D grap=(Graphics2D)g;
        
        grap.setColor(Color.red);
        for (int i = 0; i < 4000; i++) {
            grap.fillOval(100*i, i*100, 50, 50);
        }*/
        Graphics2D grap = (Graphics2D) g;
        grap.setColor(Color.blue);
        
        Font fuente = new Font("Monospaced", Font.BOLD, 36);
        g.setFont(fuente);
        FontMetrics fm = g.getFontMetrics();

        int x;
        int y;
        
        
        if (arbol != null) {
        for (int i = 0; i < arbol.length; i++) {
            
            for (int j = 0; j < arbol.length; j++) {
                x=(i*100)+50;
                y=(j*100)+50;
                if(arbol[i][j]!='•'){
                    g.drawString(""+arbol[i][j], y, x);
                }
            }

        }
        } else {

            g.drawString("No hay Arbol", 100, 100);
        }

    }

    public void setArbol(char[][] arbol) {
        this.arbol = arbol;
    }

}
