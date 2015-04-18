/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto.util;

import java.util.ArrayList;
import sistemaexperto.Entidad.TablaVal;
import sistemaexperto.Entidad.TablaVar;

/**
 *
 * @author Lion
 */
public abstract class aTablaVal {
    public void validarTablaVal(){
        if (GV.tablaVal==null){
            GV.tablaVal= new TablaVal();
        }
    }
    public void validarTablaVar(){
        if (GV.tablaVar==null){
            GV.tablaVar= new TablaVar();
        }
    }
}
