/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ventana;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo_2
 */
public class Multilista {

    private NodoNum cab;

    public Multilista() {
        this.cab = null;
    }

    /**
     * inserta un valor en las cabezas de la multilista, lo que corresponderia a
     * la primera fila de la matriz.
     *
     * @param dato lo que se quiere insertar.
     */
    public boolean insertarEnFila(int dato, String nombre) {

        NodoNum nodoInsertar = new NodoNum(dato, nombre);
        NodoNum s = this.cab;   //variable auxiliar 1
        NodoNum q = null;       //variable auxiliar 2
        if (this.buscarEnFila(dato)) {
            System.out.println("El nodo ya esta en la lista");
            return false;
        }
        while (s != null && s.id < dato) {
            q = s;
            s = q.sig;
        }

        if (q == null) {
            nodoInsertar.sig = this.cab;
            this.cab = nodoInsertar;
        } else if (s == null) {
            q.sig = nodoInsertar;
        } else {
            nodoInsertar.sig = s;
            q.sig = nodoInsertar;
        }

        return true;

    }

    /**
     * busca un valor en la multilista.
     *
     * @param dato lo que se quiere buscar.
     */
    public boolean buscarEnFila(int dato) {
        NodoNum aux = this.cab;
        while (aux != null && aux.id < dato) {
            aux = aux.sig;
        }
        if (aux != null && aux.id == dato) {
            return true;
        } else { 
            return false;
        }
    }

    /**
     * @param idPropietario
     */
    public boolean retirarEnFila(int idPropietario) {
        boolean esta;
        esta = this.buscarEnFila(idPropietario);

        if (esta == false) {
            return false;
        }

        NodoNum aux = null;
        NodoNum q = null;
        NodoNum s = this.cab;

        while (s != null && s.id <= idPropietario) {
            aux = q;
            q = s;
            s = s.sig;
        }
        //System.out.println("este es aux " + aux.info);
        //System.out.println("este es q " + q.info);

        if (q.abajo != null) { //Caso0: el propietario tiene inmuebles a su nombre
            //System.out.println("No se puede borrar porque tiene inmuebles a su name");
            JOptionPane.showMessageDialog(null, "No se puede borrar porque tiene inmuebles a su name");
            return false;
        }
        if (s != null) { //Caso1: borro el inmusble dado, nodo entre dos nodos 
            q.id = s.id;
            q.nombre = s.nombre;
            q.abajo = s.abajo;
            q.sig = s.sig;
        } else if (q == this.cab) {
            q = null;
            this.cab = q;
            JOptionPane.showMessageDialog(null, "se ha eliminado el unico elemento de la lista");
        } else {
            aux.sig = s;
            q = s;
        }
        return true;
    }

    /**
     * inserta un valor en la multilista, dado una cabeza y despues lo inserta
     * creando un nodo siguiente al ultimo nodo.
     *
     * @param idPropietario posicion de la primera fila en la cual se quiere
     * insertar el dato.
     * @param idInmueble lo que se quiere insertar.
     */
    public boolean insertarAbajo(int idPropietario, int idInmueble, double valor, String nombre, String direccion) {
        NodoNum p = cab;
        while (p != null && p.id < idPropietario) {
            p = p.sig;
        }
        if (p == null) {
            //System.out.println("no existe");
            return false;
        }
        if (p.id == idPropietario) {
            NodoN s, q;
            s = null;
            q = p.abajo;
            while (q != null) {
                s = q;
                q = q.abajo;
            }
            if (s == null) {
                NodoN n = new NodoN(idInmueble, valor, nombre, direccion);
                p.abajo = n;
                return true;
            }
            NodoN n = new NodoN(idInmueble, valor, nombre, direccion);
            s.abajo = n;
            return true;
        }//p.i==x
        else {
            //System.out.println("no lo encontro");
            return false;
        }
    }

    /**
     * busca un valor en la multilista.
     *
     * @param idPropietario posicion de la primera fila en la cual se quiere
     * buscar el dato.
     * @param idInmueble lo que se quiere buscar.
     */
    public boolean buscarAbajo(int idPropietario, int idInmueble) {
        NodoNum q = this.cab;
        if(q==null){
            return false;
        }
        while (q != null && q.id < idPropietario) {
            q = q.sig;
        }
        NodoN s = q.abajo;

        while (s != null && s.id < idInmueble) {
            s = s.abajo;
        }
        if (s == null) {
            JOptionPane.showMessageDialog(null, "No existe inmueble con id: " + idInmueble);
            return false;
        }
        if (s.id == idInmueble) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "no existen inmuebles para esta persona");
            return false;
        }
    }

    /**
     * Retira en la lista de inmueble
     *
     * @param idPropietario propietario al cual se le quiere eliminar el
     * inmueble
     * @param idInmueble inmueble que se desea eliminar
     */
    public boolean retirarAbajo(int idPropietario, int idInmueble) {
        NodoNum q = this.cab;
        if (q == null) {
            JOptionPane.showMessageDialog(null, "No hay lista de propietarios");
            return false;
        }
        if (!buscarEnFila(idPropietario)) {
            JOptionPane.showMessageDialog(null, "El propietario no esta en la lista");
            return false;
        }
        while (q != null && q.id < idPropietario) {
            q = q.sig;
        }
        if (!buscarAbajo(idPropietario, idInmueble)) {
            return false;
        }
        if (q.abajo == null) {
            JOptionPane.showMessageDialog(null, "El propietario no tiene propiedades");
            return false;
        }
        NodoN aux = null;
        NodoN r = null;
        NodoN s = q.abajo;

        while (s != null && s.id <= idInmueble) {
            aux = r;
            r = s;
            s = s.abajo;
        }
        if (s != null) { //Caso1: borro el inmusble dado, nodo entre dos nodos 
            r.id = s.id;
            r.nombre = s.nombre;
            r.valor = s.valor;
            r.direccion = s.direccion;
            r.abajo = s.abajo;
        } else if (r == q.abajo) {
            r = null;
            q.abajo = r;
            JOptionPane.showMessageDialog(null, "se ha eliminado el unico elemento de la lista");
        } else {
            aux.abajo = s;
            r = s;
        }
        return true;
    }

    public String[] crearTextoPropietario(int dato) {
        NodoNum p = this.cab;
        ArrayList<String> textoProp = new ArrayList<String>();

        if (p == null) {
            return null;
        }

        while (p != null && p.id < dato) {
            p = p.sig;
        }

        //textoProp.add(" ID: " + p.id + " Nombre: " + p.nombre);
        NodoN q = p.abajo;

        while (q != null) {
            textoProp.add(" IDinmueble: " + q.id);
            textoProp.add(" Nombre: " + q.nombre);
            textoProp.add(" Direccion: " + q.direccion);
            textoProp.add(" Valor: $" + q.valor);
            textoProp.add("");
            q = q.abajo;
        }
        String[] aux = new String[textoProp.size()];
        aux = textoProp.toArray(aux);
        return aux;
    }

    public DefaultTableModel listar() {
        NodoNum p = cab;
        DefaultTableModel dmt = new DefaultTableModel();
        if (p == null) {
            return null;
        }
        

        while (p != null) {
            dmt.addColumn("ID: "+p.id+" Nombre: "+p.nombre, crearTextoPropietario(p.id));
            p = p.sig;
        }
        
        return dmt;
        
    }

    /**
     * Imprime los datos de la fila de la multilista
     *
     * @param dato posicion que quiere listar.
     * @return retorna -1 o 1
     */
    public String listarEnFila() {
        String Lista = "";
        NodoNum q = cab;

        if (q == null) {
            JOptionPane.showMessageDialog(null, "No hay propietarios registrados en la multilista");
        }
        while (q != null) {
            Lista += "\n" + "ID: " + q.id + " Nombre: " + q.nombre;
            //System.out.println("ID: " + q.id + " Nombre: " + q.nombre);           
            q = q.sig;
        }
        return Lista;
    }

    /**
     * Imprime los datos de la multilista
     *
     * @param idPropietario posicion que quiere listar.
     * @return retorna -1 o 1
     */
    public String listarAbajo(int idPropietario) {
        NodoNum p = this.cab;
        NodoN q = p.abajo;
        String Lista = "";
        if (q == null) {
            System.out.println("El propietario no tiene inmuebles");
        }

        while (p != null && p.id < idPropietario) {

            p = p.sig;
        }
        if (p != null) {
            while (q != null) {
                //System.out.println("ID: " + q.id + " Nombre: " + q.nombre + " Direccion: " + q.direccion);
                Lista = Lista + "\n" + "ID: " + q.id + " Nombre: " + q.nombre + " Valor $: " + q.valor + " Direccion: " + q.direccion;
                q = q.abajo;
            }
        }
        return Lista;
    }

    public String[] retornarPropietarios() {
        String[] Lista = new String[20];
        NodoNum q = cab;

        if (q == null) {
            return null;
        }
        int i = 0;
        while (q != null) {
            Lista[i] = "ID: " + q.id + " Nombre: " + q.nombre;
            q = q.sig;
            i++;
        }
        return Lista;
    }

    public String[] retornarInmuebles(int idPropietario) {
        NodoNum p = this.cab;
        String[] inmuebles = new String[20];

        if (p == null) {
            return null;
        }
        if (!buscarEnFila(idPropietario)) {
            return null;
        }

        while (p != null && p.id < idPropietario) {
            p = p.sig;
        }
        NodoN q = p.abajo;
        int i = 0;

        while (q != null) {
            inmuebles[i] = (" IDinmueble: " + q.id + " Nombre: " + q.nombre + " Direccion: " + q.direccion + " Valor: $" + q.valor);
            q = q.abajo;
            i++;
        }
        return inmuebles;
    }
}
