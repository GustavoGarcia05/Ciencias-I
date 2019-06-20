
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
        ab.insertar(10);
        ab.insertar(11);
        ab.insertar(12);
        ab.insertar(13);
        ab.insertar(20);
        ab.insertar(32);
        ab.insertar(2);
        ab.insertar(5);
        System.out.println(ab.niveles());
        System.out.println(ab.preOrden());
        System.out.println(ab.inOrden());
        System.out.println(ab.postOrden());
    }

}
