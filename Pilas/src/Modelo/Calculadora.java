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

    private Pila pCalc = new Pila();
    private String expresion;

    public void insertarExpresion(String exp) {
        expresion = exp;
        char[] encadena = expresion.toCharArray();
        for (int i = 0; i < encadena.length; i++) {
            switch(encadena[i]){
                case '^':
                    pCalc.insertar(encadena[i]);
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

}
