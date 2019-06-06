/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Multilista;
import java.awt.BorderLayout;
import java.awt.Color;
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
 * @author estudiantes
 */
public class Ventana extends JFrame implements ActionListener {

    //------------- Paneles-----------
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    //------------- botones-----------    
    JButton insertarPropietario = new JButton("Insertar propietario");
    JButton buscarPropietario = new JButton("Buscar propietario");
    JButton retirarPropietario = new JButton("Retirar propietario");
    JButton listarPropietario = new JButton("Listar propietario");

    JButton insertarInmueble = new JButton("Insertar inmueble");
    JButton buscarInmueble = new JButton("Buscar inmueble");
    JButton retirarInmueble = new JButton("Retirar inmueble");
    JButton listarInmueble = new JButton("Listar inmueble");

    //------------- caja de texto-----------
    JTextField cajaInsertarPropNombre = new JTextField(5);
    JTextField cajaInsertarPropId = new JTextField(5);
    JTextField cajaRetirarProp = new JTextField(5);
    JTextField cajaBuscarProp = new JTextField(5);

    JTextField cajaInsertarInmuebleIdProp = new JTextField(5);
    JTextField cajaInsertarInmuebleId = new JTextField(5);
    JTextField cajaInsertarInmuebleNombre = new JTextField(5);
    JTextField cajaInsertarInmuebleValor = new JTextField(5);
    JTextField cajaInsertarInmuebleDireccion = new JTextField(5);
    JTextField cajaRetirarInmueble = new JTextField(5);
    JTextField cajaBuscarInmueble = new JTextField(5);
    JTextField cajaListarInmueble = new JTextField(5);

    //------------- areas donde se pondra la lista-----------
    TextArea areaPanel1 = new TextArea();
    TextArea areaPanel2 = new TextArea();
    //------------------Multilista---------------------------
    Multilista m = new Multilista();

    /**
     * Ventana principal donde se ejecutara todo el programa
     */
    public Ventana() {
        this.getContentPane().setLayout(null);

        setSize(1200, 800);
        setVisible(true);
        setResizable(false);

        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        this.getContentPane().add(panel2, BorderLayout.CENTER);

        inicializarPanel1();
        inicializarPanel2();
        inicializarBotones();
        inicializarCajasTexto();
//        inicializarAreas();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * inicializa el primer panel, donde se ubicaran los botones
     * correspondientes al propietario
     */
    void inicializarPanel1() {

        panel1.setBackground(Color.cyan);
        panel1.setSize(getWidth(), getHeight() / 2);
        panel1.setLocation(0, 0);

        panel1.add(insertarPropietario);
        panel1.add(cajaInsertarPropId);
        panel1.add(cajaInsertarPropNombre);
        panel1.add(buscarPropietario);
        panel1.add(cajaBuscarProp);
        panel1.add(retirarPropietario);
        panel1.add(cajaRetirarProp);
        panel1.add(listarPropietario);

        panel1.add(areaPanel1);
    }

    /**
     * inicializa el segundo panel, donde se ubicaran los botones
     * correspondientes al inmueble
     */
    void inicializarPanel2() {

        panel2.setBackground(Color.pink);
        panel2.setSize(getWidth(), getHeight() / 2);
        panel2.setLocation(0, getHeight() / 2);

        panel2.add(insertarInmueble);
        panel2.add(cajaInsertarInmuebleIdProp);
        panel2.add(cajaInsertarInmuebleId);
        panel2.add(cajaInsertarInmuebleNombre);
        panel2.add(cajaInsertarInmuebleValor);
        panel2.add(cajaInsertarInmuebleDireccion);
        panel2.add(buscarInmueble);
        panel2.add(cajaBuscarInmueble);
        panel2.add(retirarInmueble);
        panel2.add(cajaRetirarInmueble);
        panel2.add(listarInmueble);
        panel2.add(cajaListarInmueble);

        panel2.add(areaPanel2);
    }

    void inicializarCajasTexto() {
        cajaInsertarPropId.setText("id usuario");
    }

    void inicializarBotones() {
        insertarPropietario.addActionListener(this);
        buscarPropietario.addActionListener(this);
        retirarPropietario.addActionListener(this);
        listarPropietario.addActionListener(this);

        insertarInmueble.addActionListener(this);
        buscarInmueble.addActionListener(this);
        retirarInmueble.addActionListener(this);
        listarInmueble.addActionListener(this);
    }

    void inicializarAreas() {
        //areaPanel1.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertarPropietario) {
            m.insertarEnFila(Integer.parseInt(cajaInsertarPropId.getText()), cajaInsertarPropNombre.getText());
            cajaInsertarPropId.setText("");
            cajaInsertarPropNombre.setText("");
        }
        if (e.getSource() == listarPropietario) {
            areaPanel1.setText(m.listarEnFila());
        }
        if (e.getSource() == retirarPropietario) {
            m.retirarEnFila(Integer.parseInt(cajaRetirarProp.getText()));
        }
        if (e.getSource() == buscarPropietario) {
            m.buscarEnFila(Integer.parseInt(cajaBuscarProp.getText()));
        }

        if (e.getSource() == insertarInmueble) {
            m.insertarAbajo(Integer.parseInt(cajaInsertarInmuebleIdProp.getText()),
                    Integer.parseInt(cajaInsertarInmuebleId.getText()),
                    Float.parseFloat(cajaInsertarInmuebleValor.getText()),
                    cajaInsertarInmuebleNombre.getText(),
                    cajaInsertarInmuebleDireccion.getText());

            cajaInsertarPropId.setText("");
            cajaInsertarPropNombre.setText("");
        }
        if (e.getSource() == listarInmueble) {
            areaPanel2.setText(m.listarAbajo(Integer.parseInt(cajaListarInmueble.getText())));
        }
        if (e.getSource() == retirarInmueble) {
            m.retirarEnFila(Integer.parseInt(cajaRetirarProp.getText()));
        }
        if (e.getSource() == buscarInmueble) {
            m.buscarEnFila(Integer.parseInt(cajaBuscarProp.getText()));
        }

    }

}
