
import modelo.ArbolPrueva;
import vista.Ventana;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new Ventana();
        ArbolPrueva ap = new ArbolPrueva();
        ap.insertar(10);
        ap.insertar(5);
        //ap.insertar(15);
        ap.insertar(3);
        //ap.insertar(1);
        //ap.insertar(7);
        //ap.insertar(13);
        //ap.insertar(17);

        /*System.out.println("raiz: "+ap.getRaiz().dato);
        System.out.println("izq: "+ap.getRaiz().izq.dato);
        System.out.println("der: "+ap.getRaiz().der.dato);
        System.out.println("izq.izq: "+ap.getRaiz().izq.izq.dato);
        System.out.println("izq.izq: "+ap.getRaiz().izq.der.dato);
        System.out.println("der.izq: "+ap.getRaiz().der.izq.dato);
        System.out.println("der.izq: "+ap.getRaiz().der.der.dato);*/
 /*
        System.out.println("balance: "+ ap.factorBalance(ap.getRaiz()));
        System.out.println("balance: "+ ap.factorBalance(ap.getRaiz().der));
         */
        System.out.println("izq" + ap.getRaiz().dato);
        ap.rotacionSimpleIzquierda(ap.getRaiz().izq,ap.getRaiz().izq.izq);
        System.out.println("izq" + ap.getRaiz().dato);
        //System.out.println("izq" + ap.getRaiz().izq.dato);*/

    }

}
