/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo_2
 */
public class ArbolPrueva {

    Nodo raiz;

    public ArbolPrueva() {
        raiz = null;
    }

    /**
     */
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        Nodo p = null;      //nodo que sigue a q
        Nodo q = raiz;      //nodo q es el que recorrre el arbol

        if (raiz == null) {
            raiz = nuevo;
            return;
        } else {
            while (q != null) {
                p = q;
                if (dato == q.dato) {
                    return;
                }
                if (dato < q.dato) {
                    q = q.izq;
                    //   continue;
                } else if (dato > q.dato) {
                    q = q.der;
                    // continue;
                }
            }
            if (dato < p.dato) {
                p.izq = nuevo;
                nuevo.padre = p;
            }
            if (dato > p.dato) {
                p.der = nuevo;
                nuevo.padre = p;
            }
            raiz.balance = factorBalance(raiz);
            if (p.padre == null) {
                return;
            }
            p.balance = factorBalance(p);
            p.padre.balance = factorBalance(p.padre);
//            System.out.println("p balance " + p.balance);
            System.out.println("p padre balance " + p.padre.balance);
//            System.out.println("nuevo " + nuevo.padre.dato);
            if (p.padre.balance == -2 && p.balance == -1) {
                rotacionSimpleIzquierda(p.padre, p);
            } else if (p.padre.balance == 2 && p.balance == 1) {
                rotacionSimpleDerecha(p.padre, p);
                System.out.println(p.dato);
            } else if (p.padre.balance == -2 && p.balance == 1) {
                rotacionDobleIzquierda(p.padre, p);
            } else if (p.padre.balance == 2 && p.balance == -1) {
                rotacionDobleDerecha(p.padre, p);
            }
        }

    }

    public int factorBalance(Nodo n) {
        if (n == null) {
            return 99;
        }
        return altura(n.izq) - altura(n.der);
    }

    public int altura(Nodo n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + (Math.max(altura(n.izq), altura(n.der)));
        }
    }

    public void rotarIzq(Nodo n) {
        Nodo temp = n;

        n = temp.der;
        temp.der = n.izq;

        n.izq = temp;
    }

    public void rotarDer(Nodo n) {
        System.out.println(" rot simple der");
    }

    public void rotarIzq_Der(Nodo n) {
        System.out.println(" rot simple izq der");
    }

    public void rotarDer_Izq(Nodo n) {
        System.out.println(" rot simple der izq");
    }

    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Rotacion simple a la derecha dado un nodo padre y un hijo
     *
     * @param padre nodo padre o donde se produce el desbalanceo
     * @param hijo nodo hijo o rama donde se desbalanceo
     */
    public void rotacionSimpleDerecha(Nodo padre, Nodo hijo) {
//        Nodo abuelo = padre.padre;
        padre.izq = hijo.der;
        hijo.der = padre;
        /* Posible rotacion 
        if (padre.padre == null) { // asignacion de raiz  a la rotacion
            raiz = hijo;
        }
        abuelo.izq = hijo;
        hijo.padre = padre.padre;
        padre.padre = hijo;
        */
        padre.balance = factorBalance(padre);
        hijo.balance = factorBalance(hijo);
        System.out.println("new balance padre: " + padre.balance);
        System.out.println("new balance hijo: " + hijo.balance);
    }

    /**
     * Rotacion simple a la izquierda dado un nodo padre y un hijo
     *
     * @param padre nodo padre o donde se produce el desbalanceo
     * @param hijo nodo hijo o rama donde se desbalanceo
     */
    public void rotacionSimpleIzquierda(Nodo padre, Nodo hijo) {
        padre.balance = 0;
        hijo.balance = 0;
        padre.der = hijo.izq;
        hijo.izq = padre;
    }

    /**
     * Rotacion doble a la derecha dado un nodo padre y un hijo
     *
     * @param padre nodo padre o donde se produce el desbalanceo
     * @param hijo nodo hijo o rama donde se desbalanceo
     */
    public Nodo rotacionDobleDerecha(Nodo padre, Nodo hijo) {

        Nodo r;

        r = hijo.der;
        hijo.der = r.izq;
        r.izq = hijo;
        padre.izq = r.der;
        r.der = padre;
        switch (r.balance) {
            case -1:
                hijo.balance = 1;
                padre.balance = 0;
                break;
            case 0:
                hijo.balance = padre.balance = 0;
                break;
            case 1:
                hijo.balance = 0;
                padre.balance = -1;
                break;
        }
        r.balance = 0;
        return r;
    }

    /**
     * Rotacion doble a la izquierda dado un nodo padre y un hijo
     *
     * @param padre nodo padre o donde se produce el desbalanceo
     * @param hijo nodo hijo o rama donde se desbalanceo
     */
    public Nodo rotacionDobleIzquierda(Nodo padre, Nodo hijo) {
        Nodo r;

        r = hijo.izq;
        hijo.izq = r.der;
        r.der = hijo;
        padre.der = r.izq;
        r.izq = padre;
        switch (r.balance) {
            case -1:
                hijo.balance = 0;
                padre.balance = 1;
                break;
            case 0:
                hijo.balance = padre.balance = 0;
                break;
            case 1:
                hijo.balance = -1;
                padre.balance = 0;
                break;
        }
        r.balance = 0;
        return r;
    }

}

/*
    public void insertar(int d) {
        Nodo nuevo = new Nodo(d);
        if (raiz == null) {
            raiz = nuevo;
            return;
        } else {
            Nodo p = raiz;
            Nodo q = null;

            while (p != null) {
                if (d == p.dato) {
                    JOptionPane.showMessageDialog(null, "El nodo ya existe");
                    return;
                }

                if (d < p.dato) {
                    q = p;
                    p = p.izq;
                }else if(d>p.dato){
                    q=p;
                    p=p.der;
                }
            }
            //insercion del nodo 
            if(d<q.dato){
                q.izq=nuevo;
                nuevo.padre=q;
            }
            if(d>q.dato){
                q.der=nuevo;
                nuevo.padre=q;
            }
            //Equilibrar el arbol
            if(q==raiz){
                System.out.println("en proceso");
            }
            if(q.padre.balance==-2 &&q.balance==-1 ){
                rotacionIzq();
            }
            if(q.padre.balance==2 &&q.balance==1 ){
                rotacionDer();
            }
            if(q.padre.balance==-2 &&q.balance==1 ){
                rotacionIzq_Der();
            }
            if(q.padre.balance==2 &&q.balance==-1 ){
                rotacionDer_izq();
            }
            
            
        }

    }
    
    public int calcularBalance(Nodo acutual){
        int balance=0;
        if(acutual.izq==null){
            return balance=3;
        }
        balance=altura(acutual.izq)-altura(acutual.der);
        
        return balance;
    }
    public int altura(Nodo c){
        int altura=0;
        if(c==null){
            return altura;
        }
        altura=Math.max(altura(c.izq), altura(c.der))+1;
        return altura;
    }

    public void rotacionIzq() {

    }

    public void rotacionDer() {

    }

    public void rotacionIzq_Der() {

    }

    public void rotacionDer_izq() {

    }*/
