/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto.util;

import java.io.File;
import sistemaexperto.Entidad.BC;
import sistemaexperto.Entidad.TablaVal;
import sistemaexperto.Entidad.TablaVar;

/**
 *
 * @author Lion
 */
public class GV {
    public static File homeFile;
    public static TablaVal tablaVal;
    public static TablaVar tablaVar;
    public static BC tableBC;
    
    //-------OPREL-------
    
    public static final int igual=0;
    public static final int diferente=1;
    public static final int mayor=2;
    public static final int mayorI=3;
    public static final int menor=4;
    public static final int menorI=5;
    //------------------------
    public static int disyuncion= 6;//v
    public static int conjuncion=7;//^
    
}
