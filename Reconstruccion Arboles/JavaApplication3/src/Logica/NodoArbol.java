package Logica;

public class NodoArbol {
	
		String info;
		NodoArbol izq;
		NodoArbol der;
		NodoArbol(String info){
			this.info=info;
			izq=null;
			der=null;
		}
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
		public NodoArbol getIzq() {
			return izq;
		}
		public void setIzq(NodoArbol izq) {
			this.izq = izq;
		}
		public NodoArbol getDer() {
			return der;
		}
		public void setDer(NodoArbol der) {
			this.der = der;
		}	

}
