package SelfCheckout;

import java.util.*;
import java.util.stream.*;
import javax.swing.*;

public class Payment extends javax.swing.JFrame {
    
    private double totalPayment = 0;
    private String custID = "";
    private int counterNumber = 0;
    private int countItem = 0;

    public Payment(String custID, double totalPayment, int counterNumber, int countItem) {
        this.totalPayment = totalPayment;
        this.custID = custID;
        this.counterNumber = counterNumber;
        this.countItem = countItem;
        initComponents();
        pack();
        setLocationRelativeTo(null);

        paymenttitle.setText("Pay for customer " + custID);
        totalNeedPaylabel.setText("Total: RM " + totalPayment);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        paymenttitle = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        amountpayfield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        totalNeedPaylabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PAYMENT");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        paymenttitle.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        paymenttitle.setForeground(new java.awt.Color(51, 51, 51));
        paymenttitle.setText("Checkout");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymenttitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymenttitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Enter amount:");

        amountpayfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 217, Short.MAX_VALUE))
                    .addComponent(amountpayfield, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountpayfield, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Pay");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        totalNeedPaylabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalNeedPaylabel.setText("Total: RM 0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalNeedPaylabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalNeedPaylabel)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        //PAYMENT PROCESS AND DISPLAY RECEIPT
        double amountpay = 0;
        try {
            amountpay = Double.parseDouble(amountpayfield.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter money to proceed", "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (amountpay < totalPayment) {
            JOptionPane.showMessageDialog(null, "Insufficient amount, please add more money", "Insufficient", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double balance = amountpay - totalPayment;

        //FIND CUSTOMER'S DATA IN QUEUE
        List<CustInformation> convertedCustList = null;
        if (counterNumber == 1) {
            convertedCustList = (List<CustInformation>) SelfCheckout.Main.getCounter1().stream().collect(Collectors.toList());
        } else if (counterNumber == 2) {
            convertedCustList = (List<CustInformation>) SelfCheckout.Main.getCounter2().stream().collect(Collectors.toList());
        } else if (counterNumber == 3) {
            convertedCustList = (List<CustInformation>) SelfCheckout.Main.getCounter3().stream().collect(Collectors.toList());
        }
        String custIC = "";
        String custName = "";
        for (Iterator iterator = convertedCustList.iterator(); iterator.hasNext();) {
            CustInformation nextCustomerData = (CustInformation) iterator.next();
            if (nextCustomerData.getCustID().equalsIgnoreCase(custID)) {
                custIC = nextCustomerData.getCustIC();
                custName = nextCustomerData.getCustName();
                break;
            }
        }

        //REMOVE CUSTOMER AND ITEM AFTER PAYMENT MADE AND ALSO SAVE LIST ITEM FOR RECEIPT DISPLAY
        Queue listItem = new LinkedList();
        for (int i = 0; i < countItem; i++) {
            if (counterNumber == 1) {
                CustInformation itemCurrent = (CustInformation) SelfCheckout.Main.getCounter1().peek();
                listItem.add(itemCurrent);
                SelfCheckout.Main.getCounter1().remove();
            } else if (counterNumber == 2) {
                CustInformation itemCurrent = (CustInformation) SelfCheckout.Main.getCounter2().peek();
                listItem.add(itemCurrent);
                SelfCheckout.Main.getCounter2().remove();
            } else if (counterNumber == 3) {
                CustInformation itemCurrent = (CustInformation) SelfCheckout.Main.getCounter3().peek();
                listItem.add(itemCurrent);
                SelfCheckout.Main.getCounter3().remove();
            }
        }

        //this will display the receipt
        CustReceipt receipt = new CustReceipt(custID, custIC, custName, totalPayment, amountpay, balance, listItem);
        receipt.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MouseReleased

    //Auto generated by NetBeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountpayfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel paymenttitle;
    private javax.swing.JLabel totalNeedPaylabel;
    // End of variables declaration//GEN-END:variables

}
