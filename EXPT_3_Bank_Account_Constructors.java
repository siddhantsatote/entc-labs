class BankAccount {
    private String owner;
    private double balance;

    // Default constructor
    BankAccount() {
        owner = "Unknown";
        balance = 0;
    }

    // Parameterised constructor
    BankAccount(String name, double bal) {
        owner = name;
        balance = bal;
    }

    void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.println("Deposited: Rs." + amt);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amt;
            System.out.println("Withdrawn: Rs." + amt);
        }
    }

    void checkBalance() {
        System.out.println(owner + "'s Balance: Rs." + balance);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Siddh", 5000);
        acc.checkBalance();
        acc.deposit(2000);
        acc.withdraw(1500);
        acc.withdraw(8000);  // insufficient
        acc.checkBalance();
    }
}
