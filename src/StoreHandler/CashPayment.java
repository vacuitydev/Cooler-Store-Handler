package StoreHandler;

public class CashPayment extends Payment {
    public CashPayment(String c, Order o) {
        super(c, o);
    }


    public String get_payment_type(){
        return "by cash";
    }
}