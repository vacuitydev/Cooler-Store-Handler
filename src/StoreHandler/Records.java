/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreHandler;

import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author Muneeb
 */
public class Records extends JFrame {
    private JScrollPane scroller;
    private JTable table;
    private JLabel top_image;
    
    public Records(ArrayList<Payment> payments) {
        
        top_image = new JLabel();
        scroller = new JScrollPane();
        table = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        top_image.setIcon(new ImageIcon(getClass().getResource("/Images/realistic_records.png"))); // NOI18N
        top_image.setText("");
        
        table.setModel(new PaymentModel(payments));

        
        scroller.setViewportView(table);
        initComponents();
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_image, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(scroller)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_image)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(scroller, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }



    
}
