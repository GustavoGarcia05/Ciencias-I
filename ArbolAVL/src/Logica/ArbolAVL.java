/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * clase donde se implementa un arbol AVL. Los metodos insertar, eliminar, los
 * balanceos y las rotaciones son tomados de la pagina porcomputador.com, pero
 * modificados para asegurar su funcionamiento.
 *
 * @author estudiantes
 */
public class ArbolAVL {

    Nodo raiz;

     
    //prueba 
    public ArbolAVL() {
        this.raiz = null;
    }

    /**
     * Inserta un nodo en el arbol AVL
     *
     * @param dato dato que le ingresa al arbol
     */
    public boolean insertar(int dato) {
        Nodo nuevo, p, q, s, pivote, pp;
        int llave, altura;

        nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
            return true;
        }
        pp = q = null;
        pivote = p = raiz;
        llave = nuevo.info;
        while (p != null) {
            if (p.balance != 0) {
                pp = q;
                pivote = p;
            }
            if (llave == p.info) {
                return false;
            } else {
                q = p;
                if (llave < p.info) {
                    p = p.izq;
                } else {
                    p = p.der;
                }
            }
        }
        if (llave < q.info) {
            q.izq = nuevo;
        } else {
            q.der = nuevo;
        }
        if (llave < pivote.info) {
            s = pivote.izq;
            altura = -1;
        } else {
            s = pivote.der;
            altura = -1;
        }
        p = s;
        while (p != nuevo) {
            if (llave < p.info) {
                p.balance = 1;
                p = p.izq;
            } else {
                p.balance = 1;
                p = p.der;
            }
        }
        if (pivote.balance == 0) {
            pivote.balance = altura;
        } else if (pivote.balance + altura == 0) {
            pivote.balance = 0;
        } else {
            if (altura == 1) {
                if (s.balance == 1) {
                    rotacionSimpleDerecha(pivote, s);
                } else {
                    s = rotacionDobleDerecha(pivote, s);
                }
                if (s.balance == -1) {
                    rotacionSimpleIzquierda(pivote, s);
                } else {
                    s = rotacionDobleIzquierda(pivote, s);
                }
                if (pp == null) {
                    raiz = s;
                } else if (pp.izq == pivote) {
                    pp.izq = s;
                } else {
                    pp.der = s;
                }
            }
        }
        return false;
    }

    /**
     * Rotacion simple a la derecha dado un nodo padre y un hijo
     *
     * @param padre nodo padre o donde se produce el desbalanceo
     * @param hijo nodo hijo o rama donde se desbalanceo
     */
    void rotacionSimpleDerecha(Nodo padre, Nodo hijo) {
        padre.balance = 0;
        hijo.balance = 0;
        padre.izq = hijo.der;
        hijo.der = padre;
    }

    /**
     * Rotacion simple a la izquierda dado un nodo padre y un hijo
     *
     * @param padre nodo padre o donde se produce el desbalanceo
     * @param hijo nodo hijo o rama donde se desbalanceo
     */
    void rotacionSimpleIzquierda(Nodo padre, Nodo hijo) {
        padre.balance = 0;
        hijo.balance = 0;
        padre.der = hijo.izq;
        hijo.izq = padre;
    }

    /**
     * Rotacion doble a la derecha dado un nodo padre y un hijo
     *
     * @param padre nodo padre o donde se produce el desbalanceo
     * @param hijo nodo hijo o rama donde se desbalanceo
     */
    Nodo rotacionDobleDerecha(Nodo padre, Nodo hijo) {

        Nodo r;

        r = hijo.der;
        hijo.der = r.izq;
        r.izq = hijo;
        padre.izq = r.der;
        r.der = padre;
        switch (r.balance) {
            case -1:
                hijo.balance = 1;
                padre.balance = 0;
                break;
            case 0:
                hijo.balance = padre.balance = 0;
                break;
            case 1:
                hijo.balance = 0;
                padre.balance = -1;
                break;
        }
        r.balance = 0;
        return r;
    }

    /**
     * Rotacion doble a la izquierda dado un nodo padre y un hijo
     *
     * @param padre nodo padre o donde se produce el desbalanceo
     * @param hijo nodo hijo o rama donde se desbalanceo
     */
    Nodo rotacionDobleIzquierda(Nodo padre, Nodo hijo) {
        Nodo r;

        r = hijo.izq;
        hijo.izq = r.der;
        r.der = hijo;
        padre.der = r.izq;
        r.izq = padre;
        switch (r.balance) {
            case -1:
                hijo.balance = 0;
                padre.balance = 1;
                break;
            case 0:
                hijo.balance = padre.balance = 0;
                break;
            case 1:
                hijo.balance = -1;
                padre.balance = 0;
                break;
        }
        r.balance = 0;
        return r;
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
     * Elimina un nodo dado
     *
     * @param n valor a eliminar en el arbol
     *
     * @return 1 cuando la raiz es nula, 0 cuando se elimino el nodo y 2 cuando
     * el nodo no se encuentra en el arbol
     */
    public int eliminar(int n) {
        Stack pila = new Stack();
        Nodo p, q, t, r;
        int llave, accion;

        int[] terminar = new int[1];        //para trabajar terminar por referencia

        boolean encontro = false;

        if (raiz == null) {
            return 1;
        }
        terminar[0] = 0;

        p = raiz;

        /*busca el dato en el arbol. no se puede remplazar por el metodo buscar 
        poque la direccion de p que se obtiene de este metodo se usa mas adelante */
        while (!encontro && p != null) {
            pila.push(p);
            if (n < p.info) {
                p = p.izq;
            } else if (n > p.info) {
                p = p.der;
            } else {
                encontro = true;
            }
        }

        if (!encontro) {
            return 2;
        }
        t = null;
        p = (Nodo) pila.pop();
        llave = p.info;
        if (p.izq == null && p.der == null) {
            accion = 0;
        } else if (p.der == null) {
            accion = 1;
        } else if (p.izq == null) {
            accion = 2;
        } else {
            accion = 3;
        }
        if (accion == 3 || accion == 1 || accion == 2) {
            if (!pila.empty()) {
                q = (Nodo) pila.pop();
                if (llave < q.info) {
                    switch (accion) {
                        case 0:
                        case 1:
                            q.izq = p.izq;
                            t = balanceoDerecha(q, terminar);
                            break;
                        case 2:
                            q.izq = p.der;
                            t = balanceoIzquierda(q, terminar);
                            break;
                    }
                } else {
                    switch (accion) {
                        case 0:
                        case 1:
                            q.der = p.izq;
                            t = balanceoIzquierda(q, terminar);
                            break;
                        case 2:
                            q.der = p.der;
                            t = balanceoIzquierda(q, terminar);
                            break;
                    }
                }
            } else {
                switch (accion) {
                    case 0:
                        raiz = null;
                        terminar[0] = 1;
                        break;
                    case 1:
                        raiz = p.izq;
                        break;
                    case 2:
                        raiz = p.der;
                        break;
                }
            }
        } else {
            pila.push(p);
            r = p;
            p = r.der;
            q = null;
            while (p.izq != null) {
                pila.push(p);
                q = p;
                p = p.izq;
            }
            llave = r.info = p.info;
            if (q != null) {
                q.izq = p.der;
                t = balanceoDerecha(q, terminar);
            } else {
                r.der = p.der;
                t = balanceoIzquierda(r, terminar);
            }
            q = (Nodo) pila.pop();
        }
        while (!pila.empty() && terminar[0] == 0) {
            q = (Nodo) pila.pop();
            if (llave < q.info) {
                if (t != null) {
                    q.izq = t;
                    t = null;
                }
                t = balanceoDerecha(q, terminar);
            } else {
                if (t != null) {
                    q.der = t;
                    t = null;
                }
                t = balanceoIzquierda(q, terminar);
            }
        }
        if (t != null) {
            if (pila.empty()) {
                raiz = t;
            } else {
                q = (Nodo) pila.pop();
                if (llave < q.info) {
                    q.izq = t;
                } else {
                    q.der = t;
                }
            }
        }
        return 0;
    }

    Nodo balanceoDerecha(Nodo q, int[] terminar) {
        Nodo t = null;
        switch (q.balance) {
            case -1:
                t = q.der;
                switch (t.balance) {
                    case -1:
                        rotacionSimpleIzquierda(q, t);
                        break;
                    case 0:
                        q.der = t.izq;
                        t.izq = q;
                        t.balance = 1;
                        terminar[0] = 1;
                        break;
                    case 1:
                        t = rotacionDobleIzquierda(q, t);
                        break;
                }
                break;
            case 0:
                q.balance = -1;
                terminar[0] = 1;
                break;
            case 1:
                q.balance = 0;
                break;
        }
        return t;
    }

    Nodo balanceoIzquierda(Nodo q, int[] terminar) {
        Nodo t = null;
        switch (q.balance) {
            case -1:
                q.balance = 0;
                break;
            case 0:
                q.balance = 1;
                terminar[0] = 1;
                break;
            case 1:
                t = q.izq;
                switch (t.balance) {
                    case -1:
                        t = rotacionDobleDerecha(q, t);
                        break;
                    case 0:
                        q.izq = t.der;
                        t.der = q;
                        t.balance = -1;
                        terminar[0] = 1;
                        break;
                    case 1:
                        rotacionSimpleDerecha(q, t);
                        break;
                }
                break;
        }
        return t;
    }

    /**
     * Recorre el arbol en pre-orden
     *
     * @return un string con el recorrido del arbol
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
     * recorre el arbol por niveles Posee errores
     *
     * @return un string con el recorrido del arbol
     */
    public String niveles() {
        String arreglo = "";
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
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

    /**
     * Metodo para obtener la raiz del arbo
     *
     * @return la raiz del arbol que es tipo Nodo.
     */
    public Nodo getRaiz() {
        return raiz;
    }

}
