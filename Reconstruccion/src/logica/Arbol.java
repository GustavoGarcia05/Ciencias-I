package logica;

import java.util.ArrayList;

public class Arbol {

    private NodoArbol raiz;
    private Arbol izquierda, derecha;

    public Arbol(String valor) {
        setRaiz(new NodoArbol(valor));
        setIzquierda(null);
        setDerecha(null);
    }

    public static Arbol reconstruir(ArrayList<String> primero, int hashP, ArrayList<String> segundo, int hashS) {
        ArrayList<String> postorden, preorden, inorden;
        postorden = preorden = inorden = null;
        switch (hashing(hashP)) {
            case "inorden":
                inorden = primero;
                break;
            case "postorden":
                postorden = primero;
                break;
            case "preorden":
                preorden = primero;
                break;
            default:
                break;
        }
        switch (hashing(hashS)) {
            case "inorden":
                inorden = segundo;
                break;
            case "postorden":
                postorden = segundo;
                break;
            case "preorden":
                preorden = segundo;
                break;
            default:
                break;
        }
        if (postorden == null) {
            return reconstruccionPreInOrden(preorden, inorden);
        } else if (preorden == null) {
            return reconstruccionPostInOrden(postorden, inorden);
        } else if (inorden == null) {
            // return reconstruccionPrePostOrden(preorden,postorden);
        }
        return null;
    }

    private static Arbol reconstruccionPreInOrden(ArrayList<String> preorden, ArrayList<String> inorden) {
        if (!inorden.isEmpty()) {
            Arbol resultado = new Arbol(preorden.get(0));
            preorden.remove(0);
            ArrayList<String> subInOrdenIzquierda = new ArrayList<String>();
            ArrayList<String> subInOrdenDerecha = new ArrayList<String>();
            ArrayList<String> subPreOrdenIzquierda = new ArrayList<String>();
            ArrayList<String> subPreOrdenDerecha = new ArrayList<String>();

            while (!resultado.getRaiz().getValor().equals(inorden.get(0))) {
                subInOrdenIzquierda.add(inorden.remove(0));
            }

            inorden.remove(0);
            subInOrdenDerecha.addAll(inorden);
            for (int i = 0; i < preorden.size(); i++) {
                if (subInOrdenDerecha.contains(preorden.get(i))) {
                    subPreOrdenDerecha.add(preorden.get(i));
                } else {
                    subPreOrdenIzquierda.add(preorden.get(i));
                }
            }
            resultado.setIzquierda(reconstruccionPreInOrden(subPreOrdenIzquierda, subInOrdenIzquierda));
            resultado.setDerecha(reconstruccionPreInOrden(subPreOrdenDerecha, subInOrdenDerecha));
            return resultado;
        } else {
            return null;
        }

    }

    private static Arbol reconstruccionPostInOrden(ArrayList<String> postorden, ArrayList<String> inorden) {
        if (!inorden.isEmpty()) {
            Arbol resultado = new Arbol(postorden.get(postorden.size() - 1));
            postorden.remove(postorden.size() - 1);
            ArrayList<String> subInOrdenIzquierda = new ArrayList<String>();
            ArrayList<String> subInOrdenDerecha = new ArrayList<String>();
            ArrayList<String> subPostOrdenIzquierda = new ArrayList<String>();
            ArrayList<String> subPostOrdenDerecha = new ArrayList<String>();

            while (!resultado.getRaiz().getValor().equals(inorden.get(0))) {
                subInOrdenIzquierda.add(inorden.remove(0));
            }

            inorden.remove(0);
            subInOrdenDerecha.addAll(inorden);
            for (int i = 0; i < postorden.size(); i++) {
                if (subInOrdenDerecha.contains(postorden.get(i))) {
                    subPostOrdenDerecha.add(postorden.get(i));
                } else {
                    subPostOrdenIzquierda.add(postorden.get(i));
                }
            }
            resultado.setIzquierda(reconstruccionPostInOrden(subPostOrdenIzquierda, subInOrdenIzquierda));
            resultado.setDerecha(reconstruccionPostInOrden(subPostOrdenDerecha, subInOrdenDerecha));
            return resultado;
        } else {
            return null;
        }

    }

//	private static Arbol reconstruccionPrePostOrden(ArrayList<String> preorden, ArrayList<String> postorden) {
//		// TODO Auto-generated method stub
//		return null;
//
//	}
    private static String hashing(int id) {
        switch (id) {
            case 0:
                return "inorden";
            case 1:
                return "postorden";
            case 2:
                return "preorden";
            default:
                return "";
        }
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public Arbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Arbol izquierda) {
        this.izquierda = izquierda;
    }

    public Arbol getDerecha() {
        return derecha;
    }

    public Arbol setDerecha(Arbol derecha) {
        this.derecha = derecha;
        return derecha;
    }

    public ArrayList<String> preOrden() {
        ArrayList<String> resultado = new ArrayList<String>();
        resultado.add(getRaiz().getValor());
        if (getIzquierda() != null) {
            resultado.addAll(getIzquierda().preOrden());
        }
        if (getDerecha() != null) {
            resultado.addAll(getDerecha().preOrden());
        }
        return resultado;
    }

    public ArrayList<String> inOrden() {
        ArrayList<String> resultado = new ArrayList<String>();
        if (getIzquierda() != null) {
            resultado.addAll(getIzquierda().inOrden());
        }
        resultado.add(getRaiz().getValor());
        if (getDerecha() != null) {
            resultado.addAll(getDerecha().inOrden());
        }
        return resultado;
    }

    public ArrayList<String> postOrden() {
        ArrayList<String> resultado = new ArrayList<String>();
        if (getIzquierda() != null) {
            resultado.addAll(getIzquierda().postOrden());
        }
        if (getDerecha() != null) {
            resultado.addAll(getDerecha().postOrden());
        }
        resultado.add(getRaiz().getValor());
        return resultado;
    }

    public ArrayList<String> niveles() {
        ArrayList<String> resultado = new ArrayList<String>();
        Cola cola = new Cola();
        cola.shift(this);
        while (!cola.estaVacia()) {
            Arbol tempo = cola.unshift();
            resultado.add(tempo.getRaiz().getValor());
            if (tempo.getIzquierda() != null) {
                cola.shift(tempo.getIzquierda());
            }
            if (tempo.getDerecha() != null) {
                cola.shift(tempo.getDerecha());
            }
        }
        return resultado;
    }

    public int cantNiveles() {
        Arbol tempo = this;
        int recorrido = 1, recIzq = 0, recDer = 0;
        if (tempo.getIzquierda() != null || tempo.getDerecha() != null) {
            if (tempo.getIzquierda() != null) {
                recIzq = tempo.getIzquierda().cantNiveles();
            }
            if (tempo.getDerecha() != null) {
                recDer = tempo.getDerecha().cantNiveles();
            }
            if (recDer < recIzq) {
                return recorrido + recIzq;
            } else {
                return recorrido + recDer;
            }
        } else {
            return 0;
        }
    }
}
