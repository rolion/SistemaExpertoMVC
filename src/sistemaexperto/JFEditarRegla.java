/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import sistemaexperto.Entidad.Hecho;
import sistemaexperto.Entidad.Literal;
import sistemaexperto.Entidad.Tupla;
import sistemaexperto.util.GV;
import sistemaexperto.util.listenerRegla;

/**
 *
 * @author Lion
 */
public class JFEditarRegla extends javax.swing.JFrame {

    /**
     * Creates new form JFEditarRegla
     */
    private listenerRegla mListenerRegla;
    private DefaultComboBoxModel modelVariables;
    private DefaultComboBoxModel<String>modelOprel;
    private DefaultComboBoxModel<String>modelResultado;
    private String vOprelHecho[]={"="};
    private String vOprelNumerico[]={"=","<>",">",">=","<","<="};
    private String vOprelEscalar[]={"=","<>"};
    private String vResult[];
    private Tupla selectedT;
    private boolean isHecho;

    public boolean isIsHecho() {
        return isHecho;
    }

    public void setIsHecho(boolean isHecho) {
        this.isHecho = isHecho;
    }

    public void setListenerRegla(listenerRegla mListenerRegla) {
        this.mListenerRegla = mListenerRegla;
    }
    public JFEditarRegla(boolean hecho) {
       this.isHecho=hecho;
       initFrame();
       
    }
    public JFEditarRegla() {
       this.isHecho=false;
       initFrame();
       
    }
    private void initFrame(){
         initComponents();
        modelVariables=new DefaultComboBoxModel(GV.tablaVar.getLista().toArray());
        this.jCBvariables.setModel(modelVariables);
         selectedT=(Tupla)this.jCBvariables.getSelectedItem();
         this.jCBvariables.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        selectedT=(Tupla) e.getItem();
                        initComboBox();
                    }
                }
            });
        
           initComboBox();
    }
    private void initComboBox(){
     if(selectedT.getVarlorI()==-2){
            //this.modelResultado=new DefaultComboBoxModel<>(vOprelHecho)
            initResultNumerico();
        }else if(selectedT.getVarlorI()>-1){
            //es un escalar
            initResultEscalar();
        }
    this.jCBoprel.updateUI();
    this.jCBresultado.updateUI();
    this.jCBvariables.updateUI();
    }
    
    private void initResultEscalar(){

        this.modelOprel=isHecho==false?new DefaultComboBoxModel<>(vOprelEscalar)
                :new DefaultComboBoxModel<>(vOprelHecho);
        //this.modelOprel=new DefaultComboBoxModel<>(vOprelEscalar);
        this.vResult=new String[selectedT.getValorF()-selectedT.getVarlorI()+1];
        int cont=0;
        for(int i=selectedT.getVarlorI();i<=selectedT.getValorF();i++){
            this.vResult[cont]=GV.tablaVal.getVal(i);
            cont++;
        }
        this.jCBoprel.setModel(modelOprel);
        this.modelResultado=new DefaultComboBoxModel<>(vResult);
        this.jCBresultado.setModel(modelResultado);
        this.jCBresultado.setEditable(false);
    }
    private void initResultNumerico(){
        vResult=new String[1];
        vResult[0]="";
        this.modelOprel=isHecho==false?new DefaultComboBoxModel<>(vOprelNumerico):new DefaultComboBoxModel<>(vOprelHecho);
        this.jCBoprel.setModel(modelOprel);
        this.modelResultado=new DefaultComboBoxModel<>(vResult);
        this.jCBresultado.setModel(modelResultado);
        this.jCBresultado.setEditable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPresultado = new javax.swing.JPanel();
        jCBvariables = new javax.swing.JComboBox();
        jCBoprel = new javax.swing.JComboBox();
        jCBresultado = new javax.swing.JComboBox();
        jPt = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jRBdisyuncion = new javax.swing.JRadioButton();
        jRBconjuncion = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jRBneg = new javax.swing.JRadioButton();
        jBagregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPresultado.setAlignmentX(0.0F);
        jPresultado.setAlignmentY(0.0F);
        jPresultado.setLayout(new javax.swing.BoxLayout(jPresultado, javax.swing.BoxLayout.LINE_AXIS));

        jCBvariables.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBvariables.setPreferredSize(new java.awt.Dimension(70, 20));
        jCBvariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBvariablesActionPerformed(evt);
            }
        });
        jPresultado.add(jCBvariables);

        jCBoprel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", "<>", ">", ">=", "<", "<=" }));
        jPresultado.add(jCBoprel);

        jCBresultado.setPreferredSize(new java.awt.Dimension(65, 20));
        jPresultado.add(jCBresultado);

        getContentPane().add(jPresultado, java.awt.BorderLayout.CENTER);

        jPt.setLayout(new javax.swing.BoxLayout(jPt, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Conector"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jRBdisyuncion.setText("Disyuncion");
        jRBdisyuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBdisyuncionActionPerformed(evt);
            }
        });
        jPanel1.add(jRBdisyuncion, java.awt.BorderLayout.CENTER);

        jRBconjuncion.setText("Conjuncion");
        jRBconjuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBconjuncionActionPerformed(evt);
            }
        });
        jPanel1.add(jRBconjuncion, java.awt.BorderLayout.PAGE_START);

        jPt.add(jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jRBneg.setText("not");
        jPanel2.add(jRBneg);

        jBagregar.setText("Agregar");
        jBagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBagregarActionPerformed(evt);
            }
        });
        jPanel2.add(jBagregar);

        jPt.add(jPanel2);

        getContentPane().add(jPt, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBvariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBvariablesActionPerformed
        // TODO add your handling code here:
       
        this.jRBconjuncion.setSelected(false);
    }//GEN-LAST:event_jCBvariablesActionPerformed

    private void jRBconjuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBconjuncionActionPerformed
        // TODO add your handling code here:
        if(this.jRBconjuncion.isSelected() )
            this.jRBdisyuncion.setSelected(false);
    }//GEN-LAST:event_jRBconjuncionActionPerformed

    private void jRBdisyuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBdisyuncionActionPerformed
        // TODO add your handling code here:
        if(this.jRBdisyuncion.isSelected() )
            this.jRBconjuncion.setSelected(false);
    }//GEN-LAST:event_jRBdisyuncionActionPerformed
    private Literal literal;
    private Hecho hecho;
    private void jBagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBagregarActionPerformed
        // TODO add your handling code here:
        int oprel=getOprealValue((String)this.jCBoprel.getSelectedItem());
        int valor;
        Tupla t=(Tupla) this.jCBvariables.getSelectedItem();
        if(t.getVarlorI()==-2){
            sendLiteralNumeral(oprel);
            
        }if(t.getVarlorI()>-1){
            sendLiteralEscalar(oprel);
        }
        //
    }//GEN-LAST:event_jBagregarActionPerformed
    private void sendLiteralNumeral( int oprel){
        int valor;
        String result=(String) this.jCBresultado.getSelectedItem();
        try{
            valor=Integer.valueOf(result);
            literal= new Literal(this.jRBneg.isSelected(), oprel, this.jCBvariables.getSelectedIndex(), valor);
            if(this.mListenerRegla!=null && !this.isHecho){
            mListenerRegla.addLiteral(literal);
        }else if(this.mListenerRegla!=null && this.isHecho)
            mListenerRegla.addHehco(literal);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Debe introducir un numero");
        }
    }
    private void sendLiteralEscalar(int oprel){
        int valor;
        String result=(String) this.jCBresultado.getSelectedItem();
        valor=GV.tablaVal.getV().indexOf(this.jCBresultado.getSelectedItem());
        literal= new Literal(this.jRBneg.isSelected(), oprel, this.jCBvariables.getSelectedIndex(), valor);
        if(this.mListenerRegla!=null && !this.isHecho){
            mListenerRegla.addLiteral(literal);
        }else if(this.mListenerRegla!=null && this.isHecho)
            mListenerRegla.addHehco(literal);
    }
    private void sendHecho(){
    }
    private int getOprealValue(String oprel){
    if(oprel.equals("<>")){
        return GV.diferente;
    }
    if(oprel.equals(">")){
        return GV.mayor;
    }
    if(oprel.equals(">=")){
        return GV.mayorI;
    }
    if(oprel.equals("<")){
        return GV.menor;
    }
    if(oprel.equals("<=")){
        return GV.menorI;
    }
    
        return GV.igual;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBagregar;
    private javax.swing.JComboBox jCBoprel;
    private javax.swing.JComboBox jCBresultado;
    private javax.swing.JComboBox jCBvariables;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPresultado;
    private javax.swing.JPanel jPt;
    private javax.swing.JRadioButton jRBconjuncion;
    private javax.swing.JRadioButton jRBdisyuncion;
    private javax.swing.JRadioButton jRBneg;
    // End of variables declaration//GEN-END:variables
}