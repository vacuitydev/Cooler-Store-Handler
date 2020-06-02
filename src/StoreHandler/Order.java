package StoreHandler;


public class Order {
    private String item_name;
    private int number_of_items;
    private Store store;
    private int payment_type; // 1 for Cash, 2 for Card, 3 for Online
    String payment_string;
    public double price;

    public Order(String name, int number, Store s) {
        item_name = name;
        number_of_items = number;
        store = s;
        //This used to handle payment type too
    }

    // Some getters
    public String get_name() {
        return item_name;
    }

    public void details() {
        switch (payment_type) {
            case 1:
                payment_string = "Cash";
                break;
            case 2:
                payment_string = "Bank Card";
                break;
            case 3:
                payment_string = "Online API";
        }
        System.out.printf("\nProcessing the order of %d %s from %s through %s\n", number_of_items, item_name, store,
                payment_string);
    }

    // some getters
    public Integer get_number() {
        return number_of_items;
    }

    public int get_payment_type() {
        return payment_type;
    }

    public Store get_store() {
        return store;
    }
    
    public String toString(){
        return (number_of_items) + " " + item_name +" worth " + get_total_price()+ " from " + store;
    }
    public double get_total_price(){
        return (store.get_price(item_name)*number_of_items);
    }
}