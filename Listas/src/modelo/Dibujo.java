package Modelo;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

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

    public Dibujo(Lista l) {
        setSize(100, 50);
    }

    private int anchoCuadro = 20;
    private int largoCuadro = 10;
    private int x = 10;
    private int xAdyacente = x + anchoCuadro;
    private int y = 10;
    private int yAdyacente = y + largoCuadro;

    @Override
    public void paint(Graphics g) {
        
        g.setColor(Color.BLACK);
        g.drawRect(x, y, anchoCuadro, largoCuadro);
        g.drawRect(xAdyacente, y, anchoCuadro, largoCuadro);
        x += 3*anchoCuadro;
        xAdyacente+=3*anchoCuadro;
    }

}
