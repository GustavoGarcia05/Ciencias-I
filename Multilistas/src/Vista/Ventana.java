/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo_2
 */
public class Ventana extends JFrame implements ActionListener {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JButton insertarPropietario = new JButton("Insertar propietario");
    JButton retirarPropietario = new JButton("Retirar propietario");
    JButton buscarPropietario = new JButton("buscar propietario");
    JButton listarPropietario = new JButton("listar propietario");

    JButton insertarInmueble = new JButton("Insertar inmueble");
    JButton retirarInmueble = new JButton("Retirar inmueble");
    JButton buscarInmueble = new JButton("buscar inmueble");
    JButton listarInmueble = new JButton("listar inmueble");

    JTextField cajaInsProp = new JTextField(5);
    JTextField cajaRetProp = new JTextField(5);
    JTextField cajaBusProp = new JTextField(5);

    JTextField cajaInsInmueble = new JTextField(5);
    JTextField cajaRetInmueble = new JTextField(5);
    JTextField cajaBusInmueble = new JTextField(5);

    TextArea Area1 = new TextArea(100, 100);
    TextArea Area2 = new TextArea(100, 100);

    public Ventana() {

        setSize(800, 600);
        getContentPane().setLayout(null);

        inicializarPanel1();
        inicializarPanel2();
        inicilizarBotones();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().add(panel1);
        getContentPane().add(panel2);
//        System.out.println("posX: "+ getX());
//        System.out.println("posY: "+ getY());
    }

    void inicializarPanel1() {

        this.panel1.setSize(getWidth(), getHeight() / 2);
        this.panel1.setLocation(0, 0);
        this.panel1.setBackground(Color.CYAN);

        this.panel1.add(insertarPropietario);
        this.panel1.add(cajaInsProp);
        this.panel1.add(retirarPropietario);
        this.panel1.add(cajaRetProp);
        this.panel1.add(buscarPropietario);
        this.panel1.add(cajaBusProp);
        this.panel1.add(listarPropietario);

        this.panel1.add(Area1);
    }

    void inicializarPanel2() {

        this.panel2.setSize(getWidth(), getHeight());
        this.panel2.setLocation(0, panel1.getHeight());
        this.panel2.setBackground(Color.darkGray);

        this.panel2.add(insertarInmueble);
        this.panel2.add(cajaInsInmueble);
        this.panel2.add(retirarInmueble);
        this.panel2.add(cajaRetInmueble);
        this.panel2.add(buscarInmueble);
        this.panel2.add(cajaBusInmueble);
        this.panel2.add(listarInmueble);

        this.panel2.add(Area2);
    }

    void inicilizarBotones() {

        insertarPropietario.addActionListener(this);
        retirarPropietario.addActionListener(this);
        buscarPropietario.addActionListener(this);
        listarPropietario.addActionListener(this);

        insertarInmueble.addActionListener(this);
        retirarInmueble.addActionListener(this);
        buscarInmueble.addActionListener(this);
        listarInmueble.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertarPropietario) {
            Area1.setText(cajaInsProp.getText());
        }
        if (e.getSource() == retirarPropietario) {
            JOptionPane.showMessageDialog(null, "el boton si sirve");
        }
        if (e.getSource() == buscarPropietario) {
            JOptionPane.showMessageDialog(null, "el boton si sirve");
        }
        if (e.getSource() == listarPropietario) {
            JOptionPane.showMessageDialog(null, "el boton si sirve");
        }
        if (e.getSource() == insertarInmueble) {
            JOptionPane.showMessageDialog(null, "el boton si sirve");
        }
        if (e.getSource() == retirarInmueble) {
            JOptionPane.showMessageDialog(null, "el boton si sirve");
        }
        if (e.getSource() == buscarInmueble) {
            JOptionPane.showMessageDialog(null, "el boton si sirve");
        }
        if (e.getSource() == listarInmueble) {
            JOptionPane.showMessageDialog(null, "el boton si sirve");
        }
    }
}
