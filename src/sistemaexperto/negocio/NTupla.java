/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto.negocio;

import sistemaexperto.Entidad.Tupla;
import sistemaexperto.util.GV;
import sistemaexperto.util.aTablaVal;
import sistemaexperto.util.listenerVariable;

/**
 *
 * @author Lion
 */
public class NTupla extends aTablaVal {

    private listenerVariable listener;
    
    public NTupla() {
        validarTablaVal();
        validarTablaVar();
    }

    public NTupla(listenerVariable listener) {
        this.listener = listener;
        validarTablaVal();
        validarTablaVar();
    }
    
    public listenerVariable getListener() {
        return listener;
    }

    public void setListener(listenerVariable listener) {
        this.listener = listener;
        
    }
    
    public void insertTupla(Tupla t, String valor){
        
        if(t!=null){
            Tupla aux=exist(t);
            if(aux!=null) 
                t=aux;
            if(t.getVarlorI()==-2){
                //es numerica
                GV.tablaVar.addTupla(t);
            }else{
                if(t.getVarlorI()==-1){
                    //no tiene valores
                    GV.tablaVal.insertVal(valor);
                    t.setVarlorI(GV.tablaVal.getV().size()-1);
                    t.setValorF(GV.tablaVal.getV().size()-1);
                    GV.tablaVar.addTupla(t);
                }else{
                    GV.tablaVal.getV().add(t.getValorF()+1, valor);
                    t.setValorF(t.getValorF()+1);
                    //actualizar valores de tablaVar
                    for (int i = 0; i <= GV.tablaVar.getLista().size()-1; i++) {
                        Tupla tu=GV.tablaVar.getTupla(i);
                        if(!tu.getNombre().equals(t.getNombre()) && 
                                tu.getVarlorI()>=t.getValorF()-1){
                            tu.setVarlorI(tu.getVarlorI()+1);
                            tu.setValorF(tu.getValorF()+1);
                        }
                    }

                }
            }
            if(listener!=null && aux==null)
                listener.updateVarTextArea(t); 
            else if(listener!=null &&aux!=null){
                listener.updateValList(t);
            }
        }     
    }
    
    public Tupla exist(Tupla t){
        if(t!=null){
            if(GV.tablaVar.getLista()!=null){
                for (Tupla tupla : GV.tablaVar.getLista()) {
                    if(tupla.getNombre().equals(t.getNombre())){
                        t=tupla;
                        return t;
                    }
                }   
            }
        }
        return null;
    }
    public boolean deleteValVar(Tupla tupla, String valor){
        boolean rslt=true;
        if(tupla!=null && valor==null){
            int cont=0;
            if(tupla.getVarlorI()>-1){
                for(int i=tupla.getVarlorI(); i<=tupla.getValorF();i++){
                    GV.tablaVal.getV().remove(i-cont);
                    cont++;
                }
                updateVar(tupla, tupla.getValorF()-tupla.getVarlorI()+1);
            }
            
            GV.tablaVar.getLista().remove(tupla);
            if(this.listener!=null){
                this.listener.removeTupla(tupla);
                this.listener.updateValList(tupla);
            }
        }else if(tupla!=null && valor !=null){
            GV.tablaVal.getV().remove(valor);
            updateVar(tupla, 1);
        }else
            return false;
        
        return rslt;
    }
    
    private void updateVar(Tupla tupla, int cant){
        for(int i=0; i<GV.tablaVar.getLista().size();i++){
            Tupla t= GV.tablaVar.getLista().get(i);
            if(!t.getNombre().equals(tupla.getNombre()) &&
                    t.getVarlorI()>tupla.getValorF()){
                t.setVarlorI(t.getVarlorI()-cant);
                t.setValorF(t.getValorF()-cant);
            }
        }
    }
}
