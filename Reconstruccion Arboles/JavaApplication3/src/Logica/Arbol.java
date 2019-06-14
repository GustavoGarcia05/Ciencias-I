package Logica;

import Controlador.ControladorBoton;

public class Arbol {
    
	
    private NodoArbol raiz, nodo, temp;
    private int r, hijos=0;
    private String pos, in, valor, pre;
    private Cola cola;
    private NodoFifo n;
    private ControladorBoton controladorBoton;
	
    public Arbol(String in, String pos, String pre, ControladorBoton boton){
	controladorBoton = boton;
	this.pre = pre;
	this.pos=pos;
	this.in=in;
	cola = new Cola(); //Crea una cola
	if(pos!=null){//condicion para saber si es en posorden o preorden
            raiz=new NodoArbol(""+pos.charAt(pos.length()-1));//inserta el ultimo digito del textfield de pos			
	}else{
            raiz= new NodoArbol(""+pre.charAt(0));//inserta el primer digito del textfield de pre
	}		
    }
	
    public void reconstruir(){//Reconstruye el arbol en posorden
	r = in.indexOf(pos.charAt(pos.length()-1));// Toma el valor de la raiz del ultimo valor de la string pos
	hijos++; //incrementador de hijos
	if(!in.substring(0,r).equals("")) // condicion para saber si el string in no es vacia y lo delimita a una subcadena entre in hasta el valor de raiz
            cola.insertar(in.substring(0, r), pos.substring(0,r), 'i', "" + pos.charAt(pos.length()-1), hijos); //inserta dentro de la cola la info que esta a la izq de de la raiz(Strings pos-in)
        hijos++; //incrementa hijos
        if(!in.substring(r+1,in.length()).equals("")) //condicion para saber si despues de la raiz no esta vacio
            cola.insertar(in.substring(r + 1, in.length()), pos.substring(r, pos.length()-1), 'd', "" + pos.charAt(pos.length()-1), hijos); //inserta dentro de la cola la info que esta a la der de de la raiz(Strings pos-in)
        controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().dibujarNodo(controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().getGraphics(), raiz.getInfo(), 'n', ""+pos.charAt(pos.length()-1)); //dibuja la raiz
        temp = raiz; //Asigna a temp la raiz
        while(!cola.estaVacia()){ //mientras que la cola no este vacia
            hijos = 0; //asigna cero hijos
            n = cola.getCab(); // asigna la cabecera de la cola
            cola.retirar();//retira tipo fifo
            System.out.println("Datos del nodo retirado: \n In: " + n.getIn() + " Pos: " + n.getPos() + " i/d: " + n.getC() + " Padre: " + n.getPadre() + " Num H: " + n.getHijos());
            valor = "" + n.getPos().charAt(n.getPos().length()-1); // asigna a la cadena valor el nuevo valor del nodoFifo en n.getPos toma el ultimo
            r = n.getIn().indexOf(n.getPos().charAt(n.getPos().length()-1));//toma el valor indexado de la cadena "valor"
            System.out.println("Letra :"+n.getPos().charAt(n.getPos().length()-1));
            controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().dibujarNodo(controladorBoton.getPanelControles().getVentana().getPanelArbol().getLienzo().getGraphics(), valor, n.getC(), n.getPadre()); // dibuja el hijo de la raiz
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
	
    public void reconstruirPre(){ // Reconstruye el arbol en PreOrden
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
