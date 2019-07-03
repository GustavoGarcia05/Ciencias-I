package interfaz;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class NodoGrafico extends JLabel {

    /**
     * constructor de la clase NodoGrafico
     *
     * @param texto texto que llevara el nodo
     * @param x posicion x del nodo
     * @param y posicion y del nodo
     */
    public NodoGrafico(String texto, int x, int y) {
        setText(texto);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 50, 30);
        setBorder(new LineBorder(Color.BLACK));
    }
}
