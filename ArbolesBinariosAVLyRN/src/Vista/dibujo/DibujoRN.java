/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.dibujo;

import Modelo.RN.ArbolRN;
import Modelo.RN.NodoRN;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class DibujoRN extends JPanel {

    private ArbolRN arbolRN;

    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public DibujoRN(ArbolRN arbolAVL) {
        this.arbolRN = arbolAVL;
    }

    public DibujoRN() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 20, arbolRN.raiz.der);
    }

    private void pintar(Graphics g, int x, int y, NodoRN nod) {
//        nod.setZ(arbolRN.getZ());
        if (nod != arbolRN.getZ()) {
            if (nod.color == 1) {
                g.setColor(Color.red);
            }
            if (nod.color == 0) {
                g.setColor(Color.black);
                int EXTRA = nod.nodosCompletos(nod) * (ANCHO / 2);
                g.drawOval(x, y, DIAMETRO, DIAMETRO);
                g.drawString(Integer.toString(nod.llave), x + 12, y + 18);
                g.setColor(Color.black);
                if (nod.izq != arbolRN.getZ()) {
                    g.drawLine(x + RADIO, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);
                }
                if (nod.der != arbolRN.getZ()) {
                    g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
                }
                pintar(g, x - ANCHO - EXTRA, y + ANCHO, nod.izq);
                pintar(g, x + ANCHO + EXTRA, y + ANCHO, nod.der);
            }
        }
    }

    public void setObjArbol(ArbolRN objArbol) {
        this.arbolRN = objArbol;
        repaint();
    }

}
