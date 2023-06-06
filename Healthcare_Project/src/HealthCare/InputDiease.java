/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package HealthCare;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class InputDiease extends javax.swing.JFrame {

    /**
     * Creates new form InputDiease
     */
    DefaultTableModel modelDiease;
    String Diease_id="";
    Connection conn;
    private String [] judulKolom={"Diease_ID","Doctor_ID", "Doctor Name", "Specialist", "Complaint", "Diagnose","Receipt"};
    private int select=-1;
    String Doctor_ID, Doctor_Name, Specialist;
    Session GetSession;
    
    public InputDiease() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            conn = koneksi.koneksiDB();
        } catch (Exception e) {
        }
        modelDiease = new DefaultTableModel(judulKolom,0);
        jTableDiease.setModel(modelDiease);
        jTableDiease.removeColumn(jTableDiease.getColumnModel().getColumn(0));
        getDataDiease();
        GetSession = new Session();
        
        getsession();
    }
    
    public void getsession () {
        Doctor_ID = GetSession.getDoctor_ID();
        Doctor_Name = GetSession.getDoctor_name();
        Specialist = GetSession.getSpecialist();
        
        
    }
    
    public void getDataDiease(){
        modelDiease.getDataVector().removeAllElements();
        modelDiease.fireTableDataChanged();
        try {
            //JOptionPane.showMessageDialog(null, "Cek");
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from diease");
            while(sql.next())
            {
                String data[] ={
                    sql.getString(1),
                    sql.getString(2),
                    sql.getString(3),
                    sql.getString(4),
                    sql.getString(5),
                    sql.getString(6),
                    sql.getString(7)
                };
                modelDiease.addRow(data);
            }

            sql.close();
            stm.close();

        } catch (Exception e) {
        }
    }
    
    public void selectData () throws Exception{
        select = jTableDiease.getSelectedRow();
        Diease_id = modelDiease.getValueAt(select, 0).toString();
        jTextFieldComplaint.setText(modelDiease.getValueAt(select, 4).toString());
        jTextAreaDiagnose.setText(modelDiease.getValueAt(select, 5).toString());
        jTextAreaReceipt.setText(modelDiease.getValueAt(select, 6).toString());
    }
    
    public void DeleteData(){
        if (select == -1) {
            JOptionPane.showMessageDialog(null, "Please choose one data!");
            return;
        }

        try {
            String sql = "DELETE FROM diease WHERE Diease_ID=?";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, modelDiease.getValueAt(select, 0).toString());
            prep.executeUpdate();
            prep.close();
            JOptionPane.showMessageDialog(null, "Delete Successfully");
            getDataDiease();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There's an Error to Delete Data :"+e);
        }
    }
    
    public void ClearDataDiease(){
        jTextFieldComplaint.setText("");
        jTextAreaDiagnose.setText("");
        jTextAreaReceipt.setText("");
    }
    
    
    
    public void SubmitDiease(){
        
        
        try {
            String sql = "INSERT INTO diease ( Doctor_ID, Doctor_Name, Specialist, Complaint, Diagnose, Receipt) VALUES (?,?,?,?,?,?)";
            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, Doctor_ID);
            prep.setString(2, Doctor_Name);
            prep.setString(3, Specialist);
            prep.setString(4, jTextFieldComplaint.getText());
            prep.setString(5, jTextAreaDiagnose.getText());
            prep.setString(6, jTextAreaReceipt.getText());
            prep.executeUpdate();
            prep.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There's an Error :"+e);
        } finally {
            getDataDiease();
            ClearDataDiease();
        }
    }
    
    public void editData(){
    try {
        String sql = "UPDATE diease SET Complaint=?, Diagnose=?, Receipt=? WHERE Diease_ID =? ";
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setString(1, jTextFieldComplaint.getText());
        prep.setString(2, jTextAreaDiagnose.getText());
        prep.setString(3, jTextAreaReceipt.getText());
        prep.setString(4, Diease_id);
        System.out.println("HealthCare.InputDiease.editData()"+Diease_id);
        prep.executeUpdate();
        prep.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        getDataDiease();
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDiease = new javax.swing.JTable();
        jButtonDelete = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonSubmit = new javax.swing.JButton();
        jTextFieldComplaint = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDiagnose = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaReceipt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Input Diease");

        jLabelBack.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelBack.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HealthCare/icons8-back-arrow-30 white.png"))); // NOI18N
        jLabelBack.setText("Back");
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabelBack)
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelBack)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41))))
        );

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Complaint");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Diagnose");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Receipt");

        jTableDiease.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableDiease.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableDiease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDieaseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDiease);

        jButtonDelete.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonClear.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonEdit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonSubmit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jTextAreaDiagnose.setColumns(20);
        jTextAreaDiagnose.setLineWrap(true);
        jTextAreaDiagnose.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDiagnose);

        jTextAreaReceipt.setColumns(20);
        jTextAreaReceipt.setLineWrap(true);
        jTextAreaReceipt.setRows(5);
        jScrollPane3.setViewportView(jTextAreaReceipt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDelete)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jTextFieldComplaint))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldComplaint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonClear)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonSubmit))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableDieaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDieaseMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            selectData();
        } catch (Exception ex) {
            Logger.getLogger(InputDiease.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableDieaseMouseClicked

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
        SubmitDiease();
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        DeleteData();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        editData();
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        ClearDataDiease();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new DoctorMainMenu().setVisible(true);
    }//GEN-LAST:event_jLabelBackMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InputDiease.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InputDiease.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InputDiease.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InputDiease.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InputDiease().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDiease;
    private javax.swing.JTextArea jTextAreaDiagnose;
    private javax.swing.JTextArea jTextAreaReceipt;
    private javax.swing.JTextField jTextFieldComplaint;
    // End of variables declaration//GEN-END:variables
}
