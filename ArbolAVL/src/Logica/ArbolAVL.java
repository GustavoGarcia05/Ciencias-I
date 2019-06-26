/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author estudiantes
 */
public class ArbolAVL {

    Nodo raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    void insertar() {

    }

    /**
     * busca un dato dentro del arbol.
     *
     * @param dato. El dato que buscara en el arbol
     * @return true si lo encuentra y false si no.
     */
    public boolean buscar(int dato) {
        Nodo p = raiz;
        while (p != null) {
            if (p.info < dato) {
                p = p.der;
            } else if (p.info > dato) {
                p = p.izq;
            } else if (p.info == dato) {
                return true;
            }
        }
        return false;
    }

    void eliminar() {

    }

    /**
     * Recorre el arbol en pre-orden
     *
     * @return un string con el recorrido del arbol
     */
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
     * recorre el arbol por niveles Posee errores
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

    /**
     * Metodo para obtener la raiz del arbo
     *
     * @return la raiz del arbol que es tipo Nodo.
     */
    public Nodo getRaiz() {
        return raiz;
    }

}
