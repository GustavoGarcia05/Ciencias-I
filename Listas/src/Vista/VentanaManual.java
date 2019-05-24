/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Dibujo;
import Modelo.Lista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo_2
 */
public class VentanaManual extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    //------------- botones-----------
    JButton insertar = new JButton("Insertar");
    JButton remover = new JButton("Remover");
    JButton buscar = new JButton("Buscar");
    JButton dibujar = new JButton("Dibujar");

    //---------Cajas de texto---------------
    JTextField cajaInsertar = new JTextField(5);
    JTextField cajaRemover = new JTextField(5);
    JTextField cajaBuscar = new JTextField(5);

    //---------- canvas-----------------------
    Lienzo lienzo = new Lienzo();
    //----------Scroll------------------------
    JScrollPane scroll = new JScrollPane(lienzo);
    //------------------lista--------------------
    private Lista lis = new Lista();

    public VentanaManual() {

        inicializarPanel();
        inicializarPanel2();
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        this.getContentPane().add(panel, BorderLayout.NORTH);
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cajaInsertar.setText("");

    }

    public void inicializarPanel() {

        panel.add(insertar);
        panel.add(cajaInsertar);
        insertar.addActionListener(this);

        panel.add(remover);
        panel.add(cajaRemover);
        remover.addActionListener(this);

        panel.add(buscar);
        panel.add(cajaBuscar);
        buscar.addActionListener(this);

        panel.setBackground(Color.gray);
    }

    public void inicializarPanel2() {
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout());
        panel2.add(scroll, BorderLayout.CENTER);
        dibujar.addActionListener(this);
        panel2.add(dibujar, BorderLayout.SOUTH);

    }

    public JTextField getCajaInsertar() {
        return cajaInsertar;
    }

    public JButton getInsertar() {
        return insertar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == insertar) {

            if (cajaInsertar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡No ha ingresado dato!", "No Hay Dato", JOptionPane.ERROR_MESSAGE);
            } else {
                lis.insertar(Integer.parseInt(cajaInsertar.getText()));
                cajaInsertar.setText("");

            }

        }

        if (e.getSource() == remover) {
            if (cajaRemover.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡No ha ingresado algun dato!", "No Hay Dato", JOptionPane.ERROR_MESSAGE);
            } else {
                if (lis.retirar(Integer.parseInt(cajaRemover.getText()))) {
                    JOptionPane.showMessageDialog(null, "se ha eliminado: " + cajaBuscar.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "el elemento no se eliminó en la lista ");
                }
                cajaRemover.setText("");

            }

        }

        if (e.getSource() == buscar) {
            if (cajaInsertar.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "¡No ha ingresado algun dato!", "No Hay Dato", JOptionPane.ERROR_MESSAGE);
            } else {

                if (lis.buscar(Integer.parseInt(cajaBuscar.getText()))) {
                    JOptionPane.showMessageDialog(null, "se ha encontrado: " + cajaBuscar.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "el elemento no se encuentra en la lista ");
                }
                cajaBuscar.setText("");
            }

        }
        //-----boton dibujar-----
        if (e.getSource() == dibujar) {
            Graphics pincel = lienzo.getGraphics();
            lis.dibujar(pincel,this.getWidth());
        }

    }

}
