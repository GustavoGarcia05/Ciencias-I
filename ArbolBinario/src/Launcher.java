
import Modelo.ArbolBinario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author estudiantes
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArbolBinario ab = new ArbolBinario();
        ab.insertar(5);
        ab.insertar(2);
        ab.insertar(10);

        System.out.println(ab.inOrden());
        System.out.println("retiro: " + ab.retirar(5));
        System.out.println(ab.inOrden());
        System.out.println("retiro: " + ab.retirar(10));
        System.out.println("retiro: " + ab.retirar(2));
        System.out.println(ab.inOrden());
        ab.insertar(3);
        System.out.println(ab.inOrden());
    }
}
