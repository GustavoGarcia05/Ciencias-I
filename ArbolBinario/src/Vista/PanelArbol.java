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
        objArbol.insertar(5);
        objArbol.insertar(22);
        objArbol.insertar(10);
        objArbol.insertar(19);
        objArbol.insertar(15);
        objArbol.insertar(17);
        objArbol.insertar(14);
        objArbol.insertar(12);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 20, objArbol.getRaiz());
    }

    private void pintar(Graphics g, int x, int y, Nodo nod) {
        if (nod != null) {
            int EXTRA = nod.nodosCompletos(nod) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(Integer.toString(nod.getInfo()), x + 12, y + 18);
            if (nod.getIzq() != null) {
                g.drawLine(x + RADIO, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);
            }
            if (nod.getDer() != null) {
                g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            }
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, nod.getIzq());
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, nod.getDer());
        }
    }

    public void setObjArbol(ArbolBinario objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

}
