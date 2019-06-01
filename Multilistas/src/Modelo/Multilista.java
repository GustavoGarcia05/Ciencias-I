/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ventana;
import javax.swing.JOptionPane;

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
            //System.out.println("el elemento se encontro");
            JOptionPane.showMessageDialog(null, Integer.toString(aux.id) + " " + aux.nombre);
            return true;
        } else {
            //System.out.println("el elemento no esta");
            return false;
        }
    }

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

        if (q.abajo != null) {
            System.out.println("No se puede borrar porque tiene inmuebles a su name");
            JOptionPane.showMessageDialog(null, "No se puede borrar porque tiene inmuebles a su name");
            return false;
        }

        if (s != null) {
            q.id = s.id;
            q.nombre = s.nombre;
            q.abajo = s.abajo;
            q.sig = s.sig;
        } else if (q == this.cab) {
            q = null;
            this.cab = q;
            //JOptionPane.showMessageDialog(null, "se ha eliminado el unico elemento de la lista");
        } else {
            aux.sig = s;
            q = s;
        }
        return true;
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
            Lista = Lista + "\n" + "ID: " + q.id + " Nombre: " + q.nombre;
            //System.out.println("ID: " + q.id + " Nombre: " + q.nombre);           
            q = q.sig;
        }
        return Lista;
    }

    /**
     * inserta un valor en la multilista, dado una cabeza y despues lo inserta
     * creando un nodo siguiente al ultimo nodo.
     *
     * @param idPropietario posicion de la primera fila en la cual se quiere
     * insertar el dato.
     * @param idInmueble lo que se quiere insertar.
     */
    public boolean insertarAbajo(int idPropietario, int idInmueble, float valor, String nombre, String direccion) {
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
        while (q != null && q.id < idPropietario) {
            q = q.sig;
        }
        NodoN s = q.abajo;

        while (s != null && s.id < idInmueble) {
            s = s.abajo;
        }
        if (s == null) {
            JOptionPane.showMessageDialog(null, "No existen inmueble con id: " + idInmueble);
            return false;
        }
        if (s.id == idInmueble) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "no existen inmuebles para esta persona");
            return false;
        }
    }

    public boolean retirarAbajo(int idPropietario, int idInmueble) {
        return false;
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
}
