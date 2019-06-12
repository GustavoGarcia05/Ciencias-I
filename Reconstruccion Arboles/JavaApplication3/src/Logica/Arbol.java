package Logica;

import Controlador.ControladorBoton;

public class Arbol {
	
	private NodoArbol raiz, nodo, temp;
	private int r, hijos=0;
	private String pos, in, valor, pre;
	private Cola cola;
	private NodoFifo n;
	private ControladorBoton controladorBoton;
	
	public Arbol(String in, String pos,String pre, ControladorBoton boton){
		controladorBoton = boton;
		this.pre = pre;
		this.pos=pos;
		this.in=in;
		cola =new Cola();
		if(pos!=null){
			raiz=new NodoArbol(""+pos.charAt(pos.length()-1));			
		}else{
			raiz= new NodoArbol(""+pre.charAt(0));
		}
		
	}
	
	public void reconstruir(){
		r=in.indexOf(pos.charAt(pos.length()-1));
		hijos++;
		if(!in.substring(0,r).equals(""))
			cola.insertar(in.substring(0, r), pos.substring(0,r), 'i', ""+pos.charAt(pos.length()-1), hijos);
		hijos++;
		if(!in.substring(r+1,in.length()).equals(""))
			cola.insertar(in.substring(r+1, in.length()), pos.substring(r, pos.length()-1), 'd', ""+pos.charAt(pos.length()-1), hijos);
		controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().dibujarNodo(controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().getGraphics(), raiz.getInfo(), 'n', ""+pos.charAt(pos.length()-1));
		temp=raiz;
		while(!cola.estaVacia()){
			hijos=0;
			n=cola.getCab();
			cola.retirar();
			System.out.println("Datos del nodo retirado: \n In: "+n.getIn()+" Pos: "+n.getPos()+" i/d: "+n.getC()+" Padre: "+n.getPadre()+" Num H: "+n.getHijos());
			valor=""+n.getPos().charAt(n.getPos().length()-1);
			r=n.getIn().indexOf(n.getPos().charAt(n.getPos().length()-1));
			System.out.println("Letra :"+n.getPos().charAt(n.getPos().length()-1));
			controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().dibujarNodo(controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().getGraphics(), valor, n.getC(), n.getPadre());
			if(!n.getIn().substring(0,r).equals("")){
				hijos++;
				cola.insertar(n.getIn().substring(0,r) , n.getPos().substring(0,r), 'i', valor, hijos );
			}
			if(!n.getIn().substring(r+1,n.getIn().length()).equals("")){
				hijos++;
				cola.insertar(n.getIn().substring(r+1,n.getIn().length()), n.getPos().substring(r, n.getPos().length()-1), 'd', valor, hijos);				
			}
			
			
			nodo = new NodoArbol(valor);
			System.out.println("Valor: "+valor+"\n der/izq: "+n.getC()+"\n r: "+r);
			if(n.getC()=='d'){
				temp.setDer(nodo);
				temp=nodo;
			}else{
				temp.setIzq(nodo);
				temp=nodo;
			}
		}
		recorrerInOrden(raiz);
	}
	
	public void reconstruirPre(){
		r=in.indexOf(pre.charAt(0));
		if(!in.substring(0,r).equals(""))
			cola.insertar(in.substring(0, r), pre.substring(1,r+1), 'i', ""+pre.charAt(0), hijos);
		if(!in.substring(r+1,in.length()).equals(""))
			cola.insertar(in.substring(r+1, in.length()), pre.substring(r+1, pre.length()), 'd', ""+pre.charAt(0), hijos);
		controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().dibujarNodo(controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().getGraphics(), raiz.getInfo(), 'n', ""+pre.charAt(0));
		temp=raiz;
		while(!cola.estaVacia()){
			n=cola.getCab();
			cola.retirar();
			System.out.println("Datos del nodo retirado: \n In: "+n.getIn()+" Pre: "+n.getPos()+" i/d: "+n.getC()+" Padre: "+n.getPadre()+" Num H: "+n.getHijos());
			valor=""+n.getPos().charAt(0);
			r=n.getIn().indexOf(n.getPos().charAt(0));
			System.out.println("Letra :"+n.getPos().charAt(n.getPos().length()-1));
			controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().dibujarNodo(controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().getGraphics(), valor, n.getC(), n.getPadre());
			if(!n.getIn().substring(0,r).equals("")){
				cola.insertar(n.getIn().substring(0,r) , n.getPos().substring(1,r+1), 'i', valor, hijos );
			}
			if(!n.getIn().substring(r+1,n.getIn().length()).equals("")){
				cola.insertar(n.getIn().substring(r+1,n.getIn().length()), n.getPos().substring(r+1, n.getPos().length()), 'd', valor, hijos);				
			}			
			
			nodo = new NodoArbol(valor);
			System.out.println("Valor: "+valor+"\n der/izq: "+n.getC()+"\n r: "+r);
			if(n.getC()=='d'){
				temp.setDer(nodo);
				temp=nodo;
			}else{
				temp.setIzq(nodo);
				temp=nodo;
			}
		}		
	}
	
	public void recorrerInOrden(NodoArbol r){
		if(r!=null){
			recorrerInOrden(r.getIzq());
			System.out.print(r.getInfo()+"");
			recorrerInOrden(r.getDer());			
		}

	}
	
	public NodoArbol getNodoArbol(){
		return nodo;
	}
	
}
