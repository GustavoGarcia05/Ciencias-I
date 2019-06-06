/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ventana;

/**
 *
 * @author Gustavo_2
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Multilista mLista = new Multilista();
        
        mLista.insertarEnFila(1, "brayan");
        mLista.insertarEnFila(2, "gustavo");
        mLista.insertarEnFila(3, "pepe");
        
        mLista.insertarAbajo(1, 1, 10000.00, "Casa1", "kra ajaaj");
        mLista.insertarAbajo(1, 2, 10000.00, "Casa2", "kra ajaaj");
        mLista.insertarAbajo(1, 3, 10000.00, "Casa3", "kra ajaaj");
        /*
        System.out.println(mLista.listarEnFila());

        System.out.println("-------");

        System.out.println(mLista.retirarEnFila(1));

        System.out.println("-------");

        System.out.println(mLista.listarEnFila());

        mLista.retirarAbajo(1, 1);

        System.out.println("-------");

        System.out.println(mLista.retirarEnFila(1));

        System.out.println("-------");

        System.out.println(mLista.listarEnFila());
         */
        mLista.retirarAbajo(1, 1);
        mLista.retirarAbajo(1, 2);
        mLista.retirarAbajo(1, 3);
        
        System.out.println(mLista.listarAbajo(1));

//      mLista.listarEnFila();
Ventana nVentana = new Ventana();
    }
}
