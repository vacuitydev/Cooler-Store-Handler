package StoreHandler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Muneeb
 */

//Using the class itself for events
public class StartPage extends JFrame implements ActionListener{
    private JButton add_item_button;
    private JButton add_store_button;
    private JButton customer_interaction_button;
    private JScrollPane jScrollPane1;
    private JButton payment_records_button;
    private JLabel records_label;
    private JTextArea stores_area;
    private JPanel stores_panel;
    private JLabel top_image_label;
    
    //to be set later by the main
    private SelectionEmitter listener;
    
    //to be aligned later
    
    //top level layout
    GroupLayout stores_panelLayout;
    
    //subsequent levels don't need to be refreshed
    
    public StartPage() {
        super("Start Page");
        add_store_button = new JButton("Add Store");
        add_store_button.addActionListener(this);
        
        
        add_item_button = new JButton("Add Item");
        add_item_button.addActionListener(this);
        
        customer_interaction_button = new JButton("Make Sale");
        //red because its about monies
        customer_interaction_button.setBackground(new java.awt.Color(255, 51, 51));
        customer_interaction_button.addActionListener(this);
        
        payment_records_button = new JButton("Payment Records");
        payment_records_button.addActionListener(this);        
        
        stores_panel = new JPanel();
        stores_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        
        records_label = new JLabel("Current Stores");
        records_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        
        stores_area = new JTextArea(20, 5);
        stores_area.setEditable(false);
        jScrollPane1 = new JScrollPane(stores_area);
        //jScrollPane1.setViewportView(records_text_area);
        top_image_label = new JLabel();
        
        top_image_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Store_manager_background.png")));
        //idk why but this one down here didn't work, even though its identical
        //gives a null pointer exception
        //top_image_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Store_manager_background.png"))); 
        top_image_label.setText("Literally anything lol");
        
        stores_panelLayout = new GroupLayout(stores_panel);
        stores_panel.setLayout(stores_panelLayout);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        alignComponents();
        setVisible(true);
    }
    
    //aligns the components, better not mess with it again
    private void alignComponents() {
        //setting the GroupLayout
        
        
        stores_panelLayout.setHorizontalGroup(
            stores_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stores_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stores_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stores_panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(records_label)
                        .addGap(213, 213, 213)))
                .addContainerGap())
        );
        
        
        stores_panelLayout.setVerticalGroup(
            stores_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stores_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(records_label, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        //level 2 layout, won't need to refresh
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(top_image_label, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(add_store_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(add_item_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customer_interaction_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(payment_records_button, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stores_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(top_image_label)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_store_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_item_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(customer_interaction_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(payment_records_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stores_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }
    
    //sets listener attribute
    public void setListener(SelectionEmitter listener){
        this.listener = listener;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((listener!= null))                                                  //contingency if listener isn't set
        {
            //It's always going to be a button
            JButton sauce = (JButton) e.getSource();
            
            //comparing sauce with reference and emitting signals accordingly
            if(sauce == add_store_button){
                listener.CommandEmitted("add store");
            } else if (sauce == add_item_button) {
                listener.CommandEmitted("add item");
            } else if (sauce == customer_interaction_button) {
                listener.CommandEmitted("make payment");
            } else if (sauce == payment_records_button) {
                listener.CommandEmitted("show records");
            }
            
        }
    }
    
    public void erase_panel(){
        stores_area.setText("");
    }
    public void append_to_panel(String S){
        stores_area.append(S);
    }
    public void disable_buttons(){
        add_item_button.setEnabled(false);
        add_store_button.setEnabled(false);
        customer_interaction_button.setEnabled(false);
        payment_records_button.setEnabled(false);
    }
    public void enable_buttons(){
        add_item_button.setEnabled(true);
        add_store_button.setEnabled(true);
        customer_interaction_button.setEnabled(true);
        payment_records_button.setEnabled(true);
    }
}
