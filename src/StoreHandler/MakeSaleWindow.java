/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Muneeb
 */
public class MakeSaleWindow extends JFrame {
    private JScrollPane jScrollPane2;
    private JButton make_order_button;
    private JButton new_order_button;
    private JList<Order> order_list;
    private JLabel top_image_label;
    private DefaultListModel<Order> list_data;
    
    //There's gonna be three levels of convolutedness when it comes to refreshing the panel here
    private MainButtonPressed refresher;
    
    public MakeSaleWindow(ArrayList <Store> stores, ArrayList<Order> orders, ArrayList<Payment> payments) {
        super("Sales");
        top_image_label = new JLabel();
        new_order_button = new JButton("Create New Order");
        make_order_button = new JButton("Make Selected Order");
        jScrollPane2 = new JScrollPane();
        order_list = new JList<>();

        

        top_image_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/make_sale_top.png"))); // NOI18N
        top_image_label.setText("");

        new_order_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateOrder create_order = new CreateOrder(stores,orders);
                disable_buttons();
                create_order.set_listener(new MainButtonPressed() {
                    @Override
                    public void button_pressed() {
                        refresh_list(orders);
                    }
                });
                create_order.addWindowListener( new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent e)
                        {
                            enable_buttons();
                            create_order.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }
                });
            }
        });
        make_order_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentWindow foreground = new PaymentWindow(order_list.getSelectedValue(), payments);
                disable_buttons();
                foreground.set_listener(new MainButtonPressed() {
                    @Override
                    public void button_pressed() {
                        refresher.button_pressed();
                        refresh_list(orders);
                    }
                });
                foreground.addWindowListener( new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent e)
                        {
                            enable_buttons();
                            foreground.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }
                });
            }
        });
        
        refresh_list(orders);
        jScrollPane2.setViewportView(order_list);
        jScrollPane2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createTitledBorder("Select An Order")));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
        setVisible(true);
    }

    public void set_listener(MainButtonPressed m){
        this.refresher = m;
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_image_label, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(new_order_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(make_order_button))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_image_label, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(new_order_button)
                    .addComponent(make_order_button))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
    
    public void refresh_list(ArrayList<Order> orders){
       list_data = new DefaultListModel<>();
        for (Order order: orders) {
            list_data.addElement(order);
        }
        order_list.setModel(list_data);
    }
    
    public void disable_buttons(){
        make_order_button.setEnabled(false);
        new_order_button.setEnabled(false);
    }
    public void enable_buttons(){
        make_order_button.setEnabled(true);
        new_order_button.setEnabled(true);
    }
}
