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
public class Literal extends Hecho{
    private boolean neg;
    private int oprel;

    public Literal(boolean neg, int oprel, int var, double valor) {
        super(var, valor);
        this.neg = neg;
        this.oprel = oprel;
    }

    public Literal(boolean neg, int oprel) {
        this.neg = neg;
        this.oprel = oprel;
    }

    @Override
    public void setValor(double valor) {
        super.setValor(valor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getValor() {
        return super.getValor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVar(int var) {
        super.setVar(var); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getVar() {
        return super.getVar(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isNeg() {
        return neg;
    }

    public void setNeg(boolean neg) {
        this.neg = neg;
    }

    public int getOprel() {
        return oprel;
    }

    public void setOprel(int oprel) {
        this.oprel = oprel;
    }

    @Override
    public String toString() {
        String negar=(isNeg()?"not (":"(");
        String literal=negar+GV.tablaVar.getLista().get(getVar()).getNombre();
        switch(getOprel()){
            case GV.igual:
                literal=literal+" = ";
                break;
            case GV.diferente:
                literal=literal+" <> ";
                break;
            case GV.mayor:
                literal=literal+" > ";
                break;
            case GV.mayorI:
                literal=literal+" >= ";
                break;
            case GV.menor:
                literal=literal+" < ";
                break;
            case GV.menorI:
                literal=literal+" <= ";
                break;
        }
        Tupla t=GV.tablaVar.getLista().get(getVar());
        if(t.getVarlorI()>-1)
            literal=literal+GV.tablaVal.getVal((int) getValor())+")";
        else
            literal=literal+String.valueOf(getValor())+")";
        return   literal;
    }

    

 
    
}
