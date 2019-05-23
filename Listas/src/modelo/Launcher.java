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

import Vista.Ventana;
import Vista.VentanaManual;
import javax.swing.JOptionPane;
public class Launcher {
    
    public static void main(String[] args) {
        new VentanaManual();
        
       // new Launcher().generarLista();
        
    }
    private Lista l= new Lista();

    
    public void generarLista(){
        
        int seguir=1;
        while(seguir==1){
            l.insertar(Integer.parseInt(JOptionPane.showInputDialog("ingrese el dato")));
            seguir=JOptionPane.showConfirmDialog(null, "desea terminar", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        
        l.imprimir();
        
          
    }
    
}
