package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo_2
 */
public class Ventana extends JFrame {

    JButton btnInsetar;
    JButton btnBuscar;
    JButton btnEliminar;

    JTextField txtInsertar;
    JTextField txtBuscar;

    JPanel pnlBotones;

    public Ventana() {

        setTitle("Arbol Binario");
        setVisible(true);
        setResizable(true);

        setLayout(new BorderLayout());
        setSize(500, 500);

        inicializarBotones();
        inicializarCajasTexto();
        inicializarPaneles();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void inicializarBotones() {
        btnInsetar = new JButton("insertar");
        btnBuscar = new JButton("buscar");
        btnEliminar = new JButton("eliminar");
    }

    void inicializarPaneles() {
        pnlBotones = new JPanel();
        add(pnlBotones);
        pnlBotones.setBackground(Color.yellow);

        pnlBotones.add(btnInsetar);
        pnlBotones.add(txtInsertar);
        pnlBotones.add(btnBuscar);
        pnlBotones.add(txtBuscar);
        pnlBotones.add(btnEliminar);
    }

    void inicializarCajasTexto() {
        txtInsertar = new JTextField(5);
        //txtInsertar.setSize(5, 10);
        txtBuscar = new JTextField(5);
        //txtBuscar.setSize(5, 10);
    }

}
