/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo_2
 */
package Modelo;

import javax.swing.JOptionPane;
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*        //Nodo p= new Nodo(5);
        Lista list = new Lista();

        list.insertar(10);
        list.insertar(5);
        list.insertar(7);
        list.insertar(12);
        list.insertar(15);
        list.insertar(-32);
        list.insertar(-2);
        list.insertar(-32);

        System.out.println(list.buscar(22));

        list.retirar(10);

        list.imprimir();

        System.out.println("");
        //list.dibujar();
         */
        //new VentanaGrafica();
        new Launcher().generarLista();
    }
    private Lista l= new Lista();

    
    public void generarLista(){
        
        int seguir=1;
        
        //System.out.println(JOptionPane.showInputDialog("puto"));
        while(seguir==1){
            l.insertar(Integer.parseInt(JOptionPane.showInputDialog("ingrese el dato")));
            seguir=JOptionPane.showConfirmDialog(null, "desea terminar", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        
        l.imprimir();
        
        
       
    }
    
    
}
