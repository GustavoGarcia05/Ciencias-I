package Modelo;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo_2
 */
public class Lista {

    private Nodo cabeza;

    public Lista() {
        cabeza = null;
    }

    public Nodo insertar(int info) {
        if (buscar(info)) {
            JOptionPane.showMessageDialog(null, "El nodo ya esta en la lista");
            return null;
        }
        Nodo q;
        Nodo s;

        q = null;
        s = cabeza;
        while (s != null && info > s.info) {
            if (s.info == info) {
                return null;
            }
            q = s;
            s = s.sig;
        }
        Nodo n = new Nodo(info);

        if (q == null) {
            n.sig = cabeza;
            cabeza = n;
        } else if (s == null) {
            q.sig = n;
        } else {
            n.sig = s;
            q.sig = n;
        }
        return cabeza;
    }

    public boolean retirar(int info) {
        boolean esta;
        esta = buscar(info);

        if (esta == false) {
            return false;
        }

        Nodo aux = null;
        Nodo q = null;
        Nodo s = cabeza;

        while (s != null && s.info <= info) {
            aux = q;
            q = s;
            s = s.sig;
        }
        //System.out.println("este es aux " + aux.info);
        //System.out.println("este es q " + q.info);

        if (s != null) {
            q.info = s.info;
            q.sig = s.sig;
        } else if(q==cabeza){
            q=null;
            cabeza=q;
            JOptionPane.showMessageDialog(null, "se ha eliminado el unico elemento de la lista");
        }else {

            aux.sig = null;
            q = aux;
        }
        return true;
    }

    public void imprimir() {
        Nodo q = cabeza;

        while (q != null) {
            System.out.print(q.info + ", ");
            q = q.sig;
        }
    }

    public boolean buscar(int info) {
        Nodo q = cabeza;
        while (q != null && q.info < info) {

            q = q.sig;
        }
        if (q != null && q.info == info) {
            return true;
        } else {
            // JOptionPane.showMessageDialog(null, "el elemento no esta");
            return false;
        }

    }

    public void dibujar(Graphics g,int ancho,int alto) {
        Nodo q = cabeza;
        ArrayList<Integer> infor = new ArrayList<Integer>();

        while (q != null) {
            infor.add(q.info);
            q = q.sig;
        }

        //--------------dibujar---------------------
        Dibujo dib = new Dibujo(infor,ancho,alto);
        dib.paint(g);

    }

    public Nodo getCabeza() {
        return cabeza;
    }

}
