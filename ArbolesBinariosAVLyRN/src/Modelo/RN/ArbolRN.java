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
    public NodoRN z;
    final int negro = 0;
    final int rojo = 1;

    void inicializar() {
        z = new NodoRN(0, negro);
        z.izq = z;
        z.der = z;
        raiz = new NodoRN(0, negro);
        raiz.izq = z;
        raiz.der = z;
    }

    NodoRN rotar(int v, NodoRN p) {
        NodoRN c, gc;
        if (v < p.llave) {
            c = p.izq;
        } else {
            c = p.der;
        }
        if (v < c.llave) {
            gc = c.izq;
            c.izq = gc.der;
            gc.der = c;
        } else {
            gc = c.der;
            c.der = gc.izq;
            gc.izq = c;
        }
        if (v < p.llave) {
            p.izq = gc;
        } else {
            p.der = gc;
        }
        return gc;
    }

    NodoRN dividir(int v, NodoRN gf, NodoRN g, NodoRN p, NodoRN x) {
        x.color = rojo;
        x.izq.color = negro;
        x.der.color = negro;
        if (p.color == rojo) {
            g.color = rojo;
            if ((v < g.llave) != (v < p.llave)) {
                System.out.println("sentido contrario-" + gf.llave);
                p = rotar(v, g);
            }
            System.out.println("mismo sentido- " + gf.llave);
            x = rotar(v, gf);
            x.color = negro;
        }
        raiz.der.color = negro;
        return x;
    }

    /**
     * Inserta un llave en el arbol rojinegro
     *
     * @return un nodoRN
     */
    public NodoRN insertar(int v) {
        NodoRN gf, g, p, x;
        if (raiz == null) {
            raiz = new NodoRN(v);
        }
        x = raiz;
        p = x;
        g = x;
        do {
            if (v < x.llave) {
                gf = g;
                g = p;
                p = x;
                x = x.izq;
            } else if (v > x.llave) {
                gf = g;
                g = p;
                p = x;
                x = x.der;
            } else {
                System.out.println("la llave ya existe" + v);
                return z;
            }
            if (x.izq.color == rojo && x.der.color == rojo) {
                x = dividir(v, gf, g, p, x);
            }
        } while (x != z);
        x = new NodoRN(v); //color sin asignar todavia
        x.llave = v;
        x.izq = x.der = z;
        if (v < p.llave) {
            p.izq = x;
        } else {
            p.der = x;
        }
        x = dividir(v, gf, g, p, x);
        return x;
    }
    
    

    /**
     * busca un nodo en un arbol
     *
     * @return el nodo buscado, null en caso de que no lo encuentre.
     */
    public NodoRN buscar(int d, NodoRN r) {
        if (raiz == null) {
            return null;
        } else if (r.llave == d) {
            return r;
        } else if (r.llave < d) {
            return buscar(d, r.der);
        } else {
            return buscar(d, r.izq);
        }
    }

    /**
     * Metodo para obtener la raiz del arbol.
     *
     * @return la raiz del arbol
     */
    public NodoRN getRaiz() {
        return raiz;
    }

    public NodoRN getZ() {
        return z;
    }

}
