
import Vista.Ventana;
import Vista.prueva;
import modelo.Arbol;

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
        Arbol a = new Arbol();

        //a.recibirInOrden("daecgfhb");
        //a.recibirPosOrden("deghfcba");
        a.recibirInOrden("gdkhlbaeicfjm");
        a.recibirPosOrden("gklhdbiemjfca");
        a.recibirPreOrden("abdghklceifjm");
        a.armandoMatrizInPre();
        System.out.println("------------");
        a.armandoMatrizInPos();
        
        new Ventana();
        //new prueva();
  
    }

}
