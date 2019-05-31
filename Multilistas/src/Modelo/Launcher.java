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

        mLista.insertarEnFila(10, "Brayan");
        mLista.insertarEnFila(11, "pimpollo");
        mLista.insertarEnFila(12, "pepe");
        mLista.insertarEnFila(13, "pepa");

        mLista.insertarAbajo(10, 1, 10, "SuperCasa", "Kennedy");
        mLista.insertarAbajo(10, 2, 101000, "SuperApartamento", "Kennedy");
        mLista.insertarAbajo(10, 3, 101000, "SuperApartamento1", "Kennedy");
        mLista.insertarAbajo(10, 4, 101000, "SuperApartamento2", "Kennedy");
        mLista.insertarAbajo(10, 5, 101000, "SuperApartamento3", "Kennedy");
        mLista.insertarAbajo(10, 6, 101000, "SuperApartamento4", "Kennedy");

        mLista.listarEnFila();
        System.out.println("-------");
        System.out.println("se borro: " + mLista.retirarEnFila(13));
        mLista.listarEnFila();
        System.out.println("-------");
        mLista.listarAbajo(10);
        
        Ventana nVentana = new Ventana();

//        System.out.println(mLista.buscar());
    }
}
