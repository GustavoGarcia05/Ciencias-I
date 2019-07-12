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

            v.getArbolAVL().insertar(Integer.parseInt(v.getCajaInsertar().getText()));
            v.getArbolRN().insertar(Integer.parseInt(v.getCajaInsertar().getText()));
            v.getCajaInsertar().setText("");

            v.getDibujoAVL().setObjArbol(v.getArbolAVL());
            v.getPanelAVL().setViewportView(v.getDibujoAVL());

            /*  v.getDibujoRN().setObjArbol(v.getArbolRN());
            v.getPanelRN().setViewportView(v.getDibujoRN());
            
             */
        }
    }

}
