/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.ArbolAVL;
import Vista.Ventana;

/**
 *
 * @author estudiantes
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ventana vent = new Ventana();
        ArbolAVL avl = new ArbolAVL();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                avl.insertar(i);
            } else {
                avl.insertar(-i);
            }
        }
        System.out.println(avl.inOrden());
    }

}
