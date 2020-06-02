package StoreHandler;

import java.awt.Component;
import javax.swing.JOptionPane;

public class OnlineStore extends Store {
    // online stores can only be accessed by their website
    public void sale(Integer n, String s, String c) {
        super.sale(n, s, c);
        System.out.println("A website was provided to the user.");
    }

    public OnlineStore(String name, String s) {
        super(name, s);
    }
    
    public void interact(){
        JOptionPane.showMessageDialog(null, "A website was provided to the user.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public String getStoreType(){
        return "online";
    }
}