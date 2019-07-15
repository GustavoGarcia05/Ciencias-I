/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.AVL;

/**
 *
 * @author Gustavo
 */
public class NodoAVL {
        public int dato, balance;
    public NodoAVL izq,der; 

 

    public NodoAVL(int dato) {
        this.dato = dato;
        balance=0;
        izq=der=null;
    }
    
    public int nodosCompletos(NodoAVL n) {
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
