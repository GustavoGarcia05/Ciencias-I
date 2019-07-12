/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.RN;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class ArbolRN {

    public NodoRN raiz;
    public NodoRN centinela;

    public ArbolRN() {
        raiz = null;
        centinela = null;
    }

    /**
     * busca un nodo en un arbol
     */
    public NodoRN buscar(int d, NodoRN r) {
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

    //Rotacion simple izquierda
    public void rotacionIzq(NodoRN c) {
    }

    //Rotacion simple izquierda
    public void rotacionDer(NodoRN c) {
    }

    //Metodo insertar
    public void insertar(int d) {
    }

    //Metodo para insertar nodo
   /* public NodoRN insertarAVL(NodoRN nuevo, NodoRN subAr) {
    }
*/
    public NodoRN getRaiz() {
        return raiz;
    }

    public NodoRN getCentinela() {
        return centinela;
    }

}
