/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jrockit.jfr.events.Bits;

/**
 *
 * @author Gustavo
 */
public class Lienzo extends Canvas implements Runnable {

    private int tamanio;
    char[][] arbolAPintar;
    int x=0;
    int y=0;
    public Lienzo() {
        setBackground(Color.LIGHT_GRAY);
        setSize(4000, 4000);

    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
        setSize(tamanio, tamanio);
    }

    public void setArbolAPintar(char[][] arbolAPintar) {
        this.arbolAPintar = arbolAPintar;
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.red);
        
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(10 * (x - 1), 10 * (y - 1), 50, 50);
            g.setColor(Color.red);
            g.fillOval(10 * x, 10 * y, 50, 50);
        

        /*for(int i=0; i<arbolAPintar.length;i++){
            for(int j=0;i<arbolAPintar[0].length;j++){
                if(arbolAPintar[i][j]=='•'){
                    int auxX=i*100;
                    int auxY=j*100;
                    g.drawString(Character.toString(arbolAPintar[i][j]), auxX, auxY);
                }
            }
        }*/
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void run() {

        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            while (true) {
                repaint();
                x++;
                y++;
            }
        }
    }

}
