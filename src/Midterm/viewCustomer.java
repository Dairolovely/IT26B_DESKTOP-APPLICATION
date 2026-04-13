package Midterm;

import java.sql.*;
import javax.swing.*;

public class viewCustomer extends javax.swing.JFrame {

    public viewCustomer() {
        initComponents();
        LoadTableData(); // VERY IMPORTANT

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @SuppressWarnings("override")
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.getSelectedRow();

                customerNameTxtField.setText(jTable1.getValueAt(row, 1).toString());
                addressTxtField.setText(jTable1.getValueAt(row, 2).toString());
            }
        });
    }

    @SuppressWarnings("ConvertToTryWithResources")
    private void LoadTableData() {
        try {
            Connection conn = ConnectionDB.getConnection();

            String sql = "SELECT * FROM customers";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            javax.swing.table.DefaultTableModel model
                    = (javax.swing.table.DefaultTableModel) jTable1.getModel();

            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("CustomerID"),
                    rs.getString("CustomerName"),
                    rs.getString("Address")
                });
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        customerIdTxtField = new javax.swing.JTextField();
        addressTxtField = new javax.swing.JTextField();
        customerNameTxtField = new javax.swing.JTextField();
        deleteBtn = new javax.swing.JButton();
        backToUserPanelBtn = new javax.swing.JButton();
        createBtn2 = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CUSTOMER ID:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CUSTOMER ID", "CUSTOMER NAME", "ADDRESS"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CUSTOMER NAME:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ADDRESS:");

        customerIdTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIdTxtFieldActionPerformed(evt);
            }
        });

        addressTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTxtFieldActionPerformed(evt);
            }
        });

        customerNameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameTxtFieldActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(0, 153, 153));
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        backToUserPanelBtn.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        backToUserPanelBtn.setForeground(new java.awt.Color(0, 153, 153));
        backToUserPanelBtn.setText("USER PANEL");
        backToUserPanelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToUserPanelBtnActionPerformed(evt);
            }
        });

        createBtn2.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        createBtn2.setForeground(new java.awt.Color(0, 153, 153));
        createBtn2.setText("CREATE");
        createBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(addressTxtField))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(customerNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deleteBtn)
                                    .addComponent(createBtn2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backToUserPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(45, 45, 45))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(185, 185, 185)
                    .addComponent(customerIdTxtField)
                    .addGap(185, 185, 185)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBtn2)
                    .addComponent(jLabel4)
                    .addComponent(customerNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(addressTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(backToUserPanelBtn)
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(customerIdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(217, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerIdTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIdTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIdTxtFieldActionPerformed

    private void addressTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTxtFieldActionPerformed

    private void customerNameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameTxtFieldActionPerformed

    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String customerId = JOptionPane.showInputDialog(this, "Enter Customer ID to delete:");

        if (customerId == null || customerId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Customer ID is required!");
            return;
        }

        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "DELETE FROM customers WHERE CustomerID=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(customerId));

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Deleted successfully!");
                LoadTableData();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void backToUserPanelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToUserPanelBtnActionPerformed
        new CRUD().setVisible(true); // go back to purchase panel
        this.dispose(); // close current window
    }//GEN-LAST:event_backToUserPanelBtnActionPerformed

    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
    private void createBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtn2ActionPerformed
        String name = customerNameTxtField.getText().trim(); // CUSTOMER NAME
        String address = addressTxtField.getText().trim(); // ADDRESS

        if (name.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        try {
            Connection conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO customers (CustomerName, Address) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, address);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Customer added!");

            LoadTableData();

            customerNameTxtField.setText("");
            addressTxtField.setText("");

            pst.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_createBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(viewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new viewCustomer().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTxtField;
    private javax.swing.JButton backToUserPanelBtn;
    private javax.swing.JButton createBtn2;
    private javax.swing.JTextField customerIdTxtField;
    private javax.swing.JTextField customerNameTxtField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
