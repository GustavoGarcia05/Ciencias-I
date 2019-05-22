/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo_2
 */
public class Lista {

    Nodo cabeza;

    public Lista() {
        cabeza = null;
    }

    Nodo insertar(Nodo p, int d) {
        Nodo q;
        Nodo s;

        q = null;
        s = p;

        while (s != null && d > s.info) {
            if (s.info == d) {
                return null;
            }
            q = s;
            s = s.sig;
        }
        Nodo n = new Nodo(d);

        if (q == null) {
            n.sig = p;
            p = n;
        }else if(s==null){
            q.sig=n;
        }else{
            n.sig=s;
            q.sig=n;
        }
        return p;
    }

    boolean retirar() {
        return false;
    }

    void imprimir() {

    }

    boolean buscar(int d) {
        return false;
    }

}
