/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Ventana;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Integer;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener {

    private Ventana v;

    public Control(Ventana v) {
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.getInsertar()) {

            if (!isInteger(v.getCajaInsertar().getText())) {
                JOptionPane.showMessageDialog(null, "No es un numero");
                return;
            }
            v.getArbolAVL().insertar(Integer.parseInt(v.getCajaInsertar().getText()));
            v.getArbolRN().insertar(Integer.parseInt(v.getCajaInsertar().getText()));

            v.getCajaInsertar().setText("");

            dibujarAVL();
            dibujarRN();

        }

        if (e.getSource() == v.getRetirar()) {

            if (!isInteger(v.getCajaRetirar().getText())) {
                JOptionPane.showMessageDialog(null, "No es un numero");
                return;
            }
            v.getArbolAVL().retirar(Integer.parseInt(v.getCajaRetirar().getText()));

            v.getCajaRetirar().setText("");
            dibujarAVL();
        }
    }

    private void dibujarAVL() {

        v.getDibujoAVL().setObjArbol(v.getArbolAVL());
        v.getPanelAVL().setViewportView(v.getDibujoAVL());

    }

    private void dibujarRN() {

        v.getDibujoRN().setObjArbol(v.getArbolRN());
        v.getPanelRN().setViewportView(v.getDibujoRN());

    }

    private boolean isInteger(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
