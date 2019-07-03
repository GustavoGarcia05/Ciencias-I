package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import logica.Arbol;

public class IPrincipalBotones implements ActionListener {

    private VPrincipal principal;

    public IPrincipalBotones(VPrincipal principal) {
        this.principal = principal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton obj = (JButton) e.getSource();
        for (int i = 0; i < principal.btnPrincipal.length; i++) {
            if (principal.btnPrincipal[i].equals(obj)) {
                try {
                    accion(i);
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "No se pudo generar el árbol :(");
                }

            }
        }
    }

    private void accion(int num) {
        switch (num) {
            case 0:
                ArrayList<String> primero = new ArrayList<String>(),
                 segundo = new ArrayList<String>();
                String[] otroOrden = principal.txtCampos[0].getText().split(",");
                String[] inOrden = principal.txtCampos[1].getText().split(",");
                for (int i = 0; i < inOrden.length; i++) {
                    primero.add(inOrden[i]);
                    segundo.add(otroOrden[i]);
                }
                Arbol tree = Arbol.reconstruir(primero, 0, segundo, principal.seleccion);
                VArbol vtnTree = new VArbol(tree, principal.txtCampos[0].getText());
                System.out.println("Hola entre");
                if (imprimir(tree.postOrden()).equals(principal.txtCampos[0].getText())
                        || imprimir(tree.preOrden()).equals(principal.txtCampos[0].getText())) {
                    vtnTree.setVisible(true);
                } else {
                    vtnTree.dispose();
                    JOptionPane.showMessageDialog(null, "El recorrido es inválido");
                }
                break;
            case 1:
                principal.dispose();
                System.exit(0);
                break;
            default:
                System.out.println("Opción no disponible");
                break;
        }
    }

    String imprimir(ArrayList<String> lista) {
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
