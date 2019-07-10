/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ArbolBinario;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Ventana donde se dibujara el arbol
 *
 * @author Gustavo_2
 */
public class VentanaArbol extends JFrame {

    PanelArbol laminaArbol;

    /**
     * Constructor de la clase VentanaArbol, define las caracteristicas de la
     * ventana e instancia el panel donde se pinta el grafo
     * @param arbol no me acuerdo que hace
     */
    public VentanaArbol(ArbolBinario arbol) {

        setTitle("Arbol Binario");
        setResizable(true);

        setBounds(400, 200, 500, 500);

        laminaArbol = new PanelArbol(arbol);
        getContentPane().add(laminaArbol);

        setVisible(true);
    }
}
