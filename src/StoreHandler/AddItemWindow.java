/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
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

public class AddItemWindow extends JFrame {
    private JLabel top_image;
    private JLabel store_selection_label;
    private JComboBox<String> store_selection_box;

    private JLabel name_label;
    private JTextField name_field;    
    
    private JTextField price_field;
    private JLabel price_label;
    private JLabel monies_label;
    
    private JTextField quantity_field;
    private JLabel quantity_label;

    
    private JButton confirm_button;
    private JLabel preview;
    
    private GroupLayout layout;
    
    private MainButtonPressed refresher;
    
    public final int NEW_STORE = 1;
    public final int APPEND = 0;
    
    public AddItemWindow(ArrayList<Store> stores) {
        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        //Top image
        top_image = new javax.swing.JLabel();
        top_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add_item_back.png"))); // NOI18N

        //Store selection box
        store_selection_box = new javax.swing.JComboBox<>();
        store_selection_label = new javax.swing.JLabel();
        DefaultComboBoxModel ComboBoxData= new DefaultComboBoxModel();
        for (Store s: stores) {
            ComboBoxData.addElement(s);
        }
        store_selection_box.setModel(ComboBoxData);
        
        store_selection_label.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        store_selection_label.setText("Add to");

        
        name_label = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        name_label.setText("Item Name:");

        
        quantity_label = new javax.swing.JLabel();
        quantity_label.setText("Number of items:");
        quantity_field = new javax.swing.JTextField();
        quantity_field.setText("0");
 
        price_field = new javax.swing.JTextField(5);
        price_label = new javax.swing.JLabel();
        price_label.setText("Price of item:");
        price_field.setText("0");

        monies_label = new javax.swing.JLabel();
        monies_label.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        monies_label.setText("Monies");
        
        preview = new javax.swing.JLabel();
        preview.setText("Ready");
        preview.setHorizontalTextPosition(JLabel.CENTER);
        
        confirm_button = new javax.swing.JButton();
        confirm_button.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirm_button.setText("Add");
        
        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //keeping them strings to aid memory
                String name = name_field.getText();
                String quantity = quantity_field.getText();
                String price = price_field.getText();
                
                System.out.println(name + " " + quantity + " " + price);
                
                preview.setForeground(Color.RED);
                if ("".equals(name) == false) {
                    if("".equals(quantity)== false &&"0".equals(quantity)== false){
                        //An item can technically cost 0 Monies
                        //Some items do irl
                        if("".equals(price) ==  false){
                            try {
                                preview.setForeground(Color.BLACK);
                                //Reset the fields to empty
                                //name_field.setText("");
                                quantity_field.setText("0");
                                price_field.setText("0");

                                //Finally
                                //Add the item(s) to the selected Store
                                Store selection = stores.get(store_selection_box.getSelectedIndex());
    //                            Store selection = (Store) store_selection_box.getSelectedItem();
                                selection.add_item(name, Double.parseDouble(price), Integer.parseInt(quantity));
                                refresher.button_pressed();
                                preview.paintImmediately(preview.getVisibleRect());
                                JOptionPane.showMessageDialog(null, quantity+ " of the item " + name + " costing " 
                                + price + " Monies has been added to " + selection+ ".");
                                System.out.println(name + " " + Integer.parseInt(quantity) + " " + Double.parseDouble(price));
                            } catch (NumberFormatException exception) {
                                preview.setForeground(Color.RED);
                                preview.setText("<html><div style='text-align: center;'>" +  "Price or quantity cannot be non-numeric"+"</div></html>");
                                preview.paintImmediately(preview.getVisibleRect());
                            }
                            
                        } else {
                            preview.setText("<html><div style='text-align: center;'>" + "Price field cannot be empty"+"</div></html>");
                            preview.paintImmediately(preview.getVisibleRect());
                        }
                    } else {
                        preview.setText("<html><div style='text-align: center;'>" + "Cannot add 0 items."+"</div></html>");
                        preview.paintImmediately(preview.getVisibleRect());
                    }
                                

                }else {
                    preview.setText("<html><div style='text-align: center;'>" + "Item name cannot be empty"+"</div></html>");
                    preview.paintImmediately(preview.getVisibleRect());
                }
            }
        });
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        align_components();
        setVisible(true);
    };
    private void align_components() {
        
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top_image)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name_label)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(store_selection_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(store_selection_box, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantity_label)
                            .addComponent(price_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(price_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monies_label))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(preview))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(confirm_button))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_image)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(store_selection_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(store_selection_label))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_label)
                            .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(quantity_label)
                                    .addComponent(quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(price_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(monies_label)))
                    .addComponent(price_label))
                .addGap(33, 33, 33)
                .addComponent(preview)
                .addGap(18, 18, 18)
                .addComponent(confirm_button)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        pack();
    }


    public void set_listener(MainButtonPressed listener){
        refresher = listener;
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AddItemWindow().setVisible(true);
//            }
//        });
//    }

}
