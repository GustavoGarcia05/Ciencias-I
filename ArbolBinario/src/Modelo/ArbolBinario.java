/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author estudiantes
 */
public class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    /**
     * busca un dato dentro del arbol.
     *
     * @param dato. El dato que buscara en el arbol
     * @return true si lo encuentra y false si no.
     */
    public boolean buscar(int dato) {
        Nodo p = raiz;
        while (p != null) {
            if (p.info < dato) {
                p = p.der;
            } else if (p.info > dato) {
                p = p.izq;
            } else if (p.info == dato) {
                return true;
            }
        }
        return false;
    }

    /**
     * inserta un dato dentro del arbol, si el dato a insertar ya se encuentra
     * dentro del arbol, no lo insertara.
     *
     * @param dato. El dato que insertara en el arbol
     * @return true si lo inserta aducuadamente o false si no lo puede insertar.
     */
    public boolean insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = new Nodo(dato);
            return true;
        } else {
            Nodo anterior = null, recorrido;
            recorrido = raiz;
            while (recorrido != null) {
                anterior = recorrido;
                if (recorrido.info == dato) {
                    return false;
                } else if (dato < recorrido.info) {
                    recorrido = recorrido.izq;
                } else {
                    recorrido = recorrido.der;
                }
            }
            if (dato < anterior.info) {
                anterior.izq = nuevo;
            } else {
                anterior.der = nuevo;
            }
        }
        return true;
    }

    /**
     * elimina un dato dentro del arbol, si el dato no se encuentra no eliminara
     * nada.
     *
     * @param dato. El dato que eliminara en el arbol
     * @return true si lo elimina, false si no.
     */
    public boolean retirar(int dato) {
        Nodo padre = null, hijo = raiz;

        while (hijo != null) {
            if (hijo.info < dato) {
                padre = hijo;
                hijo = hijo.der;
            } else if (hijo.info > dato) {
                padre = hijo;
                hijo = hijo.izq;
            } else if (hijo.info == dato) {
                borrarNodo(padre, hijo);
                return true;
            }
        }
        return false;
    }

    /**
     * dados un padre y un hijo, decide como borrar un nodo teniendo en cuenta
     * si tiene cero hijos, uno o dos.
     *
     * @param padre. padre del nodo que se quiere eliminar
     * @param hijo. hijo del nodo que se quiere eliminar
     */
    void borrarNodo(Nodo padre, Nodo hijo) {
        if (hijo.izq == null && hijo.der == null) {
            borrarNoHijos(padre, hijo);
        } else if (hijo.izq != null && hijo.der != null) {
            borrarDosHijos(padre, hijo);
        } else {
            borrarUnHijo(padre, hijo);
        }
    }

    /**
     * dados un padre y un hijo, elimina el hijo. esta funcion sirve cuando el
     * nodo a eliminar no tiene hijos
     *
     * @param padre. padre del nodo que se quiere eliminar
     * @param hijo. hijo del nodo que se quiere eliminar
     */
    void borrarNoHijos(Nodo padre, Nodo hijo) {
        if (hijo == raiz) {
            raiz = null;
        } else if (padre.der == hijo) {
            padre.der = null;
        } else {
            padre.izq = null;
        }
    }

    /**
     * dados un padre y un hijo, elimina el hijo. esta funcion sirve cuando el
     * nodo a eliminar tiene dos hijos
     *
     * @param padre. padre del nodo que se quiere eliminar
     * @param hijo. hijo del nodo que se quiere eliminar
     */
    void borrarUnHijo(Nodo padre, Nodo hijo) {
        if (padre == null) {
            if (hijo.der != null) {
                System.out.println(" 5   " + hijo.info);
                raiz = hijo.der;
                hijo.der = null;
                System.out.println(hijo.info);
            } else {
                raiz = hijo.izq;
                hijo.izq = null;
            }
        } else if (padre.izq == hijo) {
            if (hijo.izq != null) {
                padre.izq = hijo.izq;
            } else {
                padre.izq = hijo.der;
            }
        } else {
            if (hijo.izq != null) {
                padre.der = hijo.izq;
            } else {
                padre.der = hijo.der;
            }
        }
    }

    /**
     * dados un padre y un hijo, elimina el hijo. esta funcion sirve cuando el
     * nodo a eliminar tiene dos hijos
     *
     * @param padre. padre del nodo que se quiere eliminar
     * @param hijo. hijo del nodo que se quiere eliminar
     *
     * Problema: intercambia valores cuando borra, si se arregla eso, ya queda.
     */
    void borrarDosHijos(Nodo padre, Nodo hijo) {
        Nodo padreRempl = hijo;
        Nodo hijoRempl = hijo.der;
        while (hijoRempl.izq != null) {
            padreRempl = hijoRempl;
            hijoRempl = hijoRempl.izq;
        }
        Nodo aux = hijoRempl;
        if (hijoRempl.izq == null && hijoRempl.der == null) {
            borrarNoHijos(padreRempl, hijoRempl);
        } else {
            borrarUnHijo(padreRempl, hijoRempl);
        }
        if (hijo != null) {
            aux.der = hijo.der;
            aux.izq = hijo.izq;
        }
        if (padre == null) {
            raiz = aux;
            System.out.println("raz" + raiz.info);
        } else if (padre.der == hijo) {
            padre.der = aux;
        } else {
            padre.izq = aux;
        }
    }

    /**
     * Recorre el arbol en pre-orden
     *
     * @return una string con el recorrido del arbol
     */
    public String preOrden() {
        String arreglo = "";
        Stack<Nodo> pila = new Stack<>();
        Nodo nodo = raiz;
        while (nodo != null) {
            arreglo += nodo.info + ", ";
            pila.add(nodo);
            nodo = nodo.izq;
        }
        while (!pila.isEmpty()) {
            nodo = pila.pop();
            nodo = nodo.der;
            while (nodo != null) {
                arreglo += nodo.info + ", ";
                pila.add(nodo);
                nodo = nodo.izq;
            }
        }
        return arreglo;
    }

    /**
     * recorre el arbol en inorden
     *
     * @return un string con el recorrido del arbol
     */
    public String inOrden() {
        String arreglo = "";
        Stack<Nodo> pila = new Stack<>();
        Nodo nodo = raiz;
        while (nodo != null) {
            pila.add(nodo);
            nodo = nodo.izq;
        }
        while (!pila.isEmpty()) {
            nodo = pila.pop();
            arreglo += nodo.info + ", ";
            nodo = nodo.der;
            while (nodo != null) {
                pila.add(nodo);
                nodo = nodo.izq;
            }
        }
        return arreglo;
    }

    /**
     * recorre el arbol en postOrden
     *
     * @return un string con el recorrido del arbol
     */
    /*public String postOrden() {
        String arreglo = "";
        Stack<Nodo> pila = new Stack<>();
        Nodo nodo = raiz;
        while (nodo != null) {
            pila.add(nodo);
            nodo = nodo.izq;
        }
        while (!pila.isEmpty()) {
            if (nodo == null) {
                nodo = new Nodo(0);
            }
            if (nodo.der != null) {
                nodo = nodo.der;
                while (nodo != null) {
                    pila.add(nodo);
                    nodo = nodo.izq;
                }
            } else {
                nodo = pila.pop();
                arreglo += nodo.info + ", ";
            }
        }
        return arreglo;
    }*/
    public String postOrden() {
        String arreglo = "";
        Stack<Nodo> pila = new Stack<>();
        Nodo nodo = raiz;
        while (nodo != null) {
            //arreglo += nodo.info + ", ";
            pila.add(nodo);
            nodo = nodo.izq;
        }
        while (!pila.isEmpty()) {
            nodo = pila.pop();
            nodo = nodo.der;
            arreglo += nodo.info + ", ";
            while (nodo != null) {
                pila.add(nodo);
                arreglo += nodo.info + ", ";
                nodo = nodo.izq;
            }
        }
        return arreglo;
    }

    /**
     * recorre el arbol por niveles Posee errores
     *
     * @return un string con el recorrido del arbol
     */
    public String niveles() {
        String arreglo = "";
        Queue<Nodo> cola = new LinkedList<>();
        if (raiz != null) {
            cola.add(raiz);
        }
        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            arreglo += nodo.info + ", ";
            if (nodo.izq != null) {
                cola.add(nodo.izq);
            }
            if (nodo.der != null) {
                cola.add(nodo.der);
            }
        }
        return arreglo;
    }

    public Nodo getRaiz() {
        return raiz;
    }

}
