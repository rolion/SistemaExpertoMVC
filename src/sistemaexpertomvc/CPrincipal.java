/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexpertomvc;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sistemaexperto.Entidad.BC;
import sistemaexperto.Entidad.Regla;
import sistemaexperto.Entidad.TablaVal;
import sistemaexperto.Entidad.TablaVar;
import sistemaexperto.Entidad.Tupla;
import sistemaexperto.JFEditarRegla;
import sistemaexperto.JFPrincipal;
import sistemaexperto.JPRegla;
import sistemaexperto.jFContenedor;
import sistemaexperto.util.FileManager;
import sistemaexperto.util.GV;
import sistemaexperto.util.listenerBC;

/**
 *
 * @author Lion
 */
public class CPrincipal implements listenerBC {

    /**
     * @param args the command line arguments
     */
    private JFPrincipal formPrincipal;
    private jFContenedor formContenedor;
    private DefaultListModel dListModel;
    private JPRegla panelRegla;
    private JFileChooser fileChooser;
    private JFEditarRegla formEditarRegla;
    private Regla selectedRegla;
    private CRegla cRegla;
    public CPrincipal() {
        initComponent();
        
    }
    private void initComponent(){
        this.formPrincipal=new JFPrincipal();
        this.dListModel=new DefaultListModel();
        this.formPrincipal.jList1.setModel(dListModel);
        setComponentListener();
        this.formPrincipal.setVisible(true);
        
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CPrincipal();
            }
        });
        
    }

    public void ShowMessageDialog(Component parent,String Menssage, String title, int messageType) {
        JOptionPane.showMessageDialog(parent, Menssage, title, messageType);
    }
    private void enableComponent(){
        formPrincipal.jBEliminarRegka.setEnabled(true);
        formPrincipal.jBNuevaReglas.setEnabled(true);
        formPrincipal.jBVerRegla.setEnabled(true);
        formPrincipal.jBagregarVariables.setEnabled(true);
    }
    
    private listenerBC lbc=this;
    private void setComponentListener(){
        this.formPrincipal.jList1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
               if (!e.getValueIsAdjusting()){
                    selectedRegla =(Regla) ((JList)e.getSource())
                            .getSelectedValue();
                }
            }
        });
        this.formPrincipal.jMInuevo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                enableComponent();
                GV.tablaVal=new TablaVal(new ArrayList<String>());
                GV.tablaVar=new TablaVar(new ArrayList<Tupla>());
                GV.tableBC=new BC(new ArrayList<Regla>());
            }
        });
        this.formPrincipal.jMIguardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser=new JFileChooser();
                int returnVal=fileChooser.showSaveDialog(formPrincipal);
                fileChooser.setDialogTitle("Buscar Archivo");
                if(returnVal== JFileChooser.APPROVE_OPTION){
                    File f=fileChooser.getSelectedFile();
                    GV.homeFile=f;
                    System.out.println(f.getPath());
                    ArrayList alist=new ArrayList();
                    alist.add(GV.tablaVal.getV());
                    alist.add(GV.tablaVar.getLista());
                    alist.add(GV.tableBC.getReglas());
                    FileManager.writeListToFile(alist, f.getPath());

                }
            }
        });
        this.formPrincipal.jMIabrirArchivo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser=new JFileChooser();
                int returnVal=fileChooser.showOpenDialog(formPrincipal);
                fileChooser.setDialogTitle("Buscar Archivo");
                if(returnVal== JFileChooser.APPROVE_OPTION){
                    File f=fileChooser.getSelectedFile();
                    GV.homeFile=f;
                    List lObjet=FileManager.getAllObject(f.getPath());
                    cargarReglas();
                    enableComponent();
                }
            }
        });
        this.formPrincipal.jBEliminarRegka.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(selectedRegla!=null){
                    dListModel.removeElement(selectedRegla);
                    formPrincipal.jList1.updateUI();
                    GV.tableBC.getReglas().remove(selectedRegla);
                }else
                    ShowMessageDialog(formPrincipal, "Debe seleccionar una regla", 
                            "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        });
        this.formPrincipal.jBVerRegla.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); 
                if(selectedRegla!=null){
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        cRegla=new CRegla();
                        cRegla.setmListenerBc(lbc);
                        cRegla.setRegla(selectedRegla);
                    }   
                }); 
                }else
                    ShowMessageDialog(formPrincipal, "Debe seleccionar una regla", 
                            "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        });
        this.formPrincipal.jBNuevaReglas.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); 
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new CRegla().setmListenerBc(lbc);
                    }   
                }); 
            }
            
        });
        this.formPrincipal.jBagregarVariables.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); 
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new CVariable();
                    }   
                }); 
            }
            
        });
    }

    @Override
    public void addRegla(Regla regla) {
        int nro=this.dListModel.getSize();
        if(regla.getNombre()!=null && regla.getNombre().equals("")){
            regla.setNombre("Regla"+nro);
            this.dListModel.addElement(regla);
            if(GV.tableBC==null)
                GV.tableBC=new BC();
            GV.tableBC.addRegla(regla);
        }
        for(int i=0;i<this.dListModel.getSize();i++){
            Regla aux=(Regla) this.dListModel.get(i);
            if(aux.getNombre().equals(regla.getNombre())){
                this.dListModel.remove(i);
                this.dListModel.add(i, regla);
                i=this.dListModel.getSize()+1;
            }
        }
        this.formPrincipal.jList1.updateUI();
    } 
    public void cargarReglas(){
        this.dListModel=new DefaultListModel();
        for (Regla r : GV.tableBC.getReglas()) {
            this.dListModel.addElement(r);
        }
        this.formPrincipal.jList1.setModel(dListModel);
        this.formPrincipal.jList1.updateUI();
    }
}
