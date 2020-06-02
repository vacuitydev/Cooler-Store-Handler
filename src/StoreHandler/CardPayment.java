package StoreHandler;

public class CardPayment extends Payment {

    public CardPayment() {
    };

    public CardPayment(String c, Order o) {
        super(c, o);
    }

    public String get_payment_type(){
        return "by card";
    }
}