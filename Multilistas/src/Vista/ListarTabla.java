/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Multilista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo_2
 */
public class ListarTabla extends JFrame {

    public ListarTabla(Multilista mLista) {

        mLista.insertarEnFila(1, "brayan");
        mLista.insertarEnFila(2, "gustavo");
        mLista.insertarEnFila(3, "pep");
        mLista.insertarEnFila(4, "gavo");

        mLista.insertarAbajo(1, 1, 10000.00, "Casa1", "kra ajaaj");
        mLista.insertarAbajo(1, 2, 10000.00, "Casa2", "kra ajaaj");
        mLista.insertarAbajo(2, 5, 10000.00, "Casa3", "kra ajaaj");
        mLista.insertarAbajo(4, 5, 10000.00, "Casa3", "kra ajaaj");

        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        final JTable table = new JTable(dtm);

        // Agregar nueva columna
        String[] columnaProp = mLista.retornarPropietarios();
        int i = 0;
        for (i = 0; i < 7; i++) {
            String[] columnaInmu = mLista.retornarInmuebles(i + 1);
            dtm.addColumn(columnaProp[i], columnaInmu);
        }

        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.CENTER);

        this.setSize(800, 500);
        this.setSize(getWidth() / 2, 500);
        this.setLocation(getWidth() / 2, getHeight() / 2);
        setVisible(true);
//        this.pack();
    }
}
