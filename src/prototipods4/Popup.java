/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipods4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import privilegios.conectar;

public class Popup extends javax.swing.JDialog {
conectar co;
Connection reg;
boolean visto1 =false;
boolean visto2 =false;
DefaultTableModel tb;
    /**
     * Creates new form NewJDialog
     */
    public Popup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.tabla_art.setVisible(true);
        this.cb_subcat.setVisible(false);
        this.jLabel4.setVisible(false);
        this.jLabel3.setVisible(false);
        this.jLabel5.setVisible(false);
        this.tx_nombre.setVisible(false);
        this.btn_buscar.setVisible(false);
        this.btn_guardar_lista.setVisible(false);
        this.panel.setVisible(false);
         co = new conectar();
        reg = co.conexion();
        carga_cbcat();
        this.btn_nextsub.setVisible(false);
    }

    public void carga_cbcat(){
        if(reg != null){
            try{
               String sql ="{CALL obtener_cat()}"; 
               CallableStatement cs = reg.prepareCall(sql);
               cs.execute();
               ResultSet rs = cs.getResultSet();
               buildTableModel2(rs,0);
               cs.close();
            }catch(SQLException e){
                System.out.println(e);
            }
                    
        }
    }
    
    
    public static DefaultTableModel buildTableModel(ResultSet rs) 
         throws SQLException { 

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<String>(); 
        
            // names of columns 
            for (int column = 1; column <= columnCount; column++) {
                if (column != 5) {
                    columnNames.add(metaData.getColumnName(column)); 
                }else{
                    columnNames.add("Tienda"); 
                }
             
            } 
        

        





        // data of the table 
        Vector<Vector<Object>> data = new Vector<Vector<Object>>(); 
        while (rs.next()) { 
         Vector<Object> vector = new Vector<Object>(); 
         for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
          if(columnIndex != 5){
              vector.add(rs.getObject(columnIndex)); 
          }else{
              if(rs.getObject(columnIndex).toString().equals("1")){
                  vector.add("Soriana"); 
              }
              if(rs.getObject(columnIndex).toString().equals("2")){
                  vector.add("Taste"); 
              }
              if(rs.getObject(columnIndex).toString().equals("3")){
                  vector.add("Costco"); 
              }
              if(rs.getObject(columnIndex).toString().equals("4")){
                  vector.add("Cubiella"); 
              }
              
          
          }
          
             
         } 
         data.add(vector); 
        } 



        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {       
                return false; // or a condition at your choice with row and column
            }
        };
        return tableModel; 

    } 
    
    public void buildTableModel2(ResultSet rs, int cb) 
     throws SQLException { 
     
    ResultSetMetaData metaData = rs.getMetaData();
    int columnCount = metaData.getColumnCount();


    // data of the table 
    
    if (cb == 0){
        while (rs.next()) { 

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
             this.cb_cat.addItem((String) rs.getObject(columnIndex)); 

            } 

        } 
    }
    

    if (cb == 1){
        while (rs.next()) { 

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
             this.cb_subcat.addItem((String) rs.getObject(columnIndex)); 

            } 

        } 
    }


    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_cat = new javax.swing.JComboBox<>();
        cb_subcat = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tx_nombre = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_guardar_lista = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_art = new javax.swing.JTable();
        btn_nextcat = new javax.swing.JButton();
        btn_nextsub = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Busqueda de articulos");

        jLabel2.setText("Seleccione una Categoria");

        jLabel3.setText("Seleccione una Sub categoria");

        cb_cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_catActionPerformed(evt);
            }
        });

        cb_subcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_subcatActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre de Articulo o parecido:");

        btn_buscar.setText("Buscar Articulo");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_guardar_lista.setText("Guardar en Lista");
        btn_guardar_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_listaActionPerformed(evt);
            }
        });

        jLabel5.setText("Articulos parecidos:");

        tabla_art.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_art.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla_art);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btn_nextcat.setText("Continuar");
        btn_nextcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextcatActionPerformed(evt);
            }
        });

        btn_nextsub.setText("Continuar");
        btn_nextsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextsubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tx_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(cb_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(cb_subcat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_buscar)
                            .addComponent(btn_nextcat)
                            .addComponent(btn_nextsub)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guardar_lista))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nextcat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_subcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nextsub))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tx_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_guardar_lista)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_catActionPerformed
        if (this.cb_cat.getSelectedIndex()==0 && this.visto1 == false) {
            this.visto1= true;
        }
        
        
        
    }//GEN-LAST:event_cb_catActionPerformed

    private void btn_nextcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextcatActionPerformed
        if(this.visto1 == true){
            if(reg != null){
                this.cb_cat.setEnabled(false);
                try{
                   String sql ="{CALL obtener_subcat("+"'"+(this.cb_cat.getSelectedIndex()+1)+"'"+")}";
                   CallableStatement cs = reg.prepareCall(sql);
                   cs.execute();
                   ResultSet rs = cs.getResultSet();
                   buildTableModel2(rs,1);
                   cs.close();
                   this.btn_nextcat.setVisible(false);
                   this.jLabel2.setVisible(true);
                   this.jLabel3.setVisible(true);
                   this.cb_subcat.setVisible(true);
                   this.btn_nextsub.setVisible(true);
                }catch(SQLException e){
                    System.out.println(e);
                }
                    
            }
        }
        
        
    }//GEN-LAST:event_btn_nextcatActionPerformed

    private void cb_subcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_subcatActionPerformed
        if (this.cb_subcat.getSelectedIndex()==0 && this.visto2 == false) {
            this.visto2= true;
        }
    }//GEN-LAST:event_cb_subcatActionPerformed

    private void btn_nextsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextsubActionPerformed
        if(this.visto2 == true){
            this.cb_subcat.setEnabled(false);
            this.jLabel4.setVisible(true);
            this.tx_nombre.setVisible(true);
            this.btn_buscar.setVisible(true);
            this.btn_nextsub.setVisible(false);
        }
    }//GEN-LAST:event_btn_nextsubActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        if(!"".equals(this.tx_nombre.getText())){
            this.tx_nombre.setEnabled(false);
            if(reg != null){
                try{
                   String sql ="{CALL buscar_art("+"'"+this.cb_subcat.getSelectedItem()+"',"+"'"+this.tx_nombre.getText()+"'"+")}";
                    System.out.println(sql);
                   CallableStatement cs = reg.prepareCall(sql);
                   cs.execute();
                   ResultSet rs = cs.getResultSet();
                   this.tabla_art.setModel(buildTableModel(rs));
                   this.panel.setVisible(true);
                   cs.close();
                }catch(SQLException e){
                    System.out.println(e);
                }
                this.btn_buscar.setVisible(false);
                this.btn_guardar_lista.setVisible(true);
            }
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_guardar_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_listaActionPerformed
        int row = this.tabla_art.getSelectedRow();
        int index = (int) this.tabla_art.getModel().getValueAt(row, 0);
        System.out.println(index);
        if(reg != null){
                try{
                   String sql ="{CALL fragmento("+"'"+index+"'"+")}";
                    System.out.println(sql);
                   CallableStatement cs = reg.prepareCall(sql);
                   cs.execute();
                   cs.close();
                }catch(SQLException e){
                    System.out.println(e);
                }
                
            }
    }//GEN-LAST:event_btn_guardar_listaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Popup dialog = new Popup(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_guardar_lista;
    private javax.swing.JButton btn_nextcat;
    private javax.swing.JButton btn_nextsub;
    private javax.swing.JComboBox<String> cb_cat;
    private javax.swing.JComboBox<String> cb_subcat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla_art;
    private javax.swing.JTextField tx_nombre;
    // End of variables declaration//GEN-END:variables
}
