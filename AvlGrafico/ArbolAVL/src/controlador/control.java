/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Ventana;

/**
 *
 * @author Gustavo
 */
public class control implements ActionListener{
    Ventana v;

    public control(Ventana v) {
        this.v = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==v.getInsertar()){
            v.getAbAVL().insertar(Integer.parseInt(v.getCinsertar().getText()));
            v.getCinsertar().setText("");
            
            v.getLienzo().setObjArbol(v.getAbAVL());
            v.getArbol().setViewportView(v.getLienzo());
        }
        if(e.getSource()==v.getRetirar()){
            System.out.println("hy");
        }
        if(e.getSource()==v.getDibujar()){
            v.getLienzo().setObjArbol(v.getAbAVL());
            v.getArbol().setViewportView(v.getLienzo());
        }
        
    }
    
}
