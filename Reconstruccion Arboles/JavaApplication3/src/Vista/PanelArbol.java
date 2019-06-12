package Vista;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelArbol extends JPanel{
	
	public Lienzo lienzo;
	
	public PanelArbol(Ventana v){
		lienzo =new Lienzo();
		setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10), new TitledBorder("Arbol")));
		setLayout(new FlowLayout());
		add(lienzo);
	}

	public Lienzo getLienzo() {
		return lienzo;
	}
}
