
import Modelo.ArbolBinario;
import Vista.PanelArbol;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo_2
 */
public class Control {

    private PanelArbol objLienzo; //VISTA
    private ArbolBinario objArbol; //MODELO

    public Control( ArbolBinario objArbol) {
//        this.objLienzo = objLienzo;
        this.objArbol = objArbol;
    }

    public void iniciar() {
        objLienzo.setObjArbol(objArbol);
    }

}
