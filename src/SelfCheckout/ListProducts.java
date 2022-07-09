package SelfCheckout;

import java.util.*;
import java.util.stream.*;
import javax.swing.table.*;

public class ListProducts extends javax.swing.JFrame {
    private String custID;
    private int counterNumber = 0;
    private double totalPayment = 0;

    public ListProducts(String custID, int counterNumber) {
        this.custID = custID;
        this.counterNumber = counterNumber;
        initComponents();
        pack();
        setLocationRelativeTo(null);
        displayItem();
    }

    private void displayItem() {
        DefaultTableModel itemTableModel = (DefaultTableModel) itemTable.getModel();
        itemTableModel.setRowCount(0);
        //SORT ITEMS TO ADD TO A NEW LIST
        List<CustInformation> convertedItemList = null;
        List<CustInformation> filteredItemListCust = null;
        switch (counterNumber) {
            case 1 -> {
                convertedItemList = (List<CustInformation>) SelfCheckout.Main.getCounter1().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
            }
            case 2 -> {
                convertedItemList = (List<CustInformation>) SelfCheckout.Main.getCounter2().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
            }
            case 3 -> {
                convertedItemList = (List<CustInformation>) SelfCheckout.Main.getCounter3().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
            }
            default -> {
            }
        }

        for (CustInformation nextItemData : filteredItemListCust) {
            //ALSO CALCULATE TOTAL PAYMENT HERE
            totalPayment = totalPayment + nextItemData.getitemPrice();
            itemTableModel.addRow(new Object[]{nextItemData.getItemName(), nextItemData.getItemID(), "RM " + nextItemData.getitemPrice(), nextItemData.getDatePurchase()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        itemtitlelabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ITEM");

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        itemtitlelabel1.setBackground(new java.awt.Color(255, 255, 255));
        itemtitlelabel1.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        itemtitlelabel1.setForeground(new java.awt.Color(255, 255, 255));
        itemtitlelabel1.setText("List Item for customer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(itemtitlelabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemtitlelabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\shame\\Desktop\\1080p.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setToolTipText("");
        jLabel1.setAutoscrolls(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-640, -20, 830, 410));

        itemTable.setBackground(new java.awt.Color(204, 255, 255));
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item ID", "Price", "Date Purchased"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Auto generated by NetBeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel itemtitlelabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
