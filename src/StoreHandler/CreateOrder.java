package StoreHandler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Muneeb
 */
public class CreateOrder extends JFrame {
    private JLabel amount_label;
    private JButton button;
    private JTextField name_field;
    private JLabel name_label;
    private JLabel preview;
    private JTextField quantity_field;
    private JLabel store_label;
    private JComboBox<Store> store_selector;
    private JLabel top_image;
    private MainButtonPressed refresher;
    /**
     * Creates new form CreateAnOrder
     */
    public CreateOrder(ArrayList <Store> stores, ArrayList <Order> orders){
        top_image = new javax.swing.JLabel();
        store_selector = new JComboBox<>();
        store_label = new JLabel("Select Store:");
        name_label = new JLabel("Item Name:");
        name_field = new JTextField();
        amount_label = new JLabel("Amount:");
        quantity_field = new JTextField(4);
        quantity_field.setText("0");
        preview = new javax.swing.JLabel();
        preview.setText("Ready");
        button = new javax.swing.JButton("Create Order");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //keeping them strings to aid memory
                String name = name_field.getText();
                String quantity = quantity_field.getText();
                System.out.println(name + " " + quantity + " " );
                Store selection= (Store) store_selector.getSelectedItem();
                
                preview.setForeground(Color.RED);
                if(is_valid(name, quantity, selection)== true){
                    preview.setForeground(Color.BLACK);
                    //Reset the fields to empty
                    name_field.setText("");
                    quantity_field.setText("0");

                    //Finally
                    //Add the item(s) to the selected Store
                    orders.add(new Order(name, Integer.parseInt(quantity), selection));
                    refresher.button_pressed();
                    preview.paintImmediately(preview.getVisibleRect());
                    
                    JOptionPane.showMessageDialog(null, quantity+ " of the item " + name + " costing " 
                    + selection.get_price(name) +" Monies has been added to " + selection+ ".");
                }
            }
        });   
        top_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/order_creatiion_top.png"))); // NOI18N
        top_image.setText("");
        refresh_list(stores);

        setResizable(false);
        setVisible(true);
        initComponents();
    }
    private void initComponents() {

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(store_label, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(amount_label)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(store_selector, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(preview, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(button)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(store_selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(store_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_label)
                    .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amount_label)
                    .addComponent(quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(preview)
                .addGap(18, 18, 18)
                .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void refresh_list(ArrayList<Store> stores) {
        DefaultComboBoxModel list_data = new DefaultComboBoxModel<Store>();
        for(Store s: stores){
            list_data.addElement(s);
        }
        store_selector.setModel(list_data);
    }
    
    public boolean is_valid(String name, String quantity, Store store){
        boolean output = true;
        //Try to catch type mismatch
        try {
            //Contingency for empty name
            if ("".equals(name) == true){
                preview.setText("<html><div style='text-align: left'>" + "Item name cannot be empty"+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output= false;
            }
            
            //Contingency for empty or 0 quantity
            else if("".equals(quantity)== true || "0".equals(quantity)== true){
                preview.setText("<html><div style='text-align: left'>" + "Cannot add 0 items."+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output=false;
            }
            //Contingency for item that doesn't exist in store
            else if(store.exists(name) != 1){
                preview.setText("<html><div style='text-align: left'>" + "Invalid Item"+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output=false;
            }
            //Contingency for quantity > stock
            else if(Integer.parseInt(quantity)> store.get_stock(name) ==true) {
                preview.setText("<html><div style='text-align: left'>" + "Quantity > Stock"+"</div></html>");
                preview.paintImmediately(preview.getVisibleRect());
                output=false;
            }
        } catch (NumberFormatException e) {
            //Contingency for non numeric quantity
            preview.setText("<html><div style='text-align: center;'>" +  "Quantity cannot be non-numeric"+"</div></html>");
            preview.paintImmediately(preview.getVisibleRect());
            output=false;
        }
        return output;
    }
            
    public void set_listener(MainButtonPressed listener){
        refresher = listener;
    }

    

    
}
