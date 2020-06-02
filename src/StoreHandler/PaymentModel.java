/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreHandler;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Muneeb
 */
public class PaymentModel extends AbstractTableModel{
    private ArrayList<Payment> payments;
    private String[] columns;
    
    public PaymentModel(ArrayList<Payment> inp){
        super();
        payments = inp;
        columns = new String[]{"Index", "Customer Name", "Item Name", "Store Type", "Store Name", "Price", "Paid by"};
    }
    @Override
    public int getRowCount() {
        return payments.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Payment current = payments.get(row);
        switch(col){
            case 0:
                return Integer.toString(row+1);
            case 1:
                return current.getCustomer();
            case 2:
                return current.getIname();
            case 3:
                return current.getStore().getStoreType();
            case 4:
                return current.getStore().get_name();
            case 5:
                return current.getPrice();
            case 6:
                return current.get_payment_type();
        }
        return 0;
    }
    @Override
    public String getColumnName(int col){
        return columns[col];
    }
    
}
