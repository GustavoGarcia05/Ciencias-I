/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gustavo_2
 */
public class Multilista {

    NodoNum cab;

    public Multilista() {
        this.cab = null;
    }

    /**
     * inserta un valor en la multilista.
     *
     * @param dato lo que se quiere insertar.
     */
    int insertar(String dato) {
        return 0;
    }

    /**
     * busca un valor en la multilista.
     *
     * @param dato lo que se quiere buscar.
     */
    int buscar(String dato) {
        return 0;
    }

    /**Imprime los datos de la multilista
     * @param info posicion que quiere listar.
     * @return retorna -1 o 1
     */
    int listar(int info) {
        NodoNum p = cab;
        while (p != null && p.i < info) {
            p = p.sig;
        }
        if (p == null) {
            System.out.println("no existe");
            return -1;
        }
        if (p.i == info) {
            NodoN q;
            q = p.abajo;
            while (q != null) {
                System.out.println(q.n);
                q = q.abajo;
            }
        } else {
            System.out.println("no lo encontro");
            return -1;
        }
        return 1;
    }

    /**
     * Busca un numero en una multilista, si lo encuntra inserta un nombre en la
     * lista que corresponde a ese numero, despues del ultimo nodo
     *
     * @param info numero a buscar.
     * @param nombre nombre a insertar.
     * @return 1 si logro insertar o -1 si no logro insertar.
     */
    int insertarNombre(int info, String nombre) {
        NodoNum p = cab;
        while (p != null && p.i < info) {
            p = p.sig;
        }
        if (p == null) {
            System.out.println("\"no existe\"");
            return -1;
        }
        if (p.i == info) {
            NodoN s, q;
            s = null;
            q = p.abajo;
            while (q != null) {
                s = q;
                q = q.abajo;
            }
            if (s == null) {
                NodoN n = new NodoN(nombre);
                p.abajo = n;
                return 1;
            }
            NodoN n = new NodoN(nombre);
            s.abajo = n;
            return 1;
        }//p.i==x
        else {
            System.out.println("no lo encontro");
            return -1;
        }
    }//insertar

    int retirar() {
        return 0;
    }
}
