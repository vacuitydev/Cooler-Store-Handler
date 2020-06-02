package StoreHandler;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author Muneeb
 */
public class Add_Store_Window extends javax.swing.JFrame implements ActionListener{
    private JButton confirm_button;
    private JLabel address_label;
    private JLabel preview;
    
    //Keeping with the design type of the StartPage
    private JLabel top_image;
    
    private JRadioButton outlet_button;
    private JTextField address_field;
    private JTextField name_field;
    private JLabel name_label;
    private JRadioButton online_button;
    private JLabel store_type_label;
    private ButtonGroup store_types;
    
    private boolean is_online;
    
    //A window adapter AND a button listener just to be safe
    public void setWindowAdapter(WindowAdapter adapter){
        addWindowListener(adapter);
    }
    
    private MainButtonPressed refresher;

    public Add_Store_Window(ArrayList <Store> stores) {
        initComponents();       
        store_types= new ButtonGroup();
        store_types.add(online_button);
        store_types.add(outlet_button);
        online_button.setSelected(true);
        pack();
        
        confirm_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preview.setForeground(Color.RED);
                if(name_field.getText().isEmpty()!= true){
                    if(address_field.getText().isEmpty()!=true){
                        preview.setForeground(Color.BLACK);
                        is_online = online_button.isSelected();
                        if(is_online ==true)
                            stores.add(new OnlineStore(name_field.getText(), address_field.getText()));
                        else stores.add(new OutletStore(name_field.getText(), address_field.getText()));
                        
                        refresher.button_pressed();
                        preview.setText("Store added");
                        preview.paintImmediately(preview.getVisibleRect());
                        JOptionPane.showMessageDialog(null, "The " + (is_online ? "online":"outlet") + " store \""+name_field.getText()+ "\" at "+
                                address_field.getText()+" has been added.");

                    }
                    //condition for when adress field is empty
                    else {
                        preview.setText("Adress cannot be empty");
                        preview.paintImmediately(preview.getVisibleRect());
                        System.out.println("Address Field is empty.");
                    }
                }
                //condition for when name field is empty
                else {
                    preview.setText("Name cannot be empty");
                    preview.paintImmediately(preview.getVisibleRect());
                    System.out.println("Name Field is empty.");
                }
                pack();
            }
            
        });
        setResizable(false);
        setVisible(true);
    }
    
    
    
    //NetBeans generated layout
    private void initComponents() {

        online_button = new javax.swing.JRadioButton();
        outlet_button = new javax.swing.JRadioButton();
        store_type_label = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        address_field = new javax.swing.JTextField();
        address_label = new javax.swing.JLabel();
        preview = new javax.swing.JLabel();
        confirm_button = new javax.swing.JButton();
        top_image = new javax.swing.JLabel();
        preview.setPreferredSize(new Dimension(400,50));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add a Store");

        online_button.setText("Online Store");

        outlet_button.setText("Outlet");

        store_type_label.setText("Choose Store Type:");

        name_label.setText("Store Name:");


        address_label.setText("Store Address:");

        preview.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        preview.setText("Preview");

        confirm_button.setText("Add Store");

        top_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add_a_store_type_back.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(online_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_label)
                    .addComponent(address_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outlet_button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_field, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(address_field, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(preview))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(confirm_button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(store_type_label, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(top_image, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(store_type_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(online_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outlet_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(preview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirm_button, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(refresher != null){
            refresher.button_pressed();
        }
    }
    
    public void set_listener(MainButtonPressed listener){
        refresher = listener;
    }
}
