package logica;

public class Cola {

    Nodo cabecera, centinela;

    public Cola() {
        cabecera = new Nodo();
        centinela = null;
        cabecera.setSiguiente(centinela);
    }

    public boolean estaVacia() {
        return cabecera.getSiguiente() == null;
    }

    public void shift(Arbol valor) {
        Nodo tempo = new Nodo(valor);
        if (estaVacia()) {
            cabecera.setSiguiente(tempo);
        } else {
            centinela = cabecera.getSiguiente();
            while (centinela.getSiguiente() != null) {
                centinela = centinela.getSiguiente();
            }
            centinela.setSiguiente(tempo);
        }
    }

    public Arbol unshift() {
        if (estaVacia()) {
            return null;
        } else {
            Nodo tempo = cabecera;
            centinela = cabecera.getSiguiente();
            Arbol resultado = centinela.getValor();
            tempo.setSiguiente(centinela.getSiguiente());
            return resultado;
        }
    }
}
