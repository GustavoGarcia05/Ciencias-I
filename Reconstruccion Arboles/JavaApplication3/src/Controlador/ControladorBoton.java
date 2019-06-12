package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Arbol;
import Vista.PanelControles;

public class ControladorBoton implements ActionListener {
	
	private PanelControles panelControles;
	private Arbol arbol;
	private boolean pos=true;
	
	public ControladorBoton(PanelControles p){
		panelControles = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				
		if(e.getSource()==panelControles.getBtnEjecutar()){
			if(pos){
				arbol=new Arbol(panelControles.getTxtInOrden().getText(), panelControles.getTxtPostOrden().getText(),null , this);
				arbol.reconstruir();
			}
			else{
				arbol=new Arbol(panelControles.getTxtInOrden().getText(),null , panelControles.getTxtPreOrden().getText(), this);
				arbol.reconstruirPre();
			}
		}
		if(e.getSource()==panelControles.getBtnPreOrden()){
			System.out.println("PreOrden");
			panelControles.getTxtPostOrden().setEditable(false);
			panelControles.getTxtPreOrden().setEditable(true);
			panelControles.getTxtPreOrden().setText("");
			pos=false;			
		}
		if(e.getSource()==panelControles.getBtnPostOrden()){
			System.out.println("PostOrden");
			panelControles.getTxtPostOrden().setEditable(true);
			panelControles.getTxtPreOrden().setEditable(false);
			panelControles.getTxtPostOrden().setText("");
			pos=true;
		}
		if(e.getSource()==panelControles.getBtnBorrar()){
			System.out.println("Borrar Funcionando");
			panelControles.getVentana().getPanelArbol().getLienzo().Borrar(panelControles.getVentana().getPanelArbol().getLienzo().getGraphics());
		}		
		
	}

	public PanelControles getPanelControles(){
		return panelControles;
	}
}
