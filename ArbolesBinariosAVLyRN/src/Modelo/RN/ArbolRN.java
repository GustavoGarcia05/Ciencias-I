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
    public int contadorIns = 0;
    public int contadorEli = 0;

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
            contadorIns += 1;
            c = p.izq;
        } else {
            contadorIns += 1;
            c = p.der;
        }
        if (v < c.llave) {
            contadorIns += 1;
            gc = c.izq;
            c.izq = gc.der;
            gc.der = c;
        } else {
            contadorIns += 1;
            gc = c.der;
            c.der = gc.izq;
            gc.izq = c;
        }
        if (v < p.llave) {
            contadorIns += 1;
            p.izq = gc;
        } else {
            contadorIns += 1;
            p.der = gc;
        }
        return gc;
    }

    NodoRN dividir(int v, NodoRN gf, NodoRN g, NodoRN p, NodoRN x) {
        x.color = rojo;
        x.izq.color = negro;
        x.der.color = negro;
        if (p.color == rojo) {
            contadorIns += 1;
            g.color = rojo;
            if ((v < g.llave) != (v < p.llave)) {
                contadorIns += 1;
//                System.out.println("sentido contrario-" + gf.llave);
                p = rotar(v, g);
            }
//            System.out.println("mismo sentido- " + gf.llave);
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
                contadorIns += 1;
                gf = g;
                g = p;
                p = x;
                x = x.izq;
            } else if (v > x.llave) {
                contadorIns += 1;
                gf = g;
                g = p;
                p = x;
                x = x.der;
            } else {
                contadorIns += 1;
//                System.out.println("la llave ya existe" + v);
                return z;
            }
            if (x.izq.color == rojo && x.der.color == rojo) {
                contadorIns += 1;
                x = dividir(v, gf, g, p, x);
            }
        } while (x != z);
        x = new NodoRN(v); //color sin asignar todavia
        x.llave = v;
        x.izq = x.der = z;
        if (v < p.llave) {
            contadorIns += 1;
            p.izq = x;
        } else {
            contadorIns += 1;
            p.der = x;
        }
        x = dividir(v, gf, g, p, x);
        System.out.println("Cantidad de if para insertar los numeros en RN: " + contadorIns);
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
            contadorEli += 1;
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
                    contadorEli += 1;
                    v = p.der;
                } else {
                    contadorEli += 1;
                    v = p.izq;
                }
                if (dir == 0) {
                    contadorEli += 1;
                    q = q.izq;
                } else {
                    contadorEli += 1;
                    q = q.der;
                }
                //actualiza dir
                if (q.llave < llave) {
                    dir = 1;
                    contadorEli += 1;
                } else {
                    dir = 0;
                    contadorEli += 1;
                }
                if (q.llave == llave) {
                    f = q;
                    contadorEli += 1;
                }
                if (dir == 0) {
                    t = q.izq;
                    w = q.der;
                    contadorEli += 1;
                } else {
                    t = q.der;
                    w = q.izq;
                    contadorEli += 1;
                }
                if (!colorRojo(q) && !colorRojo(t)) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        contadorEli += 1;
                    if (colorRojo(w)) {
                        contadorEli += 1;
                        temp = simpleRotacion(q, dir);
                        if (anterior == 0) {
                            p.izq = temp;
                            contadorEli += 1;
                        } else {
                            p.der = temp;
                            contadorEli += 1;
                        }
                        p = temp;
                    } else if (!colorRojo(w)) {
                        NodoRN s = v;
                        NodoRN r1, v1;
                        contadorEli += 1;
                        if (anterior == 0) {
                            r1 = s.izq;
                            v1 = s.der;
                            contadorEli += 1;
                        } else {
                            r1 = s.der;
                            v1 = s.izq;
                            contadorEli += 1;
                        }
                        if (s != z) {
                            contadorEli += 1;
                            if (!colorRojo(v1) && !colorRojo(r1)) {
                                p.color = negro;
                                s.color = rojo;
                                q.color = rojo;
                                contadorEli += 1;
                            } else {
                                int dir2;
                                NodoRN r2;
                                contadorEli += 1;
                                if (g.der == p) {
                                    dir2 = 1;
                                    contadorEli += 1;
                                } else {
                                    dir2 = 0;
                                    contadorEli += 1;
                                }
                                if (dir2 == 0) {
                                    r2 = g.izq;
                                    contadorEli += 1;
                                } else {
                                    r2 = g.der;
                                    contadorEli += 1;
                                }
                                if (colorRojo(r1)) {
                                    contadorEli += 1;
                                    if (dir2 == 0) {
                                        System.out.println("doble rotacion a la izq");
                                        g.izq = doblerotacion(p, anterior);
                                        contadorEli += 1;
                                    } else {
                                        System.out.println("doble rotacion a la der");
                                        g.der = doblerotacion(p, anterior);
                                        contadorEli += 1;
                                    }
                                } else if (colorRojo(v1)) {
                                    contadorEli += 1;
                                    if (dir2 == 0) {
                                        g.izq = simpleRotacion(p, anterior);
                                        contadorEli += 1;
                                    } else {
                                        g.der = simpleRotacion(p, anterior);
                                        contadorEli += 1;
                                    }
                                }
                                if (dir2 == 0) {
                                    r2 = g.izq;
                                    contadorEli += 1;
                                } else {
                                    r2 = g.der;
                                    contadorEli += 1;
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
                contadorEli += 1;
                if (q.izq == z) {
                    h = q.der;
                    contadorEli += 1;
                } else {
                    h = q.izq;
                    contadorEli += 1;
                }
                if (p.der == q) {
                    p.der = h;
                    contadorEli += 1;
                } else {
                    p.izq = h;
                    contadorEli += 1;
                }
                q = null;
            } else {
                System.out.println("!no existe la llave");
                contadorEli += 1;
            }
            arbol.der = cabeza.der;
            cabeza = null;
            if (arbol.der != z) {
                arbol.der.color = negro;
                contadorEli += 1;
            }
        }
        return 1;
    }

    public void retirar(int n) {
        eliminar(raiz, n);
        System.out.println("Cantidad de if para eliminar el numero en RN: " + contadorEli);
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
