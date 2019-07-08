/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Gustavo
 */
public class Nodo {
    public int dato, balance;
    public Nodo izq,der,padre; 

 

    public Nodo(int dato) {
        this.dato = dato;
        balance=0;
        izq=der=padre=null;
    }
    
    public int nodosCompletos(Nodo n) {
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
