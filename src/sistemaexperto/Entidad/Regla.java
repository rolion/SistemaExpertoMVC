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
public class Regla {
    private List<Literal> premisa;
    private Hecho conclusion;
    private String nombre;

    public Regla() {
        this.nombre="";
    }

    public Regla(List<Literal> premisa, Hecho conclusion) {
        this.premisa = premisa;
        this.conclusion = conclusion;
        this.nombre="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void addLiteralToRegla(Literal literal){
        if(literal!=null)
        {
            if(this.premisa==null)
            this.premisa=new ArrayList();
            this.premisa.add(literal);
        }
    }
    public List<Literal> getPremisa() {
        return premisa;
    }

    public void setPremisa(List<Literal> premisa) {
        this.premisa = premisa;
    }

    public Hecho getConclusion() {
        return conclusion;
    }

    public void setConclusion(Hecho conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
}
