/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Pantalla principal donde el usuario podra interactuar con el programa
 *
 * @author Gustavo_2
 */
public class VentanaPrincipal extends JFrame {

    JPanel panel1;

    public VentanaPrincipal() {

        setTitle("Arbol Binario");
        setVisible(true);
        //setResizable(false);

        //setLayout(new BorderLayout());
        setSize(700, 700);
        //setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        PanelArbol obj = new PanelArbol();
        getContentPane().add(obj);
        /*
        inicializarPanel1();
        getContentPane().add(panel1);
*/
    }

    /**
     * Metodo donde se inicializan todos los parametros del panel1. el panel1
     * muestra los comandos basicos del programa
     */
    void inicializarPanel1() {

        JButton btnInsetar = new JButton("insertar");
        JButton btnBuscar = new JButton("buscar");
        JButton btnEliminar = new JButton("eliminar");

        JTextField txtInsertar = new JTextField(5);
        JTextField txtBuscar = new JTextField(5);

        panel1 = new JPanel();
        panel1.setBackground(Color.yellow);

        panel1.add(btnInsetar);
        panel1.add(txtInsertar);
        panel1.add(btnBuscar);
        panel1.add(txtBuscar);
        panel1.add(btnEliminar);
    }

}
