package StoreHandler;

import java.awt.Component;
import javax.swing.JOptionPane;

public class OutletStore extends Store {
    public void sale(Integer n, String s, String c) {
        super.sale(n, s, c);
        System.out.println("Customer has been provided a building.");
    }

    public OutletStore(String name, String s) {
        super(name, s);
    }

    @Override
    public String getStoreType() {
        return "outlet";
    }
    public void interact(){
        JOptionPane.showMessageDialog(null, "A walk-in outlet was provided to the user.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

}