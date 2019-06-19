/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Gustavo
 */
public class Lienzo extends Canvas {

    private int tamanio;
    char [][] arbolAPintar;


    
    public Lienzo() {
        setBackground(Color.LIGHT_GRAY);

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
            g.fillOval(10, 10, 50, 50);
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
   
}
