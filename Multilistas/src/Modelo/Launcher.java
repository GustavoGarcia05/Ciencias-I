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

        mLista.insertarNombre(0, "brayan");
        mLista.listar(0);

//        System.out.println(mLista.buscar());
    }

}
