package Logica;

public class NodoFifo {

	private char c;
	private String in;
	private String pos;
	private NodoFifo sig;
	private String padre;
	private int hijos=0;
	
	
	public String getPadre() {
		return padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
	}

	public int getHijos() {
		return hijos;
	}

	public void setHijos(int hijos) {
		this.hijos = hijos;
	}

	public NodoFifo(){
		
	}
	
	public NodoFifo getSig(){
		return sig;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setSig(NodoFifo sig) {
		this.sig = sig;
	}
}
