/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.AVL;

import java.util.Stack;

/**
 *
 * @author Gustavo
 */
public class ArbolAVL {

    public NodoAVL raiz;
    private int fila;
    public int contadorIns;
    public int contadorEli;

    public int getContadorIns() {
        return contadorIns;
    }

    public int getContadorEli() {
        return contadorEli;
    }
    

    public ArbolAVL() {
        raiz = null;
    }

    //Rotaciones
    private void rDerecha(NodoAVL p, NodoAVL q) {
        p.balance = 0;
        q.balance = 0;

        p.izq = q.der;
        q.der = p;
    }

    private void rIzquierda(NodoAVL p, NodoAVL q) {
        p.balance = 0;
        q.balance = 0;

        p.der = q.izq;
        q.izq = p;
    }

    private NodoAVL drDerecha(NodoAVL p, NodoAVL q) {

        NodoAVL r;

        r = q.der;
        q.der = r.izq;
        r.izq = q;
        p.izq = r.der;
        r.der = p;

        switch (r.balance) {
            case -1:
                q.balance = 1;
                p.balance = 0;
                break;
            case 0:
                q.balance = p.balance = 0;
                break;
            case 1:
                q.balance = 0;
                p.balance = -1;
                break;
        }
        r.balance = 0;
        return r;

    }

    private NodoAVL drIzquierda(NodoAVL p, NodoAVL q) {
        NodoAVL r;

        r = q.izq;
        q.izq = r.der;
        r.der = q;
        p.der = r.izq;
        r.izq = p;

        switch (r.balance) {
            case -1:
                q.balance = 0;
                q.balance = 1;
                break;
            case 0:
                q.balance = p.balance = 0;
                break;
            case 1:
                q.balance = -1;
                p.balance = 0;
                break;

        }
        r.balance = 0;
        return r;
    }

    // Insertar
    private int insertarAVL(int n) {

        NodoAVL nuevo, p, q, s, pivote, pp;
        int llave, altura;

        nuevo = new NodoAVL(n);

        if (raiz == null) {
            raiz = nuevo;
            return 1; //el arbol tiene un solo nodo
        }

        pp = q = null;
        pivote = p = raiz;
        llave = nuevo.dato;

        while (p != null) {

            if (p.balance != 0) {
                pp = q;
                pivote = p;
                contadorIns += 1;
            }
            if (llave == p.dato) {
                contadorIns += 1;
                return 2; //ya existe
            } else {
                contadorIns += 1;
                q = p;
                if (llave < p.dato) {
                    contadorIns += 1;
                    p = p.izq;
                } else {
                    contadorIns += 1;
                    p = p.der;
                }

            }
        }

        if (llave < q.dato) {
            contadorIns += 1;
            q.izq = nuevo;
        } else {
            contadorIns += 1;
            q.der = nuevo;
        }

        if (llave < pivote.dato) {
            s = pivote.izq;
            altura = 1;
            contadorIns += 1;
        } else {
            contadorIns += 1;
            s = pivote.der;
            altura = -1;
        }

        p = s;
        while (p != nuevo) {
            if (llave < p.dato) {
                contadorIns += 1;
                p.balance = 1;
                p = p.izq;
            } else {
                contadorIns += 1;
                p.balance = -1;
                p = p.der;
            }
        }

        if (pivote.balance == 0) {
            contadorIns += 1;
            pivote.balance = altura;
        } else if (pivote.balance + altura == 0) {
            contadorIns += 1;
            pivote.balance = 0;
        } else {
            contadorIns += 1;
            if (altura == 1) {
                contadorIns += 1;
                if (s.balance == 1) {
                    contadorIns += 1;
                    rDerecha(pivote, s);
                } else {
                    contadorIns += 1;
                    s = drDerecha(pivote, s);
                }
            } else {
                contadorIns += 1;
                // esta puede ser la que esta mal
                if (s.balance == -1) {
                    contadorIns += 1;
                    rIzquierda(pivote, s);
                } else {
                    contadorIns += 1;
                    s = drIzquierda(pivote, s);
                }
            }

            if (pp == null) {
                contadorIns += 1;
                raiz = s;
            } else if (pp.izq == pivote) {
                contadorIns += 1;
                pp.izq = s;
            } else {
                contadorIns += 1;
                pp.der = s;
            }
        }
        return 1;
    }

    public void insertar(int d) {
        insertarAVL(d);
        System.out.println("** Cantidad de if para insertar los numeros en AVL: " + contadorIns);
    }

    //Retirar
    private NodoAVL bal_der(NodoAVL q, int[] terminar) {
        NodoAVL t = null;

        switch (q.balance) {
            case 1:
                q.balance = 0;
                break;
            case -1:
                t = q.der;
                switch (t.balance) {
                    case 1:
                        t = drIzquierda(q, t);
                        break;
                    case -1:
                        rIzquierda(q, t);
                        break;
                    case 0:
                        q.der = t.izq;
                        t.izq = q;
                        t.balance = 1;
                        terminar[0] = 1;
                        break;
                }
                break;

            case 0:
                q.balance = -1;
                terminar[0] = 1;
                break;
        }
        return t;
    }

    private NodoAVL bal_izq(NodoAVL q, int[] terminar) {
        NodoAVL t = null;
        switch (q.balance) {
            case -1:
                q.balance = 0;
                break;
            case 1:
                t = q.izq;
                switch (t.balance) {
                    case 1:
                        rDerecha(q, t);
                        break;
                    case -1:
                        t = drDerecha(q, t);
                        break;
                    case 0:
                        q.izq = t.der;
                        t.der = q;
                        t.balance = -1;
                        terminar[0] = 1;
                        break;
                }
                break;
            case 0:
                q.balance = 1;
                terminar[0] = 1;
                break;
        }
        return t;
    }

    private void initFila() {
        fila = 0;
    }

    private int retirarAVL(int n) {
        Stack pila = new Stack();
        NodoAVL p, q, t, r;
        int llave, accion;

        // para trabajar termina por referencia
        int[] terminar = new int[1];

        boolean encontro = false;

        if (raiz == null) {
            contadorEli += 1;
            return 1;
        }

        terminar[0] = 0;
        p = raiz;

        while (!encontro && p != null) {
            pila.push(p);
            if (n < p.dato) {
                p = p.izq;
                contadorEli += 1;
            } else if (n > p.dato) {
                p = p.der;
                contadorEli += 1;
            } else {
                encontro = true;
                contadorEli += 1;
            }
        }

        if (!encontro) {
            contadorEli += 1;
            return 2;
        }

        t = null;

        p = (NodoAVL) pila.pop();
        llave = p.dato;
        if (p.izq == null && p.der == null) {
            accion = 0;
            contadorEli += 1;
        } else if (p.der == null) {
            accion = 1;
            contadorEli += 1;
        } else if (p.izq == null) {
            accion = 2;
            contadorEli += 1;
        } else {
            accion = 3;
            contadorEli += 1;
        }

        if (accion == 0 || accion == 1 || accion == 2) {
            contadorEli += 1;
            if (!pila.empty()) {
                contadorEli += 1;
                q = (NodoAVL) pila.pop();
                if (llave < q.dato) {
                    contadorEli += 1;
                    switch (accion) {
                        case 0:
                        case 1:
                            q.izq = p.izq;
                            t = bal_der(q, terminar);
                            break;
                        case 2:
                            q.izq = p.der;
                            t = bal_der(q, terminar);
                            break;
                    }
                } else {
                    contadorEli += 1;
                    switch (accion) {
                        case 0:
                        case 2:
                            q.der = p.der;
                            t = bal_izq(q, terminar);
                            break;
                        case 1:
                            q.der = p.der;
                            t = bal_izq(q, terminar);
                            break;
                    }
                }
            } else {
                contadorEli += 1;
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
            contadorEli += 1;
            while (p.izq != null) {
                pila.push(p);
                q = p;
                p = p.izq;
            }
            llave = r.dato = p.dato;

            if (q != null) {
                q.izq = p.der;
                t = bal_der(q, terminar);
                contadorEli += 1;
            } else {
                r.der = p.der;
                t = bal_izq(r, terminar);
                contadorEli += 1;
            }
            q = (NodoAVL) pila.pop();
        }

        while (!pila.empty() && terminar[0] == 0) {
            q = (NodoAVL) pila.pop();
            if (llave < q.dato) {
                contadorEli += 1;
                if (t != null) {
                    q.izq = t;
                    t = null;
                    contadorEli += 1;
                }
                t = bal_der(q, terminar);
            } else {
                contadorEli += 1;
                if (t != null) {
                    q.der = t;
                    t = null;
                    contadorEli += 1;
                }
                t = bal_izq(q, terminar);
            }
        }

        if (t != null) {
            contadorEli += 1;
            if (pila.empty() == true) {
                raiz = t;
                contadorEli += 1;
            } else {
                q = (NodoAVL) pila.pop();
                contadorEli += 1;
                if (llave < q.dato) {
                    q.izq = t;
                    contadorEli += 1;
                } else {
                    q.der = t;
                    contadorEli += 1;
                }
            }
        }
        return 0;
    }

    public void retirar(int d) {
        retirarAVL(d);
        System.out.println("** Cantidad de if para eliminar el numero en AVL: " + contadorEli);
    }

    public NodoAVL getRaiz() {
        return raiz;
    }
}
