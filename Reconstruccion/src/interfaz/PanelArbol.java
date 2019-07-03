package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelArbol extends JPanel {

    private ArrayList<NodoGrafico[]> nodos;

    /**
     * constructor de la clase PanelArbol
     */
    public PanelArbol(int width, int height) {
        setBackground(Color.GRAY);
        setBounds(10, 10, width, height);
        setLayout(null);
        setBorder(new LineBorder(Color.BLACK));
        nodos = new ArrayList<NodoGrafico[]>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        for (int i = 1; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.get(i).length; j++) {
                if (nodos.get(i)[j] != null) {
                    int xo, xf, yo = -1, yf;
                    xo = nodos.get(i - 1)[j / 2].getX() + 25;
                    xf = nodos.get(i)[j].getX() + 25;
                    for (int k = 0; k < nodos.get(i - 1).length; k++) {
                        if (nodos.get(i - 1)[k] != null) {
                            yo = nodos.get(i - 1)[k].getY() + 30;
                            k = nodos.get(i - 1).length + 1;
                        }
                    }
                    yf = nodos.get(i)[j].getY();
                    g.drawLine(xo, yo, xf, yf);
                }
            }
        }
    }

    public void setNodos(ArrayList<NodoGrafico[]> nodos) {
        this.nodos = nodos;
    }
}
