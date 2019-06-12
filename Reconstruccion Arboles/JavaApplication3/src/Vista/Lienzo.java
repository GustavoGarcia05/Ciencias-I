 package Vista;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import Logica.NodoArreglo;

public class Lienzo extends Canvas{
	
	private Color color;
	int x=2,x1=2, y=7, y1=1, pass=0;
	char c;
	private ArrayList<NodoArreglo> nodoArreglo;
	private NodoArreglo nodo, temp;
	
	public Lienzo(){
		setBackground(color.white);
		setSize(1000,800);
		nodoArreglo = new ArrayList<NodoArreglo>();
	}
	
	public void dibujarNodo(Graphics g,String valor, char c, String padre){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(2.0f));
			
		}
		nodo= new NodoArreglo();
		if(pass>=4){
			x1=4;
		}
		if(c=='n'){
			nodo.setPadre(valor);
			nodo.setX(this.getWidth()/2);
			nodo.setY(this.getHeight()/7);
			x=this.getWidth()/2;
			y=this.getHeight()/7;
			
		}
		if(c=='i'){
			temp=nodoArreglo.get(buscar(padre));
			System.out.println("index de padre: "+buscar(padre));
			x=temp.getX()-(nivel(temp.getY()));
			y=temp.getY()+100;
			g.drawLine(temp.getX(), temp.getY(), x, y);
			nodo.setPadre(valor);
			nodo.setX(x);
			nodo.setY(y);
		}
		if(c=='d'){
			temp=nodoArreglo.get(buscar(padre));
			System.out.println("index de padre: "+buscar(padre));
			x=temp.getX()+(nivel(temp.getY()));
			y=temp.getY()+100;
			g.drawLine(temp.getX(), temp.getY(), x, y);
			nodo.setPadre(valor);
			nodo.setX(x);
			nodo.setY(y);			
		}
		g.setColor(Color.yellow);
		g.fillOval(x, y, 30, 30);
		g.setColor(Color.black);
		g.drawString(""+valor, x+12, y+20);
		if(pass>=1){
			g.drawLine((x1*(this.getWidth()/x)), (y1*(this.getHeight()/y)), (x1*(this.getWidth()/x)), (y1*(this.getHeight()/y)));			
		}
		
		nodoArreglo.add(nodo);
		//pass++;
	}
	
	public int buscar(String padre){
		for(int i=0; i<=nodoArreglo.size();i++){
			if(nodoArreglo.get(i).getPadre().equals(padre)){
				return i;				
			}
		}
		return -1;
	}
	
	public int nivel(int y){
		if(y==(this.getHeight()/7)){
			return 250;
		}
		if(y==(this.getHeight()/7+100)){
			return 125;						
		}
		if(y==(this.getHeight()/7+200)){
			return 62;			
		}
		if(y==(this.getHeight()/7+300)){
			return 31;
		}
		if(y==(this.getHeight()/7+400)){
			return 15;
		}
		if(y==(this.getHeight()/7+500)){
			return 7;			
		}
		return 0;		
	}
	
	public void Borrar(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, 1000, 800);		
	}
	
	

}
