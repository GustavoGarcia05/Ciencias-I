/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo_2
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Nodo p= new Nodo(5);
        Lista list = new Lista();
        list.insertar(10);
        list.insertar(-2);
        list.insertar(-5);
        list.insertar(22);
        list.insertar(15);
        list.insertar(-32);
        list.insertar( -2);
        list.insertar( -32);


        list.imprimir();
        
        list.dibujar();
 
    }

}
