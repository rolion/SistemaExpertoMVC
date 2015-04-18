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
public class TablaVar {
    private List<Tupla> lista;

    public TablaVar() {
    }

    public List<Tupla> getLista() {
        return lista;
    }

    public void setLista(List<Tupla> lista) {
        this.lista = lista;
    }

    public TablaVar(List<Tupla> lista) {
        this.lista = lista;
    }
    public Tupla getTupla(int pos){
        Tupla t=null;
        if(lista!=null && pos>=0 && pos<lista.size())
            return lista.get(pos);
        return t;
    }
    public void addTupla(Tupla t){
        if(lista==null){
            this.lista=new ArrayList<>();
        }
        if(t!=null)
            lista.add(t);
    }
}
