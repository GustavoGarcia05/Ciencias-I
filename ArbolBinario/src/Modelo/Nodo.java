package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author estudiantes
 */
public class Nodo {

    int info;
    Nodo izq;
    Nodo der;

    public Nodo(int dato) {
        info = dato;
        izq = null;
        der = null;
    }
}
