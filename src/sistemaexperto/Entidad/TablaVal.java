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
public class TablaVal {
    private List<String> v;

    public TablaVal() {
    }

    public List<String> getV() {
        return v;
    }

    public void setV(List<String> v) {
        this.v = v;
    }

    public TablaVal(List<String> v) {
        this.v = v;
    }
    
    public void insertVal(String v){
        if(this.v==null)
            this.v=new ArrayList<String>();
        this.v.add(v);           
    }
    public String getVal(int pos){
        String rstl="";
        if(this.v!=null && pos>-1&& pos<this.v.size())
            rstl=this.v.get(pos);
        return rstl;
    }
}
