import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    Bank bank = new Bank();

    public void runMenu() {
        while (true) {
            System.out.println("~~~~~~MENU~~~~~~");
            System.out.println("Please Make A Selection:");
            System.out.println("1) Access Account");
            System.out.println("2) Open A New Account");
            System.out.println("3) Close All Accounts");
            System.out.println("4) Exit");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                accessAccount();
                continue;
            }
            if (choice == 2) {
                createNewAccount();
                continue;
            }
            if (choice == 3) {
                closeAccounts();
                continue;
            }
            if (choice == 4) {
                System.out.println("Thanks For Choosing Our Bank");
                break;
            } else {
                System.out.println("Invalid Entry");
            }
        }
    }

    private void accessAccount() {
        Customer customer;
        Account account;
        int pin;
        int accountNum;
        System.out.println("Please Enter Your Pin");
        pin = Integer.parseInt(scan.nextLine());
        customer = bank.getCustomer(pin);
        if (customer == null) {
            System.out.println("Invalid Pin");
        } else {
            List<Account> accountList = customer.getAllAccounts();
            for (int i = 0; i < accountList.size(); i++) {
                System.out.println(accountList.get(i));
            }
            System.out.println("Please Enter The Account Number");
            accountNum = Integer.parseInt(scan.nextLine());
            account = customer.getAccount(accountNum);
            if (account == null) {
                System.out.println("Invalid Account Number");
            } else {
                while (true) {
                    System.out.println("Please Make A Selection:");
                    System.out.println("1) Make A Deposit");
                    System.out.println("2) Make A Withdrawal");
                    System.out.println("3) See Account Balance");
                    System.out.println("4) Close Account");
                    System.out.println("5) Exit");
                    int choice = Integer.parseInt(scan.nextLine());
                    if (choice == 1) {
                        System.out.println("How Much Do You Want To Deposit?");
                        double amount = Integer.parseInt(scan.nextLine());
                        account.deposit(amount);
                        continue;
                    }
                    if (choice == 2) {
                        System.out.println("How Much Do You Want To Withdrawal?");
                        double amount = Integer.parseInt(scan.nextLine());
                        account.withdrawal(amount);
                        continue;
                    }
                    if (choice == 3) {
                        System.out.println(account);
                        continue;
                    }
                    if (choice == 4) {
                        customer.removeAccount(account);
                        System.out.println("Account Number " + accountNum + " Closed");
                        continue;
                    }
                    if (choice == 5) {
                        break;
                    } else {
                        System.out.println("Invalid Entry");
                    }
                }
            }
        }
    }

    private void createNewAccount() {
        Customer customer;
        System.out.println("Are You A New Customer?");
        String answer = scan.nextLine();
        if(answer.equalsIgnoreCase("yes")) {
            createNewCustomer();
        }
        if(answer.equalsIgnoreCase("no")) {
            System.out.println("Enter Your PIN");
            int pin = Integer.parseInt(scan.nextLine());
            customer = bank.getCustomer(pin);
            if (customer != null) {
                System.out.println("Enter Initial Deposit");
                double initialBalance = Integer.parseInt(scan.nextLine());
                Account newAccount = new Account(initialBalance);
                customer.addAccount(newAccount);
                System.out.println("New Account Opened: " + newAccount.getAccountNumber());
            }
        }
    }
    private void createNewCustomer() {
        System.out.println("Enter Your First Name");
        String firstName = scan.nextLine();
        System.out.println("Enter Your Last Name");
        String lastName = scan.nextLine();
        System.out.println("Enter A 4 Digit PIN");
        int pin = Integer.parseInt(scan.nextLine());
        Customer newCustomer = new Customer(firstName,lastName,pin);
        bank.addCustomer(newCustomer);
        System.out.println("Enter Deposit Amount");
        double initialBalance = Integer.parseInt(scan.nextLine());
        Account newAccount = new Account(initialBalance);
        newCustomer.addAccount(newAccount);
        System.out.println("New Account Opened: " + newAccount.getAccountNumber());
    }
    private void closeAccounts() {
        Customer customer;
        System.out.println("Enter PIN");
        int pin = Integer.parseInt(scan.nextLine());
        customer = bank.getCustomer(pin);
        if(customer != null){
            bank.removeCustomer(customer);
            System.out.println("You Have Been Removed From Bank Registry");
        }
    }
}
