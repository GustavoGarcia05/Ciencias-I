package interfaz;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logica.Arbol;

public class VArbol extends JFrame {

    private PanelArbol pnlArbol;
    private JPanel contentPane;
    private int parametro = 1;
    private ArrayList<NodoGrafico[]> nodos = null;

    /**
     * constructor de la ventana arbol, donde se grafica el arbol despues de
     * reconstruirlo.
     */
    public VArbol(Arbol arbol, String valor) {

        parametro = arbol.cantNiveles();
        pnlArbol = new PanelArbol((int) (Math.pow(2, parametro) * 70), ((parametro + 1) * 50));
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 750, 450);
        pnlArbol.setPreferredSize(pnlArbol.getSize());
        contentPane.add(scrollPane);

        nodos = new ArrayList<NodoGrafico[]>();
        for (int i = 0; i <= parametro + 1; i++) {
            nodos.add(new NodoGrafico[(int) (Math.pow(2, i))]);
            for (int j = 0; j < nodos.get(i).length; j++) {
                nodos.get(i)[j] = new NodoGrafico("",
                        (int) (pnlArbol.getWidth() / Math.pow(2, i + 1)) * ((2 * j) + 1) - 25, 10 + 50 * i);
                pnlArbol.add(nodos.get(i)[j]);
            }
        }
        for (int i = 0; i < nodos.get(nodos.size() - 1).length; i++) {
            pnlArbol.remove(nodos.get(nodos.size() - 1)[i]);
        }
        nodos.remove(nodos.size() - 1);
        adaptarArbol(arbol, 0, 0);
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.get(i).length; j++) {
                if (nodos.get(i)[j].getText().equals("")) {
                    pnlArbol.remove(nodos.get(i)[j]);
                    nodos.get(i)[j] = null;
                }
            }
        }

        pnlArbol.setNodos(nodos);
        pnlArbol.repaint();
        scrollPane.setViewportView(pnlArbol);
        setBounds(100, 300, 780, 500);
        setVisible(true);
//		if (imprimir("Pre", arbol.preOrden()).equals(valor)
//				|| imprimir("Post", arbol.postOrden()).equals(valor)) {
//			this.dispose();
//			JOptionPane.showMessageDialog(null, "El recorrido es inválido");
//		} else {
//			System.out.println("Hola");
//		}
//		System.out.println(imprimir("Pre", arbol.preOrden()).equals(valor));
//		System.out.println(imprimir("Pre", arbol.postOrden()).equals(valor));
//		System.out.println(
//				(imprimir("Pre", arbol.preOrden()).equals(valor) || imprimir("Post", arbol.postOrden()).equals(valor)));
//
    }

    private void adaptarArbol(Arbol arbol, int i, int j) {
        if (arbol != null) {
            nodos.get(i)[j].setText(arbol.getRaiz().getValor());
            int tempoU = i, tempoD = j;
            Arbol centi = arbol;
            while (centi.getIzquierda() != null) {
                centi = centi.getIzquierda();
                i++;
                j = 2 * j;
                adaptarArbol(centi, i, j);
            }
            centi = arbol;
            i = tempoU;
            j = tempoD;
            while (centi.getDerecha() != null) {
                centi = centi.getDerecha();
                i++;
                j = 2 * j + 1;
                adaptarArbol(centi, i, j);
            }
        }
    }

    private String imprimir(String titulo, ArrayList<String> lista) {
        String resultado = "";
        for (int i = 0; i < lista.size(); i++) {
            resultado = resultado + lista.get(i);
            if (i + 1 < lista.size()) {
                resultado = resultado + ",";
            }
        }
        return resultado;
    }
}
