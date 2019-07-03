package logica;

public class Nodo {

    private Arbol valor;
    private Nodo siguiente;

    public Nodo() {
        this.setSiguiente(null);
    }

    public Nodo(Arbol valor) {
        this.setValor(valor);
        this.setSiguiente(null);
    }

    public Arbol getValor() {
        return valor;
    }

    public void setValor(Arbol valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
