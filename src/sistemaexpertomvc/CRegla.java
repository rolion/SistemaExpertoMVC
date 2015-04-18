/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexpertomvc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sistemaexperto.Entidad.Hecho;
import sistemaexperto.Entidad.Literal;
import sistemaexperto.Entidad.Regla;
import sistemaexperto.JFEditarRegla;
import sistemaexperto.JPRegla;
import sistemaexperto.jFContenedor;
import sistemaexperto.util.GV;
import sistemaexperto.util.listenerBC;
import sistemaexperto.util.listenerRegla;

/**
 *
 * @author Lion
 */

public class CRegla implements listenerRegla {
    private Object selected;
    private DefaultListModel dListModel;
    private int endLiteral;//Posicion de "Enconces" en la lista;
    private Regla regla;
    private listenerBC mListenerBc;
    private jFContenedor contenedor;
    private JPRegla pRegla;
    private JFEditarRegla editarRegla;
    private listenerRegla listenerRegla=this;
    public CRegla() {
        this.contenedor=new jFContenedor();
        this.pRegla=new JPRegla();
        endLiteral=1;
        this.dListModel=new DefaultListModel();
        this.dListModel.addElement("Si");
        this.dListModel.addElement("Entonces");
        this.pRegla.jLregla.setModel(dListModel);
        this.pRegla.jLregla.updateUI();
        regla=new Regla();
        initComponent();
        contenedor.add(pRegla);
        contenedor.pack();
        contenedor.setVisible(true);
    }
    public listenerBC getmListenerBc() {
        return mListenerBc;
    }

    public void setmListenerBc(listenerBC mListenerBc) {
        this.mListenerBc = mListenerBc;
    }
    public void setRegla(Regla regla){
        this.regla=regla;
        this.regla.getPremisa();
        for (Literal literal : this.regla.getPremisa()) {
            this.dListModel.add(this.endLiteral, literal);
            this.endLiteral++;
        }
        this.dListModel.addElement(this.regla.getConclusion());
    }
    private void initComponent(){
        this.pRegla.jLregla.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    selected =((JList)e.getSource())
                            .getSelectedValue();
                }
            }
        });
        this.pRegla.jBagregar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(GV.tablaVar!=null && GV.tablaVar.getLista()!=null && GV.tablaVar.getLista().size()>0){
                    if(selected instanceof String && ((String)selected).equals("Si")){
                        //TODO Agrega un literal
                        editarRegla= new JFEditarRegla(false);
                        editarRegla.setListenerRegla(listenerRegla);
                        editarRegla.setVisible(true);
                    }else if(selected instanceof String && ((String)selected).equals("Entonces")){
                        //TODO Agrega un hecho
                        editarRegla= new JFEditarRegla(true); 
                        editarRegla.setListenerRegla(listenerRegla);
                        editarRegla.setVisible(true);
                    }

                }else
                    JOptionPane.showMessageDialog(contenedor, "No hay variables para crear reglas");
                    }
            
        });
        this.pRegla.jBEliminar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(selected!=null){
            int indexS=dListModel.indexOf(selected);
            if(indexS>0 && indexS<endLiteral)
            {
                regla.getPremisa().remove(selected);
                dListModel.removeElement(selected);
                endLiteral--;
                 pRegla.jLregla.updateUI();
            }
            if(indexS==endLiteral+1){
               dListModel.remove(indexS);
                regla.setConclusion(null);
                pRegla.jLregla.updateUI();
            }
        }
            }
            
        });
        this.pRegla.jBGuardar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                 if(mListenerBc!=null && regla!=null)
                            mListenerBc.addRegla(regla);
            }
            
        });
    }

    @Override
    public void addLiteral(Literal l) {
        if(l!=null){
            this.regla.addLiteralToRegla(l);
            this.dListModel.add(this.endLiteral, l);
            this.endLiteral++;
        }
    }

    @Override
    public void addHehco(Hecho hecho) {
        if(hecho!=null)
        {
            if(this.regla.getConclusion()==null )
            {
                this.dListModel.addElement(hecho);
                this.regla.setConclusion(hecho);
            }
            else{
                this.dListModel.removeElement(this.regla.getConclusion());
                this.dListModel.addElement(hecho);
                this.regla.setConclusion(hecho);
            }
            this.pRegla.updateUI();
            
            
        }
    }
}
