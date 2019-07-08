/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo_2
 */
public class ArbolPrueva {

    Nodo raiz;

    public ArbolPrueva() {
        raiz = null;
    }

    public void insertar(int d) {
        Nodo nuevo = new Nodo(d);
        if (raiz == null) {
            raiz = nuevo;
            return;
        } else {
            Nodo p = raiz;
            Nodo q = null;

            while (p != null) {
                if (d == p.dato) {
                    JOptionPane.showMessageDialog(null, "El nodo ya existe");
                    return;
                }

                if (d < p.dato) {
                    q = p;
                    p = p.izq;
                }
                if(d>p.dato){
                    q=p;
                    p=p.der;
                }
            }
            
            
        }

    }
    
    public int calcularBalance(Nodo acutual){
        int balance=0;
        
        if(acutual.izq==null){
            
        }
        
        return balance;
    }

    public void rotacionIzq() {

    }

    public void rotacionDer() {

    }

    public void rotacionIzq_Der() {

    }

    public void rotacionDer_izq() {

    }

}
