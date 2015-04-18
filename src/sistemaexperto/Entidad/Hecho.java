/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto.Entidad;

import sistemaexperto.util.GV;

/**
 *
 * @author Lion
 */
public class Hecho {
    private int var;
    private double valor;

    public Hecho() {
    }

    public Hecho(int var, double valor) {
        this.var = var;
        this.valor = valor;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
         Tupla t=GV.tablaVar.getLista().get(getVar());
         String hecho=GV.tablaVar.getLista().get(this.getVar()).getNombre() + " = ";
        if(t.getVarlorI()>-1)
            hecho=hecho+GV.tablaVal.getVal((int) getValor());
        else
            hecho=hecho+String.valueOf(getValor());
        
        return hecho ;
    }
    
    
}
