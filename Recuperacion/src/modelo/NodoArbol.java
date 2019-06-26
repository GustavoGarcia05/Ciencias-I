package modelo;

/**
 *
 * @author estudiantes
 */
public class NodoArbol {

    public char info;
    public NodoArbol izq;
    public NodoArbol der;

    public NodoArbol(char info) {
        this.info = info;
        izq = der = null;
    }

}