/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gustavo_2
 */
public class Multilista {

    NodoNum cab;

    public Multilista() {
        this.cab = null;
    }

    /**
     * inserta un valor en las cabezas de la multilista, lo que corresponderia a
     * la primera fila de la matriz.
     *
     * @param dato lo que se quiere insertar.
     */
    boolean insertarCabeza(int dato) {
        if (this.buscarCabeza(dato)) {
            System.out.println("El nodo ya esta en la lista");
            return false;
        }

        NodoNum nodoInsertar = new NodoNum(dato);
        NodoNum s = this.cab;   //variable auxiliar 1
        NodoNum q = null;       //variable auxiliar 2

        while (s != null && s.info < dato) {
            q = s;
            s = q.sig;
        }

        if (q == null) {
            nodoInsertar.sig = this.cab;
            this.cab = nodoInsertar;
        } else if (s == null) {
            q.sig = nodoInsertar;
        } else {
            nodoInsertar.sig = s;
            q.sig = nodoInsertar;
        }
        return true;

    }

    /**
     * inserta un valor en la multilista, dado una cabeza y despues lo inserta
     * creando un nodo siguiente al ultimo nodo.
     *
     * @param cabeza posicion de la primera fila en la cual se quiere insertar
     * el dato.
     * @param dato lo que se quiere insertar.
     */
    boolean insertarAbajo(int cabeza, String dato) {
        NodoNum p = cab;
        while (p != null && p.info < cabeza) {
            p = p.sig;
        }
        if (p == null) {
            //System.out.println("no existe");
            return false;
        }
        if (p.info == cabeza) {
            NodoN s, q;
            s = null;
            q = p.abajo;
            while (q != null) {
                s = q;
                q = q.abajo;
            }
            if (s == null) {
                NodoN n = new NodoN(dato);
                p.abajo = n;
                return true;
            }
            NodoN n = new NodoN(dato);
            s.abajo = n;
            return true;
        }//p.i==x
        else {
            //System.out.println("no lo encontro");
            return false;
        }
    }

    /**
     * busca un valor en la multilista.
     *
     * @param dato lo que se quiere buscar.
     */
    boolean buscarCabeza(int dato) {
        NodoNum aux = this.cab;
        while (aux != null && aux.info < dato) {
            aux = aux.sig;
        }
        if (aux != null && aux.info == dato) {
            //System.out.println("el elemento se encontro");
            return true;
        } else {
            //System.out.println("el elemento no esta");
            return false;
        }
    }

    /**
     * busca un valor en la multilista.
     *
     * @param cabeza posicion de la primera fila en la cual se quiere buscar el
     * dato.
     * @param dato lo que se quiere buscar.
     */
    int buscarAbajo(int cabeza, String dato) {
        return 0;
    }

    /**
     * Imprime los datos de la multilista
     *
     * @param dato posicion que quiere listar.
     * @return retorna -1 o 1
     */
    int listarAbajo(int dato) {
        NodoNum p = cab;
        while (p != null && p.info < dato) {
            p = p.sig;
        }
        if (p == null) {
            System.out.println("no existe");
            return -1;
        }
        if (p.info == dato) {
            NodoN q;
            q = p.abajo;
            while (q != null) {
                System.out.println(q.n);
                q = q.abajo;
            }
        } else {
            System.out.println("no lo encontro");
            return -1;
        }
        return 1;
    }

    int retirar() {
        return 0;
    }
}
