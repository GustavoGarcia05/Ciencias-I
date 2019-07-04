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

    /**
     * Constructor de la clase Nodo
     *
     * @param dato sera el valor que se guarde en el atributo info.
     */
    public Nodo(int dato) {
        info = dato;
        izq = null;
        der = null;
    }

    /**
     * Metodo necesario para graficar el arbol
     *
     * @param ´n no me acuerdo para que se necesita
     *
     * @return algo que tampoco me acuerdo
     */
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

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

}
