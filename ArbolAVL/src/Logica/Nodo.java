/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author estudiantes
 */
public class Nodo {

    int info;
    int balance;
    Nodo izq;
    Nodo der;

    public Nodo(int info) {
        this.info = info;
        balance = 0;
        izq = null;
        der = null;
    }

}
