
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

    private Nodo cabeza;

    public Lista() {
        cabeza = null;
    }

    Nodo insertar(int d) {
        if(buscar(d)){
            System.out.println("ya esta el numero");
            return null; 
        }
        Nodo q;
        Nodo s;

        q = null;
        s = cabeza;
        while (s != null && d > s.info) {
            if (s.info == d) {
                return null;
            }
            q = s;
            s = s.sig;
        }
        Nodo n = new Nodo(d);

        if (q == null) {
            n.sig = cabeza;
            cabeza = n;
        } else if (s == null) {
            q.sig = n;
        } else {
            n.sig = s;
            q.sig = n;
        }
        return cabeza;
    }

    boolean retirar(int d) {
        boolean esta;
        esta = buscar(d);

        if (esta == false) {
            return false;
        }

        Nodo aux = null;
        Nodo q = null;
        Nodo s = cabeza;

        while (s != null && s.info <= d) {
            aux = q;
            q = s;
            s = s.sig;
        }
        System.out.println("este es aux " + aux.info);
        System.out.println("este es q " + q.info);

        if (s != null) {
            q.info = s.info;
            q.sig = s.sig;
        } else {
            
            aux.sig=null;
            q=aux;
        }
        return true;
    }

    void imprimir() {
        Nodo q = cabeza;

        while (q != null) {
            System.out.println(q.info);
            q = q.sig;
        }
    }

    boolean buscar(int d) {
        Nodo q = cabeza;
        while (q != null && q.info < d) {
            q = q.sig;
        }
        if (q != null && q.info == d) {
            return true;
        } else {
            return false;
        }

    }
    
    void dibujar(){
        new Ventana(this);
    }

    public Nodo getCabeza() {
        return cabeza;
    }

}
