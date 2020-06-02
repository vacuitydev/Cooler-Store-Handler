/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreHandler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author Muneeb
 */
public class PaymentWindow extends JFrame {
    private JTextField balance_field;
    private JLabel balance_label;
    private JButton button;
    private ButtonGroup buttongroup;
    private JRadioButton card_button;
    private JRadioButton cash_button;
    private JLabel image_label;
    private JLabel monies_label;
    private JTextField name_field;
    private JLabel name_label;
    private JRadioButton online_button;
    private JLabel payment_label;
    private JLabel preview;
    private Order order;
    
    private MainButtonPressed listener2;
    /**
     * Creates new form PaymentWindow
     */
    public PaymentWindow(Order order, ArrayList<Payment> payments) {
        super("Confirm Orders");
        this.order = order;
        System.out.print(order.get_name());
        buttongroup = new ButtonGroup();
        
        image_label = new JLabel();
        image_label.setIcon(new ImageIcon(getClass().getResource("/Images/Make_Payment_Top.png")));
        image_label.setText("");
        
        name_label = new JLabel("Enter Customer Name:");
        name_field = new JTextField();
        
        balance_label = new JLabel("Enter Customer's Balance:");        
        balance_field = new JTextField();
        
        payment_label = new JLabel("How would they like to pay for it?");
        
        cash_button = new JRadioButton("By Cash");
        card_button = new JRadioButton("By Card");
        online_button = new JRadioButton("By Online API");
        
        monies_label = new JLabel();
        monies_label.setFont(new Font("Segoe UI", 2, 12)); // NOI18N
        monies_label.setText("Monies");
        preview = new JLabel("Ready");
        
        buttongroup.add(cash_button);
        buttongroup.add(card_button);
        buttongroup.add(online_button);
        cash_button.setSelected(true);
        
        button = new JButton("Confirm");
        //Here comes the fun part
        //Store store = order.get_store();
        String item_name = order.get_name();
        button.addActionListener(new ActionListener() {
            String balance = balance_field.getText();
            String customer_name = name_field.getText();
            //String payment_type = (buttongroup.getSelection()).getText();
            
            @Override
            public void actionPerformed(ActionEvent e) {
                preview.setForeground(Color.RED);
                if(is_valid()== true){
                    Payment temp;
                    if (cash_button.isSelected()) {
                        payments.add(temp= new CashPayment(customer_name, order));
                    } else if(card_button.isSelected()){
                        payments.add(temp= new CardPayment(customer_name, order));
                    } else{
                        payments.add(temp= new OnlinePayment(customer_name, order));
                    }
                    listener2.button_pressed();
                    order.get_store().interact();
                    JOptionPane.showMessageDialog(null, "The order has been carried out "+ temp.get_payment_type()+".", "Success", JOptionPane.INFORMATION_MESSAGE);
                    balance_field.setText((Double.parseDouble(balance_field.getText())-order.get_total_price()) + "");
                    preview.setForeground(Color.BLACK);
                    preview.setText("<html><div style='text-align: left'>" + "Payment made."+"</div></html>");
                    preview.paintImmediately(preview.getVisibleRect());
                }
                
            }
        });
        
        
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    
    private void initComponents() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payment_label)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_label)
                            .addComponent(balance_label))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(balance_field, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(monies_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(cash_button, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card_button, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(online_button, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balance_label)
                    .addComponent(balance_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monies_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(payment_label)
                .addGap(18, 18, 18)
                .addComponent(image_label)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cash_button)
                    .addComponent(card_button)
                    .addComponent(online_button))
                .addGap(18, 18, 18)
                .addComponent(preview)
                .addGap(18, 18, 18)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }
    public boolean is_valid(){
        
        System.out.print(order.get_number());
        String name = name_field.getText();
        String item_name = order.get_name();
        String balance = balance_field.getText();
        Store store = order.get_store();
        boolean output = true;
        //Try to catch type mismatch
        try {
            //Contingency for empty name
            if ("".equals(name) == true){
                preview.setText("<html><div style='text-align: left'>" + "Customer name cannot be empty"+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output= false;
            }
            
            //Contingency for empty or 0 quantity
            else if("".equals(balance)== true || "0".equals(balance)== true){
                preview.setText("<html><div style='text-align: left'>" + "Cannot have 0 or null <i> Monies </i>."+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output=false;
            }
            //Contingency for item that doesn't exist in store
            else if(store.get_stock(item_name) == 0){
                preview.setText("<html><div style='text-align: left'>" + "Item is out of stock."+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output=false;
            }
            //Contingency for quantity > stock
            else if(order.get_number()> store.get_stock(item_name) ==true) {
                preview.setText("<html><div style='text-align: left'>" + "Quantity of item is greater than stock"+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output=false;
            }
            //Contingency for broke bois
            else if(order.get_total_price() > Double.parseDouble(balance) ==true) {
                preview.setText("<html><div style='text-align: left'>" + "Customer balance too low"+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output=false;
            }
        } catch (NumberFormatException e) {
            //Contingency for non numeric quantity
            preview.setText("<html><div style='text-align: center;'>" +  "Balance cannot be non-numeric"+"</div></html>");
            preview.paintImmediately(preview.getVisibleRect());
            output=false;
        }
        return output;
    }
    public void set_listener(MainButtonPressed mainButtonPressed) {
        listener2 = mainButtonPressed;
    }

    
    

}
