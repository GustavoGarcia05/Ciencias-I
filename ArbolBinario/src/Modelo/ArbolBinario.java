/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author estudiantes
 */
public class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public boolean buscar(int dato) {
        Nodo p = raiz;
        while (p != null) {
            if (p.info < dato) {
                p = p.der;
            } else if (p.info > dato) {
                p = p.izq;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = new Nodo(dato);
            return true;
        } else {
            Nodo anterior = null, recorrido;
            recorrido = raiz;
            while (recorrido != null) {
                anterior = recorrido;
                if (dato < recorrido.info) {
                    recorrido = recorrido.izq;
                } else {
                    recorrido = recorrido.der;
                }
            }
            if (dato < anterior.info) {
                anterior.izq = nuevo;
            } else {
                anterior.der = nuevo;
            }
        }
        return true;
    }

    public void retirar() {

    }

    public String preOrden() {
        String arreglo = "";
        Stack<Nodo> pila = new Stack<>();
        Nodo nodo = raiz;
        while (nodo != null) {
            arreglo += nodo.info + ", ";
            pila.add(nodo);
            nodo = nodo.izq;
        }
        while (!pila.isEmpty()) {
            nodo = pila.pop();
            nodo = nodo.der;
            while (nodo != null) {
                arreglo += nodo.info + ", ";
                pila.add(nodo);
                nodo = nodo.izq;
            }
        }
        return arreglo;
    }

    /**
     * recorre el arbol en inorden
     *
     * @return un string con el recorrido del arbol
     */
    public String inOrden() {
        String arreglo = "";
        Stack<Nodo> pila = new Stack<>();
        Nodo nodo = raiz;
        while (nodo != null) {
            pila.add(nodo);
            nodo = nodo.izq;
        }
        while (!pila.isEmpty()) {
            nodo = pila.pop();
            arreglo += nodo.info + ", ";
            nodo = nodo.der;
            while (nodo != null) {
                pila.add(nodo);
                nodo = nodo.izq;
            }
        }
        return arreglo;
    }

    /**
     * recorre el arbol en postOrden
     *
     * @return un string con el recorrido del arbol
     */
    public String postOrden() {
        String arreglo = "";
        Stack<Nodo> pila = new Stack<>();
        Nodo nodo = raiz;
        while (nodo != null) {
            pila.add(nodo);
            nodo = nodo.izq;
        }
        while (!pila.isEmpty()) {
            if (nodo == null) {
                nodo = new Nodo(0);
            }
            if (nodo.der != null) {
                nodo = nodo.der;
                while (nodo != null) {
                    pila.add(nodo);
                    nodo = nodo.izq;
                }
            } else {
                nodo = pila.pop();
                arreglo += nodo.info + ", ";
            }
        }
        return arreglo;
    }

    /**
     * recorre el arbol por niveles
     *
     * @return un string con el recorrido del arbol
     */
    public String niveles() {
        String arreglo = "";
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            arreglo += nodo.info + ", ";
            if (nodo.izq != null) {
                cola.add(nodo.izq);
            }
            if (nodo.der != null) {
                cola.add(nodo.der);
            }
        }
        return arreglo;
    }

    public Nodo getRaiz() {
        return raiz;
    }

}
