/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gustavo_2
 */
public class Calculadora {

    private Pila pilaCalc = new Pila();
    private String expresion;

    //Jerarquia de los operadores
    private static int prioridad(String op) {
        int prf = 99;
        if (op.equals("^")) {
            prf = 5;
        }
        if (op.equals("*") || op.equals("/")) {
            prf = 4;
        }
        if (op.equals("+") || op.equals("-")) {
            prf = 3;
        }
        if (op.equals(")")) {
            prf = 2;
        }
        if (op.equals("(")) {
            prf = 1;
        }
        return prf;
    }

    void insertarExpresion(String exp) {
        expresion = exp;
        char[] encadena = expresion.toCharArray();
        for (int i = 0; i < encadena.length; i++) {
            switch (encadena[i]) {
                case '^':
                    pilaCalc.insertar(encadena[i]);
                    break;
                case '/':

                    break;
                case '*':
                    break;
                case '+':
                    break;
                case '-':
                    break;
                case '(':
                    break;
                case ')':
                    break;
            }
        }
    }

    String notacionPostFija(String exp) {
        expresion = exp;
        String retorno = "";
        char[] encadena = expresion.toCharArray();
        for (int i = 0; i < encadena.length; i++) {
            if (encadena[i] >= '0' && encadena[i] <= '9') {
                retorno += encadena[i];
            } else {
                switch (encadena[i]) {
                    case '^':
                        pilaCalc.insertar(encadena[i]);
                        break;
                    case '/':

                        break;
                    case '*':
                        break;
                    case '+':
                        break;
                    case '-':
                        break;
                    case '(':
                        break;
                    case ')':
                        pilaCalc.retirar();
                        break;
                }
            }
        }
        return retorno;
    }
}
