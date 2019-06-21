/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Arbol;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener {

    public static Arbol ab = new Arbol();
    public static Ventana v = new Ventana();

    //-----botones-----
    private JButton posOrden = new JButton("Pos-Orden");
    private JButton preOrden = new JButton("Pre-Orden");
    //private JButton limpiar = new JButton("Limpiar");

    public Control() {
        inicializarBotones();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == posOrden) {
            String in;
            String pos;

            v.getCajaPos().setEditable(true);
            v.getCajaPre().setEditable(false);

            in = v.getCajaIn().getText();
            pos = v.getCajaPos().getText();

            if (in.equals("") || pos.equals("")) {
                JOptionPane.showMessageDialog(v, "No existe arbol");
                return;
            }
            if (ab.verificarLetraRepetida(in) || ab.verificarLetraRepetida(pos)) {
                JOptionPane.showMessageDialog(v, "Existen letras repetidas");
                return;
            }

            ab.recibirInOrden(in);
            ab.recibirPosOrden(pos);

            if (!ab.verificarLongitudInYPos()) {
                JOptionPane.showMessageDialog(v, "el In-orden y el Pos-Orden no coinciden");
            }
            //ab.armandoMatrizInPos();
            v.getLienzo().setArbol(ab.armandoMatrizInPos());
            v.getLienzo().repaint();
            v.getLienzo().paint(v.getLienzo().getGraphics());

        }
        //----------------------------------------------------------------
        if (e.getSource() == preOrden) {
            String in;
            String pre;

            v.getCajaPos().setEditable(false);
            v.getCajaPre().setEditable(true);

            in = v.getCajaIn().getText();
            pre = v.getCajaPre().getText();

            if (in.equals("") || pre.equals("")) {
                JOptionPane.showMessageDialog(v, "No existe arbol");
                return;
            }
            if (ab.verificarLetraRepetida(in) || ab.verificarLetraRepetida(pre)) {
                JOptionPane.showMessageDialog(v, "Existen letras repetidas");
                return;
            }

            ab.recibirInOrden(in);
            ab.recibirPreOrden(pre);

            if (!ab.verificarLongitudInYPre()) {
                JOptionPane.showMessageDialog(v, "el In-orden y el Pos-Orden no coinciden");
            }
            //ab.armandoMatrizInPos();
            v.getLienzo().setArbol(ab.armandoMatrizInPre());
            v.getLienzo().repaint();
            v.getLienzo().paint(v.getLienzo().getGraphics());

        }
    }

    private void inicializarBotones() {
        posOrden.addActionListener(this);
        preOrden.addActionListener(this);
    }

    public JButton getPosOrden() {
        return posOrden;
    }

    public JButton getPreOrden() {
        return preOrden;
    }

}
