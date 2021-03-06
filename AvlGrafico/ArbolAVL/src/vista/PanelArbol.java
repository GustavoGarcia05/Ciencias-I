/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import modelo.ArbolAVL;
import modelo.ArbolPrueva;
import modelo.Nodo;

/**
 *
 * @author Gustavo
 */
public class PanelArbol extends JPanel{
    private ArbolPrueva arbolAVL;
    
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public PanelArbol(ArbolPrueva arbolAVL) {
        this.arbolAVL = arbolAVL;
    }

    PanelArbol() {
        
    }

@Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 20, arbolAVL.getRaiz());
    }

    private void pintar(Graphics g, int x, int y, Nodo nod) {
        if (nod != null) {
            int balance=nod.balance;
            System.out.println("dato: "+nod.dato+" balance: "+balance);
            
            if(balance==1){
                g.setColor(Color.red);
            }
            if(balance==-1){
                g.setColor(Color.blue);
            }
            if(balance==0){
                g.setColor(Color.black);
            }
            int EXTRA = nod.nodosCompletos(nod) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(Integer.toString(nod.dato), x + 12, y + 18);
            g.setColor(Color.black);
            if (nod.izq != null) {
                g.drawLine(x + RADIO, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);
            }
            if (nod.der != null) {
                g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            }
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, nod.izq);
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, nod.der);
        }
    }

    public void setObjArbol(ArbolPrueva objArbol) {
        this.arbolAVL = objArbol;
        repaint();
    }
    
}
