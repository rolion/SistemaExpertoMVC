/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto.Entidad;

/**
 *
 * @author Lion
 */
public class Tupla {
    private String nombre;
    private int varlorI;
    private int valorF;

    public Tupla() {
    }

    public Tupla(String nombre, int varlorI, int valorF) {
        this.nombre = nombre;
        this.varlorI = varlorI;
        this.valorF = valorF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVarlorI() {
        return varlorI;
    }

    public void setVarlorI(int varlorI) {
        this.varlorI = varlorI;
    }

    public int getValorF() {
        return valorF;
    }

    public void setValorF(int valorF) {
        this.valorF = valorF;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
    
}
