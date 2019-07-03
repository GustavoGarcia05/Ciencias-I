package interfaz;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * ventana principal donde se ejecutaran el programa.
 */
public class VPrincipal extends JFrame {

    private JPanel contentPane;
    private String[] opciones = {"Postorden", "Preorden"};
    private String[] textoBotones = {"Generar", "Salir"};

    public int seleccion;
    public JTextField[] txtCampos = new JTextField[2];
    public JRadioButton[] rdbtnOpcionesOrden = new JRadioButton[opciones.length];
    public JButton[] btnPrincipal = new JButton[textoBotones.length];

    /**
     * Constructor de la ventana principal.
     */
    public VPrincipal() {

        setBounds(100, 100, 600, 170);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel labelInorden = new JLabel("Inorden");
        labelInorden.setBounds(300, 20, 70, 20);

        contentPane = new JPanel();
        contentPane.setBackground(Color.CYAN);
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(labelInorden);

        IPrincipalBotones ctrBoton = new IPrincipalBotones(this);
        IPrincipalRdBotones ctrSeleccion = new IPrincipalRdBotones(this);

        ButtonGroup orden = new ButtonGroup();

        for (int i = 0; i < rdbtnOpcionesOrden.length; i++) {
            rdbtnOpcionesOrden[i] = new JRadioButton(opciones[i]);
            rdbtnOpcionesOrden[i].setBounds(10 + (140 * i), 20, 130, 20);
            rdbtnOpcionesOrden[i].setBackground(Color.WHITE);
            rdbtnOpcionesOrden[i].addActionListener(ctrSeleccion);
            orden.add(rdbtnOpcionesOrden[i]);
            contentPane.add(rdbtnOpcionesOrden[i]);
        }

        for (int i = 0; i < txtCampos.length; i++) {
            txtCampos[i] = new JTextField();
            txtCampos[i].setBounds(10 + (290 * i), 60, 280, 20);
            txtCampos[i].setBorder(new LineBorder(Color.BLACK));
            contentPane.add(txtCampos[i]);
        }

        for (int i = 0; i < btnPrincipal.length; i++) {
            btnPrincipal[i] = new JButton(textoBotones[i]);
            btnPrincipal[i].setBorder(new LineBorder(Color.BLACK));
            btnPrincipal[i].setBackground(Color.WHITE);
            btnPrincipal[i].setBounds(100 + (300 * i), 100, 90, 30);
            btnPrincipal[i].addActionListener(ctrBoton);
            contentPane.add(btnPrincipal[i]);
        }
    }
}
