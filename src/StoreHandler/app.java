package StoreHandler;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

public class app {
    static private StartPage start_page;
    private ArrayList<Store> stores;
    private ArrayList<Payment> payments;
    private ArrayList<Order> orders;
    private Scanner in;
    private int mode;
   
//    // Giving it the Meteorite approach.
    
    

    public app(int is_hardcode){
        
        orders = new ArrayList<>();
        stores = new ArrayList<>();
        payments= new ArrayList<>();
        start_page = new StartPage();
        if(is_hardcode == 1){
            hardcode();
        }
        start_page.setListener(new SelectionEmitter() {
            @Override
            public void CommandEmitted(String command) {
                if ("add store".equals(command)) {
                    start_page.disable_buttons();
                    Add_Store_Window store_adding_window = new Add_Store_Window(stores);
                    store_adding_window.set_listener(new MainButtonPressed() {
                            @Override
                            public void button_pressed() {
                                refresh_panel();
                            }
                    });
                    store_adding_window.addWindowListener( new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent e)
                        {
                            start_page.enable_buttons();
                            store_adding_window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }
                    });
                    } else if ("add item".equals(command)) {
                        AddItemWindow foreground = new AddItemWindow(stores);
                        start_page.disable_buttons();
                        foreground.set_listener(new MainButtonPressed() {
                            @Override
                            public void button_pressed() {
                                refresh_panel();
                            }
                        });
                        foreground.addWindowListener( new WindowAdapter()
                        {
                        public void windowClosing(WindowEvent e)
                        {
                            start_page.enable_buttons();
                            foreground.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }
                    });
                    } else if ("make payment".equals(command)) {
                        MakeSaleWindow foreground = new MakeSaleWindow(stores, orders, payments);
                        //Same code
                        foreground.set_listener(new MainButtonPressed() {
                            @Override
                            public void button_pressed() {
                                refresh_panel();
                            }
                        });
                        start_page.disable_buttons();
                        foreground.set_listener(new MainButtonPressed() {
                            @Override
                            public void button_pressed() {
                                refresh_panel();
                            }
                        });
                        foreground.addWindowListener( new WindowAdapter()
                        {
                        @Override
                        public void windowClosing(WindowEvent e)
                        {
                            start_page.enable_buttons();
                            foreground.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }
                    });
                    }else if ("show records".equals(command)) {
                        Records foreground = new Records(payments);
                        //Same code
                        start_page.disable_buttons();
                        foreground.addWindowListener( new WindowAdapter(){
                        public void windowClosing(WindowEvent e)
                        {
                            start_page.enable_buttons();
                            foreground.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        }});
                    }
                    }
            });
        
        }
    public static void main(String[] args) {
        try {
            if(args[0].equals("hardcode"));
            app ayyy = new app(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            app ayyy = new app(0);
        }      
    }
    
    //For debugging purposes hehe
    public void hardcode() {
        Store temp;
        Order temp2;
        stores.add(temp = new OutletStore("Rockland", "Near a chowk ig"));
        temp.add_item("Flim Flam", 99.0, 10);
        orders.add(temp2 = new Order("Flim Flam", 2, temp));
        payments.add(new OnlinePayment("Dio", temp2));
        orders.add(temp2 =new Order("Flim Flam", 3, temp));
        payments.add(new CardPayment("Jojo", temp2));

            
        stores.add(temp = new OnlineStore("Daraz.pk", "https://www.daraz.pk"));
        temp.add_item("Floop", 89.0, 10);
       
        orders.add(temp2 =new Order("Floop", 2, temp));
                payments.add(new CardPayment("Dio", temp2));

        orders.add(temp2 =new Order("Floop", 3, temp));
                payments.add(new CashPayment("Dio", temp2));

        orders.add(temp2 =new Order("Floop", 4, temp));
                payments.add(new OnlinePayment("Dio", temp2));

        orders.add(temp2 =new Order("Floop", 5, temp));
                payments.add(new CardPayment("Dio", temp2));

        orders.add(temp2 =new Order("Floop", 1, temp));
                payments.add(new CashPayment("Dio", temp2));

        refresh_panel();
    }
    
    //Avoiding a minor inconvenience
    public void refresh_panel() {
        start_page.erase_panel();
        for(Store store: stores){
            start_page.append_to_panel(store.generate_info());    
        }
    }
}