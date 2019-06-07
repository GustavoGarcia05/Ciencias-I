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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import sun.nio.ch.DefaultAsynchronousChannelProvider;

/**
 *
 * @author estudiantes
 */
public class Ventana extends JFrame implements ActionListener {

    //------------- Paneles-----------
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panelListar = new JPanel();

    //------------- botones-----------    
    JButton insertarPropietario = new JButton("Insertar propietario");
    JButton buscarPropietario = new JButton("Buscar propietario");
    JButton retirarPropietario = new JButton("Retirar propietario");

    JButton insertarInmueble = new JButton("Insertar inmueble");
    JButton buscarInmueble = new JButton("Buscar inmueble");
    JButton retirarInmueble = new JButton("Retirar inmueble");

    JButton listar = new JButton("Listar");

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
    JTextField cajaRetirarInmuebleIDProp = new JTextField(5);
    JTextField cajaRetirarInmuebleIDInm = new JTextField(5);
    JTextField cajaBuscarInmuebleIdProp = new JTextField(5);
    JTextField cajaBuscarInmuebleIdInm = new JTextField(5);
    JTextField cajaListarInmueble = new JTextField(5);

    //------------- areas donde se pondra la lista-----------
    TextArea areaPanel1 = new TextArea();
    TextArea areaPanel2 = new TextArea();

    //------------------Multilista---------------------------
    Multilista multList = new Multilista();

    /**
     * Ventana principal donde se ejecutara todo el programa
     */
    public Ventana() {
        this.getContentPane().setLayout(null);

        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(false);

        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        this.getContentPane().add(panelListar, BorderLayout.CENTER);

        inicializarPanel1();
        inicializarPanel2();
        inicializarPanelListar();

        inicializarBotones();
//        inicializarAreas();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * inicializa el primer panel, donde se ubicaran los botones
     * correspondientes al propietario
     */
    void inicializarPanel1() {

        panel1.setBackground(Color.cyan);
        panel1.setSize(getWidth() / 2, getHeight() / 2);
        panel1.setLocation(0, 0);

        panel1.add(insertarPropietario);
        panel1.add(new JLabel("ID propietario"));
        panel1.add(cajaInsertarPropId);
        panel1.add(new JLabel("Nombre propietario"));
        panel1.add(cajaInsertarPropNombre);
        panel1.add(buscarPropietario);
        panel1.add(new JLabel("ID propietario"));
        panel1.add(cajaBuscarProp);
        panel1.add(retirarPropietario);
        panel1.add(new JLabel("ID propietario"));
        panel1.add(cajaRetirarProp);

//        panel1.add(areaPanel1);
    }

    /**
     * inicializa el segundo panel, donde se ubicaran los botones
     * correspondientes al inmueble
     */
    void inicializarPanel2() {

        panel2.setBackground(Color.pink);
        panel2.setSize(getWidth() / 2, getHeight() / 2);
        panel2.setLocation(0, getHeight() / 2);

        panel2.add(insertarInmueble);
        panel2.add(new JLabel("ID propietario"));
        panel2.add(cajaInsertarInmuebleIdProp);
        panel2.add(new JLabel("ID inmueble"));
        panel2.add(cajaInsertarInmuebleId);
        panel2.add(new JLabel("Nombre inmueble"));
        panel2.add(cajaInsertarInmuebleNombre);
        panel2.add(new JLabel("Valor inmueble"));
        panel2.add(cajaInsertarInmuebleValor);
        panel2.add(new JLabel("Direccion inmueble"));
        panel2.add(cajaInsertarInmuebleDireccion);
        panel2.add(buscarInmueble);
        panel2.add(new JLabel("ID propietario"));
        panel2.add(cajaBuscarInmuebleIdProp);
        panel2.add(new JLabel("ID inmueble"));
        panel2.add(cajaBuscarInmuebleIdInm);
        panel2.add(retirarInmueble);
        panel2.add(new JLabel("ID propietario"));
        panel2.add(cajaRetirarInmuebleIDProp);
        panel2.add(new JLabel("ID inmueble"));
        panel2.add(cajaRetirarInmuebleIDInm);

    }

    void inicializarPanelListar() {
        panelListar.setBackground(Color.ORANGE);
        panelListar.setSize(getWidth() / 2, getHeight());
        panelListar.setLocation(getWidth() / 2, 0);

        panelListar.add(listar);
    }

    void inicializarBotones() {
        insertarPropietario.addActionListener(this);
        buscarPropietario.addActionListener(this);
        retirarPropietario.addActionListener(this);

        insertarInmueble.addActionListener(this);
        buscarInmueble.addActionListener(this);
        retirarInmueble.addActionListener(this);

        listar.addActionListener(this);
    }

    void inicializarAreas() {
        //areaPanel1.setEnabled(false);
    }

    public boolean isInteger(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean comprobarIngreso(String datoComprobar, JPanel pn) {
        if (!isInteger(datoComprobar)) {
            JOptionPane.showMessageDialog(pn, "la cadena que ingreso no es un numero entero o tiene algún caracter");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertarPropietario) {
            if (cajaInsertarPropId.getText().equals("") || cajaInsertarPropNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(panel1, "No has llenado todos los campos");
                return;
            }
            if (comprobarIngreso(cajaInsertarPropId.getText(), panel1)) {
                return;
            }
            multList.insertarEnFila(Integer.parseInt(cajaInsertarPropId.getText()), cajaInsertarPropNombre.getText());
            cajaInsertarPropId.setText("");
            cajaInsertarPropNombre.setText("");
        }
        if (e.getSource() == buscarPropietario) {

            if (cajaBuscarProp.getText().equals("")) {
                JOptionPane.showMessageDialog(panel1, "No has ingresado Una ID para buscar");
                return;
            }
            if (comprobarIngreso(cajaBuscarProp.getText(), panel1)) {
                return;
            }
            if (multList.buscarEnFila(Integer.parseInt(cajaBuscarProp.getText()))) {
                JOptionPane.showMessageDialog(panel1, "El propietario esta en la lista");
            } else {
                JOptionPane.showMessageDialog(panel1, "El propietario no esta en la lista");
            }
            cajaBuscarProp.setText("");
        }
        if (e.getSource() == retirarPropietario) {
            if (cajaRetirarProp.getText().equals("")) {
                JOptionPane.showMessageDialog(panel1, "No has ingresado Una ID para retirar");
                return;
            }
            if (comprobarIngreso(cajaRetirarProp.getText(), panel1)) {
                return;
            }

            multList.retirarEnFila(Integer.parseInt(cajaRetirarProp.getText()));
            cajaRetirarProp.setText("");
        }
        if (e.getSource() == insertarInmueble) {
            if (cajaInsertarInmuebleIdProp.getText().equals("") || cajaInsertarInmuebleId.getText().equals("") || cajaInsertarInmuebleValor.getText().equals("") || cajaInsertarInmuebleNombre.getText().equals("") || cajaInsertarInmuebleDireccion.getText().equals("")) {
                JOptionPane.showMessageDialog(panel2, "No has llenado todos los campos");
                return;
            }
            multList.insertarAbajo(Integer.parseInt(cajaInsertarInmuebleIdProp.getText()),
                    Integer.parseInt(cajaInsertarInmuebleId.getText()),
                    Float.parseFloat(cajaInsertarInmuebleValor.getText()),
                    cajaInsertarInmuebleNombre.getText(),
                    cajaInsertarInmuebleDireccion.getText());

            //cajaInsertarInmuebleIdProp.setText("");
            cajaInsertarInmuebleId.setText("");
            cajaInsertarInmuebleValor.setText("");
            cajaInsertarInmuebleNombre.setText("");
            cajaInsertarInmuebleDireccion.setText("");
        }
        if (e.getSource() == retirarInmueble) {
            if (cajaRetirarInmuebleIDProp.getText().equals("") || cajaRetirarInmuebleIDInm.getText().equals("")) {
                JOptionPane.showMessageDialog(panel2, "Datos incompletos para retirar");
                return;
            }
            multList.retirarAbajo(Integer.parseInt(cajaRetirarInmuebleIDProp.getText()), Integer.parseInt(cajaRetirarInmuebleIDInm.getText()));

            cajaRetirarInmuebleIDProp.setText("");
            cajaRetirarInmuebleIDInm.setText("");
        }
        if (e.getSource() == buscarInmueble) {
            if (cajaBuscarInmuebleIdProp.getText().equals("") || cajaBuscarInmuebleIdInm.getText().equals("")) {
                JOptionPane.showMessageDialog(panel2, "Datos incompletos para buscar");
                return;
            }
            multList.buscarAbajo(Integer.parseInt(cajaBuscarInmuebleIdProp.getText()), Integer.parseInt(cajaBuscarInmuebleIdInm.getText()));
            cajaBuscarInmuebleIdProp.setText("");
            cajaBuscarInmuebleIdInm.setText("");
        }
        if (e.getSource() == listar) {

            JTable tabla = new JTable(multList.listar());
            //tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            //tabla.doLayout();

            JScrollPane sP = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sP.setBounds(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - 25, (getHeight() / 2) - 50);

//            sP.setHorizontalScrollBar(sP.createHorizontalScrollBar());
            JFrame venAux = new JFrame();
            venAux.getContentPane().add(sP);
            //venAux.setDefaultCloseOperation(EXIT_ON_CLOSE);
            venAux.setSize(800, 600);
            venAux.setVisible(true);

            //getContentPane().add(sP);
            //tabla.setEnabled(true);
        }

    }

}
