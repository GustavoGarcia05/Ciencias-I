package Vista;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Controlador.ControladorBoton;

public class PanelControles extends JPanel{
	
	private JLabel inOrden, postOrden, preOrden;
	private JTextField txtInOrden, txtPostOrden, txtPreOrden;
	private JButton btnEjecutar, btnPreOrden, btnPostOrden, btnBorrar;
	private ControladorBoton controladorBoton;
	private Ventana ventana;
	
	public PanelControles(Ventana v){
		ventana = v;
		inOrden = new JLabel("Inorden: ");
		postOrden = new JLabel("PostOrden: ");
		preOrden = new JLabel("PreOrden");
		txtInOrden = new JTextField(10);
		txtPostOrden = new JTextField(10);
		txtPreOrden = new JTextField(10);
		txtInOrden.setText("");
		txtPostOrden.setText("");
		btnEjecutar = new JButton("Dibujar");
		btnPreOrden = new JButton("PreOrden");
		btnPostOrden = new JButton("PostOrden");
		btnBorrar = new JButton("Limpiar");
		controladorBoton = new ControladorBoton(this);
		setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new TitledBorder("Controles")));
		setLayout(new FlowLayout());
		btnEjecutar.addActionListener(controladorBoton);
		btnPreOrden.addActionListener(controladorBoton);
		btnPostOrden.addActionListener(controladorBoton);
		btnBorrar.addActionListener(controladorBoton);
		txtPreOrden.setEditable(false);
		add(inOrden);
		add(txtInOrden);
		add(postOrden);
		add(txtPostOrden);
		add(preOrden);
		add(txtPreOrden);
		add(btnEjecutar);		
		add(btnPreOrden);
		add(btnPostOrden);
		add(btnBorrar);
	}
	
	public JTextField getTxtPreOrden() {
		return txtPreOrden;
	}

	public Ventana getVentana(){
		return ventana;
		
	}

	public JTextField getTxtInOrden() {
		return txtInOrden;
	}

	public JTextField getTxtPostOrden() {
		return txtPostOrden;
	}

	public JButton getBtnEjecutar() {
		return btnEjecutar;
	}

	public JButton getBtnPreOrden() {
		return btnPreOrden;
	}

	public JButton getBtnPostOrden() {
		return btnPostOrden;
	}
	
	public JButton getBtnBorrar() {
		return btnBorrar;
	}

}
