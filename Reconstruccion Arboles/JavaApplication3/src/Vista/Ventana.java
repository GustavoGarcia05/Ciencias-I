package Vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	private PanelControles panelControles;
	private PanelArbol panelArbol;
	
	public Ventana(){
		setLayout(new BorderLayout());	
		panelControles = new PanelControles(this);
		panelArbol = new PanelArbol(this);
		add(panelControles, BorderLayout.SOUTH);
		add(panelArbol, BorderLayout.CENTER);
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
		setSize(1150,800);	
	}
	
	public PanelArbol getPanelArbol(){
		return panelArbol;
	}

}
