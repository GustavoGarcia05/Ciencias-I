/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.RN;

import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class ArbolRN {

    public NodoRN raiz;
    public NodoRN z;
    final int negro = 0;
    final int rojo = 1;

    public void inicializar() {
        z = new NodoRN(0, negro);
        z.izq = z;
        z.der = z;
        raiz = new NodoRN(0, negro);
        raiz.izq = z;
        raiz.der = z;
    }

    NodoRN rotar(int v, NodoRN p) {
        NodoRN c, gc;
        if (v < p.llave) {
            c = p.izq;
        } else {
            c = p.der;
        }
        if (v < c.llave) {
            gc = c.izq;
            c.izq = gc.der;
            gc.der = c;
        } else {
            gc = c.der;
            c.der = gc.izq;
            gc.izq = c;
        }
        if (v < p.llave) {
            p.izq = gc;
        } else {
            p.der = gc;
        }
        return gc;
    }

    NodoRN dividir(int v, NodoRN gf, NodoRN g, NodoRN p, NodoRN x) {
        x.color = rojo;
        x.izq.color = negro;
        x.der.color = negro;
        if (p.color == rojo) {
            g.color = rojo;
            if ((v < g.llave) != (v < p.llave)) {
                System.out.println("sentido contrario-" + gf.llave);
                p = rotar(v, g);
            }
            System.out.println("mismo sentido- " + gf.llave);
            x = rotar(v, gf);
            x.color = negro;
        }
        raiz.der.color = negro;
        return x;
    }

    /**
     * Inserta un llave en el arbol rojinegro
     *
     * @return un nodoRN
     */
    public NodoRN insertar(int v) {
        NodoRN gf, g, p, x;

        x = raiz;
        p = x;
        g = x;
        do {
            if (v < x.llave) {
                gf = g;
                g = p;
                p = x;
                x = x.izq;
            } else if (v > x.llave) {
                gf = g;
                g = p;
                p = x;
                x = x.der;
            } else {
                System.out.println("la llave ya existe" + v);
                return z;
            }
            if (x.izq.color == rojo && x.der.color == rojo) {
                x = dividir(v, gf, g, p, x);
            }
        } while (x != z);
        x = new NodoRN(v); //color sin asignar todavia
        x.llave = v;
        x.izq = x.der = z;
        if (v < p.llave) {
            p.izq = x;
        } else {
            p.der = x;
        }
        x = dividir(v, gf, g, p, x);
        return x;
    }

    boolean colorRojo(NodoRN raiz) {
        return raiz != z && raiz.color == rojo;
    }

    NodoRN simpleRotacion(NodoRN raiz, int dir) {
        NodoRN temp;
        if (dir == 1) {
            System.out.println("simple rotacion a la der.");
            temp = raiz.izq;
            raiz.izq = temp.der;
            temp.der = raiz;
        } else {
            System.out.println("simple rotacion a la izq");
            temp = raiz.der;
            raiz.der = temp.izq;
            temp.izq = raiz;
        }
        raiz.color = rojo;
        temp.color = negro;
        return temp;
    }

    NodoRN doblerotacion(NodoRN raiz, int dir) {
        if (dir == 1) {
            raiz.izq = simpleRotacion(raiz.izq, 0);
        } else {
            raiz.der = simpleRotacion(raiz.der, 1);
        }
        return simpleRotacion(raiz, dir);
    }

    /**
     * elimina un dato en el arbol
     *
     * @return el dato que se ha eliminado.
     */
    public int eliminar(NodoRN arbol, int llave) {
        if (arbol.der != z) {
            NodoRN cabeza = new NodoRN(0);
            cabeza.color = negro;
            cabeza.izq = z;
            cabeza.der = z;
            NodoRN temp, q, p, g;
            NodoRN t, f = z;
            int dir = 1;

            q = cabeza;
            g = p = z;
            q.der = arbol.der;

            t = q.der;

            while (t != z) {
                int anterior = dir;
                NodoRN w, v;

                g = p;
                p = q;

                if (anterior == 0) {
                    v = p.der;
                } else {
                    v = p.izq;
                }
                if (dir == 0) {
                    q = q.izq;
                } else {
                    q = q.der;
                }
                //actualiza dir
                if (q.llave < llave) {
                    dir = 1;
                } else {
                    dir = 0;
                }
                if (q.llave == llave) {
                    f = q;
                }
                if (dir == 0) {
                    t = q.izq;
                    w = q.der;
                } else {
                    t = q.der;
                    w = q.izq;
                }
                if (!colorRojo(q) && !colorRojo(t)) {
                    if (colorRojo(w)) {
                        temp = simpleRotacion(q, dir);
                        if (anterior == 0) {
                            p.izq = temp;
                        } else {
                            p.der = temp;
                        }
                        p = temp;
                    } else if (!colorRojo(w)) {
                        NodoRN s = v;
                        NodoRN r1, v1;
                        if (anterior == 0) {
                            r1 = s.izq;
                            v1 = s.der;
                        } else {
                            r1 = s.der;
                            v1 = s.izq;
                        }
                        if (s != z) {
                            if (!colorRojo(v1) && !colorRojo(r1)) {
                                p.color = negro;
                                s.color = rojo;
                                q.color = rojo;
                            } else {
                                int dir2;
                                NodoRN r2;
                                if (g.der == p) {
                                    dir2 = 1;
                                } else {
                                    dir2 = 0;
                                }
                                if (dir2 == 0) {
                                    r2 = g.izq;
                                } else {
                                    r2 = g.der;
                                }
                                if (colorRojo(r1)) {
                                    if (dir2 == 0) {
                                        System.out.println("doble rotacion a la izq");
                                        g.izq = doblerotacion(p, anterior);
                                    } else {
                                        System.out.println("doble rotacion a la der");
                                        g.der = doblerotacion(p, anterior);
                                    }
                                } else if (colorRojo(v1)) {
                                    if (dir2 == 0) {
                                        g.izq = simpleRotacion(p, anterior);
                                    } else {
                                        g.der = simpleRotacion(p, anterior);
                                    }
                                }
                                if (dir2 == 0) {
                                    r2 = g.izq;
                                } else {
                                    r2 = g.der;
                                }
                                q.color = r2.color = rojo;
                                r2.izq.color = negro;
                                r2.der.color = negro;
                            }
                        }///if(s!=z)
                    }///if(!colorRojo(w))
                }///if(!colorRojo(q)&&!colorRojo(t))
            }///while(terminar!=z)

            if (f != z) {
                NodoRN h = null;
                f.llave = q.llave;
                if (q.izq == z) {
                    h = q.der;
                } else {
                    h = q.izq;
                }
                if (p.der == q) {
                    p.der = h;
                } else {
                    p.izq = h;
                }
                q = null;
            } else {
                System.out.println("!no existe la llave");
            }
            arbol.der = cabeza.der;
            cabeza = null;
            if (arbol.der != z) {
                arbol.der.color = negro;
            }
        }
        return 1;
    }

    public void retirar(int n) {
        eliminar(raiz, n);
    }

    /**
     * busca un nodo en un arbol
     *
     * @return el nodo buscado, null en caso de que no lo encuentre.
     */
    public NodoRN buscar(int d, NodoRN r) {
        if (raiz == null) {
            return null;
        } else if (r.llave == d) {
            return r;
        } else if (r.llave < d) {
            return buscar(d, r.der);
        } else {
            return buscar(d, r.izq);
        }
    }

    /**
     * Metodo para obtener la raiz del arbol.
     *
     * @return la raiz del arbol
     */
    public NodoRN getRaiz() {
        return raiz;
    }

    public NodoRN getZ() {
        return z;
    }

}
