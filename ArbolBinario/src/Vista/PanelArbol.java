/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ArbolBinario;
import Modelo.Nodo;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Clase donde se grafica el arbol
 *
 * @author Gustavo_2
 */
public class PanelArbol extends JPanel {

    private ArbolBinario objArbol = new ArbolBinario();

    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public PanelArbol() {
    }

    public PanelArbol(ArbolBinario arbol) {
        objArbol = arbol;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 20, objArbol.getRaiz());
    }

    /**
     * Metodo recursivo
     */
    private void pintar(Graphics g, int x, int y, Nodo nod) {
        if (nod != null) {
            int EXTRA = nod.nodosCompletos(nod) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(Integer.toString(nod.getInfo()), x + 12, y + 18);
            if (nod.getIzq() != null) {
                if (x - ANCHO - EXTRA + RADIO < x) {
                    g.drawLine(x + RADIO, y + RADIO, (x - 2 * ANCHO - EXTRA + RADIO), y + ANCHO + RADIO);
                    pintar(g, (x - 2*ANCHO - EXTRA), y + ANCHO, nod.getIzq());
                    //pintar(g, x + ANCHO + EXTRA, y + ANCHO, nod.getDer());

                } else {
                    g.drawLine(x + RADIO, y + RADIO, (x - ANCHO - EXTRA + RADIO), y + ANCHO + RADIO);
                    pintar(g, (x - ANCHO - EXTRA), y + ANCHO, nod.getIzq());
                    //pintar(g, x + ANCHO + EXTRA, y + ANCHO, nod.getDer());
                }
            }
            if (nod.getDer() != null) {
                if (x + ANCHO + EXTRA + RADIO > x) {
                    g.drawLine(x + RADIO, y + RADIO, x + 2 * ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
                    //pintar(g, (x - ANCHO - EXTRA), y + ANCHO, nod.getIzq());
                    pintar(g, x + 2*ANCHO + EXTRA, y + ANCHO, nod.getDer());
                } else {
                    g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
                   //pintar(g, (x - ANCHO - EXTRA), y + ANCHO, nod.getIzq());
                    pintar(g, x + ANCHO + EXTRA, y + ANCHO, nod.getDer());
                }
            }
            // pintar(g, (x - ANCHO - EXTRA), y + ANCHO, nod.getIzq());
            // pintar(g, x + ANCHO + EXTRA, y + ANCHO, nod.getDer());
        }
    }

    public void setObjArbol(ArbolBinario objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    public int altura(Nodo n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + (Math.max(altura(n.getIzq()), altura(n.getDer())));
        }
    }
}
