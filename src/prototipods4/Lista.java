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
import static prototipods4.Popup.buildTableModel;


public class Lista extends javax.swing.JFrame {
conectar co;
Connection reg;

    /**
     * Creates new form Lista
     */
    public Lista() {
        initComponents();
        this.agregar_art.setVisible(false);
        this.lista.setVisible(false);
        this.borrar_art.setVisible(false);
        co = new conectar();
        reg = co.conexion();

        
    }

    public void cargarlista(){
        if(reg != null){
            try{
               String sql ="{CALL crear_lista(?, ?)}"; 
               CallableStatement cs = reg.prepareCall(sql);
               cs.registerOutParameter(1, Types.VARCHAR);
               cs.registerOutParameter(2, Types.DATE);
      //Executing the CallableStatement
                cs.execute();
      //Retrieving the values for product name, customer name and, price
                String nombre_lista = cs.getString(1);
                String fecha_lista = cs.getString(2);
                this.lb_nombre.setText(nombre_lista);
                this.lb_fecha.setText(fecha_lista);
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
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JTable();
        agregar_art = new javax.swing.JButton();
        borrar_art = new javax.swing.JButton();
        nueva_lista = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_fecha = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        btn_actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de Articulo", "Precio", "URL", "Tienda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(lista);

        agregar_art.setText("Agregar nuevo articulo");
        agregar_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_artActionPerformed(evt);
            }
        });

        borrar_art.setText("Borrar articulo");
        borrar_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_artActionPerformed(evt);
            }
        });

        nueva_lista.setText("Crear nueva lista");
        nueva_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_listaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre de la lista:");

        jLabel2.setText("Fecha:");

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nueva_lista))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregar_art)
                                .addGap(59, 59, 59)
                                .addComponent(btn_actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(borrar_art))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(nueva_lista)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar_art)
                    .addComponent(borrar_art)
                    .addComponent(btn_actualizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nueva_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_listaActionPerformed
        this.nueva_lista.setVisible(false);
        this.lista.setVisible(true);
        this.agregar_art.setVisible(true);
        this.cargarlista();
    }//GEN-LAST:event_nueva_listaActionPerformed

    private void agregar_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_artActionPerformed
        Popup dialog = new Popup(this,true);
        dialog.setVisible(true);
        this.borrar_art.setVisible(true);
    }//GEN-LAST:event_agregar_artActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        if(reg != null){
                try{
                   String sql ="{CALL enviar_art()}";
                    System.out.println(sql);
                   CallableStatement cs = reg.prepareCall(sql);
                   cs.execute();
                   ResultSet rs = cs.getResultSet();
                   this.lista.setModel(buildTableModel(rs));
                   cs.close();
                   
                   
                }catch(SQLException e){
                    System.out.println(e);
                }
                
            }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void borrar_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_artActionPerformed
        int row = this.lista.getSelectedRow();
        int index = (int) this.lista.getModel().getValueAt(row, 0);
        System.out.println(index);
        if(reg != null){
                try{
                   String sql ="{CALL borrar_delista("+"'"+index+"'"+")}";
                    System.out.println(sql);
                   CallableStatement cs = reg.prepareCall(sql);
                   cs.execute();
                   cs.close();
                }catch(SQLException e){
                    System.out.println(e);
                }
                
            }
    }//GEN-LAST:event_borrar_artActionPerformed

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
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
                new Lista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_art;
    private javax.swing.JButton borrar_art;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JTable lista;
    private javax.swing.JButton nueva_lista;
    // End of variables declaration//GEN-END:variables
}
