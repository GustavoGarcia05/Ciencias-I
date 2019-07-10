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

    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        Nodo q = raiz;
        Nodo p = null;

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
                    continue;
                }
                if (dato > q.dato) {
                    q = q.der;
                    continue;
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
            p.balance = factorBalance(p);
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
