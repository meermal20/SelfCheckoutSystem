package SelfCheckout;

import java.awt.event.*;
import java.util.*;
import java.util.stream.*;
import javax.swing.*;
import javax.swing.table.*;

public class ListCustCounter extends javax.swing.JFrame {

    private int counterNumber = 0;

    public ListCustCounter(int counterNumber) {
        this.counterNumber = counterNumber;
        initComponents();
        pack();
        setLocationRelativeTo(null);
        counterlabel.setText("Counter " + counterNumber);
        switch (counterNumber) {
            case 1 -> displayCustomer(SelfCheckout.Main.getCounter1());
            case 2 -> displayCustomer(SelfCheckout.Main.getCounter2());
            case 3 -> displayCustomer(SelfCheckout.Main.getCounter3());
            default -> {
            }
        }
    }

    private void displayCustomer(Queue counter) {
        String currentCustID = "";
        DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
        customerTableModel.setRowCount(0);
        //sort customers data only to add to a new list
        List<CustInformation> convertedCustList = (List<CustInformation>) counter.stream().collect(Collectors.toList());

        int custCount = 0;
        for (CustInformation nextCustomerData : convertedCustList) {
            if (!nextCustomerData.getCustID().equalsIgnoreCase(currentCustID)) {
                currentCustID = nextCustomerData.getCustID();
                custCount++;
                customerTableModel.addRow(new Object[]{nextCustomerData.getCustName(), nextCustomerData.getCustIC(), nextCustomerData.getCustID()});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        counterlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Counter");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Open customer item");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 150, -1));

        jButton1.setText("Pay");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 150, -1));

        counterlabel.setBackground(new java.awt.Color(255, 255, 255));
        counterlabel.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        counterlabel.setText("Counter 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(counterlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(counterlabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\shame\\Desktop\\1080p.jpg")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-390, 0, 640, 410));

        customerTable.setBackground(new java.awt.Color(204, 255, 255));
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Customer IC", "Customer ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setPreferredWidth(400);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Payment payment;
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //this is for payment process
        if (payment == null) {
            //get the first customer from the queue
            CustInformation datacust = null;
            switch (counterNumber) {
                case 1:
                    datacust = (CustInformation) SelfCheckout.Main.getCounter1().peek();
                    break;
                case 2:
                    datacust = (CustInformation) SelfCheckout.Main.getCounter2().peek();
                    break;
                case 3:
                    datacust = (CustInformation) SelfCheckout.Main.getCounter3().peek();
                    break;
                default:
                    break;
            }
            if (datacust == null) {
                JOptionPane.showMessageDialog(null, "No customer queue to pay", "No customer", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String custIDPay = datacust.getCustID();
            double totalPayment = 0;

            List<CustInformation> convertedItemList = null;
            List<CustInformation> filteredItemListCust = null;
            switch (counterNumber) {
                case 1 -> {
                    convertedItemList = (List<CustInformation>) SelfCheckout.Main.getCounter1().stream().collect(Collectors.toList());
                    filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
                }
                case 2 -> {
                    convertedItemList = (List<CustInformation>) SelfCheckout.Main.getCounter2().stream().collect(Collectors.toList());
                    filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
                }
                case 3 -> {
                    convertedItemList = (List<CustInformation>) SelfCheckout.Main.getCounter3().stream().collect(Collectors.toList());
                    filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
                }
                default -> {
                }
            }

            int countitem = 0;
            for (CustInformation nextItemData : filteredItemListCust) {
                countitem++;
                //calculate total payment
                totalPayment = totalPayment + nextItemData.getitemPrice();
            }

            payment = new Payment(custIDPay, totalPayment, counterNumber, countitem);
            payment.setVisible(true);
            payment.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    switch (counterNumber) {
                        case 1 -> displayCustomer(SelfCheckout.Main.getCounter1());
                        case 2 -> displayCustomer(SelfCheckout.Main.getCounter2());
                        case 3 -> displayCustomer(SelfCheckout.Main.getCounter3());
                        default -> {
                        }
                    }
                    payment = null;
                }

            });
        } else {
            payment.setVisible(true);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    Map<String, ListProducts> itemInstance = new TreeMap<>();
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        try {
            String custIDselect = (String) customerTable.getValueAt(customerTable.getSelectedRow(), 2);

            ListProducts getItemUI = itemInstance.get("items" + custIDselect);
            if (getItemUI == null) {
                ListProducts newItemUI = new ListProducts(custIDselect, counterNumber);
                itemInstance.put("items" + custIDselect, newItemUI);
                newItemUI.setVisible(true);
            } else {
                getItemUI.setVisible(true);
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Please select customer from table", "No customer selected", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    //Auto generated by NetBeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterlabel;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
