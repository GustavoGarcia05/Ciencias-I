
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ArbolBinario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Pantalla principal donde el usuario podra interactuar con el programa
 *
 * @author Gustavo_2
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    //-------------Botones-----------
    JButton btnInsertar = new JButton("Insertar");
    JButton btnBuscar = new JButton("Buscar");
    JButton btnEliminar = new JButton("Eliminar");
    JButton btnGraficar = new JButton("Graficar");
    JButton btnPreOrden = new JButton("Pre-Orden");
    JButton btnInOrden = new JButton("In-Orden");
    JButton btnPostOrden = new JButton("Post-Orden");
    JButton btnNiveles = new JButton("Niveles");

    //------------- Cajas de texto-----------
    JTextField txtInsertar = new JTextField(5);
    JTextField txtBuscar = new JTextField(5);
    JTextField txtEliminar = new JTextField(5);

    JPanel panel1;

    ArbolBinario objArbol = new ArbolBinario();

    /**
     * Constructor de la VentanaPrincipal. Le da caracteristicas a la ventana y
     * llama el metodo inicializarPanel1 donde se instancian los botones y los
     * eventos de los mismos
     */
    public VentanaPrincipal() {

        setTitle("Arbol Binario");
        setBounds(200, 200, 500, 500);
        setResizable(false);

        inicializarPanel1();
        getContentPane().add(panel1);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Metodo donde se inicializan todos los parametros del panel1. el panel1
     * muestra los comandos basicos del programa
     */
    void inicializarPanel1() {

        btnInsertar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnGraficar.addActionListener(this);
        btnPreOrden.addActionListener(this);
        btnInOrden.addActionListener(this);
        btnPostOrden.addActionListener(this);
        btnNiveles.addActionListener(this);

        panel1 = new JPanel();
        panel1.setBackground(Color.white);
        panel1.setSize(200, 200);

        panel1.add(btnInsertar);
        panel1.add(txtInsertar);
        panel1.add(btnBuscar);
        panel1.add(txtBuscar);
        panel1.add(btnEliminar);
        panel1.add(txtEliminar);
        panel1.add(btnPreOrden);
        panel1.add(btnInOrden);
        panel1.add(btnPostOrden);
        panel1.add(btnNiveles);
        panel1.add(btnGraficar);
    }

    boolean isInteger(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Comprueba que el caracter sea valido.
     *
     * @return true si el caracter es valido, false si no lo es.
     */
    boolean comprobarIngreso(String datoComprobar, JPanel pn) {
        if (datoComprobar.equals("")) {
            JOptionPane.showMessageDialog(panel1, "No se han llenado todos los campos");
            return false;
        } else if (!isInteger(datoComprobar)) {
            JOptionPane.showMessageDialog(pn, "la cadena que ingreso no es un numero entero o tiene algún caracter");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsertar) {
            if (!comprobarIngreso(txtInsertar.getText(), panel1)) {
                return;
            }
            int dato = Integer.parseInt(txtInsertar.getText());
            if (objArbol.insertar(dato)) {
                JOptionPane.showMessageDialog(panel1, "Se ha insertado: " + txtInsertar.getText());
            } else {
                JOptionPane.showMessageDialog(panel1, "No se ha podido insertar el dato, posiblemente esta repetido");
            }
        }
        if (e.getSource() == btnBuscar) {
            if (!comprobarIngreso(txtBuscar.getText(), panel1)) {
                return;
            }
            int dato = Integer.parseInt(txtBuscar.getText());
            if (objArbol.buscar(dato)) {
                JOptionPane.showMessageDialog(panel1, "El elemento se encuentra en el arbol");
            } else {
                JOptionPane.showMessageDialog(panel1, "El elemento no se encuentra en el arbol");
            }
        }
        if (e.getSource() == btnEliminar) {
            if (!comprobarIngreso(txtEliminar.getText(), panel1)) {
                return;
            }
            int dato = Integer.parseInt(txtEliminar.getText());
            if (objArbol.retirar(dato)) {
                JOptionPane.showMessageDialog(panel1, "El elemento se ha eliminado del arbol");
            } else {
                JOptionPane.showMessageDialog(panel1, "El elemento no se ha podido eliminar");
            }
        }
        if (e.getSource() == btnPreOrden) {
            JOptionPane.showMessageDialog(panel1, objArbol.preOrden());
        }
        if (e.getSource() == btnInOrden) {
            JOptionPane.showMessageDialog(panel1, objArbol.inOrden());
        }
        if (e.getSource() == btnPostOrden) {
            JOptionPane.showMessageDialog(panel1, objArbol.postOrden());
        }
        if (e.getSource() == btnNiveles) {
            JOptionPane.showMessageDialog(panel1, objArbol.niveles());
        }
        if (e.getSource() == btnGraficar) {
            VentanaArbol vent = new VentanaArbol(objArbol);
        }
    }
}
