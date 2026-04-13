package Midterm;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CRUD extends javax.swing.JFrame {

    public static int loggedInUserId;

    public CRUD() {
        initComponents();
        loadTableData(); // VERY IMPORTANT
    }

    @SuppressWarnings("ConvertToTryWithResources")
    private void loadTableData() {
        try {
            Connection conn = ConnectionDB.getConnection();

            String sql = """
            SELECT 
                p.PurchaseID,
                c.CustomerName,
                p.FlowerType,
                c.Address
            FROM purchases p
            INNER JOIN customers c ON p.CustomerID = c.CustomerID
        """;

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("PurchaseID"),
                    rs.getString("CustomerName"),
                    rs.getString("FlowerType"),
                    rs.getString("Address")
                });
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading table: " + e.getMessage());
        }
    }

    private void clearFields() {
        customerIdTxtField.setText("");
        flowerSelection.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        createBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        customerIdTxtField = new javax.swing.JTextField();
        flowerSelection = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        viewCustomerBtn = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        label1.setBackground(new java.awt.Color(0, 102, 102));
        label1.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("User Panel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        createBtn.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        createBtn.setForeground(new java.awt.Color(0, 153, 153));
        createBtn.setText("CREATE");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(0, 153, 153));
        logoutBtn.setText("LOGOUT");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CUSTOMER ID:");

        customerIdTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIdTxtFieldActionPerformed(evt);
            }
        });

        flowerSelection.setForeground(new java.awt.Color(255, 255, 255));
        flowerSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ROSE", "DAISY", "SUNFLOWER", "LILLY", " " }));
        flowerSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flowerSelectionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FLOWER TYPE:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PURCHASE ID", "CUSTOMER NAME", "FLOWER TYPE", "ADDRESS"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        updateBtn.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(0, 153, 153));
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
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

        viewCustomerBtn.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        viewCustomerBtn.setForeground(new java.awt.Color(0, 153, 153));
        viewCustomerBtn.setText("VIEW CUSTOMER");
        viewCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustomerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(customerIdTxtField)
                                        .addGap(38, 38, 38))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(flowerSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(viewCustomerBtn)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(createBtn)
                                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(logoutBtn)))))
                        .addGap(60, 60, 60)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createBtn)
                            .addComponent(customerIdTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateBtn))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(flowerSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn)
                    .addComponent(viewCustomerBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutBtn)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings({"CallToPrintStackTrace", "ConvertToTryWithResources", "UseSpecificCatch"})
    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed

        String customerId = customerIdTxtField.getText().trim();
        String flower = flowerSelection.getSelectedItem().toString();

        if (customerId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Customer ID!");
            return;
        }

        try {
            Connection conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO purchases (UserID, CustomerID, FlowerType) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, CRUD.loggedInUserId); // UserID
            pst.setInt(2, Integer.parseInt(customerId)); // CustomerID
            pst.setString(3, flower); // FlowerType

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Purchase saved!");

            loadTableData();
            clearFields();

            pst.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }


    }//GEN-LAST:event_createBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        this.dispose();

    }//GEN-LAST:event_logoutBtnActionPerformed

    private void customerIdTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIdTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIdTxtFieldActionPerformed

    private void flowerSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flowerSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flowerSelectionActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String purchaseId = JOptionPane.showInputDialog(this, "Enter Purchase ID to delete:");

        if (purchaseId == null || purchaseId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Purchase ID is required!");
            return;
        }

        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "DELETE FROM purchases WHERE PurchaseID=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(purchaseId));

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Deleted successfully!");
                loadTableData();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        String purchaseId = JOptionPane.showInputDialog(this, "Enter Purchase ID to update:");
        String customerId = customerIdTxtField.getText().trim();
        String flower = flowerSelection.getSelectedItem().toString();

        if (purchaseId == null || purchaseId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Purchase ID is required!");
            return;
        }

        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "UPDATE purchases SET CustomerID=?, FlowerType=? WHERE PurchaseID=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(customerId));
            pst.setString(2, flower);
            pst.setInt(3, Integer.parseInt(purchaseId));

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Data Updated!");
                loadTableData();
                clearFields();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }


    }//GEN-LAST:event_updateBtnActionPerformed

    private void viewCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustomerBtnActionPerformed
        new viewCustomer().setVisible(true);
        this.dispose(); // closes CRUD window
    }//GEN-LAST:event_viewCustomerBtnActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new CRUD().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createBtn;
    private javax.swing.JTextField customerIdTxtField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> flowerSelection;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton viewCustomerBtn;
    // End of variables declaration//GEN-END:variables
}
