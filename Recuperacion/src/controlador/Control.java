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

            v.getCajaPos().setEditable(true);
            v.getCajaPre().setEditable(false);

            ab.recibirInOrden(v.getCajaIn().getText());
            ab.recibirPreOrden(v.getCajaPos().getText());
            
            //ab.armandoMatrizInPos();
            
            //v.getLienzo().setArbolAPintar(ab.armandoMatrizInPre());
            v.getLienzo().paint(v.getLienzo().getGraphics());
            
            
            System.out.println("in: " + v.getCajaIn().getText());
            System.out.println("pos: " + v.getCajaPos().getText());

        }
        if (e.getSource() == preOrden) {

            v.getCajaPre().setEditable(true);
            v.getCajaPos().setEditable(false);

            ab.recibirInOrden(v.getCajaIn().getText());
            ab.recibirPreOrden(v.getCajaPre().getText());

            System.out.println("in: " + v.getCajaIn().getText());
            System.out.println("pre: " + v.getCajaPre().getText());

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
