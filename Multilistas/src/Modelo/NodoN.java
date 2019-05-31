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
public class NodoN {

    int id;
    float valor;
    String nombre;
    String direccion;

    NodoN abajo;

    public NodoN(int id, float valor, String nombre, String direccion) {
        this.id = id;
        this.valor = valor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.abajo = null;
    }


}
