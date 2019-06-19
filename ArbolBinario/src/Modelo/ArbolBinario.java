/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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

    public void preOrden() {

    }

    /**
     * recorre el arbol en inorden
     */
    public String inOrden() {
        return inOrden(raiz, "");
    }

    /**
     * recorre el arbol en inorden
     */
    public String inOrden(Nodo r, String arreglo) {
        if (r != null) {
            inOrden(r.izq, arreglo);
            //System.out.print(r.info + ", ");
            arreglo += r.info + ", ";
            inOrden(r.der, arreglo);
        }
        return arreglo;
    }

    public void postOrden() {

    }

    public void niveles() {

    }

    public Nodo getRaiz() {
        return raiz;
    }

}
