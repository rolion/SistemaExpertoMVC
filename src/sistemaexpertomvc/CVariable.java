/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexpertomvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sistemaexperto.Entidad.Tupla;
import sistemaexperto.JPVariables;
import sistemaexperto.jFContenedor;
import sistemaexperto.negocio.NTupla;
import sistemaexperto.util.GV;
import sistemaexperto.util.listenerVariable;

/**
 *
 * @author Lion
 */
public class CVariable implements listenerVariable {

    private jFContenedor contenedor;
    private JPVariables pVariables;
    private NTupla nTupla;
    private DefaultListModel listmodelnombre;
    private DefaultListModel listmodelvalor;
    private Tupla selectedTupla;
    private String selectVal;
    public CVariable() {
        this.contenedor=new jFContenedor();
        this.pVariables=new JPVariables();
        contenedor.add(this.pVariables);
        contenedor.pack();
        nTupla=new NTupla();
        nTupla.setListener(this);
        listmodelnombre=new DefaultListModel();
        listmodelvalor= new DefaultListModel();
        initComponent();
        this.contenedor.setVisible(true);
    }
    private void cargarBase(){
        if(GV.tablaVar!=null && GV.tablaVar.getLista()!=null){
            for (Tupla tupla : GV.tablaVar.getLista()) {
                this.listmodelnombre.addElement(tupla);
            }
            this.pVariables.jLNombre.setModel(listmodelnombre);
            this.pVariables.jLNombre.updateUI();
            if(GV.tablaVar.getLista().size()>0)
                updateValList(GV.tablaVar.getLista().get(0));
        }
    }
    private void initComponent(){
        this.pVariables.jRBnumerica.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pVariables.jRBescalar.setSelected(false);
                pVariables.jTFvalor.setEnabled(false);
                pVariables.jTFnombre.setEnabled(true);
                pVariables.jTFnombre.setText("");
                pVariables.jTFvalor.setText("");
            }
        });
        this.pVariables.jRBescalar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pVariables.jRBnumerica.setSelected(false);
                pVariables.jTFvalor.setEnabled(true);
                pVariables.jTFnombre.setEnabled(true);
                pVariables.jTFnombre.setText("");
                pVariables.jTFvalor.setEnabled(true);
                pVariables.jTFvalor.setText("");
            }
        });
        this.pVariables.jBguardar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Tupla t=new Tupla(pVariables.jTFnombre.getText(), -2, -1);
                // nTupla.exist(t);
                 if(pVariables.jRBnumerica.isSelected()){

                     nTupla.insertTupla(t, "");
                 }else{
                     t.setVarlorI(-1);
                     nTupla.insertTupla(t, pVariables.jTFvalor.getText());
                 }
            }        
        });
        this.pVariables.jBeliminar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(selectedTupla!=null){
                    nTupla.deleteValVar(selectedTupla, selectVal);
                }
            }
             
        });
        this.pVariables.jLNombre.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                 if (!e.getValueIsAdjusting()){
                    selectedTupla =(Tupla)((JList)e.getSource())
                            .getSelectedValue();
                    selectVal=null;
                     updateValorList(selectedTupla);
                }
            }
        });
        this.pVariables.jLvalor.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    selectVal =(String)((JList)e.getSource())
                            .getSelectedValue();
                }
            }
        });
        cargarBase();
    }

    @Override
    public void updateVarTextArea(Tupla tupla) {
        this.listmodelnombre.addElement(tupla);
        pVariables.jLNombre.setModel(listmodelnombre);
    }
    private void updateValorList(Tupla tupla){
        this.listmodelvalor=new DefaultListModel();
        if(tupla!=null && tupla.getVarlorI()!=-2){
            
            for(int i=tupla.getVarlorI(); i<=tupla.getValorF();i++){
                this.listmodelvalor.addElement(GV.tablaVal.getVal(i));
            }
        }else
            this.listmodelvalor.addElement("");
        
        pVariables.jLvalor.setModel(listmodelvalor);
    }

    @Override
    public void removeTupla(Tupla tupla) {
        if(tupla!=null)
        {
            this.listmodelnombre.removeElement(tupla);
            pVariables.jLNombre.updateUI();
        }
        
    }

    @Override
    public void removeValor(String valor) {
        if(valor!=null){
            this.listmodelvalor.removeElement(valor);
            pVariables.jLvalor.updateUI();
        }
    }

    @Override
    public void updateValList(Tupla tupla) {
        updateValorList(tupla);
    }
    
    
}
