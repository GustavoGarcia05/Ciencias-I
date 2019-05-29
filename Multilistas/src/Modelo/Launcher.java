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
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Multilista mLista = new Multilista();

        mLista.insertarCabeza(1030671263);
        mLista.buscarCabeza(1030671263);
        System.out.println("se inserto: " + mLista.insertarAbajo(1030671263, "brayan"));
        mLista.listarAbajo(1030671263);

//        System.out.println(mLista.buscar());
    }

}
