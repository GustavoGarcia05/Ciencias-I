/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
/*insertar
    eliminar
    vacia
 */
public class Pila {

    public Nodo cab;

    public Pila() {
        cab = null;
    }

    void insertar(char v) {
        Nodo t = new Nodo(v);
        System.out.println(t.valor);
/*        t.sig = cab.sig;
        cab = t;
   */ }

    char retirar() {
        char v;
        if (vacia()) {
            return '♣';
        }
        v = cab.valor;
        cab = cab.sig;
        return v;
    }

    boolean vacia() {
        if (this.cab == null) {
            return true;
        } else {
            return true;
        }
    }

}
