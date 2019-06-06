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
public class Nodo {

    public char valor;
    public Nodo sig;

    public Nodo(char v) {
        this.valor = v;
        this.sig = null;
    }
}
