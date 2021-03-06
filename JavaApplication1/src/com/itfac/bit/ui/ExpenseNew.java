/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itfac.bit.ui;

import com.itfac.bit.database.Database;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ExpenseNew extends javax.swing.JFrame {

    /**
     * Creates new form ExpenseNew
     */
    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet,resultSet1,resultSet2,resultSet3;
    DefaultTableModel modelo;
    Double tota1 = 0.0, total3 = 0.0,amount = 0.0;
    MainNew mainNew;
    

    public ExpenseNew() {
        initComponents();
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    public ExpenseNew(MainNew mainNew) {
        this.setResizable(false); 
        this.setLocationRelativeTo(null);
        this.mainNew = mainNew;
        initComponents();
        try {
           
            connection = Database.openConnection();
            modelo = (DefaultTableModel) table_form.getModel();


            statement = connection.prepareStatement("SELECT del_No FROM delivery_header WHERE del_Status = 'Delivered'");
            resultSet3 = statement.executeQuery();
            
            while (resultSet3.next()) {
                String delNo = resultSet3.getString(1);
                
                statement = connection.prepareStatement("SELECT form_No FROM expense_form_header WHERE del_No=?");
                statement.setString(1, delNo);
                resultSet1 = statement.executeQuery();
                
                if (resultSet1.next()) {
                    cmb_formNumber.addItem(resultSet1.getString(1));
                }
            }

            
            statement = connection.prepareStatement("SELECT exp_Desc FROM expense_type_master");
            resultSet2 = statement.executeQuery();

            while (resultSet2.next()) {
                cmb_formDescription.addItem(resultSet2.getString(1));
            }

            cmb_formDescription.setSelectedIndex(-1);
            cmb_formNumber.setSelectedIndex(-1);
            txt_amount.setText("");
            txt_deliveryNumber.setText("");
            txt_total.setText(String.valueOf(total3));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Occured.\n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
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
        cmb_formDescription = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_form = new javax.swing.JTable();
        btn_addForm = new javax.swing.JButton();
        btn_removeForm = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_deliveryNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        cmb_formNumber = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 212, 179));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expense Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 153));
        jLabel1.setText("Expense Description");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 153));
        jLabel2.setText("Amount");

        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });

        table_form.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expense Code", "Expense Description", "Amount"
            }
        ));
        jScrollPane1.setViewportView(table_form);

        btn_addForm.setBackground(new java.awt.Color(0, 88, 50));
        btn_addForm.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_addForm.setForeground(java.awt.Color.white);
        btn_addForm.setText("Add");
        btn_addForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addFormActionPerformed(evt);
            }
        });

        btn_removeForm.setBackground(new java.awt.Color(255, 103, 125));
        btn_removeForm.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_removeForm.setForeground(java.awt.Color.white);
        btn_removeForm.setText("Remove");
        btn_removeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeFormActionPerformed(evt);
            }
        });

        btn_submit.setBackground(new java.awt.Color(0, 88, 50));
        btn_submit.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_submit.setForeground(java.awt.Color.white);
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(51, 102, 153));
        btn_clear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_clear.setForeground(java.awt.Color.white);
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(255, 103, 125));
        btn_cancel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btn_cancel.setForeground(java.awt.Color.white);
        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 153));
        jLabel3.setText("Delivery Number");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 153));
        jLabel4.setText("Form Number");

        txt_deliveryNumber.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 153));
        jLabel5.setText("Total");

        txt_total.setEditable(false);

        cmb_formNumber.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_formNumberItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_formDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_formNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_deliveryNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_addForm)
                                .addGap(80, 80, 80)
                                .addComponent(btn_removeForm)
                                .addGap(141, 141, 141))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btn_clear)
                        .addGap(51, 51, 51)
                        .addComponent(btn_submit)
                        .addGap(49, 49, 49)
                        .addComponent(btn_cancel)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_deliveryNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_formNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_formDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_removeForm)
                    .addComponent(btn_addForm))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clear)
                    .addComponent(btn_cancel)
                    .addComponent(btn_submit))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amountActionPerformed

    private void btn_removeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeFormActionPerformed
        if (table_form.getSelectedRow() != -1) {
            if (table_form.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String aa = String.valueOf(table_form.getValueAt(table_form.getSelectedRow(), 2));
                double ab = Double.parseDouble(aa);
                tota1 = tota1 - ab;
                txt_total.setText(String.valueOf(tota1));
                String expDesc = String.valueOf(table_form.getValueAt(table_form.getSelectedRow(), 1));
                cmb_formDescription.addItem(expDesc);
                modelo.removeRow(table_form.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Row", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_removeFormActionPerformed

    private void btn_addFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addFormActionPerformed
        String in = null, ic = null;
         amount = 0.0;

        if (cmb_formDescription.getSelectedIndex() != -1) {
            try {
                
                String formDescription = cmb_formDescription.getSelectedItem().toString();
                amount = Double.parseDouble(txt_amount.getText());

              
                statement = connection.prepareStatement("SELECT * FROM expense_type_master WHERE exp_Desc=?");
                statement.setString(1, formDescription);
                resultSet = statement.executeQuery();
                
                
                
                if (resultSet.next()) {
                    ic = resultSet.getString(1);
                }

                tota1 = tota1 + amount;
                modelo.addRow(new Object[]{ic, formDescription, amount});

                txt_total.setText(String.valueOf(tota1));
                txt_amount.setText("");
                cmb_formDescription.removeItem(formDescription);
                cmb_formDescription.setSelectedIndex(-1);
            } catch (NumberFormatException | SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btn_addFormActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        if (cmb_formNumber.getSelectedIndex() != -1) {
            try {
                
                String formNumber = String.valueOf(cmb_formNumber.getSelectedItem());
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Calendar cal = Calendar.getInstance();
                String date = dateFormat.format(cal.getTime());

                Double total = Double.parseDouble(txt_total.getText());
                
                
                statement = connection.prepareStatement("UPDATE expense_form_header SET form_Date=?,exp_Tot=? WHERE form_No=?");
                statement.setString(1, date);
                statement.setDouble(2, total);
                statement.setString(3,formNumber);
                int res = statement.executeUpdate();
              
                String delno = txt_deliveryNumber.getText();
               
                statement = connection.prepareStatement("UPDATE orders_header SET ord_Status = 'Completed' WHERE del_No=?");
                statement.setString(1, delno);
                res = statement.executeUpdate();
                
             
                
                statement = connection.prepareStatement("UPDATE delivery_header SET del_Status = 'Completed' WHERE del_No=?");
                statement.setString(1, delno);
                res = statement.executeUpdate();
                
                int rows = table_form.getRowCount();

                if (rows != 0) {
                    for (int i = 0; i < rows; i++) {
                        
                        String aa = String.valueOf(table_form.getValueAt(i, 0));
                        String ab = String.valueOf(table_form.getValueAt(i, 2));
                        Double amt = Double.parseDouble(ab);

                    
                        
                         statement = connection.prepareStatement("INSERT INTO expense_form_detail VALUES(?,?,?)");
                         statement.setString(1, formNumber);
                         statement.setString(2, aa);
                         statement.setDouble(3, amt);
                         res = statement.executeUpdate();
                        
                    }

                    JOptionPane.showMessageDialog(this, "Successfully Submitted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    mainNew.getDeliveryData();
                    mainNew.getExpData();
                    mainNew.getOrdData();

                    this.dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error Occured.\n" + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex);
            }

        }

    }//GEN-LAST:event_btn_submitActionPerformed

    private void cmb_formNumberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_formNumberItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            try {
                
                String formNumber = String.valueOf(cmb_formNumber.getSelectedItem());
              
                statement = connection.prepareStatement("SELECT * FROM expense_form_header WHERE form_No=?");
                statement.setString(1, formNumber);
                        
                resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    txt_deliveryNumber.setText(resultSet.getString(4));
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_cmb_formNumberItemStateChanged

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        int rows = table_form.getRowCount();
        for (int i = 0; i < rows; i++) {
            String expDesc = String.valueOf(table_form.getValueAt(i, 1));
            cmb_formDescription.addItem(expDesc);
        }
        
        cmb_formDescription.setSelectedIndex(-1);
        cmb_formNumber.setSelectedIndex(-1);
        txt_amount.setText("");
        txt_deliveryNumber.setText("");
        txt_total.setText(String.format("%06d", 0));
        modelo.setRowCount(0);
        total3 = 0.0;
        tota1 = 0.0;
        amount = 0.0;
        
    }//GEN-LAST:event_btn_clearActionPerformed

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
            java.util.logging.Logger.getLogger(ExpenseNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpenseNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpenseNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpenseNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addForm;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_removeForm;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox cmb_formDescription;
    private javax.swing.JComboBox cmb_formNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_form;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_deliveryNumber;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
