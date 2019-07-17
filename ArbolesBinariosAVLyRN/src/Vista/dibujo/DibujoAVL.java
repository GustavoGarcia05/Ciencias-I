/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.dibujo;

import Modelo.AVL.ArbolAVL;
import Modelo.AVL.NodoAVL;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class DibujoAVL extends JPanel{
    
    
    private ArbolAVL arbolAVL;
    
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public DibujoAVL(ArbolAVL arbolAVL) {
        this.arbolAVL = arbolAVL;
    }

    public DibujoAVL() {
    }

@Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 20, arbolAVL.getRaiz());
    }

    private void pintar(Graphics g, int x, int y, NodoAVL nod) {
        if (nod != null) {
            if(nod.balance==1){
                g.setColor(Color.red);
            }
            if(nod.balance==-1){
                g.setColor(Color.blue);
            }
            if(nod.balance==0){
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
        g.drawString("Cantidad de if que usa para insertar: " + arbolAVL.getContadorIns(), 0, 15);
        g.drawString("Cantidad de if que usa para retirar: " + arbolAVL.getContadorEli(), 0, 50);
    }

    public void setObjArbol(ArbolAVL objArbol) {
        this.arbolAVL = objArbol;
        repaint();
    }
    
}
