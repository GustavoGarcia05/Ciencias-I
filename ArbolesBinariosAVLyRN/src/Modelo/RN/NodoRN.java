/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.RN;

/**
 *
 * @author Gustavo
 */
public class NodoRN {

    public int llave;
    public int color; //1 es rojo y 0 es negro
    public NodoRN padre, izq, der;

    public NodoRN(int dato) {
        this.llave = dato;
    }

    public NodoRN(int dato, int color) {
        this.llave = dato;
        this.color = color;
    }

    public int nodosCompletos(NodoRN n) {
        if (n == null) {
            return 0;
        } else {
            if (n.izq != null && n.der != null) {
                return nodosCompletos(n.izq) + nodosCompletos(n.der) + 1;
            }
            return nodosCompletos(n.izq) + nodosCompletos(n.der);
        }
    }
}
