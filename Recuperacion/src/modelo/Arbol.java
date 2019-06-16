package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Arbol {

    private NodoArbol raiz;
    private String inOrden;
    private String posOrden;
    private String preOrden;

    public Arbol() {
        raiz = null;
    }

    public void recibirInOrden(String in) {
        inOrden = in;
    }

    public void recibirPosOrden(String pos) {
        posOrden = pos;
    }

    public void recibirPreOrden(String pre) {
        preOrden = pre;
    }

    public boolean verificarLongitudInYPos() {
        if (inOrden.length() == posOrden.length()) {
            return true;
        }
        return false;
    }

    public boolean verificarLongitudInYPre() {
        if (inOrden.length() == posOrden.length()) {
            return true;
        }
        return false;
    }

    public boolean verificarLetraRepetida(String arbol) {
        for (int i = 0; i < arbol.length(); i++) {
            for (int j = i + 1; j < arbol.length(); j++) {
                if (arbol.charAt(i) == arbol.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }


    public void posicionLetra(char letra, String palabra) {
        System.out.println(posOrden.indexOf(letra));
    }
// matriz para reconstruir
    /*
    video de donde saqu la idea para construir la matriz
    https://www.youtube.com/watch?v=KY_6Xduq8jc
    */
    
    
    public void armandoMatrizInPre() {
        if (!verificarLongitudInYPos()) {
            return;
        }
        char[][] matrizInPre = new char[inOrden.length()][preOrden.length()];

        for (int i = 0; i < inOrden.length(); i++) {
            for (int j = 0; j < preOrden.length(); j++) {
                if (inOrden.charAt(i) == preOrden.charAt(j)) {
                    matrizInPre[j][i] = inOrden.charAt(i);
                } else {
                    matrizInPre[j][i] = '•';
                }
            }
        }
        imprimirMatriz(matrizInPre);

    }

    public void armandoMatrizInPos() {
        if (!verificarLongitudInYPos()) {
            return;
        }
        String posOrden="";
        for(int i=this.posOrden.length()-1;i>=0;i--){
            posOrden+=this.posOrden.charAt(i);
        }
        
        char[][] matrizInPos = new char[inOrden.length()][posOrden.length()];

        for (int i = 0; i < inOrden.length(); i++) {
            for (int j = 0; j < posOrden.length(); j++) {
                if (inOrden.charAt(i) == posOrden.charAt(j)) {
                    matrizInPos[j][i] = inOrden.charAt(i);
                } else {
                    matrizInPos[j][i] = '•';
                }
            }
        }
        
        imprimirMatriz(matrizInPos);
        
        

    }

    //metodo auxiliar para imprimir
    private void imprimirMatriz(char m[][]) {
        String aux;
        for (int i = 0; i < inOrden.length(); i++) {
            aux = "";
            for (int j = 0; j < posOrden.length(); j++) {
                aux += " " + m[i][j];
            }
            System.out.println(aux);
            //System.out.println("-----------------");
        }
    }

    public int tamanioLienzo() {
        return inOrden.length();
    }
    
    
    

}
