/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ /**
 *
 * @author Gustavo
 */

package Vista;

import Modelo.Lista;
import Modelo.Dibujo;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana(Lista l) {
        setSize(300, 200);
        add(new Dibujo(l));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
}
