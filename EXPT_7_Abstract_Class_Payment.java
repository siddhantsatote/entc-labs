interface Refundable {
    void processRefund(double amount);
}

abstract class PaymentGateway {
    String txnId;

    PaymentGateway(String id) {
        txnId = id;
    }

    void authenticate() {
        System.out.println("Auth: " + txnId);
    }

    abstract void processPayment(double amount);

    void logTxn() {
        System.out.println("Logged: " + txnId);
    }
}

class UPIPayment extends PaymentGateway implements Refundable {
    String upiId;

    UPIPayment(String id, String uid) {
        super(id);
        upiId = uid;
    }

    public void processPayment(double amt) {
        authenticate();
        System.out.println("UPI Rs." + amt + " via " + upiId + " done.");
        logTxn();
    }

    public void processRefund(double amt) {
        System.out.println("Refund Rs." + amt + " to " + upiId);
    }
}

class CardPayment extends PaymentGateway {
    String last4;

    CardPayment(String id, String c) {
        super(id);
        last4 = c.substring(c.length() - 4);
    }

    public void processPayment(double amt) {
        authenticate();
        System.out.println("Card Rs." + amt + " on xxxx" + last4 + " done.");
        logTxn();
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        UPIPayment upi = new UPIPayment("T001", "user@upi");
        CardPayment card = new CardPayment("T002", "1234567890123456");

        upi.processPayment(1500);
        card.processPayment(3200);
        upi.processRefund(500);
    }
}
