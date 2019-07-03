package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class IPrincipalRdBotones implements ActionListener {

    VPrincipal principal;

    public IPrincipalRdBotones(VPrincipal principal) {
        this.principal = principal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton obj = (JRadioButton) e.getSource();
        for (int i = 0; i < principal.btnPrincipal.length; i++) {
            if (principal.rdbtnOpcionesOrden[i].equals(obj)) {
                principal.seleccion = i + 1;
            }
        }
    }
}
