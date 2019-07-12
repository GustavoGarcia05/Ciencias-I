/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.AVL;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class ArbolAVL {
        public NodoAVL raiz;

    public ArbolAVL() {
        raiz = null;
    }

    //Buscar
    public NodoAVL buscar(int d, NodoAVL r) {
        if (raiz == null) {
            return null;
        } else if (r.dato == d) {
            return r;
        } else if (r.dato < d) {
            return buscar(d, r.der);
        } else {
            return buscar(d, r.izq);
        }
    }

    //obtener factor de equilibrio
    public int obtenerBalace(NodoAVL x) {
        if (x == null) {
            return -1;
        } else {
            return x.balance;
        }
    }

    //Rotacion simple izquierda
    public NodoAVL rotacionIzq(NodoAVL c) {
        NodoAVL auxiliar = c.izq;
        c.izq = auxiliar.der;
        auxiliar.der = c;
        c.balance = Math.max(obtenerBalace(c.izq), obtenerBalace(c.der)) + 1;
        auxiliar.balance = Math.max(obtenerBalace(auxiliar.izq), obtenerBalace(auxiliar.der)) + 1;
        return auxiliar;
    }

    //Rotacion simple izquierda
    public NodoAVL rotacionDer(NodoAVL c) {
        NodoAVL auxiliar = c.der;
        c.der = auxiliar.izq;
        auxiliar.izq = c;
        c.balance = Math.max(obtenerBalace(c.izq), obtenerBalace(c.der)) + 1;
        auxiliar.balance = Math.max(obtenerBalace(auxiliar.izq), obtenerBalace(auxiliar.der)) + 1;
        return auxiliar;
    }

    //Rotacion Doble a la inquierda
    public NodoAVL rotacionDobleIzq(NodoAVL c) {
        NodoAVL temporal;
        c.izq = rotacionDer(c.izq);
        temporal = rotacionIzq(c);
        return temporal;
    }

    //Rotacion Doble a la derecha
    public NodoAVL rotacionDobleDer(NodoAVL c) {
        NodoAVL temporal;
        c.der = rotacionIzq(c.der);
        temporal = rotacionDer(c);
        return temporal;
    }
    //Metodo para insertar nodo

    public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subAr) {
        NodoAVL nuevoPadre = subAr;
        if (nuevo.dato < subAr.dato) {
            if (subAr.izq == null) {
                subAr.izq = nuevo;
            } else {
                subAr.izq = insertarAVL(nuevo, subAr.izq);
                if ((obtenerBalace(subAr.izq) - obtenerBalace(subAr.der) == 2)) {
                    if (nuevo.dato < subAr.izq.dato) {
                        nuevoPadre = rotacionIzq(subAr);
                    } else {
                        nuevoPadre = rotacionDobleIzq(subAr);
                    }
                }
            }
        } else if (nuevo.dato > subAr.dato) {
            if (subAr.der == null) {
                subAr.der = nuevo;
            } else {
                subAr.der = insertarAVL(nuevo, subAr.der);
                if ((obtenerBalace(subAr.der) - obtenerBalace(subAr.izq) == 2)) {
                    if (nuevo.dato > subAr.der.dato) {
                        nuevoPadre = rotacionDer(subAr);
                    } else {
                        nuevoPadre = rotacionDobleDer(subAr);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nodo ya existe");
        }
        //Actualizando la altura
        if ((subAr.izq == null) && (subAr.der != null)) {
            subAr.balance = subAr.der.balance + 1;
        } else if ((subAr.der == null) && (subAr.izq != null)) {
            subAr.balance = subAr.izq.balance + 1;
        } else {
            subAr.balance = Math.max(obtenerBalace(subAr.izq), obtenerBalace(subAr.der)) + 1;
        }

        return nuevoPadre;
    }
    
    //Metodo insertar
    public void insertar(int d){
        NodoAVL nuevo= new NodoAVL(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo, raiz);
        }
    }
    
}
