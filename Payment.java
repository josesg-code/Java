// ===== PARENT CLASS (Base class) =====
class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    // This method will be OVERRIDDEN by child classes
    void pay() {
        System.out.println("Processing generic payment of ₹" + amount);
    }
}

// ===== CHILD CLASS 1 =====
class CreditCardPayment extends Payment {

    CreditCardPayment(double amount) {
        super(amount); // calls Payment's constructor
    }

    @Override
    void pay() {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

// ===== CHILD CLASS 2 =====
class PayPalPayment extends Payment {

    PayPalPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Paid ₹" + amount + " using PayPal");
    }
}

// ===== CHILD CLASS 3 =====
class UpiPayment extends Payment {

    UpiPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

// ===== MAIN CLASS (where everything runs) =====
 class Main {
    public static void main(String[] args) {

        Payment p1 = new CreditCardPayment(1500);
        Payment p2 = new PayPalPayment(800);
        Payment p3 = new UpiPayment(300);

        p1.pay(); // Paid ₹1500.0 using Credit Card
        p2.pay(); // Paid ₹800.0 using PayPal
        p3.pay(); // Paid ₹300.0 using UPI
    }
}