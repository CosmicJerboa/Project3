public class Account {
    double balance;
    int accountNumber;
    static int numberOfAccounts = 1000;

    public Account(double intialDeposit) {
        this.balance = intialDeposit;
        this.accountNumber = numberOfAccounts;
        numberOfAccounts += 1;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    public void withdrawal(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Funds");
        }
        else {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return String.format("Account Number: %d\nBalance: %.2f\n",accountNumber, balance);
    }
}
