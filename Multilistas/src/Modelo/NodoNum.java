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
public class NodoNum {

    int id;
    String nombre;
    NodoNum sig;
    NodoN abajo;

    public NodoNum(int i, String nombre) {
        this.id = i;
        this.nombre = nombre;
        this.sig = null;
        this.abajo = null;
    }

}
