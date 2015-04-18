/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto.util;

import sistemaexperto.Entidad.Tupla;

/**
 *
 * @author Lion
 */
public interface listenerVariable {

    public void updateVarTextArea(Tupla tupla);
    public void updateValList(Tupla tupla);
    public void removeTupla(Tupla tupla);
    public void removeValor(String valor);
}
