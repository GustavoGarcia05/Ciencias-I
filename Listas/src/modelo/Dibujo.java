package Modelo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */
public class Dibujo extends Canvas {

    private ArrayList<Integer> l;
    private int limite;

    public Dibujo(ArrayList l,int limite) {
        this.l = l;
        this.limite=limite;
    }

    private int anchoCuadro = 50;
    private int largoCuadro = 15;
    private int x = 10;
    private int xAdyacente = x + anchoCuadro;
    private int y = 36;
    private int yAdyacente = y + largoCuadro;
    private String dato = "";

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        int altoString, anchoString;

        
        Font fuente=new Font("Monospaced", Font.BOLD,36);
        g.setFont(fuente);
        FontMetrics fm = g.getFontMetrics();
        for (int i = 0; i < l.size(); i++) {
            
            if (i == l.size() - 1) {
                dato = l.get(i).toString();
            }else{
                dato = l.get(i).toString() + " ---> ";
            }
            altoString=fm.getHeight();
            anchoString = fm.stringWidth(dato);
            //g.drawRect(x, y, anchoCuadro, largoCuadro);
            g.drawString(dato, x, y);
            //g.drawRect(xAdyacente, y, anchoCuadro, largoCuadro);
            x += anchoString;
            //xAdyacente += 3 * anchoCuadro;
            if(x+anchoString>limite){
                x=10;
                y+=altoString;
            }

        }

    }

}
