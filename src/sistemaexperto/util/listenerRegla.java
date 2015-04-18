/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto.util;

import sistemaexperto.Entidad.Hecho;
import sistemaexperto.Entidad.Literal;
import sistemaexperto.Entidad.Regla;

/**
 *
 * @author Lion
 */
public interface listenerRegla {
    
    public void addLiteral(Literal l);
    public void addHehco(Hecho hecho);
    
}
