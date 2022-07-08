package SelfCheckout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Main {
    
    //stores all customers' queue
    private static Queue Counter1 = new LinkedList();
    private static Queue Counter2 = new LinkedList();
    private static Queue Counter3 = new LinkedList(); //counter 3 is fore customers with more than 5 items
    
    //temporary list
    private static ArrayList<CustInformation> CustomerList = new ArrayList();
    private static ArrayList<String> listCustID = new ArrayList<String>();
    private static CounterSelect CounterSwitching;
    
    public static Queue getCounter1(){
        return Counter1;
    }
    
    public static Queue getCounter2(){
        return Counter2;
    }
    
    public static Queue getCounter3(){
        return Counter3;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("cashierapp.txt"));
            String line = br.readLine();

            String customerID;
            String customerIC;
            String customerName;
            String currentCustID = "";

            while (line != null) {
                //read all data berfore adding to queue
                StringTokenizer st = new StringTokenizer(line, ",");
                customerID = st.nextToken();
                customerIC = st.nextToken();
                customerName = st.nextToken();
                String itemID = st.nextToken();
                String itemName = st.nextToken();
                double itemPrice = Double.parseDouble(st.nextToken());
                String datePurchase = st.nextToken();
                if (!customerID.equalsIgnoreCase(currentCustID)) {
                    listCustID.add(customerID);
                    currentCustID = customerID;
                }

                CustomerList.add(new CustInformation(customerID, customerIC, customerName, null, itemID, itemName, itemPrice, datePurchase));

                line = br.readLine();
            }
            br.close();

            //add data to queue
            int counterState = 1;
            for (int i = 0; i < listCustID.size(); i++) {
                List SortedCustProducts = SortItemDataCust(listCustID.get(i));

                if (SortedCustProducts.size() <= 5) {
                    if (counterState == 1) {
                        for (int j = 0; j < SortedCustProducts.size(); j++) {
                            CustInformation dataItems = (CustInformation) SortedCustProducts.get(j);
                            String custID = dataItems.getCustID();
                            String custIC = dataItems.getCustIC();
                            String custName = dataItems.getCustName();
                            String itemID = dataItems.getItemID();
                            String itemName = dataItems.getItemName();
                            Double itemPrice = dataItems.getitemPrice();
                            String datePurchased = dataItems.getDatePurchase();

                            SelfCheckout.Main.getCounter1().add(new CustInformation(custID, custIC, custName, "counter1", itemID, itemName, itemPrice, datePurchased));
                        }
                        counterState = 2;
                    } else if (counterState == 2) {
                        for (int j = 0; j < SortedCustProducts.size(); j++) {
                            CustInformation dataItems = (CustInformation) SortedCustProducts.get(j);
                            String custID = dataItems.getCustID();
                            String custIC = dataItems.getCustIC();
                            String custName = dataItems.getCustName();
                            String itemID = dataItems.getItemID();
                            String itemName = dataItems.getItemName();
                            Double itemPrice = dataItems.getitemPrice();
                            String datePurchased = dataItems.getDatePurchase();

                            SelfCheckout.Main.getCounter2().add(new CustInformation(custID, custIC, custName, "counter2", itemID, itemName, itemPrice, datePurchased));

                        }
                        counterState = 1;
                    }
                } else {
                    for (int g = 0; g < SortedCustProducts.size(); g++) {
                        CustInformation dataItems = (CustInformation) SortedCustProducts.get(g);
                        String custID = dataItems.getCustID();
                        String custIC = dataItems.getCustIC();
                        String custName = dataItems.getCustName();
                        String itemID = dataItems.getItemID();
                        String itemName = dataItems.getItemName();
                        Double itemPrice = dataItems.getitemPrice();
                        String datePurchased = dataItems.getDatePurchase();

                        SelfCheckout.Main.getCounter3().add(new CustInformation(custID, custIC, custName, "counter3", itemID, itemName, itemPrice, datePurchased));

                    }
                }
            }

            CounterSwitching = new CounterSelect();
            CounterSwitching.setVisible(true);
        } catch (IOException | NumberFormatException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    
    public static List SortItemDataCust(String custID) {
        Predicate<CustInformation> itemSelectCondition = itemsCond -> itemsCond.getCustID().equalsIgnoreCase(custID);
        List itemsCustomer = CustomerList.stream().filter(itemSelectCondition).collect(Collectors.toList());
        return itemsCustomer;
    }
   
}
