/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto.Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lion
 */
public class BC {
    private List<Regla> reglas;

    public BC() {
    }

    public BC(List<Regla> reglas) {
        this.reglas = reglas;
    }

    public List<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }
    public void addRegla(Regla r){
        if(this.reglas==null){
            this.reglas=new ArrayList<>();
        }
        this.reglas.add(r);
    }
    
}
