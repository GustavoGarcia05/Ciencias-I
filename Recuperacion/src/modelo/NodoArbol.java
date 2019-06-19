package modelo;

/**
 *
 * @author estudiantes
 */
public class NodoArbol {

    private char c;
    private NodoArbol izq;
    private NodoArbol der;

    public NodoArbol(char info) {
        c = info;
        izq = der = null;
    }

}