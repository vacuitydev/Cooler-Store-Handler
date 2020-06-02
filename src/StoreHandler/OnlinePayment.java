package StoreHandler;

public class OnlinePayment extends Payment {
    public OnlinePayment() {
        super();
        System.out.println("Java's weird, man. Who the fuck designed this and what were they smoking?");
    }

    public OnlinePayment(String c, Order o) {
        super(c, o);
    }

    public String get_payment_type(){
        return "by online API";
    }
}