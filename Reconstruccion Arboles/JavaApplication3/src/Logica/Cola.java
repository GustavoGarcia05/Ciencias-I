package Logica;

public class Cola {
	
	private NodoFifo cab=null, cola=null, penu=null;
	private String post, in;
	private int con=1;
	
	public Cola(){
		cola = new NodoFifo();
		cab=cola;
	}
	
	public void insertar(String in, String pos, char c, String padre, int hijos){
		
		NodoFifo n = new NodoFifo();
		
		if(cab==cola){
			cab=n;
		}else{
			penu.setSig(n);
		}		
		n.setSig(cola);
		n.setIn(in);
		n.setPos(pos);
		n.setC(c);
		n.setPadre(padre);
		n.setHijos(hijos);
		penu=n;
		
	}
	
	public void retirar(){
		if(cab==cola){
			System.out.println("La cola esta vacia!");
		}else{
			cab=cab.getSig();	
			System.out.println("Se retiro un nodo");
		}		
	}
	
	public boolean estaVacia(){
		if(cab==cola){
			return true;			
		}else{
			return false;					
		}		
	}

	public NodoFifo getCab() {
		return cab;
	}
	
	public NodoFifo getCola(){
		return cola;
	}
	
	

}
