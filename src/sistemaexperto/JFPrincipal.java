/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaexperto;
import javax.swing.JOptionPane;
import sistemaexperto.listenerInterfaces.IControladorPrincipal;
import sistemaexperto.util.INC;


/**
 *
 * @author Lion
 */
public class JFPrincipal extends javax.swing.JFrame{

    /**
     * Creates new form JFPrincipal
     */
    public JFPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jBNuevaReglas = new javax.swing.JButton();
        jBVerRegla = new javax.swing.JButton();
        jBEliminarRegka = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jBagregarVariables = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMfile = new javax.swing.JMenu();
        jMInuevo = new javax.swing.JMenuItem();
        jMIabrirArchivo = new javax.swing.JMenuItem();
        jMIguardar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Experto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Regla"));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jBNuevaReglas.setText("Nueva");
        jBNuevaReglas.setEnabled(false);
        jBNuevaReglas.setMaximumSize(new java.awt.Dimension(85, 23));
        jBNuevaReglas.setMinimumSize(new java.awt.Dimension(75, 23));
        jBNuevaReglas.setName(INC.nameButtonNuevaRega);
        jBNuevaReglas.setPreferredSize(new java.awt.Dimension(82, 23));
        jPanel1.add(jBNuevaReglas);

        jBVerRegla.setText("Ver");
        jBVerRegla.setEnabled(false);
        jBVerRegla.setMaximumSize(new java.awt.Dimension(85, 23));
        jBVerRegla.setMinimumSize(new java.awt.Dimension(75, 23));
        jBVerRegla.setName(INC.nameButtonVerRegla);
        jBVerRegla.setPreferredSize(new java.awt.Dimension(82, 23));
        jPanel1.add(jBVerRegla);

        jBEliminarRegka.setText("Eliminar");
        jBEliminarRegka.setToolTipText("");
        jBEliminarRegka.setActionCommand("");
        jBEliminarRegka.setEnabled(false);
        jBEliminarRegka.setMaximumSize(new java.awt.Dimension(85, 23));
        jBEliminarRegka.setMinimumSize(new java.awt.Dimension(75, 23));
        jBEliminarRegka.setName(INC.nameButtonEliminarRegla);
        jBEliminarRegka.setPreferredSize(new java.awt.Dimension(82, 23));
        jPanel1.add(jBEliminarRegka);

        jScrollPane1.setViewportView(jList1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Variables"));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jBagregarVariables.setText("Agregar");
        jBagregarVariables.setEnabled(false);
        jBagregarVariables.setMaximumSize(new java.awt.Dimension(85, 23));
        jBagregarVariables.setName(INC.nameButtonVaribles);
        jBagregarVariables.setPreferredSize(new java.awt.Dimension(82, 23));
        jPanel2.add(jBagregarVariables);

        jMfile.setText("File");

        jMInuevo.setText("Nuevo");
        jMfile.add(jMInuevo);

        jMIabrirArchivo.setText("Abrir Archivo");
        jMfile.add(jMIabrirArchivo);

        jMIguardar.setText("Guardar");
        jMfile.add(jMIguardar);

        jMenuBar1.add(jMfile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private jFContenedor contenedor;
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBEliminarRegka;
    public javax.swing.JButton jBNuevaReglas;
    public javax.swing.JButton jBVerRegla;
    public javax.swing.JButton jBagregarVariables;
    private javax.swing.JFileChooser jFileChooser2;
    public javax.swing.JList jList1;
    public javax.swing.JMenuItem jMIabrirArchivo;
    public javax.swing.JMenuItem jMIguardar;
    public javax.swing.JMenuItem jMInuevo;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jMfile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


   
}
