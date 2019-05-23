package Modelo;

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

    Nodo insertar(int info) {
        if (buscar(info)) {
            System.out.println("nodo ya esta en la lista");
            return null;
        }
        Nodo q;
        Nodo s;

        q = null;
        s = cabeza;
        while (s != null && info > s.info) {
            if (s.info == info) {
                return null;
            }
            q = s;
            s = s.sig;
        }
        Nodo n = new Nodo(info);

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

    boolean retirar(int info) {
        boolean esta;
        esta = buscar(info);

        if (esta == false) {
            return false;
        }

        Nodo aux = null;
        Nodo q = null;
        Nodo s = cabeza;

        while (s != null && s.info <= info) {
            aux = q;
            q = s;
            s = s.sig;
        }
        //System.out.println("este es aux " + aux.info);
        //System.out.println("este es q " + q.info);

        if (s != null) {
            q.info = s.info;
            q.sig = s.sig;
        } else {

            aux.sig = null;
            q = aux;
        }
        return true;
    }

    void imprimir() {
        Nodo q = cabeza;

        while (q != null) {
            System.out.print(q.info + ", ");
            q = q.sig;
        }
    }

    boolean buscar(int info) {
        Nodo q = cabeza;
        while (q != null && q.info < info) {
            q = q.sig;
        }
        if (q != null && q.info == info) {
            return true;
        } else {
            return false;
        }

    }

    void dibujar() {
    }

    public Nodo getCabeza() {
        return cabeza;
    }

}
