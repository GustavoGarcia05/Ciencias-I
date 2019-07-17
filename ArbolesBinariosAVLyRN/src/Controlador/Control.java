/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RN.ArbolRN;
import Vista.Ventana;
import Vista.dibujo.DibujoRN;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Integer;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class Control implements ActionListener {
    public int ArrNum[];
    private Ventana v;

    public Control(Ventana v) {
        this.v = v;
    }

    int[] generarRandom(int cant) {
        int random;
        int num = cant;
        ArrNum = new int[num];
        for (int k = 0; k < num; k++) {
            random = (int) (Math.random() * 200 + 1);
            ArrNum[k] = random;
        }
        System.out.println("**** Algoritmo de ordenacion QuickSort **** \n");
        System.out.println("Arreglo: \n" + Arrays.toString(ArrNum));
        return ArrNum;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.getInsertar()) {
            generarRandom(100);
            for(int i = 0; i < ArrNum.length; i++){
                v.getArbolAVL().insertar(ArrNum[i]);
                v.getArbolRN().insertar(ArrNum[i]);
                
                dibujarAVL();
                dibujarRN();
            }
            /*
            if (!isInteger(v.getCajaInsertar().getText())) {
                JOptionPane.showMessageDialog(null, "No es un numero");
                return;
            }
            v.getArbolAVL().insertar(Integer.parseInt(v.getCajaInsertar().getText()));
            v.getArbolRN().insertar(Integer.parseInt(v.getCajaInsertar().getText()));

            v.getCajaInsertar().setText("");

            dibujarAVL();
            dibujarRN();
            ArbolRN var = v.getArbolRN();
            System.out.println("Insertar------");
            System.out.println("llave raiz" + var.getRaiz().der.llave);
            System.out.println("#nodosRN: " + var.getRaiz().nodosCompletos(var.getRaiz()));
            System.out.println("#nodosAVL: " + v.getArbolAVL().raiz.nodosCompletos(v.getArbolAVL().raiz));
            */
        }

        if (e.getSource() == v.getRetirar()) {

            if (!isInteger(v.getCajaRetirar().getText())) {
                JOptionPane.showMessageDialog(null, "No es un numero");
                return;
            }
            v.getArbolAVL().retirar(Integer.parseInt(v.getCajaRetirar().getText()));
            v.getArbolRN().retirar(Integer.parseInt(v.getCajaRetirar().getText()));

            v.getCajaRetirar().setText("");
            dibujarAVL();
            dibujarRN();
            ArbolRN var = v.getArbolRN();
            System.out.println("Insertar------");
            System.out.println("llave raiz" + var.getRaiz().der.llave);
            System.out.println("#nodosRN: " + var.getRaiz().nodosCompletos(var.getRaiz()));
            System.out.println("#nodosAVL: " + v.getArbolAVL().raiz.nodosCompletos(v.getArbolAVL().raiz));
        }
    }

    private void dibujarAVL() {

        v.getDibujoAVL().setObjArbol(v.getArbolAVL());
        v.getPanelAVL().setViewportView(v.getDibujoAVL());

    }

    private void dibujarRN() {

        v.getDibujoRN().setObjArbol(v.getArbolRN());
        v.getPanelRN().setViewportView(v.getDibujoRN());

    }

    private boolean isInteger(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
