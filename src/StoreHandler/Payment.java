package StoreHandler;


abstract class Payment {
    public Payment() {
    };

    String iname;

    public String getIname() {
        return iname;
    }

    public Integer getInumber() {
        return inumber;
    }

    public String getCustomer() {
        return customer;
    }

    public double getPrice() {
        return price;
    }

    public Store getStore() {
        return store;
    }
    Integer inumber;
    String customer;
    double price;
    protected int was_successful;
    Store store;
    
    public Payment(String c, Order o) {
        store = o.get_store();
        //Extra contingencies
        was_successful = 0; // fails by default
        System.out.println("\nProcessing payment.");
        iname = o.get_name();
        inumber = o.get_number();
        customer = c;
        price = (store.get_price(iname) * inumber);
        store.get_item(iname, inumber);
        store.sale(inumber, iname, customer); 
                
    }

    public String details() {
        return inumber + " of " + iname + " costing overall " + price + " were bought from the " + store.getStoreType()+
                " store \""+ store.get_name() + "\" were bought by";
    }

    // the way a payment is acknowledged depends on the medium, so all children of
    // payment shall have different method of acknowledgement.
    
    public abstract String get_payment_type();
}